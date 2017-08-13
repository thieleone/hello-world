package uebung7;

import java.util.LinkedList;

public class RealTimeScheduler {
	public LinkedList<Task> taskList = new LinkedList<Task>();
	private Task runningTask;
	private int simulationTime;
	private int algo;
	
	//Variables for the output:
	private int maxDigitsTime;
	private int maxCharsTaskId = 0;
	
	public static class EmptyTaskListException extends Exception{
		public EmptyTaskListException(){super("You must pass a list with at least one task!");}
	}
	public static class SimulationTimeException extends Exception{
		public SimulationTimeException(){super("Simulation Time must be greater than zero!");}
	}
	
	public RealTimeScheduler(LinkedList<Task> taskList, int simulationTime, int algo) throws EmptyTaskListException, SimulationTimeException{
		if(taskList.size() == 0) throw new EmptyTaskListException();
		if(simulationTime < 0) throw new SimulationTimeException();
		this.taskList = taskList;
		this.simulationTime = simulationTime;
		//Set priorities of each task
		calculatePriorities(0);
		//Preparing variables for output
		this.maxDigitsTime = (int) (Math.log10(simulationTime)+1);
		for(Task t : taskList){if(t.id.length() > maxCharsTaskId) maxCharsTaskId = t.id.length();}
		this.algo = algo;
	}
	
	public void runSimulation(){
		//Local output variables
		String missedRow = new String(new char[maxCharsTaskId]).replace("\0","D") + "|";
		String emptyRow = new String(new char[maxCharsTaskId]).replace("\0"," ") + "|";
		String execRow = new String(new char[maxCharsTaskId]).replace("\0","#") +  "|";
		//Create table header
		StringBuffer headerString = new StringBuffer(maxDigitsTime);
		StringBuffer headerLine = new StringBuffer(maxDigitsTime);
		for(int j=0; j<2 - Math.max(this.maxDigitsTime,2); j++){headerString.append(" ");}
		headerString.append("\tstep|");
		//System.out.print(headerString);
		for(int j=0; j<taskList.size(); j++){headerString.append(taskList.get(j).id+"|");}
		System.out.println(headerString);
		headerLine.append("\t----|");
		for(int j=0; j<taskList.size(); j++){headerLine.append(new String(new char[maxCharsTaskId]).replace("\0","-")+"|");}
		System.out.println(headerLine);
		
		for(int i=0; i<simulationTime; i++){
			//For EDF and LLF, priorities are recalculated in every step
			if(this.algo == 2 || this.algo == 3) calculatePriorities(i);
			
			double maxPriority = 0;
			int maxPriorityTask = -1;
			int missedDeadline[] = new int[taskList.size()];
			for(int j=0; j<taskList.size(); j++){
				Task t = taskList.get(j);
				//Check if task has started new cycle
				if(i % t.p == 0){
					t.remaining = t.e;
					t.lastStarted = i;
				}
				if(t.priority > maxPriority && t.remaining > 0){
					maxPriority = t.priority;
					maxPriorityTask = j;
				}
				//Process gets to reach deadline without completing
				if(t.remaining > 0 && i >= t.r && (i - t.r +1)%t.p == t.d%t.p){
					missedDeadline[j] = 1;
				}
			}
			if(maxPriorityTask >= 0) chooseNext(taskList.get(maxPriorityTask));
			
			//Start current table line
			StringBuffer lineString = new StringBuffer(maxDigitsTime);
			for(int j=0; j<Math.max(this.maxDigitsTime,4) - Integer.toString(i).length(); j++){lineString.append(" ");}
			lineString.append(i + "|");
			System.out.print("\t" + lineString);
			for(int j=0; j<taskList.size(); j++){
				if(missedDeadline[j] == 1) System.out.print(missedRow);
				else if(j == maxPriorityTask) System.out.print(execRow);
				else System.out.print(emptyRow);
			}
			System.out.print("\n");
		}
		System.out.println("\tSimulation complete...\n");
	}
	
	private void chooseNext(Task t){
		this.runningTask = t;
		t.remaining--;
		//Do something else maybe
	}
	
	private void calculatePriorities(int time){
		/* Integer algo encodes the live system scheduler to use
		 * 0: RMS
		 * 1: DMS
		 * 2: EDF
		 * 3: LLF
		 */
		if(this.algo == 0){
			for(Task t : taskList){
				t.priority = 1/((float)t.p);
			}
		}
		if(this.algo == 1){
			for(Task t : taskList){
				t.priority = 1/((float)t.d);
			}
		}
		if(this.algo == 2){
			for(Task t : taskList){
				if(time % t.p == 0){
					t.remaining = t.e;
					t.lastStarted = time;
				}
				 int deadlineDistance = t.lastStarted + t.d - time;
				 t.priority = 1/((float) deadlineDistance);
			}
		}
		if(this.algo == 3){
			for(Task t : taskList){
				if(time % t.p == 0){
					t.remaining = t.e;
					t.lastStarted = time;
				}
				int slackTime = t.lastStarted + t.d - time - t.remaining;
				t.priority = 1/((float) slackTime);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Live System Scheduler:\n\nLegende:\n\t'#': Thread bedient\n\t'D': Missed deadline\n");
		System.out.println("Test 1 with RMS:\n\tThread 1 (0,2,5,5)\n\tThread 2 (0,2,7,7)\n\tThread 3 (0,3,18,18)\n");
		LinkedList<Task> tasks1 = new LinkedList<Task>();
		tasks1.add(new Task(0,2,5,5,"Thread 1"));
		tasks1.add(new Task(0,2,7,7,"Thread 2"));
		tasks1.add(new Task(0,3,18,18,"Thread 3"));
		RealTimeScheduler scheduler1 = null;
		try {
			scheduler1 = new RealTimeScheduler(tasks1, 30, 0);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler1 != null) scheduler1.runSimulation();
		
		System.out.println("Test 2 with RMS:\n\tThread 1 (0,2,7,7)\n\tThread 2 (0,3,9,9)\n\tThread 3 (0,1,11,11)\n\tThread 4 (0,1,6,6)\n");
		LinkedList<Task> tasks2 = new LinkedList<Task>();
		tasks2.add(new Task(0,2,7,7,"Thread 1"));
		tasks2.add(new Task(0,3,9,9,"Thread 2"));
		tasks2.add(new Task(0,1,11,11,"Thread 3"));
		tasks2.add(new Task(0,1,6,6,"Thread 4"));
		RealTimeScheduler scheduler2 = null;
		try {
			scheduler2 = new RealTimeScheduler(tasks2, 30, 0);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler2 != null) scheduler2.runSimulation();
		
		System.out.println("Test 3 with DMS:\n\tThread 1 (0,2,7,7)\n\tThread 2 (0,3,8,9)\n\tThread 3 (0,1,9,11)\n\tThread 4 (0,1,6,6)\n");
		LinkedList<Task> tasks3 = new LinkedList<Task>();
		tasks3.add(new Task(0,2,7,7,"Thread 1"));
		tasks3.add(new Task(0,3,8,9,"Thread 2"));
		tasks3.add(new Task(0,1,9,11,"Thread 3"));
		tasks3.add(new Task(0,1,6,6,"Thread 4"));
		RealTimeScheduler scheduler3 = null;
		try {
			scheduler3 = new RealTimeScheduler(tasks3, 30, 1);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler3 != null) scheduler3.runSimulation();
		
		System.out.println("Test 4 with EDF:\n\tThread 1 (0,1,3,3)\n\tThread 2 (0,1,4,4)\n\tThread 3 (0,2,5,5)\n");
		LinkedList<Task> tasks4 = new LinkedList<Task>();
		tasks4.add(new Task(0,1,3,3,"Thread 1"));
		tasks4.add(new Task(0,1,4,4,"Thread 2"));
		tasks4.add(new Task(0,2,5,5,"Thread 3"));
		RealTimeScheduler scheduler4 = null;
		try {
			scheduler4 = new RealTimeScheduler(tasks4, 30, 2);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler4 != null) scheduler4.runSimulation();
		
		System.out.println("Test 5 with EDF:\n\tThread 1 (0,2,7,7)\n\tThread 2 (0,3,8,9)\n\tThread 3 (0,1,9,11)\n\tThread 4 (0,1,6,6)\n");
		RealTimeScheduler scheduler5 = null;
		try {
			scheduler5 = new RealTimeScheduler(tasks3, 30, 2);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler5 != null) scheduler5.runSimulation();
		
		System.out.println("Test 6 with LLF:\n\tThread 1 (0,3,6,6)\n\tThread 2 (0,4,8,9)\n");
		LinkedList<Task> tasks5 = new LinkedList<Task>();
		tasks5.add(new Task(0,3,6,6,"Thread 1"));
		tasks5.add(new Task(0,4,8,9,"Thread 2"));
		RealTimeScheduler scheduler6 = null;
		try {
			scheduler6 = new RealTimeScheduler(tasks5, 30, 3);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler6 != null) scheduler6.runSimulation();
		
		System.out.println("Test 7 with LFF:\n\tThread 1 (0,2,7,7)\n\tThread 2 (0,3,8,9)\n\tThread 3 (0,1,9,11)\n\tThread 4 (0,1,6,6)\n");
		RealTimeScheduler scheduler7 = null;
		try {
			scheduler7 = new RealTimeScheduler(tasks3, 30, 3);
		} catch (EmptyTaskListException | SimulationTimeException e) {
			e.printStackTrace();
		}
		if(scheduler7 != null) scheduler7.runSimulation();
	}

}

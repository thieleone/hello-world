package uebung7;

public class Task {
	public final int r;
	public final int e;
	public final int d;
	public final int p;
	public int remaining;
	public int lastStarted;
	public double priority = 0.0;
	public String id;
	
	public Task(int release, int execution, int deadline, int period){
		this.r = release;
		this.e = execution;
		this.d = deadline;
		this.p = period;
		this.remaining = execution;
		this.lastStarted = release;
	}
	
	public Task(int release, int execution, int deadline, int period, String id){
		this.r = release;
		this.e = execution;
		this.d = deadline;
		this.p = period;
		this.remaining =execution;
		this.id = id;
		this.lastStarted = release;
	}
	
}

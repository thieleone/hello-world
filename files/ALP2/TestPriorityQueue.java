package u5;

public class TestPriorityQueue {
	
	public void producer(int numberOfMessages,PriorityQueue Liste){
		Liste.generate_messages(numberOfMessages);
	}
	public void consumer(int numberOfMessages,PriorityQueue Liste){
		for(int i=0;i<numberOfMessages;i++)
			Liste.remove_message();
	}
	public static void main(String[] args) {
		TestPriorityQueue TestQueue=new TestPriorityQueue();
        PriorityQueue Liste=new PriorityQueue(10);
        TestQueue.producer(10,Liste);
        Liste.show_queue();
        System.out.println();
        TestQueue.consumer(10, Liste);
        System.out.println();
        Liste.show_queue();
        System.out.println();
        TestQueue.consumer(10, Liste);
        System.out.println();
        Liste.show_queue();
        System.out.println("Ende");
        
	}

}

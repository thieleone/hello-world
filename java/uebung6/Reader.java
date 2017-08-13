package uebung6;

public class Reader extends Thread {
	 private ReadWriteLock rwLock;
	 public String name;
	 
	 public Reader( ReadWriteLock rwLock ) {
		 this.rwLock = rwLock;
	 }
	 
	 public void run() {
		 while( true ){
			 do_something_else();
			 System.out.println(this.name + " wants to read.");
			 rwLock.acquireReadLock();
			 read_for_a_while();
			 rwLock.releaseReadLock();
		 }
	 }
	 
	 public void do_something_else(){
		 System.out.println(this.name + " is doing sth else.");
		 Nap.randomNap(500, 2000);
	 }
	 
	 public void read_for_a_while(){
		 System.out.println(this.name + " is reading.");
		 Nap.randomNap(500, 2000);
	 }

}

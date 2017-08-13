package uebung6;

public class Writer extends Thread {
	 private ReadWriteLock rwLock;
	 public String name;
	 
	 public Writer(ReadWriteLock rwLock) {
		 this.rwLock = rwLock;
	 }
	 
	 public void run() {
		 while( true ){
			 do_something_else();
			 System.out.println(this.name + " wants to write.");
			 rwLock.acquireWriteLock();
			 write_for_a_while();
			 rwLock.releaseWriteLock();
		 }
	 }
	 
	 public void do_something_else(){
		 System.out.println(this.name + " is doing sth else.");
		 Nap.randomNap(2000, 4000);
	 }
	 
	 public void write_for_a_while(){
		 System.out.println(this.name + " is writing.");
		 Nap.randomNap(500, 2000);
	 }
}

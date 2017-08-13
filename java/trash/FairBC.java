package control;

import java.util.LinkedList;

import vehicle.Vehicle;
import vehicle.Vehicle.VOrigin;

public class FairBC implements BridgeControl {
	double currLoad, maxLoad = 0.0;
	VOrigin lowRiderOrigin = null;
	int lowRiderCount = 0;
	LinkedList<Thread> queue = new LinkedList<Thread>();
	private Object lock = new Object();

	@Override
	public void init(Double maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public void requestCrossing(Vehicle v) {
		double carWeight = v.getWeight();
		synchronized(lock){
			queue.add(Thread.currentThread());
			while(currLoad + carWeight > maxLoad 
					|| Thread.currentThread() != queue.getFirst() 
					|| (v.isLowrider() && lowRiderOrigin != null && v.getOrigin() != lowRiderOrigin)){
				try{
					lock.wait();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			queue.removeFirst();
			if(v.isLowrider()){
				lowRiderCount++;
				lowRiderOrigin = v.getOrigin();
			}
			currLoad += carWeight;
		}
	}

	@Override
	public void leaveBridge(Vehicle v) {
		synchronized(lock){
			currLoad -= v.getWeight();
			if(v.isLowrider()){
				lowRiderCount--;
				if(lowRiderCount == 0) lowRiderOrigin = null;
			}
			lock.notifyAll();
		}
	}

}

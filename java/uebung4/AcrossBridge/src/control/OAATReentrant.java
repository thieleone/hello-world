package control;

import vehicle.Vehicle;

import java.util.concurrent.locks.*;

public class OAATReentrant implements BridgeControl {
	private Lock crossPermission = new ReentrantLock();
	private double maxLoad; 

	@Override
	public void init(Double maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public void requestCrossing(Vehicle v) {
		while(v.getWeight() > maxLoad){
			try{
				Thread.sleep(Long.MAX_VALUE);
			}
			catch(InterruptedException e){}
		}
		crossPermission.lock();
	}

	@Override
	public void leaveBridge(Vehicle v) {
		crossPermission.unlock();	
	}

}

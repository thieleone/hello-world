package control;

import vehicle.Vehicle;

public class OAATMonitor implements BridgeControl{
	private boolean carOnBridge = false;
	private double maxLoad;

	@Override
	public void init(Double maxLoad) {
		this.maxLoad = maxLoad; 
	}

	@Override
	public synchronized void requestCrossing(Vehicle v) {
		while(v.getWeight() > maxLoad){
			try{
				Thread.sleep(Long.MAX_VALUE);
			}
			catch(InterruptedException e){}
		}
		while(carOnBridge){
			try{
				wait();
			}
			catch(InterruptedException e){}
		}
		carOnBridge = true;
	}

	@Override
	public synchronized void leaveBridge(Vehicle v) {
		carOnBridge = false;
		notify();
	}

}

package control;

import vehicle.Vehicle;
import vehicle.Vehicle.VOrigin;

public class AlternateWE implements BridgeControl {
	Object lock = new Object();
	int carCount = 0;
	VOrigin origin = null;
	double currLoad = 0.0;
	double maxLoad;
	
	@Override
	public void init(Double maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public void requestCrossing(Vehicle v) {
		double carWeight = v.getWeight();
		synchronized(lock){
			if(origin == null) origin = v.getOrigin();
			while(currLoad + carWeight > maxLoad || carCount >= 5 || v.getOrigin() != origin){
				try{
					lock.wait();
				}
				catch(InterruptedException e){}
			}
			carCount++;
			currLoad += carWeight;
			if(carCount == 5 && origin == VOrigin.WEST) origin = VOrigin.EAST;
			else if(carCount == 5 && origin == VOrigin.EAST) origin = VOrigin.WEST;
		}
	}

	@Override
	public void leaveBridge(Vehicle v) {
		synchronized(lock){
			carCount--;
			currLoad -= v.getWeight();
			/*if(carCount == 10){
				if(origin == VOrigin.WEST) origin = VOrigin.EAST;
				else if(origin == VOrigin.EAST) origin = VOrigin.WEST;
				carCount = 0 ;
				lock.notifyAll();
			}*/
			lock.notifyAll();
		}
	}

}

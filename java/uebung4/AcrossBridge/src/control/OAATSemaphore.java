package control;

import vehicle.Vehicle;

import java.util.concurrent.Semaphore;

public class OAATSemaphore implements BridgeControl{
	private Semaphore s;
	private double maxLoad;
	
	@Override
	public void init(Double maxLoad) {
		s = new Semaphore(1,true);
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
		try{
				s.acquire();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void leaveBridge(Vehicle v) {
		s.release();
	}

}

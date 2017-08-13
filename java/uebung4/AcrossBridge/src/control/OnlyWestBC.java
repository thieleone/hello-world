package control;

import vehicle.Vehicle;
import vehicle.Vehicle.VOrigin;

/**
 * Simple example. Only light vehicles coming from west will be able to pass the Bridge.
 */
public class OnlyWestBC implements BridgeControl {

	double maxLoad;

	@Override
	public void init(Double maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public void requestCrossing(Vehicle v) {
		try {
			//Check the origin and weight ...
			if (v.getOrigin() == VOrigin.EAST || v.getWeight() < 1) {
				// Let them wait for ~290 billion years
				Thread.sleep(Long.MAX_VALUE);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void leaveBridge(Vehicle v) {

	}

}

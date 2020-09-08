package SimulationObject.Roads;

import SimulationObject.Vehicle.Vehicle;

public class OneWayRoad extends Road{

    public OneWayRoad(String id, int direction) {
        super(id, direction);
    }

    @Override
    public void bind(Vehicle vehicle) {
        vehicle.setRoad(this);
    }
}

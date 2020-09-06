package SimulationObject.Vehicle;

import SimulationObject.Roads.Road;
import SimulationObject.SimulationState;

public class VehicleState extends SimulationState {
    private int runState;
    private int speed;
    private int pos;
    private Road road;

    public VehicleState(Vehicle vehicle) {
        this.runState = vehicle.getRunState();
        this.speed = vehicle.getSpeed();
        this.pos = vehicle.getPos();
        this.road = vehicle.getRoad();
    }

    public int getRunState() {
        return runState;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPos() {
        return pos;
    }

    public Road getRoad() {
        return road;
    }
}

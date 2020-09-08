package SimulationObject.Roads;

import SimAnimation.Animatable;
import SimulationObject.TrafficSignal.TrafficSignal;
import SimulationObject.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Road implements Animatable {

    public static final int DIRECTION_NORTH = 0;
    public static final int DIRECTION_SOUTH = 1;
    public static final int DIRECTION_EAST = 2;
    public static final int DIRECTION_WEST = 3;

    public static final int ORIENTATION_VERTICAL = 0;
    public static final int ORIENTATION_HORIZONTAL = 1;

    protected String id;
    protected int orientation;
    protected int direction;

    protected ArrayList<Vehicle> vehicles;
    protected HashMap<Integer, Object> roadData;

    public Road(String id, int direction) {
        this.direction = direction;
        this.id = id;
        if (direction == Road.DIRECTION_NORTH | direction == Road.DIRECTION_SOUTH) {
            orientation = Road.ORIENTATION_VERTICAL;
        } else if (direction == Road.DIRECTION_EAST | direction == Road.DIRECTION_WEST) {
            orientation = Road.ORIENTATION_HORIZONTAL;
        }
        vehicles = new ArrayList<>();
    }

    public void check(Vehicle vehicle){
        if (roadData.get(vehicle.getPos()) == null) {
            return;
        }
        else{
            Object o = roadData.get(vehicle.getPos());

            if (o instanceof TrafficSignal){
                TrafficSignal signal = (TrafficSignal)o;
                if (signal.getSignalState() == TrafficSignal.STATE_RED && vehicle.getRunState() == Vehicle.STATE_RUNNING){
                    vehicle.waitUntilGreen();
                }
                else if (signal.getSignalState() == TrafficSignal.STATE_GREEN && vehicle.getRunState() == Vehicle.STATE_WAITING){
                    vehicle.goUntilRed();
                }
            }
        }
    }

    public int getOrientation() {
        return orientation;
    }

    public int getDirection() {
        return direction;
    }

    public abstract void bind(Vehicle vehicle);

    public abstract void configureAnim();
}




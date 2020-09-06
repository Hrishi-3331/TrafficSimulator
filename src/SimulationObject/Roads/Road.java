package SimulationObject.Roads;

import SimulationObject.Vehicle.Vehicle;
import SimulationToolbox.Timeline;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Road{

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

    public abstract void bind(Vehicle vehicle);

    public abstract void configureAnim();

    public void init(Timeline timeline) {
        for (Vehicle vehicle : vehicles) {
            vehicle.init(timeline);
        }
    }
}




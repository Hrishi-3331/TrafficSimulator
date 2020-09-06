package SimulationObject.Roads;

import SimulationObject.SimulationObject;
import SimulationObject.Vehicle.Vehicle;
import SimulationToolbox.Timeline;

import java.util.ArrayList;

public abstract class Road implements SimulationObject {

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




package SimulationObject.Vehicle;

import SimulationObject.Roads.Road;
import SimulationObject.SimulationObject;
import SimulationObject.SimulationState;
import SimulationToolbox.Timeline;

import java.util.Random;

public class Vehicle implements SimulationObject {

    public static int STATE_RUNNING = 0;
    public static int STATE_WAITING = 1;

    private String id;
    private VehicleState state;
    private Timeline timeline;

    private int runState;
    private int speed;
    private int pos;
    private Road road;

    private int waitingTime;
    private int waitingInstances;

    public Vehicle(String id, VehicleState state){
        this.id = id;
        this.state = state;
        this.waitingInstances = 0;
        this.waitingTime = 0;
    }

    @Override
    public SimulationState getCurrentState() {
        return state;
    }

    @Override
    public void simulate() {
        for (int i = 0; i < speed; i++){
            this.pos++;
        }
    }

    @Override
    public void init(Timeline timeLine) {
        this.timeline = timeLine;
        this.runState = Vehicle.STATE_RUNNING;
        this.speed = 30 + new Random().nextInt(20);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getRunState() {
        return runState;
    }

    public void setRunState(int runState) {
        this.runState = runState;
    }

    public void waitUntilGreen(){
        this.runState = Vehicle.STATE_WAITING;
        waitingInstances++;
    }

    public void goUntilRed(){
        this.runState = Vehicle.STATE_RUNNING;
    }

    public String getId() {
        return id;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getWaitingInstances() {
        return waitingInstances;
    }

    public int getAverageWaitingTime() {
        return waitingInstances == 0 ? 0 : (int) waitingTime/waitingInstances;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }
}

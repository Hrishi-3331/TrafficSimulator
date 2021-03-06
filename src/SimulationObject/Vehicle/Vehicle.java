package SimulationObject.Vehicle;

import SimAnimation.Animatable;
import SimAnimation.SimulationGraphicProperties;
import SimulationObject.Roads.Road;
import SimulationObject.SimulationObject;
import SimulationObject.SimulationState;
import SimulationToolbox.Timeline;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Random;

public class Vehicle implements SimulationObject, Animatable {

    public static int STATE_RUNNING = 0;
    public static int STATE_WAITING = 1;

    private String id;
    private VehicleState state;
    private Timeline timeline;
    private GraphicProperties properties;

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
            if (this.getRunState() == Vehicle.STATE_RUNNING) this.pos++;
            road.check(this);
        }
        this.state = new VehicleState(this);
    }

    @Override
    public void init(Timeline timeLine) {
        this.timeline = timeLine;
        this.runState = Vehicle.STATE_RUNNING;
        this.speed = 30 + new Random().nextInt(20);
        this.state = new VehicleState(this);
    }

    public int getSpeed() {
        return speed;
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

    public int getFacing(){
        return this.road.getDirection();
    }

    @Override
    public GraphicProperties getGraphicProperties() {
        return this.properties;
    }

    @Override
    public void configureGraphicProperties(SimulationGraphicProperties properties) {
        GraphicProperties.Builder builder = new GraphicProperties.Builder();

    }
}

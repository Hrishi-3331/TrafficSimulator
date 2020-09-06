package SimulationObject.Vehicle;

import SimAnimation.Animatable;
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

    @Override
    public void draw(Graphics graphics) {
        Graphics2D plane = (Graphics2D)graphics;
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("/red_car.png"));
            plane.drawImage(img, pos, 400, 60, 40, null);
        }
        catch (Exception e){
            System.out.println("Error in drawing animatable object " + this.getId());
            plane.setColor(Color.red);
            plane.fillRect(pos,500, 100, 100);
        }
    }

}

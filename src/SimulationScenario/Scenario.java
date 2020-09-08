package SimulationScenario;

import SimulationObject.Roads.Road;
import SimulationObject.SimulationObject;
import SimulationToolbox.TimeSnap;
import SimulationToolbox.Timeline;

import java.util.ArrayList;

public abstract class Scenario {
    protected ArrayList<SimulationObject> simulatables;
    protected ArrayList<Road> roadMap;

    public Scenario() {
        simulatables  = new ArrayList<SimulationObject>();
        roadMap = new ArrayList<>();
    }

    public abstract void buildScenario();

    void initSim(Timeline timeline){
        for (SimulationObject object : simulatables){
            object.init(timeline);
        }
    }

    public void addSimulatable(SimulationObject object){
        if (object == null) return;
        this.simulatables.add(object);
    }

    public void addRoad(Road road){
        if (road == null)return;
        roadMap.add(road);
    }

    void run(TimeSnap timeSnap){
        for (SimulationObject o : simulatables){
            o.simulate();
            timeSnap.attach(o, o.getCurrentState());
        }
    }

    public ArrayList<Road> getRoadMap() {
        return roadMap;
    }
}

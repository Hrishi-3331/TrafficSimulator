package SimulationScenario;

import SimulationObject.SimulationObject;
import SimulationToolbox.Timeline;

import java.util.ArrayList;

public abstract class Scenario {
    protected ArrayList<SimulationObject> simulatables;

    public Scenario() {
        simulatables  = new ArrayList<SimulationObject>();
    }

    void initSim(Timeline timeline){
        for (SimulationObject object : simulatables){
            object.init(timeline);
        }
    }

    public void addSimulatable(SimulationObject object){
        if (object == null) return;
        this.simulatables.add(object);
    }

    void run(){
        for (SimulationObject o : simulatables){
            o.simulate();
        }
    }
}

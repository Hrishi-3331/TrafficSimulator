package SimulationScenario;

import SimulationObject.SimulationObject;
import SimulationToolbox.Timeline;

import java.util.ArrayList;

public abstract class Scenario {
    protected ArrayList<SimulationObject> dynamicSimulatables;
    protected ArrayList<SimulationObject> staticSimulatables;

    public Scenario() {
        dynamicSimulatables = new ArrayList<SimulationObject>();
        staticSimulatables  = new ArrayList<SimulationObject>();
    }

    public void initSim(Timeline timeline){
        for (SimulationObject object : dynamicSimulatables){
            object.init(timeline);
        }

        for (SimulationObject object : staticSimulatables){
            object.init(timeline);
        }
    }

    void run(){

    }
}

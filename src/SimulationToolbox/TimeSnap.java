package SimulationToolbox;

import SimulationObject.SimulationObject;
import SimulationObject.SimulationState;

import java.util.HashMap;

public class TimeSnap {

    private double instance;
    private HashMap<SimulationObject, SimulationState> stateMap;

    public TimeSnap(double instance){
        this.instance = instance;
        this.stateMap = new HashMap<SimulationObject, SimulationState>();
    }

    public void attach(SimulationObject o, SimulationState s){
        stateMap.put(o, s);
    }

    public HashMap<SimulationObject, SimulationState> getStateMap() {
        return stateMap;
    }
}

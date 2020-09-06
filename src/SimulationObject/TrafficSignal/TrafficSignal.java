package SimulationObject.TrafficSignal;

import SimulationObject.SimulationObject;
import SimulationToolbox.Timeline;
import SimulationObject.SimulationState;

public class TrafficSignal implements SimulationObject {

    public static final int STATE_RED = 0;
    public static final int STATE_GREEN = 1;

    private int signalState;

    @Override
    public SimulationState getCurrentState() {
        return null;
    }

    @Override
    public void simulate() {

    }

    @Override
    public void init(Timeline timeLine) {
        this.signalState = STATE_GREEN;
    }

    public int getSignalState() {
        return signalState;
    }

    public void setSignalState(int signalState) {
        this.signalState = signalState;
    }
}

package SimulationObject;

import SimulationToolbox.Timeline;

public interface SimulationObject {
    SimulationState getCurrentState();
    void simulate();
    void init(Timeline timeLine);
}

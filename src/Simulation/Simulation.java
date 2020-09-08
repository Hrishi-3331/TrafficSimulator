package Simulation;

import SimulationObject.Roads.OneWayRoad;
import SimulationObject.Roads.Road;
import SimulationScenario.Scenario;
import SimulationScenario.ScenarioHandler;
import SimulationToolbox.Timeline;

public class Simulation extends Scenario{

    public static void main(String[] args) {
        ScenarioHandler handler = new ScenarioHandler(new Simulation(), new Timeline(Timeline.DURATION_NORMAL), TrafficSimulation.MODE_ANIMATION);
        handler.run();
    }

    @Override
    public void buildScenario() {
        Road road = new OneWayRoad("Road1", Road.DIRECTION_WEST);
        Road road1 = new OneWayRoad("Road2", Road.DIRECTION_NORTH);
        addRoad(road);
        addRoad(road1);
    }
}

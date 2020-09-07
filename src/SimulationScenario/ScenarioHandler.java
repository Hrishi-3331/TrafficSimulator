package SimulationScenario;

import SimulationToolbox.Timeline;

public class ScenarioHandler {

    private Scenario scenario;
    private Timeline timeline;

    public ScenarioHandler(Scenario scenario, Timeline timeline) {
        this.scenario = scenario;
        this.timeline = timeline;
    }

    public void run(){
        scenario.initSim(timeline);
        while (!timeline.isExpired()){
            scenario.run();
        }
    }
}

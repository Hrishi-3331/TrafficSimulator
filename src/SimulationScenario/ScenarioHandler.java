package SimulationScenario;

import SimAnimation.SimFrame;
import SimAnimation.SimulationGraphicProperties;
import Simulation.TrafficSimulation;
import SimulationToolbox.TimeSnap;
import SimulationToolbox.Timeline;

public class ScenarioHandler {

    private Scenario scenario;
    private Timeline timeline;
    private int mode;

    public ScenarioHandler(Scenario scenario, Timeline timeline) {
        this.scenario = scenario;
        this.timeline = timeline;
    }

    public ScenarioHandler(Scenario scenario, Timeline timeline, int mode) {
        this.scenario = scenario;
        this.timeline = timeline;
        this.mode = mode;
    }

    public void run(){
        scenario.buildScenario();
        System.out.println("Initializing simulation....");
        scenario.initSim(timeline);
        System.out.println("Simulation started");
        while (!timeline.isExpired()){
            TimeSnap timeSnap = new TimeSnap(timeline.getCurrentInstance());
            scenario.run(timeSnap);
            timeline.attachSnap(timeSnap);
            timeline.timeProgress();
        }
        System.out.println("Simulation complete.");
        if (mode == TrafficSimulation.MODE_ANIMATION){
            System.out.println("Loading animations");
            SimulationGraphicProperties properties = new SimulationGraphicProperties();
            properties.configureDefaultGraphicProperties(scenario.getRoadMap(), SimulationGraphicProperties.ZOOM_0X);
            SimFrame frame = new SimFrame(timeline, scenario.getRoadMap(), properties);
            frame.runAnimation();
        }
        else if (mode == TrafficSimulation.MODE_LOGS){
            System.out.println("Loading logs");
        }
        else {
            System.out.println("Illegal simulation mode selected");
        }
    }
}

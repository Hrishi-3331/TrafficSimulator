package SimAnimation;

import SimulationObject.Roads.Road;
import SimulationToolbox.Timeline;

import javax.swing.*;
import java.util.ArrayList;

public class SimFrame extends JFrame {

    private SimPanel panel;
    private Timeline timeline;
    private ArrayList<Road> roadMap;
    private SimulationGraphicProperties properties;

    public SimFrame(Timeline timeline, ArrayList<Road> roadMap, SimulationGraphicProperties properties){
        this.timeline = timeline;
        this.roadMap = roadMap;
        this.properties = properties;
        panel = new SimPanel(timeline, roadMap, properties);
    }

    public void runAnimation(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
}

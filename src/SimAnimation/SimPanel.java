package SimAnimation;

import SimulationObject.Roads.Road;
import SimulationObject.SimulationObject;
import SimulationObject.SimulationState;
import SimulationToolbox.TimeSnap;
import SimulationToolbox.Timeline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SimPanel extends JPanel implements ActionListener {

    private Timer timer = new Timer(100, this);
    private double instance = 0;
    private Timeline timeline;
    private ArrayList<Road> roadMap;
    private SimulationGraphicProperties properties;

    public SimPanel(Timeline timeline, ArrayList<Road> roadMap, SimulationGraphicProperties properties){
        this.timeline = timeline;
        this.roadMap = roadMap;
        this.properties = properties;
        initGraphics();
        timer.addActionListener(this);
        timer.start();
    }

    private void initGraphics(){
        for (Road road : roadMap){
            road.configureGraphicProperties(properties);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.green);
        for (Road road : roadMap){
            Animatable.draw(g, road);
        }
        HashMap<Double, TimeSnap> snapMap = timeline.getSnapMap();
        TimeSnap snap = snapMap.get(instance);
        if (snap == null){
            timer.stop();
            return;
        }
        HashMap<SimulationObject, SimulationState> map = snap.getStateMap();
        ArrayList<SimulationObject> objects = new ArrayList<>(map.keySet());
        for (SimulationObject object : objects){
            if (object instanceof Animatable) {
                ((Animatable)object).configureGraphicProperties(properties);
                Animatable.draw(g, object, map.get(object));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
        instance++;
        if (instance == timeline.getCurrentInstance()-1) timer.stop();
    }
}

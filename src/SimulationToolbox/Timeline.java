package SimulationToolbox;

import java.util.HashMap;

public class Timeline {
    private double timeInstance;
    private HashMap<Double, TimeSnap> SnapMap;
    private double DURATION;

    public Timeline(){
        timeInstance = 0;
        DURATION = 400;
        SnapMap = new HashMap<>();
    }

    public Timeline(int duration){
        this();
        this.DURATION = duration;
    }

    public double getCurrentInstance(){
        return timeInstance;
    }

    public void attachSnap(TimeSnap snap){
        SnapMap.put(timeInstance, snap);
    }

    public void timeProgress(){
        timeInstance++;
    }

    public HashMap<Double, TimeSnap> getSnapMap() {
        return SnapMap;
    }

    public double getDURATION() {
        return DURATION;
    }

}

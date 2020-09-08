package SimulationToolbox;

import java.util.HashMap;

public class Timeline {
    public static final double DURATION_NORMAL = 400;
    public static final double DURATION_INFINITE = Double.MAX_VALUE;
    public static final double DURATION_INDEFINITE = Double.MAX_VALUE;

    private double timeInstance;
    private HashMap<Double, TimeSnap> SnapMap;
    private double DURATION;
    private boolean expired = false;

    public Timeline(){
        timeInstance = 0;
        DURATION = Timeline.DURATION_NORMAL;
        SnapMap = new HashMap<>();
    }

    public Timeline(double duration){
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
        if (timeInstance == DURATION) this.terminate();
    }

    public HashMap<Double, TimeSnap> getSnapMap() {
        return SnapMap;
    }

    public double getDURATION() {
        return DURATION;
    }

    public boolean isExpired() {
        return expired;
    }

    public void terminate(){
        this.expired = true;
    }
}

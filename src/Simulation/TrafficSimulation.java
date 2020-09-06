package Simulation;

public final class TrafficSimulation {
    /** Vehicle speed modes */
    public static final int SPEED_RANDOM = 0;
    public static final int SPEED_FIXED = 1;

    /** Simulation modes
     * Heavy simulations are recommended to be executed in logs mode and not in animation mode. */
    public static final int MODE_ANIMATION = 2;
    public static final int MODE_LOGS = 3;

    /** Traffic intensity modes */
    public static final int TRAFFIC_INTENSITY_HEAVY = 4;
    public static final int TRAFFIC_INTENSITY_LIGHT = 5;
    public static final int TRAFFIC_INTENSITY_MODERATE = 6;

}

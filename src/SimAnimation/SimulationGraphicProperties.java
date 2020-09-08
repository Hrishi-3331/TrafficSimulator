package SimAnimation;

import SimulationObject.Roads.Road;

import java.awt.*;
import java.util.ArrayList;

public class SimulationGraphicProperties {

    public static final int ZOOM_0X = 0;
    public static final int ZOOM_1X = 1;
    public static final int ZOOM_2x = 2;

    private final int ROAD_SIZE_SMALL = 160;
    private final int ROAD_SIZE_MEDIUM = 180;
    private final int ROAD_SIZE_LARGE = 200;

    private int roadVerticalLength;
    private int roadVerticalWidth;
    private int roadHorizontalLength;
    private int roadHorizontalWidth;
    private int roadVerticalPos;
    private int roadHorizontalPos;
    private int vp = 0;
    private int hp = 0;

    public void configureDefaultGraphicProperties(ArrayList<Road> roadMap, int zoom){
        int v = 0;
        int h = 0;
        for (Road road : roadMap){
            if (road.getOrientation() == Road.ORIENTATION_VERTICAL) v++;
            else if (road.getOrientation() == Road.ORIENTATION_HORIZONTAL) h++;
        }

        if (v + h < 3){
            if (zoom == SimulationGraphicProperties.ZOOM_0X){
                this.roadVerticalWidth = ROAD_SIZE_SMALL;
                this.roadHorizontalWidth = ROAD_SIZE_SMALL;
            }
            else if (zoom == SimulationGraphicProperties.ZOOM_1X){
                this.roadVerticalWidth = ROAD_SIZE_MEDIUM;
                this.roadHorizontalWidth = ROAD_SIZE_MEDIUM;
            }
            else if (zoom == SimulationGraphicProperties.ZOOM_2x){
                this.roadVerticalWidth = ROAD_SIZE_LARGE;
                this.roadHorizontalWidth = ROAD_SIZE_LARGE;
            }
        }
        else {
            if (v > 4){
                this.roadVerticalWidth = ROAD_SIZE_SMALL;
            }
            else if (v > 2){
                this.roadVerticalWidth = ROAD_SIZE_MEDIUM;
            }

            if (h > 4){
                this.roadHorizontalWidth = ROAD_SIZE_SMALL;
            }
            else if (h > 2){
                this.roadHorizontalWidth = ROAD_SIZE_MEDIUM;
            }
        }

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        roadVerticalLength = (int) dimension.getHeight();
        roadHorizontalLength = (int) dimension.getWidth();
        roadHorizontalPos = (int)dimension.getHeight()/(h+1);
        roadVerticalPos = (int)dimension.getWidth()/(v+1);
    }

    public SimulationGraphicProperties() {

    }

    public int getRoadVerticalLength() {
        return roadVerticalLength;
    }

    public int getRoadVerticalWidth() {
        return roadVerticalWidth;
    }

    public int getRoadHorizontalLength() {
        return roadHorizontalLength;
    }

    public int getRoadHorizontalWidth() {
        return roadHorizontalWidth;
    }

    public int getRoadVerticalPos() {
        vp += roadVerticalPos;
        return vp - roadVerticalWidth/2;
    }

    public int getRoadHorizontalPos() {
        hp += roadHorizontalPos;
        return hp - roadHorizontalWidth/2;
    }
}

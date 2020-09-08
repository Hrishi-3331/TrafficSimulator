package SimAnimation;

import SimulationObject.Roads.Road;
import SimulationObject.SimulationObject;
import SimulationObject.SimulationState;
import SimulationObject.TrafficSignal.TrafficSignal;
import SimulationObject.Vehicle.Vehicle;
import SimulationObject.Vehicle.VehicleState;

import javax.imageio.ImageIO;
import java.awt.*;

public interface Animatable {

    int TYPE_STATIC = 0;
    int TYPE_DYNAMIC = 1;

    static void draw(Graphics graphics, SimulationObject object, SimulationState state){
        Graphics2D canvas = (Graphics2D)graphics;
        if (object instanceof Vehicle){
            VehicleState vehicleState = (VehicleState)state;
            int Xpos = 0;
            int Ypos = 0;
            int width = 0;
            int height = 0;
            Road road = vehicleState.getRoad();
            Image vehicle_image = null;
            try {
                switch (road.getDirection()) {
                    case Road.DIRECTION_NORTH:
                        ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_north.png"));
                        break;

                    case Road.DIRECTION_SOUTH:
                        ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_south.png"));
                        break;

                    case Road.DIRECTION_EAST:
                        ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_east.png"));
                        break;

                    case Road.DIRECTION_WEST:
                        ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_west.png"));
                        break;
                }
                canvas.drawImage(vehicle_image, Xpos, Ypos, width, height, null);
            }catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }
        else if (object instanceof TrafficSignal){

        }
    }

    static void draw(Graphics graphics, Road road){
        Graphics2D canvas = (Graphics2D)graphics;
        if (road.getOrientation() == Road.ORIENTATION_HORIZONTAL){

        }
        else if (road.getOrientation() == Road.ORIENTATION_VERTICAL){

        }
    }

    class GraphicProperties{
        double Xpos;
        double Ypos;
        int width;
        int height;
        Color color;

        public GraphicProperties() {

        }

        public double getXpos() {
            return Xpos;
        }

        public void setXpos(double xpos) {
            Xpos = xpos;
        }

        public double getYpos() {
            return Ypos;
        }

        public void setYpos(double ypos) {
            Ypos = ypos;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}

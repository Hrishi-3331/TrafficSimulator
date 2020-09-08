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

    static void draw(Graphics graphics, SimulationObject object, SimulationState state){
        Graphics2D canvas = (Graphics2D)graphics;
        if (object instanceof Vehicle){
            VehicleState vehicleState = (VehicleState)state;
            GraphicProperties vehicleGraphicProperties = ((Vehicle)object).getGraphicProperties();
            int Xpos = 0;
            int Ypos = 0;
            int width = vehicleGraphicProperties.getWidth();
            int height = vehicleGraphicProperties.getHeight();
            Road road = vehicleState.getRoad();
            Image vehicle_image = null;
            try {
                switch (road.getDirection()) {
                    case Road.DIRECTION_NORTH:
                        vehicle_image = ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_north.png"));
                        Ypos = vehicleState.getPos();
                        break;

                    case Road.DIRECTION_SOUTH:
                        vehicle_image = ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_south.png"));
                        Ypos = vehicleState.getPos();
                        break;

                    case Road.DIRECTION_EAST:
                        vehicle_image = ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_east.png"));
                        Xpos = vehicleState.getPos();
                        break;

                    case Road.DIRECTION_WEST:
                        vehicle_image = ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/red_car_west.png"));
                        Xpos = vehicleState.getPos();
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
        GraphicProperties properties = road.getGraphicProperties();
        Image road_image = null;
        try {
            if (road.getOrientation() == Road.ORIENTATION_HORIZONTAL) {
                road_image = ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/road.jpg"));
            } else if (road.getOrientation() == Road.ORIENTATION_VERTICAL) {
                road_image = ImageIO.read(SimFrame.class.getClassLoader().getResourceAsStream("res/road_v.jpg"));
            }
            System.out.println("Drawing " + road.getId() + " at " + (int) properties.getXpos() + " , " + (int) properties.getYpos());
            canvas.drawImage(road_image, (int) properties.getXpos(), (int) properties.getYpos(), properties.getWidth(), properties.getHeight(), null);
        }catch (Exception e){
            System.out.println("Error in loading road graphics");
        }
    }

    GraphicProperties getGraphicProperties();

    void configureGraphicProperties(SimulationGraphicProperties properties);

    class GraphicProperties{
        private double Xpos;
        private double Ypos;
        private int width;
        private int height;
        private Color color;

        public GraphicProperties() {

        }

        public GraphicProperties(double xpos, double ypos, int width, int height, Color color) {
            Xpos = xpos;
            Ypos = ypos;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public double getXpos() {
            return Xpos;
        }

        public double getYpos() {
            return Ypos;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public Color getColor() {
            return color;
        }

        public static class Builder{

            private double Xpos;
            private double Ypos;
            private int width;
            private int height;
            private Color color;

            public Builder(){

            }

            public Builder setXpos(int xpos){
                this.Xpos = xpos;
                return this;
            }

            public Builder setYpos(int ypos){
                this.Ypos = ypos;
                return this;
            }

            public Builder setWidth(int width){
                this.width = width;
                return this;
            }

            public Builder setHeight(int height){
                this.height = height;
                return this;
            }

            public Builder setColor(Color color){
                this.color = color;
                return this;
            }

            public GraphicProperties build(){
                return new GraphicProperties(Xpos, Ypos, width, height, color);
            }
        }
    }
}

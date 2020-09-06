package SimAnimation;

import java.awt.*;

public interface Animatable {

    void draw(Graphics graphics);

    class AnimationProperties{
        double Xpos;
        double Ypos;
        int width;
        int height;
        Color color;
    }
}

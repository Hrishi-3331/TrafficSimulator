package SimAnimation;

import javax.swing.*;

public class SimFrame extends JFrame {

    private SimPanel panel;

    public SimFrame(){

    }

    public void runAnimation(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
}

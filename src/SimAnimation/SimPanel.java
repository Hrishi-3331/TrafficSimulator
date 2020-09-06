package SimAnimation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimPanel extends JPanel implements ActionListener {

    private Timer timer = new Timer(100, this);
    int index = 1;
    int pos;
    private ArrayList<Integer> positions;

    public SimPanel(ArrayList<Integer> positions){
        this.positions = positions;
        pos = positions.get(0);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.green);
        Graphics2D car = (Graphics2D)g;
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("/red_car.png"));
            car.drawImage(img, pos, 400, 60, 40, null);
        }
        catch (Exception e){
            car.setColor(Color.red);
            car.fillOval(pos,500, 100, 100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pos = positions.get(index++);
        this.repaint();

        //System.out.println(index + " value : " + positions.get(index));
        if (index == positions.size()) timer.stop();
    }
}

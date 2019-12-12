package Application;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SpeedView extends JPanel {

    JPanel speedPanel = new JPanel();
    StringBuilder sb= new StringBuilder();
    JLabel label = new JLabel("");



    public SpeedView(String framename, ArrayList<Vehicle.AbstractCar> cars) {
        initComponents(framename,cars);
    }

    protected void initComponents(String title, ArrayList<Vehicle.AbstractCar> cars){

        for (Vehicle.AbstractCar c: cars) {
            sb.append("<" + c.getModelName() +">: " +"<"+ c.getCurrentSpeed()+">"+"    ");


        }
        label = new JLabel(sb.toString());

        speedPanel.add(label);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        this.add(speedPanel);
        speedPanel.setLayout(new GridBagLayout());
        speedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.setVisible(true);

    }

    protected void updateSpeed(ArrayList<Vehicle.AbstractCar> cars){

        StringBuilder sb1 = new StringBuilder();
        for(Vehicle.AbstractCar c: cars) {
            sb1.append("<" + c.getModelName() +">: " +"<"+ c.getCurrentSpeed()+">"+"    ");
        }

        label.setText(sb1.toString());
    }
}
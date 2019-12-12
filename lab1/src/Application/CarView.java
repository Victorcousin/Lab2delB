package Application;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;


    DrawPanel drawPanel = new DrawPanel(X, Y-270);

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton addCar = new JButton("Add Car");
    JButton removeCar = new JButton("Remove Car");
    JPanel carPanel = new JPanel();
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, CarController cc){
        initComponents(framename, cc);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title,CarController carC) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        this.add(carC.speedframe.speedPanel);
        this.add(drawPanel);

        createSpinner();
        createPanel();
        addStartButton();
        addStopButton();
        createCarPanel();
        addButtonFunctions(carC);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createSpinner(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }

    private void createPanel(){
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)-40, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
    }


    private JButton addCar(){
        addCar.setBackground(Color.black);
        addCar.setForeground(Color.white);
        addCar.setPreferredSize(new Dimension(X/8-15,90));
        return addCar;
    }

    private void createCarPanel(){
        carPanel.add(addCar());
        carPanel.add(removeCar());
        carPanel.setPreferredSize(new Dimension((X/6)-40, 200));
        this.add(carPanel);
    }

    private JButton removeCar(){
        removeCar.setBackground(Color.black);
        removeCar.setForeground(Color.white);
        removeCar.setPreferredSize(new Dimension(X/8-15,90));
        return removeCar;}

    private void addStartButton(){
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/6-15,200));
        this.add(startButton);
    }

    private void addStopButton(){
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/6-15,200));
        this.add(stopButton);
    }


    private void addButtonFunctions(CarController carC){
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount); }});

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount); }});

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn(); }});

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff(); }});

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftFlatbed(); }});

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerFlatbed(); }});

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startAll(); }});

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopAll(); }});
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.addCar(); }});
        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.removeCar(); }});
    }
    }

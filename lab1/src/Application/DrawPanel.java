package Application;

import Vehicle.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    Model model = new Model();
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (model.cars.size()>0) {
            for (int i = 0; i <= model.getnCars()-1; i++) {
                if (model.carModel[i].equals("Volvo240")) {
                    g.drawImage(volvoImage, model.arrayX[i], model.arrayY[i], null);
                }
                if (model.carModel[i].equals("Saab95")) {
                    g.drawImage(saabImage, model.arrayX[i], model.arrayY[i], null);
                }
                if (model.carModel[i].equals("Scania")) {
                    g.drawImage(scaniaImage, model.arrayX[i], model.arrayY[i], null);
                }
            }
        }else{g.drawString("No cars",200,100);}
    }
}
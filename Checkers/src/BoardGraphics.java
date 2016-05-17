import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BoardGraphics extends JButton {
	private BufferedImage image;
	
	public BoardGraphics (boolean isBrown) {
		if (isBrown) {
			try {
				image = ImageIO.read(new File("resources/brown.png"));
			} catch (IOException ex) {
				System.out.print("can't find pic");
			}
		} else {
			try {
				image = ImageIO.read(new File("resources/white.png"));
			} catch (IOException ex) {
				System.out.print("can't find pic");
			}
		}
		
		this.setIcon(new ImageIcon(image));
		
	}
	
}

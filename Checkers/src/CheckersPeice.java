import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class CheckersPeice extends JButton {
	
	private String color;
	private BufferedImage image;
	
	public CheckersPeice(String color) 
	{
		
		this.color = color;
		
		if (color.equals("WP")) {
			try {
				image = ImageIO.read(new File("resources/redwhite.png"));
			} catch (IOException ex) {
				System.out.print("can't find pic");
			}
		} else if (color.equals("BP")) {
			try {
				image = ImageIO.read(new File("resources/blackwhite.png"));
			} catch (IOException ex) {
				System.out.print("can't find pic");
			}
		} else if (color.equals("0")) {
			try {
				image = ImageIO.read(new File("resources/white.png"));
			} catch (IOException ex) {
				System.out.print("can't find pic");
			}
		} else if (color.equals("#")) {
			try {
				image = ImageIO.read(new File("resources/brown.png"));
			} catch (IOException ex) {
				System.out.print("can't find pic");
			}
		} else {
			System.out.println("error at CheckersPeice constructor");
		}
		
		this.setIcon(new ImageIcon(image));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	

	
	
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return color;
	}
	
}

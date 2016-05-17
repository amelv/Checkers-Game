import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

 
public class PeiceGraphics extends JButton {
	private BufferedImage image;
	
	public PeiceGraphics (boolean isBrown) {
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
		this.setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	public PeiceGraphics(boolean isRed, boolean isBrown) {
		if (isRed)
		{
			if (isBrown)
			{
				try {
					image = ImageIO.read(new File("resources/redbrown.png"));
				} catch (IOException ex) {
					System.out.print("can't find pic");
				}
			}
			else
			{
				try {
					image = ImageIO.read(new File("resources/redwhite.png"));
				} catch (IOException ex) {
					System.out.print("can't find pic");
				}
			}
		}
		else
		{
			
			if (isBrown) {
				
			
				try {
					image = ImageIO.read(new File("resources/blackbrown.png"));
				} catch (IOException ex) {
					System.out.print("can't find pic");
				}
			}
			else {
				
				try {
					image = ImageIO.read(new File("resources/blackwhite.png"));
				} catch (IOException ex) {
					System.out.print("can't find pic");
				}
			}
		}
		
		this.setIcon(new ImageIcon(image));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	
	
	
}

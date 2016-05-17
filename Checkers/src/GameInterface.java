import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class GameInterface {

	private JFrame frame;
	private JLabel label;
	//private JPanel appletPanel;
	//private BoardGraphics board;
	private board gameBoard;
	
	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameInterface window = new GameInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("Checkers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
		label = new JLabel("A Label");
		label.setFont(new Font("Serif", Font.PLAIN, 14));
		label.setForeground(Color.BLACK);
		
		gameBoard = new board();
		PeiceGraphics peice;
		
		
		
		
		
	
		
		
		//appletPanel.add(label, BorderLayout.NORTH);
		
		//Decide whether to add buttons here or in the board class
		
		gameBoard.print();
		frame.setContentPane(gameBoard);
		
		
		frame.pack();
		frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}
	public void actionPerformed (ActionEvent event)
	{
		String eventPeice = event.getActionCommand();
		
		
	}

}

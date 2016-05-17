import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

//import net.miginfocom.swing.MigLayout;


public class board extends JPanel{
	private CheckersPeice[][] array = new CheckersPeice[8][7];
	private int row;
	private int col; 
	private JPanel appletPanel;
	private PeiceGraphics peice;
	
	public board()
	{
		this.setLayout(new GridLayout(8, 8));
		array = new CheckersPeice[8][8];
		row = array.length;
		col = array[0].length;
		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				PeiceGraphics peice;
				
				if(i % 2 == 0)
				{
					if(j % 2 == 0) {
						
						if(i <= 2) {
							array[i][j] = new CheckersPeice("WP");
						} else if(i >= row-3)  {
							array[i][j] = new CheckersPeice("BP");
							
						} else {
							array[i][j] = new CheckersPeice("0");
							
						}
					} else {
						array[i][j] = new CheckersPeice("#");
						
					}
				}


				else
				{
					if(j % 2 != 0) {
						if(i <= 2) {
							array[i][j] = new CheckersPeice("WP");
							
						} else if(i >= row-3) {
							array[i][j] = new CheckersPeice("BP");
							
						} else {
							array[i][j] = new CheckersPeice("0");
						}
					} else {
						array[i][j] = new CheckersPeice("#");
					}
				}
				
				this.add(array[i][j], "cell " + j + " " + i);
				//array[i][j].setActionCommand(array[i][j].getColor());
				//array[i][j].addActionListener((ActionListener) this);
			}
		}
		
		
	}
	public void print()
	{
		int row = array.length;
		int col = array[0].length;
		System.out.println("\n\n\n");
		System.out.print("\t0\t1\t2\t3\t4\t5\t6\t7");
		for (int i = 0; i < row; i++) {
			System.out.print("\n\n"+ i + "\t");
			for (int j = 0; j < col; j++) {
				System.out.print(array[i][j]+ "\t");
			}

		}
	}


	public boolean isLegalMove(int[][] moves, int turn)
	{
		boolean legal = true;
		if((moves[0][0]<=7 && moves[0][1]<=7)&&(moves[0][0]>=0 && moves[0][1]>=0)&&(moves[1][0]<=7 && moves[1][1]<=7)&&(moves[1][0]>=0 && moves[1][1]>=0))
		{
			if((array[moves[0][0]][moves[0][1]].toString().charAt(0)=='W' && turn==0) || (array[moves[0][0]][moves[0][1]].toString().charAt(0)=='B' && turn==1))
			{
				for(int i=1;i<moves.length;i++)
				{
					if(array[moves[i][0]][moves[i][1]].toString().charAt(0)!='0'|| !((moves[i][0]<=7 && moves[i][1]<=7)&&(moves[i][0]>=0 && moves[i][1]>=0)))
					{
						legal = false;
					}
				}
				if(legal)
				{
					if(array[moves[0][0]][moves[0][1]].toString().charAt(1)=='K')
					{
						if(moves.length==2)
						{
							boolean k=(Math.abs(moves[0][0]-moves[1][0]) == 1 && Math.abs(moves[0][1]-moves[1][1])==1) || ((Math.abs(moves[0][0]-moves[1][0]) == 2 && Math.abs(moves[0][1]-moves[1][1])== 2)),
									b=array[(moves[1][0]+moves[0][0])/2][(moves[1][1]+moves[0][1])/2].toString().charAt(0)!= array[moves[0][0]][moves[1][1]].toString().charAt(0),
									c=array[(moves[1][0]+moves[0][0])/2][(moves[1][1]+moves[0][1])/2].toString().charAt(0)!= '0';
							if(!((Math.abs(moves[0][0]-moves[1][0]) == 1 && Math.abs(moves[0][1]-moves[1][1])==1) || ((Math.abs(moves[0][0]-moves[1][0]) == 2 && Math.abs(moves[0][1]-moves[1][1])== 2)
									&& array[(moves[1][0]+moves[0][0])/2][(moves[1][1]+moves[0][1])/2].toString().charAt(0)!= array[moves[0][0]][moves[1][1]].toString().charAt(0)
									&& array[(moves[1][0]+moves[0][0])/2][(moves[1][1]+moves[0][1])/2].toString().charAt(0)!= '0')))
								legal = false;
							if(k||b||c)
								System.out.println();
						}
						else
						{
							
							for(int i=0;i<moves.length-1;i++)
							{
								boolean k=((Math.abs(moves[i][0]-moves[i+1][0]) == 2 && Math.abs(moves[i][1]-moves[i+1][1])== 2)&& moves.length!=2),
										b=array[(moves[i+1][0]+moves[i][0])/2][(moves[i+1][1]+moves[i][1])/2].toString().charAt(0)!= array[moves[i][0]][moves[i][1]].toString().charAt(0),
										c=array[(moves[i+1][0]+moves[i][0])/2][(moves[i+1][1]+moves[i][1])/2].toString().charAt(0)!='0';
								if(!(((Math.abs(moves[i][0]-moves[i+1][0]) == 2 && Math.abs(moves[i][1]-moves[i+1][1])== 2)&& moves.length!=2)
										&& array[(moves[i+1][0]+moves[i][0])/2][(moves[i+1][1]+moves[i][1])/2].toString().charAt(0)!= array[moves[i][0]][moves[i][1]].toString().charAt(0)
										&& array[(moves[i+1][0]+moves[i][0])/2][(moves[i+1][1]+moves[i][1])/2].toString().charAt(0)!='0'))
									legal = false;
								if(k||b||c)
									System.out.println();
							}
							
						}
						
					}
					else if (array[moves[0][0]][moves[0][1]].toString().charAt(0)=='W')
					{
						if(moves.length==2)
						{
							if(	!((moves[1][0]-moves[0][0] == 1	&& Math.abs(moves[0][1]-moves[1][1])==1) 
									|| ((moves[1][0]-moves[0][0] == 2 && Math.abs(moves[0][1]-moves[1][1])== 2)
											&& array[(moves[1][0]+moves[0][0])/2][(moves[1][1]+moves[0][1])/2].toString().charAt(0)=='B')))
								legal = false;
						}
						else
						{
							for(int i=0;i<moves.length-1;i++)
							{
								if(!((moves[i+1][0]-moves[i][0] == 2 && Math.abs(moves[i+1][1]-moves[i][1])== 2)
										&& array[(moves[i+1][0]+moves[i][0])/2][(moves[i+1][1]+moves[i][1])/2].toString().charAt(0)=='B'))
									legal = false;
							}
						}
					}
					else
					{
						if(moves.length==2)
						{
							if(!((moves[0][0]-moves[1][0] == 1 && Math.abs(moves[0][1]-moves[1][1])==1)
									|| ((moves[0][0]-moves[1][0] == 2 && Math.abs(moves[0][1]-moves[1][1])== 2)
											&& array[(moves[1][0]+moves[0][0])/2][(moves[1][1]+moves[0][1])/2].toString().charAt(0)=='W')))
								legal = false;
						}
						else
						{
							for(int i=0;i<moves.length-1;i++)
							{
								if(!((moves[i][0]-moves[i+1][0] == 2 && Math.abs(moves[i+1][1]-moves[i][1])== 2)
										&& array[(moves[i+1][0]+moves[i][0])/2][(moves[i+1][1]+moves[i][1])/2].toString().charAt(0)=='W'))
									legal = false;
							}
							
						}
					}
				}
				if(legal)
				{
					if(moves.length==2 && (Math.abs(moves[0][0]-moves[1][0])==1 && Math.abs(moves[0][1]-moves[1][1])==1))
						move(moves[0][0], moves[0][1], moves[1][0], moves[1][1]);
					else if(moves.length==2)
					{
						jump(moves[0][0], moves[0][1], moves[1][0], moves[1][1], turn);
					}
					else
					{
						for(int i=0;i<moves.length-1;i++)
						{
							jump(moves[i][0], moves[i][1], moves[i+1][0], moves[i+1][1], turn);
						}
					}
				}
				return legal;
			}
			else
				return false;
		}
		else
			return false;

	}


	private void move(int oldX, int oldY, int newX, int newY)
	{
		if((array[oldX][oldY].toString().charAt(0)=='W' && newX==7)||(array[oldX][oldY].toString().charAt(0)=='B' && newX==0))
		{
			array[newX][newY]= new King(array[oldX][oldY].toString().substring(0,1)+"K");
		}
		else
		{
			array[newX][newY]= new CheckersPeice(array[oldX][oldY].toString());
		}
		array[oldX][oldY]= new CheckersPeice("0");

	}

	private void jump(int oldX, int oldY, int newX, int newY, int turn)
	{
		if((array[oldX][oldY].toString().charAt(0)=='W' && newX==7)||(array[oldX][oldY].toString().charAt(0)=='B' && newX==0))
			array[newX][newY]= new King(array[oldX][oldY].toString().substring(0,1)+"K");
		else
			array[newX][newY]= new CheckersPeice(array[oldX][oldY].toString());
		array[(oldX+newX)/2][(oldY+newY)/2]= new CheckersPeice("0");
		array[oldX][oldY]= new CheckersPeice("0");
	}
	
	public int contCheck()
	{
		boolean whiteFound=false,blackFound=false;
		for (int i=0 ; i<=7 && (!whiteFound || !blackFound); i++)
		{
			for (int j=0 ; j<=7 && (!whiteFound || !blackFound); j++)
			{
				if(array[i][j].toString().charAt(0)=='W')
					whiteFound=true;
				if(array[i][j].toString().charAt(0)=='B')
					blackFound=true;
			}
		}
		if(whiteFound && blackFound)
			return 1;
		else if(whiteFound)
			return 2;
		else
			return 3;
	}

}

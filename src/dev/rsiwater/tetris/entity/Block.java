package dev.rsiwater.tetris.entity;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Block extends Entity 
{
	protected int blockCode;
	protected int graphCode;
	protected int blockSize,justifyLocation;
 
	protected ArrayList<Integer> xList=new ArrayList<Integer>(4);
	protected ArrayList<Integer> yList=new ArrayList<Integer>(4);
 
	public void setBlockI()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(2);
		yList.add(0);
		xList.add(3);
		yList.add(0);
		graphCode=0;
		blockCode=0;
		if(x+3 >= 10){
			Rx=9;
			x=6;
		}
		else
			Rx=x+3;
		Ry=y+0;
	}
	public void setBlocki()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(0);
		yList.add(2);
		xList.add(0);
		yList.add(3);
		graphCode=1;
		Rx=x;
		Ry=y+3;
	}
	public void setBlockO()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(1);
		yList.add(1);
		graphCode=2;
		blockCode=3;
		Rx=x+1;
		Ry=y+1;
	}
	public void setBlockL()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(0);
		yList.add(2);
		xList.add(1);
		yList.add(2);
		graphCode=3;
		blockCode=2;
		Rx=x+1;
		Ry=y+2;
	}
	public void setBlockrgun()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(2);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		graphCode=4;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlock7()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(1);
		yList.add(1);
		xList.add(1);
		yList.add(2);
		graphCode=5;
		Rx=x+1;
		Ry=y+2;
	}
	public void setBlocklsock()
	{
		xList.clear();
		yList.clear();
		xList.add(2);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(1);
		yList.add(1);
		xList.add(2);
		yList.add(1);
		graphCode=6;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlockJ()
	{
		xList.clear();
		yList.clear();
		xList.add(1);
		yList.add(0);
		xList.add(1);
		yList.add(1);
		xList.add(1);
		yList.add(2);
		xList.add(0);
		yList.add(2);
		graphCode=7;
		blockCode=1;
		Rx=x+1;
		Ry=y+2;
	}
	public void setBlockrsock()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(1);
		yList.add(1);
		xList.add(2);
		yList.add(1);
		graphCode=8;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlock9()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(0);
		yList.add(2);
		xList.add(1);
		yList.add(0);
		graphCode=9;
		Rx=x+1;
		Ry=y+2;
	}
	public void setBlocklgun()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(2);
		yList.add(0);
		xList.add(2);
		yList.add(1);
		graphCode=10;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlockS()
	{
	 xList.clear();
	 yList.clear();
	 xList.add(0);
	 yList.add(0);
	 xList.add(0);
	 yList.add(1);
	 xList.add(1);
	 yList.add(1);
	 xList.add(1);
	 yList.add(2);
	 graphCode=11;
	 blockCode=4;
	 Rx=x+1;
	 Ry=y+2;
	}
	public void setBlock5()
	{
		xList.clear();
		yList.clear();
		xList.add(1);
		yList.add(0);
		xList.add(2);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(1);
		yList.add(1);
		graphCode=12;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlockZ()
	{
		xList.clear();
		yList.clear();
		xList.add(1);
		yList.add(0);
		xList.add(1);
		yList.add(1);
		xList.add(0);
		yList.add(1);
		xList.add(0);
		yList.add(2);
		graphCode=13;
		blockCode=6;
		Rx=x+1;
		Ry=y+2;
	}
	public void setBlock2()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(1);
		yList.add(1);
		xList.add(2);
		yList.add(1);
		graphCode=14;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlockT()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(1);
		yList.add(0);
		xList.add(2);
		yList.add(0);
		xList.add(1);
		yList.add(1);
		graphCode=15;
		blockCode=5;
		if(x+2 >= 10)
		{
			Rx=9;
			x=7;
		}
		else 
		{
			if(x - 1 >= 0) x-=1;
			Rx=x+2;
		}
		Ry=y+1;
	}
	public void setBlockl()
	{
		xList.clear();
		yList.clear();
		xList.add(1);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(1);
		yList.add(1);
		xList.add(1);
		yList.add(2);
		graphCode=16;
		Rx=x+1;
		Ry=y+2;
	}
	public void setBlocku()
	{
		xList.clear();
		yList.clear();
		xList.add(1);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(1);
		yList.add(1);
		xList.add(2);
		yList.add(1);
		graphCode=17;
		if(x+2 >= 10){
			Rx=9;
			x=7;
			}
		else
			Rx=x+2;
		Ry=y+1;
	}
	public void setBlockr()
	{
		xList.clear();
		yList.clear();
		xList.add(0);
		yList.add(0);
		xList.add(0);
		yList.add(1);
		xList.add(0);
		yList.add(2);
		xList.add(1);
		yList.add(1);
		graphCode=18;
		if(x+1 < 10) 
		{
			x++;
		}
		Rx=x+1;
		Ry=y+2;
	}
	public void rotate()
	{
		if(graphCode==0)
		{
		   setBlocki();
		}
		else if(graphCode==1)
		{
			if(x<9)
				setBlockI();
			else
				setBlocki();
		}
		else if(graphCode==2)
		{
		   setBlockO();
		}
		else if(graphCode==3)
		{
		   setBlockrgun();
		}
		else if(graphCode==4)
		{
		   setBlock7();
		}
		else if(graphCode==5)
		{
			if(x<9)
				setBlocklsock();
			else
				setBlock7();
		}
		else if(graphCode==6)
		{
		   setBlockL();
		}
		else if(graphCode==7)
		{
		   setBlockrsock();
		}
		else if(graphCode==8)
		{
		   setBlock9();
		}
		else if(graphCode==9)
		{
		   setBlocklgun();
		}
		else if(graphCode==10)
		{
		   setBlockJ();
		}
		else if(graphCode==11)
		{
		   setBlock5();
		}
		else if(graphCode==12)
		{
		   setBlockS();
		}
		else if(graphCode==13)
		{
		   setBlock2();
		}
		else if(graphCode==14)
		{
		   setBlockZ();
		}
		else if(graphCode==15)
		{
		   setBlockl();
		}
		else if(graphCode==16)
		{
		   setBlocku();
		}
		else if(graphCode==17)
		{
		   setBlockr();
		}
		else if(graphCode==18)
		{
		   setBlockT();
		}
	}
	public void setRB()
	{
		if(graphCode==0)
		{
			Rx=x+3;
			Ry=y+0;
		}
		else if(graphCode==1)
		{
			Rx=x+0;
			Ry=y+3;
		}
		else if(graphCode==2)
		{
			Rx=x+1;
			Ry=y+1;
		}
		else if(graphCode==3)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==4)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==5)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==6)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==7)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==8)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==9)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==10)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==11)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==12)
		{
			Rx=x+2;
			Ry=y+1;
			}
		else if(graphCode==13)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==14)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==15)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==16)
		{
			Rx=x+1;
			Ry=y+2;
		}
		else if(graphCode==17)
		{
			Rx=x+2;
			Ry=y+1;
		}
		else if(graphCode==18)
		{
			Rx=x+1;
			Ry=y+2;
		}
	}
	public void setLB()
	{
		if(graphCode==0)
		{
			y=19;
		}
		else if(graphCode==1)
		{
			y=16;
		}
		else if(graphCode==2)
		{
			y=18;
		}
		else if(graphCode==3)
		{
			y=17;
		}
		else if(graphCode==4)
		{
			y=18;
		}
		else if(graphCode==5)
		{
			y=17;
		}
		else if(graphCode==6)
		{
			y=18;
		}
		else if(graphCode==7)
		{
			y=17;
		}
		else if(graphCode==8)
		{
			y=18;
		}
		else if(graphCode==9)
		{
			y=17;
		}
		else if(graphCode==10)
		{
			y=18;
		}
		else if(graphCode==11)
		{
			y=17;
		}
		else if(graphCode==12)
		{
			y=18;
		}
		else if(graphCode==13)
		{
			y=17;
		}
		else if(graphCode==14)
		{
			y=18;
		}
		else if(graphCode==15)
		{
			y=18;
		}
		else if(graphCode==16)
		{
			y=17;
		}
		else if(graphCode==17)
		{
			y=18;
		}
		else if(graphCode==18)
		{
			y=17;
		}
	}
	public ArrayList<Integer> getxList()
	{
		return xList;
	}
	public ArrayList<Integer> getyList()
	{
		return yList;
	}
 
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void setBlock();
}
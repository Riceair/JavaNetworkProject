package dev.rsiwater.tetris.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.rsiwater.tetris.game.Asset;
import dev.rsiwater.tetris.game.Audio;
import dev.rsiwater.tetris.game.AudioEffects;
import dev.rsiwater.tetris.game.Game;

public class SettleBlock extends Block
{
	private Asset asset;
	private int[][] map;
	private int flag;
	private int combo;
	private int score;
	private int[] rowFinish;
	private Game game;
	private BufferedImage blockM;
	
	private BufferedImage numberOne, numberTen, numberHun, numberTho;
	private boolean scoreChange = false;
	
	public SettleBlock(Game game)
	{
		asset = new Asset();
		this.game=game;
		blockSize = 32;
		justifyLocation = 40;
		flag=0;
		combo=0;
		score=0;
		map=new int[10][21];
		for(int i=0;i<10;i++){
			for(int j=0;j<20;j++)
				map[i][j]=-1;
		}
		
		rowFinish=new int[20];
		
		numberOne = this.setScoreImage(0);
		numberTen = this.setScoreImage(0);
		numberHun = this.setScoreImage(0);
		numberTho = this.setScoreImage(0);
	}
	public void setMap(int blockCode,int graphCode,float x,float y){
		this.blockCode=blockCode;
		this.graphCode=graphCode;
		this.x=x;
		this.y=y;
		this.flag=0;
		
		for(int i=0;i<4;i++)
			this.rotate();
		for(int i=0;i<4;i++){
			map[xList.get(i)+(int)x][yList.get(i)+(int)y]=blockCode;
			rowFinish[yList.get(i)+(int)y]++;  //紀錄該行有幾個
		}
		for(int i=0;i<20;i++){  //查詢哪一行滿惹
			if(rowFinish[i]==10){  //第i行滿惹
				AudioEffects.startMusic(asset.Single);
				for(int j=i;j>=0;j--){  //第j行以前全部向下移動一格
					for(int k=0;k<10;k++){
						if(j==0)
							map[k][j]=-1;
						else
							map[k][j]=map[k][j-1];
					}
					if(j==0)
						rowFinish[j]=0;
					else
						rowFinish[j]=rowFinish[j-1];
				}
				flag=1;
				score=score+5*(combo+1);
				scoreChange = true;
				System.out.println("score: "+score);
			}
		}
		if(flag==1){
			combo=combo+1;
			System.out.println("combo: "+combo);
		}
		else{
			combo=0;
		}
	}
	
	public int[][] getMap(){
		return map;
	}
	private BufferedImage setScoreImage(int n)
	{
		switch(n)
		{
		case 0: return game.getAsset().num0;
		case 1: return game.getAsset().num1;
		case 2: return game.getAsset().num2;
		case 3: return game.getAsset().num3;
		case 4: return game.getAsset().num4;
		case 5: return game.getAsset().num5;
		case 6: return game.getAsset().num6;
		case 7: return game.getAsset().num7;
		case 8: return game.getAsset().num8;
		case 9: return game.getAsset().num9;
		default: return null;
		}
		
	}
	
	@Override
	public void tick() 
	{
		if(scoreChange)
		{
			scoreChange = false;
			numberOne = this.setScoreImage(score % 10);
			numberTen = this.setScoreImage((score / 10) % 10);
			numberHun = this.setScoreImage((score / 100) % 10);
			numberTho = this.setScoreImage((score / 1000) % 10);
		}
	}

	@Override
	public void render(Graphics g) 
	{
		for(int i=0;i<10;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]!=-1){
					blockCode=map[i][j];
					this.setBlock();
					g.drawImage(blockM, justifyLocation+(i*blockSize), justifyLocation+(j*blockSize), null);
				}
			}
		}
		g.drawImage(numberTho, 569, 162, null);
		g.drawImage(numberHun, 569+32, 162, null);
		g.drawImage(numberTen, 569+64, 162, null);
		g.drawImage(numberOne, 569+96, 162, null);
	}

	public void setBlock()
	{
		switch(blockCode)
		{
		case 0:
			blockM = game.getAsset().blockI;
			setBlockI();
			break;
		case 1:
			blockM = game.getAsset().blockJ;
			setBlockJ();
			break;
		case 2:
			blockM = game.getAsset().blockL;
			setBlockL();
			break;
		case 3:
			blockM = game.getAsset().blockO;
			setBlockO();
			break;
		case 4:
			blockM = game.getAsset().blockS;
			setBlockS();
			break;
		case 5:
			blockM = game.getAsset().blockT;
			setBlockT();
			break;
		case 6:
			blockM = game.getAsset().blockZ;
			setBlockZ();
			break;
		}
	}
	
}

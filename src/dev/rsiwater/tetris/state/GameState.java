package dev.rsiwater.tetris.state;

import dev.rsiwater.tetris.entity.*;
import dev.rsiwater.tetris.game.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class GameState extends State 
{
	private Player player;
	private SettleBlock settleblock;
	private GameClient client;
	
	private int cursorY = 400;
	private boolean isStart = false, isPressedUp = false, isPressedDown = false, ifQuit = false;
	public GameState(Game game)
	{
		super(game);
		settleblock=new SettleBlock(game);
		player = new Player(game,settleblock);
		client=new GameClient(10,(byte)10);
	}
	
	int frame = 0;
	public void tick() 
	{
		if(isOver())
		{
			if(!game.getInputHandler().up)isPressedUp = false;
			if(game.getInputHandler().up && !isPressedUp)
			{
				isPressedUp = true;
				cursorY = 400;
			}
			if(!game.getInputHandler().down)isPressedDown = false;
			if(game.getInputHandler().down && !isPressedDown)
			{
				isPressedDown = true;
				cursorY = 520;
			}
			if(game.getInputHandler().space && cursorY == 400)
			{
				frame = 0;
				isStart = false;
				settleblock = new SettleBlock(game);
				player = new Player(game,settleblock);
				player.setOver();
			}
			else if(game.getInputHandler().space && cursorY == 520)
			{
				ifQuit = true;
			}
		}
		else
		{
			if(!isStart)
			{
				frame++;
				if(frame >= 60) isStart = true;
			}
			else
			{
				player.tick();
				settleblock.tick();
			}
		}
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(game.getAsset().BG, 0, 0, null);
		g.drawImage(game.getAsset().scoreBoard, 453, 169, null);
		g.drawImage(game.getAsset().scoreBoard, 1253, 169, null);
		g.drawImage(game.getAsset().GameStage, 40, 40, null);
		g.drawImage(game.getAsset().GameStage, 840, 40, null);
		g.drawImage(game.getAsset().grid, 40, 40, null);
		g.drawImage(game.getAsset().Enemygrid, 840, 40, null);
		player.render(g);
		settleblock.render(g);
		if(isOver())
		{
			g.drawImage(game.getAsset().overImg2, 0, 0, null);
			g.drawImage(game.getAsset().overImg3, 0, 0, null);
			g.drawImage(game.getAsset().overImg4, 0, 0, null);
			g.drawImage(game.getAsset().overButtom, 33, 65, null);
			g.drawImage(game.getAsset().cursor, -10, cursorY, null);
		}
	}

	@Override
	public boolean isOver() {
		return player.isOver();
	}

	@Override
	public boolean ifStop() {
		return ifQuit;
	}

}

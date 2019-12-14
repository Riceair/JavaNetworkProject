package dev.rsiwater.tetris.state;

import java.awt.Graphics;

import dev.rsiwater.tetris.game.AudioEffects;
import dev.rsiwater.tetris.game.Asset;
import dev.rsiwater.tetris.game.Game;

public class MenuState extends State 
{
	private Asset asset;
	private int cursorY = 215;
	private boolean isPressedUp, isPressedDown, isDecided, ifQuit = false;
	
	public MenuState(Game game) 
	{
		super(game);
		asset = new Asset();
		isDecided = false;
	}

	public void tick() 
	{
		if(!game.getInputHandler().up) isPressedUp = false;
		if(game.getInputHandler().up && !isPressedUp)
		{
			AudioEffects.startMusic(asset.Cursor);
			isPressedUp = true;
			cursorY = 215;
		}
		
		if(!game.getInputHandler().down) isPressedDown = false;
		if(game.getInputHandler().down && !isPressedDown)
		{
			AudioEffects.startMusic(asset.Cursor);
			isPressedDown = true;
			cursorY = 315;
		}
		
		if(game.getInputHandler().space && cursorY == 215)
		{
			isDecided = true;
		}
		else if(game.getInputHandler().space && cursorY == 315)
		{
			ifQuit = true;
		}
	}

	public void render(Graphics g) 
	{
		g.drawImage(Asset.welcomeBG, 0, 0, null);
		g.drawImage(Asset.options, 700, 205, null);
		g.drawImage(Asset.cursor, 610, cursorY, null);
	}


	public boolean isOver() 
	{
		return isDecided;
	}

	public boolean ifStop() {
		return ifQuit;
	}

}

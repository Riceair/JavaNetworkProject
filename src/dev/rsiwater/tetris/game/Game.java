package dev.rsiwater.tetris.game;

import dev.rsiwater.tetris.screen.*;
import dev.rsiwater.tetris.state.*;
import dev.rsiwater.tetris.inputhandler.*;

import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game implements Runnable
{
	private Graphics g;
	private BufferStrategy bs;
	private  boolean loading;
	
	private Screen screen;
	private BufferedImage sheet;
	private Asset asset;
	private State state;
	private InputHandler inputHandler;
	private boolean running = false;

	public Game()
	{
		asset = new Asset();
	}
	public Asset getAsset() {return asset;}
	public InputHandler getInputHandler() {return inputHandler;}
	public void init()
	{
		screen = new Screen();
		inputHandler = new InputHandler();
		screen.getFrame().addKeyListener(inputHandler);
		screen.display();
		
		state = new MenuState(this);
		state.setState(state);
	}
	
	public synchronized void start()
	{
		running = true;
		asset.init();
		Audio.startMusic(asset.openingMusic);
		new Thread(this).start();
	}
	public synchronized void stop()
	{
		running = false;
		screen.getFrame().setVisible(false);
		screen.getFrame().dispose();
	}
	
	public void tick() //this function is for update program logic function.
	{
		inputHandler.tick();
		
		if(state.getState() != null)
		{
			state.tick();
			if(state.isOver())
			{
				if(state.getClass().equals(MenuState.class))
				{
					state = new ConnectState(this);
					state.setState(state);
					render();
				}
				else if(state.getClass().equals(ConnectState.class)) {
					state = new GameState(this);
					Audio.startMusic(asset.gameMusic);
					state.setState(state);
				}
				else if(state.getClass().equals(GameState.class)) {
					state = new GameState(this);
					Audio.startMusic(asset.gameMusic);
					state.setState(state);
				}
			}
		}
		if(state.ifStop())
		{
			this.stop();
		}
	}
	public void render() //this function is for update screen graphic.
	{
		bs = screen.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			screen.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen from here
		g.clearRect(0, 0, Screen.WIDTH, Screen.HEIGHT);
		//drawing something from here
		if(state.getState() != null)state.render(g);
		
		//ending drawing
		bs.show();
		g.dispose();
	}
	//below is calculating screen framing. no need to modify.
	@Override
	public void run() 
	{
		long lastTimer = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		double delta = 0;
		int frame = 0;
		
		long lastTimerPerSec = System.currentTimeMillis();
		
		init();
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTimer) / nsPerTick;
			lastTimer = now;
			
			if(delta >= 1)
			{
				tick();
				render();
				delta--;
				frame++;
			}
			if(System.currentTimeMillis() - lastTimerPerSec >= 1000)
			{
				//System.out.println("frames = " + frame);
				frame = 0;
				lastTimerPerSec+=1000;
			}
		}
	}
}

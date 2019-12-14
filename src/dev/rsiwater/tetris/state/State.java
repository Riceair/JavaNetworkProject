package dev.rsiwater.tetris.state;

import dev.rsiwater.tetris.game.*;
import java.awt.Graphics;

public abstract class State 
{
	protected static State currentState = null;
	protected static Game game;
	
	public State(Game game) {this.game = game;}
	
	public static void setState(State state){currentState = state;}
	public static State getState() {return currentState;}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract boolean isOver();
	public abstract boolean ifStop();
}

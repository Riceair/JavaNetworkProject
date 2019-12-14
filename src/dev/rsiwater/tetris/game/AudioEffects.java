package dev.rsiwater.tetris.game;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class AudioEffects 
{
	public static Clip clip;
	
	public static void startMusic(String path)
	{
		try
		{
			//System.out.println(path);
			File file = new File(path);
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
		}
		catch (Exception e)
		{
			System.out.println("error path of music!");
		}
	}
	public static void stopMusic()
	{
		clip.close();
	}
}

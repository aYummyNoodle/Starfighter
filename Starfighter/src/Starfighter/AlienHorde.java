package Starfighter;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
	private int size;
	private int tick;
	private int origSize;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		this.size = size;
		origSize = size;
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien al : aliens)
			al.draw(window);
	}

	public void moveEmAll()
	{
		tick++;
		for (Alien al : aliens) 
		{
			if (tick <= 120)
				al.move("RIGHT");
			else if (tick <= 320)
				al.move("DOWN");
			else if (tick <= 440)
				al.move("LEFT");
			else if (tick <= 640)
				al.move("UP");
			else if (tick <= 1000)
				tick = 0;
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (int i = 0; i < shots.size(); i++)
		{
			for (int j = 0; j < aliens.size(); j++)
			{
				try
				{
					if (shots.get(i).isCollide(aliens.get(j))) 
					{
						shots.remove(i);
						aliens.remove(j);
						size--;
					}
					
				} catch (Exception e)
				{
					 
				}
			}
		}
	}
	
	public void checkShipDeath(Ship ship)
	{
		for (int i = 0; i < aliens.size(); i++)
		{
			if (ship.isCollide(aliens.get(i)))
			{
				System.out.println("You lose. You killed " + (origSize - aliens.size()) + " aliens.");
				System.exit(0);
			}
		}
	}
	
	public Alien getAlien(int i)
	{
		return aliens.get(i);
	}
	
	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		return "";
	}
}

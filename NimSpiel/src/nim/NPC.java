package nim;

import java.util.Random;

public class NPC implements Runnable
{
	private String name;
	private Random anzahl=new Random();
	private int take=0;
	
	public NPC(String name)
	{
		this.name=name;
	}

	@Override
	public void run()
	{
		while(!(Field.getMatches()<=0))
		{
			synchronized(Field.class)
			{
				if(!(Field.getMatches()==0))
				{
					while(!(take>0))
					{
						take=anzahl.nextInt(3);
					}
					
					if(take>0&&take<4)
					{
						Field.removeMatch(take);
						
						System.out.println("Der Spieler " + name + " hat " + take + " Streichhoelzer genommen.\nEs sind jetzt noch " 
											+ Field.getMatches() + " Streichhoelzer auf dem Spielfeld.\n");
						
						if((Field.getMatches()==0))
						{
							System.out.println("Spieler " + name + " hat verloren!");
						}
						
						Field.class.notify();
						try
						{
							Field.class.wait();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
				
			}
			
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		
		System.out.println("'/////' The End!!! '\\\\\'");
	}
	
}

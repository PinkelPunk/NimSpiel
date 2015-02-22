package nim;

import java.util.Scanner;

public class Player implements Runnable
{
	private String name;
//	private NPC npc1;
//	private NPC npc2;
//	private NPC npc3;
	private Scanner scan=new Scanner(System.in);
	private int anzahl;
	
	public Player(String name)
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
					do
					{
						if((Field.getMatches()>=3))
						{
							System.out.println("Wie viele Streichhoelzer willst du nehmen?(1-3)");
							anzahl=scan.nextInt();
							if((anzahl<1)||(anzahl>3))
							{
								System.out.println("Bitte nur 1-3 Streichhoelzer nehmen!");
							}
						}
						else if((Field.getMatches()==2))
						{
							System.out.println("Wie viele Streichhoelzer willst du nehmen?(1-2)");
							anzahl=scan.nextInt();
							if(!(anzahl==1)||!(anzahl==2))
							{
								System.out.println("Bitte nur 1-2 Streichhoelzer nehmen!");
							}
						}
						else if((Field.getMatches()==1))
						{
							System.out.println("Es ist das letzte Streichholz und du MUSST es nehmen...also tipp schon die 1 ein!");
							anzahl=scan.nextInt();
							if(!(anzahl==1))
							{
								System.out.println("Bitte nur 1 Streichholz nehmen!");
							}
						}
					}while((anzahl<1)||(anzahl>3));
					
					Field.removeMatch(anzahl);
					
					System.out.println(name + " hat " + anzahl + " Streichholzer genommen.\n" + "Jetzt es noch " 
										+ Field.getMatches() + " Streichoelzer auf dem Spielfeld.\n");
					
					if((Field.getMatches()==0))
					{
						System.out.println("Du hast das letzte Streichholz genommen und somit verloren.");
					}
					
					
					
					Field.class.notifyAll();
					try
					{
						Field.class.wait();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Da sind keine Streichhoelzer mehr auf dem Spielfeld!");
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

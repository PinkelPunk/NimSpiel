package nim;

public class Main
{

	public static void main(String[] args)
	{
		Player player=new Player("Pinky");
		NPC npc1=new NPC("npc1");
		NPC npc2=new NPC("npc2");
		NPC npc3=new NPC("npc3");
		
		new Thread(player).start();
		new Thread(npc1).start();
		new Thread(npc2).start();
		new Thread(npc3).start();
		
	}

}

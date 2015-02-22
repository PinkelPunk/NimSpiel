package nim;

public class Field
{
	//private static Match[] matches=new Match[15];
	private static int matches=15;
	/**
	 * @return the matches
	 */
	public static int getMatches()
	{
		return matches;
	}
	
	/**
	 * @param matches the matches to remove 
	 */
	public static void removeMatch(int anzMatches)
	{
		if((anzMatches>0)&&(anzMatches<4))
		{
			for(int i=0; i<anzMatches; i++)
			{
				if(getMatches()>0)
				{
					System.out.println("Streichholz Nr. " + matches + " vom Spielfeld genommen!\n");
				}
				matches--;
				if(getMatches()>0)
				{
					System.out.println("Noch " + matches + " auf dem Spielfeld!\n");
				}
			}
		}
	}
}
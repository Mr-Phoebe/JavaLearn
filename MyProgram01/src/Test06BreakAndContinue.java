
public class Test06BreakAndContinue {
	public static void main(String []args)
	{
		int total = 0;
		System.out.println("Begin");
		while(true)
		{
			total++;
			int i = (int)Math.round(100 * Math.random());
			if(i == 88)
			{
				break;
			}
		}
		
		System.out.println("Game over , used " + total + " times.");
		
		for(int i = 100;i<= 150;i ++)
		{
			if(i %3== 0)
			{
				System.out.println();
				continue;
			}
			System.out.print(i+"\t");
		}
	}
}

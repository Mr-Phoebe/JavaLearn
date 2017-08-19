
public class TestSwitch {
	public static void main(String []args)
	{
		double d = Math.random();
		System.out.println(d);
		int e = 1 + (int)(d * 6);
		System.out.println(e);
		switch(e)
		{
		case 6:
			System.out.println("运气很好");
//			break;		
		case 5:
			System.out.println("运气一般");
//			break;	
		case 4:
			System.out.println("运气还行");
//			break;
		default:
			System.out.println("运气不好");
//			break;
		}
	}
}

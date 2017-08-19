public class TestFor {
	public static void main(String []args)
	{
		for(int a = 0;a <= 100;a ++)
		{
//			System.out.println(a);
		}
		
		int Sum = 0;
		for(int i = 0;i <= 100;i += 2)
		{
			Sum += i;
		}
//		System.out.println(tmp);
		Sum = 0;
		for(int j = 1;j <= 100;j ++)
		{
			for(int i = 1;i <= j;i ++)
			{
				Sum += i;
			}
		}
		System.out.println(Sum);
		Sum = 1;
		for(int i = 1;i <= 10;i ++)
		{
			Sum +=(Sum * i);
		}
		System.out.println(Sum);
		
		for(int i = 0;i < 1000;)
		{
			for(int j = 0;j < 3;j ++)
			{
				System.out.print(i + " ");
				 i+=5;
			}
			System.out.println();
		}
	}
}

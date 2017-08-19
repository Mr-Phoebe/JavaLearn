/**
 * 递归的学习
 * @author kuen
 * Email:kunzhao126@126.com
 * 时间：2017年8月18日
 */
public class Test07Recursion {
	public static void test01(int count)
	{
		
		count ++;
		if(count == 100)
		{
			return;
		}
		test01(count);
		System.out.println(count + "Test07Recursion.test01()");
	}
	public static void test02()
	{
		int count = 0;
		System.out.println("Test07Recursion.test02()");
		test01(count);
	}
	
	public static long factorial(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		return n * factorial(n-1);
	}
	public static void main(String []args)
	{
		System.out.println(factorial(10));
	}
}

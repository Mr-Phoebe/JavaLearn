/**
 * 
 * @author kuen
 * Email:kunzhao126@126.com
 * 时间：2017年8月18日
 */


public class TestMethod {
	/*
	 *test01方法 ：方便代码的复用
	 */
	public static void Test01()
	{
		System.out.println(" Test01");
	}
	//返回值int 形参 int int 
	public static int add(int a,int b)
	{
		return a + b;
	}
	public static void main(String []args){
		Test01();
		Test01();
		Test01();
		Test01();
		
		System.out.println(add(3,5));
	}
}

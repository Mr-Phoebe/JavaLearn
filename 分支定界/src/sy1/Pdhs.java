package sy1;

/*
 * 寻找一组数据中的最大值最小值，第一个正数，第一个负数以及它们对应的下标
 */
public class Pdhs {
	//计算输入的所有数中的最大值及其下标
	public double[] max(double[] x,int n){
		int i,c=0;
		double max;//最大值
		double result[];
		result=new double[2];
		max=x[0];
		for(i=1;i<n;i++){
			if(x[i]>max){
				max=x[i];
				c=i;
			}
		}
		result[0]=max;//最大值
		result[1]=c;  //下标
		return result;   //返回最大值及其下标
	}
	//计算输入的所有数中的最小值及其下标
	public double[] min(double x[],int n){
		int i,c=0;
		double min;
		double result[];
		result=new double[2];
		min=x[0];
		for(i=1;i<n;i++){
			if(x[i]<min){
				min=x[i];
				c=i;
			}
		}
		//System.out.println(min);
		result[0]=min;
		result[1]=c;
		return result;
	} 
	// 找出数据中的第一个正数及其下标
	public double[] pos(double x[],int n){
		int i,flag1;
		double result[];
		result=new double[2];
		for(i=0;i<n;i++){
			if(x[i]>0){
				flag1=i;
				result[0]=x[i];
				result[1]=flag1;
				break;
			}
		}
		return result;
	} 
	// 找出数据中的第一个负数及其下标
	public double[] neg(double x[],int n){
		int i,flag2;
		double result[];
		result=new double[2];
		for(i=0;i<n;i++){
			if(x[i]<0){
				flag2=i;
				result[0]=x[i];
				result[1]=flag2;
				break;
			}
		}
		return result;
	} 
}

package sy1;

/*
 * Ѱ��һ�������е����ֵ��Сֵ����һ����������һ�������Լ����Ƕ�Ӧ���±�
 */
public class Pdhs {
	//����������������е����ֵ�����±�
	public double[] max(double[] x,int n){
		int i,c=0;
		double max;//���ֵ
		double result[];
		result=new double[2];
		max=x[0];
		for(i=1;i<n;i++){
			if(x[i]>max){
				max=x[i];
				c=i;
			}
		}
		result[0]=max;//���ֵ
		result[1]=c;  //�±�
		return result;   //�������ֵ�����±�
	}
	//����������������е���Сֵ�����±�
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
	// �ҳ������еĵ�һ�����������±�
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
	// �ҳ������еĵ�һ�����������±�
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

package sy1;
//��׼��ϵ������  �������˹�����
public class BzhAndJrg {
	public double A[][];  //ԭ�����ϵ������
	public String D[];   //ԭ����ķ��ž���
	public double b[];    //ԭ����ĳ�������
	public double B[][];    //ԭ�����׼�����ϵ������
	public double R[][];  //��׼����������˹�����֮���ϵ������
	public double C[];//Ŀ�꺯���ĳ�ʼϵ������
	public double c[];//��׼��֮��Ŀ�꺯����ϵ������
	int N,M;
	public BzhAndJrg(int m,int n,double a[][],double b1[],String d[],double C1[]){
		N=n;
		M=m;
		A=a;
		D=d;
		b=b1;
		C=C1;
		B=new double[m][n+m];//��׼������//��ά����
		c=new double[n+m];//��׼�����ϵ��//һά����
		R=new double[m][n+m+m];//��׼��������˹�������ϵ������//��ά����
		for(int i=0;i<m;i++){
			for(int j=0;j<m+n+m;j++){
				R[i][j]=0;
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<m+n;j++){
				B[i][j]=0;
			}
		}
	}
	//��׼��Ŀ�꺯����ϵ������
	
	//�ú���Ӧ�ô���Ĳ���Ϊ��������У�������У��Լ������ϵ���������Լ�Ҫ���صı�׼��Ŀ�꺯��ϵ������
	//�����ǵĺ����У�����ֻ����һ��ͼmgraph����
	public double[] bc(){
		for(int i=0;i<N+M;i++){
			if(i<N)
			c[i]=C[i];
			else
				c[i]=0;
		}
		return c;
	}
	//��׼��ϵ������
	//�ú���Ӧ�ô���Ĳ���Ϊ��������У�������У��Լ������ϵ���������;���ķ����������Լ�Ҫ���صı�׼��ϵ������
	public double[][] bzh(){
		//b.length��ʾ������У�A[i].length��ʾ�������
		for(int i=0;i<b.length;i++){
			for(int j=0;j<A[i].length;j++){
				B[i][j]=A[i][j];
				//System.out.print(B[i][j]+" ");
			}
			//System.out.println();
		}
		for(int i=0;i<b.length;i++){
			if(D[i].equals(">")){//���������ʣ�����
				B[i][A[i].length+i]=-1; 
			}
			else if(D[i].equals("<")){//С��������ɳڱ���
				B[i][A[i].length+i]=1;
			}
			else if(D[i].equals("="))
				B[i][A[i].length+i]=0;
		}
		return B;
	}
	//�Ա�׼��ϵ��������˹����� 
	/*
	 * �����˹���������������������У�������У��Լ���׼���ľ����ϵ���������Լ�Ҫ���ص�����˹������ı�׼��ϵ������
	 * 
	 */
	public double[][] jrgbl(){
		B=bzh();
		//b.length��ʾ
		for(int i=0;i<b.length;i++){
			for(int j=0;j<B[i].length;j++){
				R[i][j]=B[i][j];
			}
		}
		for(int i=0;i<b.length;i++){
			R[i][B[i].length+i]=1;
		}
		return R;
	}
}

package sy2;

import java.util.Scanner;

import sy1.TwoStepMethod;

/*
 * ������Գ���
 */
public class Text {
	public static void main(String args[]){
		int M=2,N=2;//M��Լ������������N��δ֪������
		double A[][]=new double[M][N];
		double b[]=new double[M];
		String D[]=new String[M];//ԭ��������
		double C[]=new double[N];//ԭĿ�꺯����ϵ������
		Scanner S=new Scanner(System.in);
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				A[i][j]=S.nextDouble();
				//System.out.print(" ");
			}
			//System.out.println();
		}
		for(int i=0;i<M;i++){
			b[i]=S.nextDouble();
			//System.out.print(" ");
		}
		for(int i=0;i<M;i++){
			D[i]=S.next();
			//System.out.print(" ");
		}
		for(int i=0;i<N;i++){
			C[i]=S.nextDouble();
			//System.out.print(" ");
		}
		System.out.println("�������ʼ����ķ��̸���"+M);
		System.out.println("�������ʼδ֪���ĸ���"+N);
		System.out.println("�������ʼ�����ϵ������");
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(A[i][j]+"   ");
			}
			System.out.println();
		}
		System.out.println("�������ʼ����ĳ����");
		for(int i=0;i<M;i++){
			System.out.print(b[i]+" ");
		}
		System.out.println("\n"+"�������ʼ����ķ����");
		for(int i=0;i<M;i++){
			System.out.print(D[i]+" ");
		}
		System.out.println("\n"+"�����Ŀ�꺯����ϵ��������");
		for(int i=0;i<N;i++){
			System.out.print(C[i]+" ");
		}
		System.out.println("\n\n��֧���編���̣�");
		double A1[][]=new double[M][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				A1[i][j]=A[i][j];
			}
		}
		double b1[]=new double[M];
		for(int i=0;i<M;i++){
			b1[i]=b[i];
		}
		String D1[]=new String[M];
		for(int i=0;i<M;i++){
			D1[i]=D[i];
		}
		double x[]=new double[N];
		
		
		FenZhiDingJie fzdj=new FenZhiDingJie(A, b, D, C);
		
		
		fzdj.FZDJ(A1, b1, D1, C,x);
		System.out.print("���������Թ滮��������Ž�ΪX={");
		for(int i=0;i<N-1;i++){
			System.out.print(fzdj.Ix[i]+",");
		}
		System.out.print(fzdj.Ix[N-1]+"}");
		System.out.println("\n���������Թ滮���������ֵΪ��Z="+fzdj.Z);
	}
}
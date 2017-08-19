package sy2;

import java.util.Scanner;

import sy1.TwoStepMethod;

/*
 * 代码测试程序
 */
public class Text {
	public static void main(String args[]){
		int M=2,N=2;//M是约束条件个数，N是未知数个数
		double A[][]=new double[M][N];
		double b[]=new double[M];
		String D[]=new String[M];//原符号向量
		double C[]=new double[N];//原目标函数的系数向量
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
		System.out.println("请输出初始矩阵的方程个数"+M);
		System.out.println("请输出初始未知数的个数"+N);
		System.out.println("请输出初始矩阵的系数矩阵：");
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(A[i][j]+"   ");
			}
			System.out.println();
		}
		System.out.println("请输出初始矩阵的常数项：");
		for(int i=0;i<M;i++){
			System.out.print(b[i]+" ");
		}
		System.out.println("\n"+"请输出初始矩阵的符号项：");
		for(int i=0;i<M;i++){
			System.out.print(D[i]+" ");
		}
		System.out.println("\n"+"请输出目标函数的系数向量：");
		for(int i=0;i<N;i++){
			System.out.print(C[i]+" ");
		}
		System.out.println("\n\n分支定界法过程：");
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
		System.out.print("该整型线性规划问题的最优解为X={");
		for(int i=0;i<N-1;i++){
			System.out.print(fzdj.Ix[i]+",");
		}
		System.out.print(fzdj.Ix[N-1]+"}");
		System.out.println("\n该整型线性规划问题的最优值为：Z="+fzdj.Z);
	}
}
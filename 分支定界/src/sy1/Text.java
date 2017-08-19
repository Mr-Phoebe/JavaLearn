package sy1;

import java.util.Scanner;

public class Text {
	public static void main(String args[]){
		int M=3,N=3;//M是约束条件个数，N是未知数个数
		double A[][]=new double[M][N];//系数矩阵
		double b[]=new double[M];//表示常量矩阵
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
		//标准化以及添加人工变量
		double B[][],R[][],c[];//定义B  R  C变量
		BzhAndJrg bad;
		//标准化系数矩阵
		/*
		 * 其中:M表示矩阵的行数,N表示矩阵的列数,A表示约束方程的系数矩阵大小为系数矩阵,
		 * b原矩阵的常量矩阵大小为M,D符号矩阵大小为M,C目标函数的系数矩阵大小为对应的边数
		 */
		bad=new BzhAndJrg(M,N,A,b,D,C);//标准化系数矩阵
		//B=bad.B;
		//c表示标准化之后的系数，该系数的个数为m + n//行的个数+列的个数
		c=bad.bc();//标准化之后目标函数的系数
		//标准化约束方程的系数矩阵，矩阵的大小为m * (m + n),矩阵的行数没有改表，列数增加了m个
		B=bad.bzh();//标准化之后的系数矩阵
		//增加人工变量之后的系数矩阵，该矩阵的大小为：m * (m + m + n)增加人工变量之后矩阵的长度右增加了m
		R=bad.jrgbl();//标准化后添加人工变量之后的系数矩阵
		
		System.out.println("\n请输出标准化后的系数矩阵：");
		for(int i=0;i<M;i++){
			//System.out.println(B[i].length);
			for(int j=0;j<B[i].length;j++){
				System.out.print(B[i][j]+"    ");
			}
			System.out.println();
		}
		/*
		System.out.print("请输出标准化后目标函数的系数向量：");
		for(int i=0;i<M+N;i++){
			System.out.print(c[i]+"  ");
		}*/
		System.out.println("请输出添加了人工变量之后的系数矩阵：");
		for(int i=0;i<M;i++){
			for(int j=0;j<R[i].length;j++){
				System.out.print(R[i][j]+"    ");
			}
			System.out.println();
		}
		System.out.println("\n第一阶段");
		
		
		
		//第一阶段
		//R添加了人工变量之后的系数矩阵
		
		/*
		 * 传入的参数的含义M矩阵的行数,N矩阵的列数,R增加人工变量之后的系数矩阵m * (m + m + n),b常数项矩阵，矩阵的大小为m
		 * 
		 */
		FirstStep fs=new FirstStep(M,N,R,b);
		//double Cr[];//添加人工变量之后目标函数的系数矩阵
		String Xb[];
		double segma[];
		//double seta[];
		//double Cb[];//目标函数中基变量对应的系数向量
		//Cr=fs.c();
		//基变量的大小为m
		Xb=fs.Xb;//获取基变量,
		//Cb=fs.Cb();
		//位置对应的检验数
		segma=fs.sgma();//未知数对应的检验数
		//seta=fs.seta();
		System.out.print("\n请输出未知数对应的检验数segma：");
		for(int i=0;i<N+M+M;i++){
			System.out.print(segma[i]+"  ");
		}
		/*
		//System.out.println("\n"+fs.womiga());
		System.out.print("\n请输出seta：");
		for(int i=0;i<M;i++){
			System.out.print(seta[i]+"  ");
		}*/
		fs.A();//第一阶段找基变量
		if(fs.flag){
			double[] XB=new double[M+N];//定义一个基变量
			for(int i=0;i<M+N;i++){
				XB[i]=0;
			}
			for(int i=0;i<M;i++){
				XB[Integer.parseInt(fs.Xb[i].substring(1))]=fs.b[i];
			}
			System.out.println("请输出经过第一阶段之后的系数矩阵：");
			for(int i=0;i<M;i++){
				for(int j=0;j<M+M+N;j++){
					int w=(int)Math.round(fs.A[i][j]*10);
					double w1=(double)w/10;
					System.out.print(w1+"      ");
				}
				System.out.println();
			}
			/*
			System.out.print("请输出通过两阶段法中单纯形表中的常向量：");
			for(int i=0;i<M;i++){
				System.out.print(fs.b[i]+" ");
			}
			System.out.print("\n请输出通过两阶段法中第一阶段找到的一组基变量：");
			for(int i=0;i<M;i++){
				System.out.print(fs.Xb[i]+" ");
			}
			*/
			System.out.print("\n请输出通过两阶段法中找到的一组基可行解：X0={");
			for(int i=0;i<M+N-1;i++){
				System.out.print(XB[i]+",");
			}
			System.out.print(XB[M+N-1]+"}\n");
			System.out.print("\n请输出未知数对应的检验数segma：");
			for(int i=0;i<N+M+M;i++){
				System.out.print(fs.sgma[i]+"  ");
			}
			/*
			System.out.println("\n"+fs.womiga());
			System.out.print("请输出seta：");
			for(int i=0;i<M;i++){
				System.out.print(fs.seta[i]+"  ");
			}*/
			//第二阶段：
			System.out.println("\n第二阶段");
			double A1[][]=new double[M][M+N];
			System.out.println("请输出经过第一阶段之后去掉人工变量的系数矩阵：");
			for(int i=0;i<M;i++){
				for(int j=0;j<M+N;j++){
					A1[i][j]=fs.A[i][j];
					System.out.print(A1[i][j]+"     ");
				}
				System.out.println();
			}
			
			
			//传入的数据为：M矩阵行，N矩阵列，A1去掉人工变量的系数矩阵，b标准化之后的常数项矩阵
			//Xb获取基变量,,c标准化之后目标函数的系数
			SecondStep ss=new SecondStep(M,N,A1,fs.b,Xb,c);
			double z=0;//最优值
			ss.danchunxing();
			if(ss.flag){
				double b2[];
				String Xb2[];
				b2=ss.b;
				Xb2=ss.Xb;
				double[] X=new double[M+N];//定义一个基变量
				for(int i=0;i<M;i++){
					X[Integer.parseInt(Xb2[i].substring(1))]=b2[i];
				}
				for(int i=0;i<M;i++){
					z=z+ss.b[i]*c[Integer.parseInt(ss.Xb[i].substring(1))];
					//System.out.print(Xb2[i]+"="+b2[i]+"   ");
				}
				/*
				System.out.print("请输出通过两阶段法最终单纯形表中的常向量：");
				for(int i=0;i<M;i++){
					System.out.print(b2[i]+" ");
				}
				*/
				System.out.println("请输出最终的系数矩阵：");
				for(int i=0;i<M;i++){
					for(int j=0;j<N+M;j++){
						System.out.print(ss.A[i][j]+"     ");
					}
					System.out.println();
				}
				System.out.print("\n请输出通过两阶段法得到的最优解：X={");
				for(int i=0;i<N-1;i++){
					System.out.print(X[i]+",");
				}
				System.out.print(X[N-1]+"}\n");
				System.out.println("\n请输出通过两阶段法得到的最优值是："+z);
			}
		}
	}
}
package sy1;
//标准化系数矩阵  并加上人工变量
public class BzhAndJrg {
	public double A[][];  //原矩阵的系数矩阵
	public String D[];   //原矩阵的符号矩阵
	public double b[];    //原矩阵的常数矩阵
	public double B[][];    //原矩阵标准化后的系数矩阵
	public double R[][];  //标准化矩阵添加人工变量之后的系数矩阵
	public double C[];//目标函数的初始系数向量
	public double c[];//标准化之后目标函数的系数向量
	int N,M;
	public BzhAndJrg(int m,int n,double a[][],double b1[],String d[],double C1[]){
		N=n;
		M=m;
		A=a;
		D=d;
		b=b1;
		C=C1;
		B=new double[m][n+m];//标准化矩阵//二维数组
		c=new double[n+m];//标准化后的系数//一维数组
		R=new double[m][n+m+m];//标准化后添加人工变量的系数矩阵//二维数组
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
	//标准话目标函数的系数向量
	
	//该函数应该传入的参数为：矩阵的行，矩阵的列，以及矩阵的系数向量，以及要返回的标准化目标函数系数向量
	//在我们的函数中：可以只传入一张图mgraph即可
	public double[] bc(){
		for(int i=0;i<N+M;i++){
			if(i<N)
			c[i]=C[i];
			else
				c[i]=0;
		}
		return c;
	}
	//标准化系数矩阵
	//该函数应该传入的参数为：矩阵的行，矩阵的列，以及矩阵的系数向量，和矩阵的符号向量，以及要返回的标准化系数矩阵
	public double[][] bzh(){
		//b.length表示矩阵的行，A[i].length表示矩阵的列
		for(int i=0;i<b.length;i++){
			for(int j=0;j<A[i].length;j++){
				B[i][j]=A[i][j];
				//System.out.print(B[i][j]+" ");
			}
			//System.out.println();
		}
		for(int i=0;i<b.length;i++){
			if(D[i].equals(">")){//大于则添加剩余变量
				B[i][A[i].length+i]=-1; 
			}
			else if(D[i].equals("<")){//小于则添加松弛变量
				B[i][A[i].length+i]=1;
			}
			else if(D[i].equals("="))
				B[i][A[i].length+i]=0;
		}
		return B;
	}
	//对标准化系数矩阵加人共变量 
	/*
	 * 加入人工变量函数参数：矩阵的行，矩阵的列，以及标准化的矩阵的系数向量，以及要返回的添加人工变量的标准化系数矩阵
	 * 
	 */
	public double[][] jrgbl(){
		B=bzh();
		//b.length表示
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

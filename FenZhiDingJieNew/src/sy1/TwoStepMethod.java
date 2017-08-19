package sy1;

public class TwoStepMethod {
	public double z=0;
	public double[] X;
	public boolean flag=true;
	public TwoStepMethod(double A[][],double b[],String[] D,double C[]){
		//标准化以及添加人工变量
		int M=b.length;
		int N=C.length;
		System.out.println("b(i)  \n");
		for(int i = 0;i < b.length;i ++)
		{
			System.out.println(b[i] +  "   ");
		}
		System.out.println("\n");
		
		X=new double[N];//定义最优解
		BzhAndJrg bar=new BzhAndJrg(M,N,A,b,D,C);//标准化
		double Cb[]=bar.bc();//标准化后目标函数的系数向量
		double Ar[][]=bar.jrgbl();//加人工变量后的系数向量
		//第一阶段
		FirstStep fs=new FirstStep(M,N,Ar,b);
		//第一阶段找基变量
		fs.A();
		if(fs.flag){
			//第二阶段
			//将第二阶段产生的系数矩阵的前M+N列取出来
			double A1[][]=new double[M][M+N];
			for(int i=0;i<M;i++){
				for(int j=0;j<M+N;j++){
					A1[i][j]=fs.A[i][j];
				}
			}
			SecondStep ss=new SecondStep(M,N,A1,fs.b,fs.Xb,Cb);
			ss.danchunxing();//进行第二阶段的单纯形算法
			if(!ss.flag){
				flag=false;//第二阶段无可行解
			}
			double X1[]=new double[M+N];
			//计算最优解
			for(int i=0;i<M;i++){
				X1[Integer.parseInt(ss.Xb[i].substring(1))]=ss.b[i];
			}
			X=X1;
			//计算最优值
			for(int i=0;i<M;i++){
				z=z+ss.b[i]*Cb[Integer.parseInt(ss.Xb[i].substring(1))];
			}
		}
		else{
			flag=false;//无可行解
			//System.out.println("无可行解");
		}
	}
}
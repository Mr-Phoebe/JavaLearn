package sy2;

import sy1.*;
/*
 * 假设这里所解的整数规划问题的目标函数取的是max
 */
public class FenZhiDingJie {
	double A[][];  //原矩阵的系数矩阵
	String D[];   //原矩阵的符号矩阵
	double b[];    //原矩阵的常数矩阵
	public int count=0;
	int index=-1;
	public double C[];//目标函数的初始系数向量
	public double Uz;//目标函数值下界
	public double Lz;//目标函数值上界
	public double z;//现在的目标函数值
	public double X[];//定义最优解
	public double zX[];//定义最优解
	public double yX[];//定义最优解
	public double Z;//定义整数线性规划的最优值
	public double Ix[];//定义整数线性规划的最优解
	public double As[][];
	public double bs[];
	public String Ds[];
	public double Xs[];
	public int lc;
	int M,N;
	//初始化分支定解法
	FenZhiDingJie(double[][] a,double[] B,String[] d,double[] c){
		M=B.length;
		N=c.length;
		A=a;
		b=B;
		D=d;
		C=c;
		X=new double[N];
		zX=new double[N];
		yX=new double[N];
		Ix=new double[N];
	}
	//分支定解过程
	public void FZDJ(double[][] a,double[] B,String[] d,double[] c,double x[]){
		boolean flag1=true;
		boolean flag2=true;
		//利用两阶段法解出该整数线性规划的最优值的上界（第一次使用两阶段法）
		while(count<10)
		{
			if(count==0)
			{
				System.out.println("\n第 "+count+" 次迭代");
				TwoStepMethod tm=new TwoStepMethod(A,b,D,C);
				if(!tm.flag)
				{
					break;
				}
				X=tm.X;
				x=X;
				Lz=0;
				Uz=-tm.z;
				System.out.print("该整数线性规划问题对应的松弛线性规划问题的最优解是：x={");
				for(int i=0;i<N-1;i++)
				{
					System.out.print(tm.X[i]+",");
				}
				System.out.print(tm.X[N-1]+"}\n");
				System.out.println("该整数线性规划问题对应的松弛线性规划问题的最优值是："+Uz);
				index=AllInteger(X,index);
				if(index==-1)
				{
					System.out.println("该整数线性规划问题的最优解即为它的松弛线性规划问题的最优解，如上所示！");
				}
				//第一次分支
				else
				{
					count++;//跳入分支定解环节
				}// else*/
			}// if
			else
			{//接下来实现继续的分支定解法
				//System.out.println(Lz);
				double A1[][]=new double[B.length+1][N];
				double yA1[][]=new double[B.length+1][N];
				double ytA[][]=new double[B.length+1][N];
				double tA[][]=tempA(a,B.length,index);
				for(int i=0;i<B.length+1;i++)
				{
					for(int j=0;j<N;j++)
					{
						A1[i][j]=tA[i][j];
						yA1[i][j]=tA[i][j];
						ytA[i][j]=tA[i][j];
						//System.out.print(ytA[i][j]+" ");
					}
					//System.out.println();
				}
				double yb1[]=new double[B.length+1];
				double b1[]=new double[B.length+1];
				double ytb[]=tempb(B,(int)x[index]+1);
				double ztb[]=tempb(B,(int)x[index]);
                for(int i=0;i<B.length+1;i++)
                {
					b1[i]=ztb[i];
					yb1[i]=ytb[i];
					//System.out.println(b1[i]+"    "+yb1[i]);
				}
				//左分支
                String D1[]=new String[B.length+1];
				String ztD[]=LeftD(d);
				 for(int i=0;i<B.length+1;i++)
				 {
						D1[i]=ztD[i];
					}
				 String yD1[]=new String[B.length+1];
				 String ytD[]=RightD(d);
				 for(int i=0;i<B.length+1;i++)
				 {
					 
						yD1[i]=ytD[i];
						//System.out.print(yD1[i]+" ");
					}
				TwoStepMethod ztm=new TwoStepMethod(tA,ztb,ztD,c);//左分支利用两阶段法求解
				TwoStepMethod ytm=new TwoStepMethod(ytA,ytb,ytD,c);//左分支利用两阶段法求解
				if(count==1)
				{
					As=yA1;
					bs=yb1;
					Ds=yD1;
					Xs=ytm.X;
				}
				if(ztm.flag)
				{
					double zz=ztm.z;
					zX=ztm.X;
					index=AllInteger(zX,index);
					if(index!=-1)
					{
						//System.out.println(DingJie(z,Uz));
						if(DingJie(zz,Uz))
						{
								//左分支
								System.out.print("第"+count+"次迭代得到一个松弛线性规划的最优解：\nzx={");
								for(int i=0;i<N-1;i++)
								{
									System.out.print(zX[i]+",");
								}// for i
								System.out.print(zX[N-1]+"}\n");
								System.out.println("对应的最优值是："+-zz);
								count++;
								if(-zz<Lz)
								{
									flag1=false;
									lc=count;
								}
						}
						else
						{
								System.out.println("不存在可行解");
								break;
						}
					}
					else
					{
						System.out.print("第 "+count+" 次迭代得到一个可行解:\nzx={");
						for(int i=0;i<N-1;i++)
						{
							System.out.print(zX[i]+",");
						}//for i
						System.out.print(zX[N-1]+"}\n");
						System.out.println("对应的最优值是："+-zz);
						Lz=-zz;
						Z=Lz;//记录可行解对应的目标函数值
						Ix=zX;//记录可行解
						count++;
					}
				}
				else
				{
					flag1=false;
					System.out.println(count+++"次迭代无可行解");
				}
				if(ytm.flag)
				{
					double yz=ytm.z;
					yX=ytm.X;
					index=AllInteger(yX,index);
					if(index!=-1)
					{
						//System.out.println(DingJie(z,Uz));
						if(DingJie(yz,Uz))
						{
							if(DingJie(yz,Uz))
							{
								//右分支
								System.out.print("第"+count+"次迭代得到一个松弛线性规划的最优解：\nyx={");
								for(int i=0;i<N-1;i++)
								{
									System.out.print(yX[i]+",");
								}
								System.out.print(yX[N-1]+"}\n");
								System.out.println("对应的最优值是："+-yz);
								//System.out.println(2);
								if(-yz<Lz){
									flag2=false;
									break;
								}
								//System.out.println(2);
									count++;
							}//if
							else{
									System.out.println("不存在可行解");
									break;
							}
						}
					}else{
						System.out.println("第 "+count+" 次迭代得到一个可行解:\nyx={");
						for(int i=0;i<N-1;i++){
							System.out.print(yX[i]+",");
						}
						System.out.print(yX[N-1]+"}\n");
						System.out.println("对应的最优值是："+-yz);
						Uz=-yz;
						Z=Uz;//记录可行解对应的目标函数值
						Ix=yX;//记录可行解
					}
							}// if
					else{
						flag2=false;
						System.out.println(count+++"次迭代无可行解");
					} 
				    if(flag1){
				    	index=AllInteger(zX,index);
						FZDJ(A1,b1,D1,c,zX);
						count++;
				    }else{
				    	break;
				    }
					index=AllInteger(Xs,index);
					FZDJ(As,bs,Ds,c,Xs);
					break;
				}
			}//else
	}//while
	//确定可行解存在性
	public boolean DingJie(double z,double Uz){
		boolean flag=true;
		//首先保证算出的最优解对应的目标函数值位于整数线性规划问题的目标函数值的上下界中
			if(z<=Lz || z>=Uz){
				flag=true;//表示该分支继续往下分不可能找到一个可行解
			}// if
			else{
				flag=false;
			}
			return flag;
	}
	//判断所给向量的元素是否全为整数如果不是返回对应第一个非整数的下标
	public int AllInteger(double X[],int index){
		boolean flag=true;
		for(int i=0;i<X.length;i++){
			if(X[i]-(int)X[i]!=0){//表示最优解中存在分数
				flag=false;//表示此解不是该整数规划的最优解
				index=i;//记录下最优解中非整数解的位置
				break;
			}// if
		}// for
		if(flag){
			index=-1;
		}
		return index;
	}
	//左分支各参数处理过程
	public String[] LeftD(String d[]){
		String D[]=new String[d.length+1];
		//对D做相应的转换
		for(int i=0;i<D.length;i++){
			if(i<d.length){
				D[i]=d[i];
			}
			else{
				D[i]="<";
			}
		}
		return D;
	}
	//右分支各参数处理过程
	public String[] RightD(String d[]){
		String D[]=new String[d.length+1];
		//对D做相应的转换
		for(int i=0;i<D.length;i++){
			if(i<d.length){
				D[i]=d[i];
			}
			else{
				D[i]=">";
			}
		}
		return D;
	}
	//每次分支扩展参数过程
	public double[][] tempA(double a[][],int m,int index){
		double A[][]=new double[m+1][N];
		//对原约束条件添加一个限制
		for(int i=0;i<m+1;i++){
			if(i<m){
				for(int j=0;j<N;j++){
					A[i][j]=a[i][j];
				}// for
			}// if
			else{
				for(int j=0;j<N;j++){
					if(j==index){
						A[i][j]=1;
					}//if
					else
					{
						A[i][j]=0;
					}// else
				}//for j
			}// else
		}//for i
		return A;
	}
	public double[] tempb(double B[],int Lx){
		double b[]=new double[B.length+1];
		//对b做相应的变换
				for(int i=0;i<B.length+1;i++){
					if(i<B.length){
						b[i]=B[i];
					}// if
					else{
						b[i]=Lx;
					}// else
				}// for i
				return b;
	}
}

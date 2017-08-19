package sy1;
/*
 * 两阶段法的第二阶段（单纯形算法）
 */
public class SecondStep {
	public double A[][];   //未知数的系数矩阵
	public double b[];  //约束条件的常数向量
	public double c[];  //目标函数的系数向量
	public boolean flag=true;
	public String[] Xb; //基变量
	double Cb[];//目标函数中基变量的对应系数
	int M,N;   //约束条件个数为M,未知数个数为N
	double sgma[];
	double seta[];
	public SecondStep(int m,int n,double a[][],double B[],String xb[],double C[]){
		M=m;
		N=n;
		A=a;//初始化系数矩阵
		b=B;//初始化常数矩阵
	    c=C;//初始化目标函数的系数向量
		Xb=xb;//初始化基变量
		Cb=new double[M];//初始化目标函数中基变量对应的系数向量
		sgma=new double[N+M];//初始化检验数
		seta=new double[M];  //初始化seta
	}
	/*
	 * 判断检验数是否全为负
	 */
	public boolean[] psegma(){
		boolean[] temp=new boolean[3];//判断线性规划问题解的存在情况
		boolean flag=true;//用来判断是否有可行解
		boolean flag1=false;//用来判断除了非基变量对应的检验数是否有负的，有为true,无为false
		boolean flag2=true;//用来判断基变量对应的换否全为负
		boolean flag3=false;//用来判断非基变量中是否有检验数为0的
		boolean flag4=true; //用来判断非基变量的检验数是否全为正
		for(int i=0;i<N+M;i++){
			if(sgma[i]<0){//当目标函数为max时改为>0
				flag=false;
				break;
			}
		}
		temp[0]=flag;//判断通过单纯形法是否找到了最优解，如果flag=true表示检验数全都小于等于0
		int t1=0;
		int t2[]=new int[Xb.length];//基变量
		int t3[]=new int[N];//非基变量
		for(int i=0;i<M;i++){
			t2[i]=(int)Integer.parseInt(Xb[i].substring(1));//确定基变量
		}
			//for语句用来进行flag1判断
		//寻找非基变量
		int t5=0;
		for(int j=0;j<M+N;j++){
			int t4=0;
			for(int i=0;i<M;i++){
				if(j==t2[i]){
					t4++;
					//System.out.println(t4);
				}//if
			}//for
			if(t4==0){
				t3[t5]=j;
				//System.out.println(t3[t5]);
				t5++;
			}//if
		}//for j
		//System.out.println(t5);
		//判断非基变量中是否有为负的检验数
		for(int i=0;i<N;i++){
			if(sgma[t3[i]]<0){//当max时改为>
				flag1=true;//有负的检验数
				t1=i;
				break;
			}//if
				}//i
		//判断非基变量为负的列中的值是否全非正
		for(int i=0;i<M;i++){
			if(A[i][t1]>0){
				flag2=false;
				break;
			}
		}
		if(flag1 && flag2){
			temp[1]=true;//表明该线性规划问题有无界解
			//System.out.println(temp[1]);
		}
		//判断非基变量中是否有为0的检验数
		for(int i=0;i<N;i++){
			if(sgma[t3[i]]<0){//当max时改为>
				flag4=false;//有负的检验数
				break;
			}//if
				}//i
		for(int i=0;i<N;i++){
			if(sgma[t3[i]]==0){//当max时改为>
				flag3=true;//有负的检验数
				break;
			}//if
				}//i
		if(flag4 && flag3){
			temp[2]=true;//表明该线性规划问题有无穷多最优解
			//System.out.println(temp[2]);
		}//if
		//System.out.println(temp[2]);
		return temp;//flag=true说明检验数全为负，flag=false说明检验数不全为负
	}
	/*
	 * 找基变量
	 */
	public String[] Xb(){
		for(int i=0;i<M+N;i++){
			int count0=0,count1=0;//用来判断对应未知数的系数向量是不是除了一个1之外，其他的全为0
			for(int j=0;j<M;j++){
				if(A[j][i]==0){
					count0=count0+1;
				}
				else
				if(A[j][i]==1){
					count1=count1+1;
				}
				else
					break;
					}// for j
			if(count1==1 && count0==M-1){
				for(int j=0;j<M;j++){
					if(A[j][i]==1){
						Xb[j]="x"+String.valueOf(i);//改变基变量
					}
				}			
			}
		}
	return Xb;
}
	/*
	 * 寻找目标函数的中基变量对应的系数
	 */
	public double[] Cb(){
		for(int i=0;i<M;i++){
			Cb[i]=c[Integer.parseInt(Xb[i].substring(1))];
		}
		return Cb;
	}
	/*
	 * 计算检验数
	 */
	public double[] sgma(){
		for(int j=0;j<M+N;j++){
			double t=0;//定义一个临时变量
			for(int i=0;i<M;i++){
				//System.out.println(Cb()[i]+" "+A[i][j]);
				t=t+Cb()[i]*A[i][j];
			}
			//System.out.print(c()[j]+" ");
			sgma[j]=c[j]-t;//计算sgmaj=cj-zj
			//System.out.print(sgma[j]+" ");
		}
		return sgma;
	}
	public double[] seta(){
		Pdhs Pd=new Pdhs();
		int index;//sgma最小的未知数的下标
		for(int i=0;i<M;i++){
			index=(int)Pd.min(sgma(), sgma.length)[1];
			//System.out.println("\n"+A[i][index]+b[i]);
			//System.out.print(b[i]+" ");
			if(A[i][index]>0){
				seta[i]=b[i]/A[i][index];
			}
			else
				seta[i]=Double.POSITIVE_INFINITY;//将对应的seta值设为无穷大
		}/*
		for(int i=0;i<M;i++){
			System.out.print(seta[i]+" ");
		}*/
		return seta;
	}
	/*
	 * 单纯形核心算法实现
	 */
	public void danchunxing(){
		double z=0;
		Pdhs p=new Pdhs();//定义对象p以继承类Pdhs中的方法
		Cb=Cb();//初始化目标函数中基变量的对应系数
		sgma=sgma();//初始化检验数
		seta=seta();//初始化seta
		while(!psegma()[0]){
			/*
			System.out.print("\nb:");
			for(int i=0;i<M;i++){
				System.out.print(b[i]+" ");
			}
			System.out.print("\nsgma:");
			for(int i=0;i<M+N;i++){
				System.out.print(sgma[i]+" ");
			}
			/*
			System.out.print("\nseta:");
			for(int i=0;i<M;i++){
				System.out.print(seta[i]+" ");
			} */
			//判断有无无解解
			if(psegma()[1]){
				flag=false;
				System.out.println("\n该线性规划问题有无界解");
				break;
			}
			//判断是否存在无穷多最优解
			if(psegma()[2]){
				System.out.println("\n该线性规划问题有无穷多最优解");
				System.out.println("下面是它的其中一个最优解：");
				for(int i=0;i<M;i++){
					z=z+b[i]*c[Integer.parseInt(Xb[i].substring(1))];
					System.out.println(Xb[i]+"="+b[i]);
				}
				System.out.println("它的最优值是："+z+"\n");
				break;
			}
			//如果最优解唯一则进行如下的单纯形算法
			int index1=0;//定位sgma最小时的列
			int index2=0;//定位seta最小时的行
			index1=(int)p.neg(sgma(), sgma().length)[1];//确定换入变量的列
			index2=(int)p.min(seta(), seta().length)[1];//确定换入变量的行
			//System.out.print(index1+" "+index2);
			for(int i=0;i<M;i++){
				//System.out.println();
				if(i==index2){
					double temp2=A[i][index1];
					b[i]=b[i]/temp2;//将换入变量所在行的常数向除以换入变量所对应的值
					//System.out.println(b[i]);
					for(int j=0;j<M+N;j++){
						if(seta[index2]!=Double.POSITIVE_INFINITY){//保证seta有意义
							//System.out.println(A[i][index1]);
							A[i][j]=A[i][j]/temp2;//将系数矩阵的换入变量所在行的每个元素都同时除以换入变量所对应的值
						}
						else{
							psegma()[0]=true;
							break;
						}//else
					}//for
				}//if
			}//for i
			for(int i=0;i<M;i++){
				if(i!=index2){
					double temp1=A[i][index1];
					b[i]=b[i]-b[index2]*temp1;
				//	System.out.print(b[i]+" ");
					for(int j=0;j<M+N;j++){
								A[i][j]=A[i][j]-A[index2][j]*temp1;//将换入变量所对应的列的除换入变量所对应的行之外的元素都变为0
								//System.out.println(A[i][index1]+" "+i);
						//System.out.println();
					}
				}
			}
			if(psegma()[0])
			{
				flag=false;
				System.out.println("原线性规划问题无可行解");
				break;
			}
			/*
			System.out.print("\nXb:");
			for(int i=0;i<M;i++){
				System.out.print(Xb()[i]+"="+b[i]+" ");
			}*/
			Xb=Xb();//计算Xb
			Cb=Cb();//计算Cb
			sgma=sgma();//计算sgma
			seta=seta();//计算seta
			/*
			System.out.print("Cb:");
			for(int i=0;i<M;i++){
				System.out.print(Cb[i]+" ");
			}*/
			/*
			System.out.print("\nc:");
			for(int i=0;i<M+M+N;i++){
				System.out.print(c[i]+" ");
			}
			System.out.println("请输出经过第二阶段之后的系数矩阵：");
			for(int i=0;i<M;i++){
				for(int j=0;j<M+N;j++){
					System.out.print(A[i][j]+"    ");
				}
				System.out.println();
			}
			System.out.print("\nsgma:");
			for(int i=0;i<M+N;i++){
				System.out.print(sgma[i]+" ");
			}
			System.out.print("\nseta:");
			for(int i=0;i<M;i++){
				System.out.print(seta[i]+" ");
			} */
		}//while
	}
}

package sy1;
/*
 * ���׶η��ĵڶ��׶Σ��������㷨��
 */
public class SecondStep {
	public double A[][];   //δ֪����ϵ������
	public double b[];  //Լ�������ĳ�������
	public double c[];  //Ŀ�꺯����ϵ������
	public boolean flag=true;
	public String[] Xb; //������
	double Cb[];//Ŀ�꺯���л������Ķ�Ӧϵ��
	int M,N;   //Լ����������ΪM,δ֪������ΪN
	double sgma[];
	double seta[];
	public SecondStep(int m,int n,double a[][],double B[],String xb[],double C[]){
		M=m;
		N=n;
		A=a;//��ʼ��ϵ������
		b=B;//��ʼ����������
	    c=C;//��ʼ��Ŀ�꺯����ϵ������
		Xb=xb;//��ʼ��������
		Cb=new double[M];//��ʼ��Ŀ�꺯���л�������Ӧ��ϵ������
		sgma=new double[N+M];//��ʼ��������
		seta=new double[M];  //��ʼ��seta
	}
	/*
	 * �жϼ������Ƿ�ȫΪ��
	 */
	public boolean[] psegma(){
		boolean[] temp=new boolean[3];//�ж����Թ滮�����Ĵ������
		boolean flag=true;//�����ж��Ƿ��п��н�
		boolean flag1=false;//�����жϳ��˷ǻ�������Ӧ�ļ������Ƿ��и��ģ���Ϊtrue,��Ϊfalse
		boolean flag2=true;//�����жϻ�������Ӧ�Ļ���ȫΪ��
		boolean flag3=false;//�����жϷǻ��������Ƿ��м�����Ϊ0��
		boolean flag4=true; //�����жϷǻ������ļ������Ƿ�ȫΪ��
		for(int i=0;i<N+M;i++){
			if(sgma[i]<0){//��Ŀ�꺯��Ϊmaxʱ��Ϊ>0
				flag=false;
				break;
			}
		}
		temp[0]=flag;//�ж�ͨ�������η��Ƿ��ҵ������Ž⣬���flag=true��ʾ������ȫ��С�ڵ���0
		int t1=0;
		int t2[]=new int[Xb.length];//������
		int t3[]=new int[N];//�ǻ�����
		for(int i=0;i<M;i++){
			t2[i]=(int)Integer.parseInt(Xb[i].substring(1));//ȷ��������
		}
			//for�����������flag1�ж�
		//Ѱ�ҷǻ�����
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
		//�жϷǻ��������Ƿ���Ϊ���ļ�����
		for(int i=0;i<N;i++){
			if(sgma[t3[i]]<0){//��maxʱ��Ϊ>
				flag1=true;//�и��ļ�����
				t1=i;
				break;
			}//if
				}//i
		//�жϷǻ�����Ϊ�������е�ֵ�Ƿ�ȫ����
		for(int i=0;i<M;i++){
			if(A[i][t1]>0){
				flag2=false;
				break;
			}
		}
		if(flag1 && flag2){
			temp[1]=true;//���������Թ滮�������޽��
			//System.out.println(temp[1]);
		}
		//�жϷǻ��������Ƿ���Ϊ0�ļ�����
		for(int i=0;i<N;i++){
			if(sgma[t3[i]]<0){//��maxʱ��Ϊ>
				flag4=false;//�и��ļ�����
				break;
			}//if
				}//i
		for(int i=0;i<N;i++){
			if(sgma[t3[i]]==0){//��maxʱ��Ϊ>
				flag3=true;//�и��ļ�����
				break;
			}//if
				}//i
		if(flag4 && flag3){
			temp[2]=true;//���������Թ滮��������������Ž�
			//System.out.println(temp[2]);
		}//if
		//System.out.println(temp[2]);
		return temp;//flag=true˵��������ȫΪ����flag=false˵����������ȫΪ��
	}
	/*
	 * �һ�����
	 */
	public String[] Xb(){
		for(int i=0;i<M+N;i++){
			int count0=0,count1=0;//�����ж϶�Ӧδ֪����ϵ�������ǲ��ǳ���һ��1֮�⣬������ȫΪ0
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
						Xb[j]="x"+String.valueOf(i);//�ı������
					}
				}			
			}
		}
	return Xb;
}
	/*
	 * Ѱ��Ŀ�꺯�����л�������Ӧ��ϵ��
	 */
	public double[] Cb(){
		for(int i=0;i<M;i++){
			Cb[i]=c[Integer.parseInt(Xb[i].substring(1))];
		}
		return Cb;
	}
	/*
	 * ���������
	 */
	public double[] sgma(){
		for(int j=0;j<M+N;j++){
			double t=0;//����һ����ʱ����
			for(int i=0;i<M;i++){
				//System.out.println(Cb()[i]+" "+A[i][j]);
				t=t+Cb()[i]*A[i][j];
			}
			//System.out.print(c()[j]+" ");
			sgma[j]=c[j]-t;//����sgmaj=cj-zj
			//System.out.print(sgma[j]+" ");
		}
		return sgma;
	}
	public double[] seta(){
		Pdhs Pd=new Pdhs();
		int index;//sgma��С��δ֪�����±�
		for(int i=0;i<M;i++){
			index=(int)Pd.min(sgma(), sgma.length)[1];
			//System.out.println("\n"+A[i][index]+b[i]);
			//System.out.print(b[i]+" ");
			if(A[i][index]>0){
				seta[i]=b[i]/A[i][index];
			}
			else
				seta[i]=Double.POSITIVE_INFINITY;//����Ӧ��setaֵ��Ϊ�����
		}/*
		for(int i=0;i<M;i++){
			System.out.print(seta[i]+" ");
		}*/
		return seta;
	}
	/*
	 * �����κ����㷨ʵ��
	 */
	public void danchunxing(){
		double z=0;
		Pdhs p=new Pdhs();//�������p�Լ̳���Pdhs�еķ���
		Cb=Cb();//��ʼ��Ŀ�꺯���л������Ķ�Ӧϵ��
		sgma=sgma();//��ʼ��������
		seta=seta();//��ʼ��seta
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
			//�ж������޽��
			if(psegma()[1]){
				flag=false;
				System.out.println("\n�����Թ滮�������޽��");
				break;
			}
			//�ж��Ƿ������������Ž�
			if(psegma()[2]){
				System.out.println("\n�����Թ滮��������������Ž�");
				System.out.println("��������������һ�����Ž⣺");
				for(int i=0;i<M;i++){
					z=z+b[i]*c[Integer.parseInt(Xb[i].substring(1))];
					System.out.println(Xb[i]+"="+b[i]);
				}
				System.out.println("��������ֵ�ǣ�"+z+"\n");
				break;
			}
			//������Ž�Ψһ��������µĵ������㷨
			int index1=0;//��λsgma��Сʱ����
			int index2=0;//��λseta��Сʱ����
			index1=(int)p.neg(sgma(), sgma().length)[1];//ȷ�������������
			index2=(int)p.min(seta(), seta().length)[1];//ȷ�������������
			//System.out.print(index1+" "+index2);
			for(int i=0;i<M;i++){
				//System.out.println();
				if(i==index2){
					double temp2=A[i][index1];
					b[i]=b[i]/temp2;//��������������еĳ�������Ի����������Ӧ��ֵ
					//System.out.println(b[i]);
					for(int j=0;j<M+N;j++){
						if(seta[index2]!=Double.POSITIVE_INFINITY){//��֤seta������
							//System.out.println(A[i][index1]);
							A[i][j]=A[i][j]/temp2;//��ϵ������Ļ�����������е�ÿ��Ԫ�ض�ͬʱ���Ի����������Ӧ��ֵ
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
								A[i][j]=A[i][j]-A[index2][j]*temp1;//�������������Ӧ���еĳ������������Ӧ����֮���Ԫ�ض���Ϊ0
								//System.out.println(A[i][index1]+" "+i);
						//System.out.println();
					}
				}
			}
			if(psegma()[0])
			{
				flag=false;
				System.out.println("ԭ���Թ滮�����޿��н�");
				break;
			}
			/*
			System.out.print("\nXb:");
			for(int i=0;i<M;i++){
				System.out.print(Xb()[i]+"="+b[i]+" ");
			}*/
			Xb=Xb();//����Xb
			Cb=Cb();//����Cb
			sgma=sgma();//����sgma
			seta=seta();//����seta
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
			System.out.println("����������ڶ��׶�֮���ϵ������");
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

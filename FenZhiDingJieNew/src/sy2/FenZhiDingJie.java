package sy2;

import sy1.*;
/*
 * ������������������滮�����Ŀ�꺯��ȡ����max
 */
public class FenZhiDingJie {
	double A[][];  //ԭ�����ϵ������
	String D[];   //ԭ����ķ��ž���
	double b[];    //ԭ����ĳ�������
	public int count=0;
	int index=-1;
	public double C[];//Ŀ�꺯���ĳ�ʼϵ������
	public double Uz;//Ŀ�꺯��ֵ�½�
	public double Lz;//Ŀ�꺯��ֵ�Ͻ�
	public double z;//���ڵ�Ŀ�꺯��ֵ
	public double X[];//�������Ž�
	public double zX[];//�������Ž�
	public double yX[];//�������Ž�
	public double Z;//�����������Թ滮������ֵ
	public double Ix[];//�����������Թ滮�����Ž�
	public double As[][];
	public double bs[];
	public String Ds[];
	public double Xs[];
	public int lc;
	int M,N;
	//��ʼ����֧���ⷨ
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
	//��֧�������
	public void FZDJ(double[][] a,double[] B,String[] d,double[] c,double x[]){
		boolean flag1=true;
		boolean flag2=true;
		//�������׶η�������������Թ滮������ֵ���Ͻ磨��һ��ʹ�����׶η���
		while(count<10)
		{
			if(count==0)
			{
				System.out.println("\n�� "+count+" �ε���");
				TwoStepMethod tm=new TwoStepMethod(A,b,D,C);
				if(!tm.flag)
				{
					break;
				}
				X=tm.X;
				x=X;
				Lz=0;
				Uz=-tm.z;
				System.out.print("���������Թ滮�����Ӧ���ɳ����Թ滮��������Ž��ǣ�x={");
				for(int i=0;i<N-1;i++)
				{
					System.out.print(tm.X[i]+",");
				}
				System.out.print(tm.X[N-1]+"}\n");
				System.out.println("���������Թ滮�����Ӧ���ɳ����Թ滮���������ֵ�ǣ�"+Uz);
				index=AllInteger(X,index);
				if(index==-1)
				{
					System.out.println("���������Թ滮��������Ž⼴Ϊ�����ɳ����Թ滮��������Ž⣬������ʾ��");
				}
				//��һ�η�֧
				else
				{
					count++;//�����֧���⻷��
				}// else*/
			}// if
			else
			{//������ʵ�ּ����ķ�֧���ⷨ
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
				//���֧
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
				TwoStepMethod ztm=new TwoStepMethod(tA,ztb,ztD,c);//���֧�������׶η����
				TwoStepMethod ytm=new TwoStepMethod(ytA,ytb,ytD,c);//���֧�������׶η����
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
								//���֧
								System.out.print("��"+count+"�ε����õ�һ���ɳ����Թ滮�����Ž⣺\nzx={");
								for(int i=0;i<N-1;i++)
								{
									System.out.print(zX[i]+",");
								}// for i
								System.out.print(zX[N-1]+"}\n");
								System.out.println("��Ӧ������ֵ�ǣ�"+-zz);
								count++;
								if(-zz<Lz)
								{
									flag1=false;
									lc=count;
								}
						}
						else
						{
								System.out.println("�����ڿ��н�");
								break;
						}
					}
					else
					{
						System.out.print("�� "+count+" �ε����õ�һ�����н�:\nzx={");
						for(int i=0;i<N-1;i++)
						{
							System.out.print(zX[i]+",");
						}//for i
						System.out.print(zX[N-1]+"}\n");
						System.out.println("��Ӧ������ֵ�ǣ�"+-zz);
						Lz=-zz;
						Z=Lz;//��¼���н��Ӧ��Ŀ�꺯��ֵ
						Ix=zX;//��¼���н�
						count++;
					}
				}
				else
				{
					flag1=false;
					System.out.println(count+++"�ε����޿��н�");
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
								//�ҷ�֧
								System.out.print("��"+count+"�ε����õ�һ���ɳ����Թ滮�����Ž⣺\nyx={");
								for(int i=0;i<N-1;i++)
								{
									System.out.print(yX[i]+",");
								}
								System.out.print(yX[N-1]+"}\n");
								System.out.println("��Ӧ������ֵ�ǣ�"+-yz);
								//System.out.println(2);
								if(-yz<Lz){
									flag2=false;
									break;
								}
								//System.out.println(2);
									count++;
							}//if
							else{
									System.out.println("�����ڿ��н�");
									break;
							}
						}
					}else{
						System.out.println("�� "+count+" �ε����õ�һ�����н�:\nyx={");
						for(int i=0;i<N-1;i++){
							System.out.print(yX[i]+",");
						}
						System.out.print(yX[N-1]+"}\n");
						System.out.println("��Ӧ������ֵ�ǣ�"+-yz);
						Uz=-yz;
						Z=Uz;//��¼���н��Ӧ��Ŀ�꺯��ֵ
						Ix=yX;//��¼���н�
					}
							}// if
					else{
						flag2=false;
						System.out.println(count+++"�ε����޿��н�");
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
	//ȷ�����н������
	public boolean DingJie(double z,double Uz){
		boolean flag=true;
		//���ȱ�֤��������Ž��Ӧ��Ŀ�꺯��ֵλ���������Թ滮�����Ŀ�꺯��ֵ�����½���
			if(z<=Lz || z>=Uz){
				flag=true;//��ʾ�÷�֧�������·ֲ������ҵ�һ�����н�
			}// if
			else{
				flag=false;
			}
			return flag;
	}
	//�ж�����������Ԫ���Ƿ�ȫΪ����������Ƿ��ض�Ӧ��һ�����������±�
	public int AllInteger(double X[],int index){
		boolean flag=true;
		for(int i=0;i<X.length;i++){
			if(X[i]-(int)X[i]!=0){//��ʾ���Ž��д��ڷ���
				flag=false;//��ʾ�˽ⲻ�Ǹ������滮�����Ž�
				index=i;//��¼�����Ž��з��������λ��
				break;
			}// if
		}// for
		if(flag){
			index=-1;
		}
		return index;
	}
	//���֧�������������
	public String[] LeftD(String d[]){
		String D[]=new String[d.length+1];
		//��D����Ӧ��ת��
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
	//�ҷ�֧�������������
	public String[] RightD(String d[]){
		String D[]=new String[d.length+1];
		//��D����Ӧ��ת��
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
	//ÿ�η�֧��չ��������
	public double[][] tempA(double a[][],int m,int index){
		double A[][]=new double[m+1][N];
		//��ԭԼ���������һ������
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
		//��b����Ӧ�ı任
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

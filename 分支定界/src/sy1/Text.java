package sy1;

import java.util.Scanner;

public class Text {
	public static void main(String args[]){
		int M=3,N=3;//M��Լ������������N��δ֪������
		double A[][]=new double[M][N];//ϵ������
		double b[]=new double[M];//��ʾ��������
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
		//��׼���Լ�����˹�����
		double B[][],R[][],c[];//����B  R  C����
		BzhAndJrg bad;
		//��׼��ϵ������
		/*
		 * ����:M��ʾ���������,N��ʾ���������,A��ʾԼ�����̵�ϵ�������СΪϵ������,
		 * bԭ����ĳ��������СΪM,D���ž����СΪM,CĿ�꺯����ϵ�������СΪ��Ӧ�ı���
		 */
		bad=new BzhAndJrg(M,N,A,b,D,C);//��׼��ϵ������
		//B=bad.B;
		//c��ʾ��׼��֮���ϵ������ϵ���ĸ���Ϊm + n//�еĸ���+�еĸ���
		c=bad.bc();//��׼��֮��Ŀ�꺯����ϵ��
		//��׼��Լ�����̵�ϵ�����󣬾���Ĵ�СΪm * (m + n),���������û�иı�����������m��
		B=bad.bzh();//��׼��֮���ϵ������
		//�����˹�����֮���ϵ�����󣬸þ���Ĵ�СΪ��m * (m + m + n)�����˹�����֮�����ĳ�����������m
		R=bad.jrgbl();//��׼��������˹�����֮���ϵ������
		
		System.out.println("\n�������׼�����ϵ������");
		for(int i=0;i<M;i++){
			//System.out.println(B[i].length);
			for(int j=0;j<B[i].length;j++){
				System.out.print(B[i][j]+"    ");
			}
			System.out.println();
		}
		/*
		System.out.print("�������׼����Ŀ�꺯����ϵ��������");
		for(int i=0;i<M+N;i++){
			System.out.print(c[i]+"  ");
		}*/
		System.out.println("�����������˹�����֮���ϵ������");
		for(int i=0;i<M;i++){
			for(int j=0;j<R[i].length;j++){
				System.out.print(R[i][j]+"    ");
			}
			System.out.println();
		}
		System.out.println("\n��һ�׶�");
		
		
		
		//��һ�׶�
		//R������˹�����֮���ϵ������
		
		/*
		 * ����Ĳ����ĺ���M���������,N���������,R�����˹�����֮���ϵ������m * (m + m + n),b��������󣬾���Ĵ�СΪm
		 * 
		 */
		FirstStep fs=new FirstStep(M,N,R,b);
		//double Cr[];//����˹�����֮��Ŀ�꺯����ϵ������
		String Xb[];
		double segma[];
		//double seta[];
		//double Cb[];//Ŀ�꺯���л�������Ӧ��ϵ������
		//Cr=fs.c();
		//�������Ĵ�СΪm
		Xb=fs.Xb;//��ȡ������,
		//Cb=fs.Cb();
		//λ�ö�Ӧ�ļ�����
		segma=fs.sgma();//δ֪����Ӧ�ļ�����
		//seta=fs.seta();
		System.out.print("\n�����δ֪����Ӧ�ļ�����segma��");
		for(int i=0;i<N+M+M;i++){
			System.out.print(segma[i]+"  ");
		}
		/*
		//System.out.println("\n"+fs.womiga());
		System.out.print("\n�����seta��");
		for(int i=0;i<M;i++){
			System.out.print(seta[i]+"  ");
		}*/
		fs.A();//��һ�׶��һ�����
		if(fs.flag){
			double[] XB=new double[M+N];//����һ��������
			for(int i=0;i<M+N;i++){
				XB[i]=0;
			}
			for(int i=0;i<M;i++){
				XB[Integer.parseInt(fs.Xb[i].substring(1))]=fs.b[i];
			}
			System.out.println("�����������һ�׶�֮���ϵ������");
			for(int i=0;i<M;i++){
				for(int j=0;j<M+M+N;j++){
					int w=(int)Math.round(fs.A[i][j]*10);
					double w1=(double)w/10;
					System.out.print(w1+"      ");
				}
				System.out.println();
			}
			/*
			System.out.print("�����ͨ�����׶η��е����α��еĳ�������");
			for(int i=0;i<M;i++){
				System.out.print(fs.b[i]+" ");
			}
			System.out.print("\n�����ͨ�����׶η��е�һ�׶��ҵ���һ���������");
			for(int i=0;i<M;i++){
				System.out.print(fs.Xb[i]+" ");
			}
			*/
			System.out.print("\n�����ͨ�����׶η����ҵ���һ������н⣺X0={");
			for(int i=0;i<M+N-1;i++){
				System.out.print(XB[i]+",");
			}
			System.out.print(XB[M+N-1]+"}\n");
			System.out.print("\n�����δ֪����Ӧ�ļ�����segma��");
			for(int i=0;i<N+M+M;i++){
				System.out.print(fs.sgma[i]+"  ");
			}
			/*
			System.out.println("\n"+fs.womiga());
			System.out.print("�����seta��");
			for(int i=0;i<M;i++){
				System.out.print(fs.seta[i]+"  ");
			}*/
			//�ڶ��׶Σ�
			System.out.println("\n�ڶ��׶�");
			double A1[][]=new double[M][M+N];
			System.out.println("�����������һ�׶�֮��ȥ���˹�������ϵ������");
			for(int i=0;i<M;i++){
				for(int j=0;j<M+N;j++){
					A1[i][j]=fs.A[i][j];
					System.out.print(A1[i][j]+"     ");
				}
				System.out.println();
			}
			
			
			//���������Ϊ��M�����У�N�����У�A1ȥ���˹�������ϵ������b��׼��֮��ĳ��������
			//Xb��ȡ������,,c��׼��֮��Ŀ�꺯����ϵ��
			SecondStep ss=new SecondStep(M,N,A1,fs.b,Xb,c);
			double z=0;//����ֵ
			ss.danchunxing();
			if(ss.flag){
				double b2[];
				String Xb2[];
				b2=ss.b;
				Xb2=ss.Xb;
				double[] X=new double[M+N];//����һ��������
				for(int i=0;i<M;i++){
					X[Integer.parseInt(Xb2[i].substring(1))]=b2[i];
				}
				for(int i=0;i<M;i++){
					z=z+ss.b[i]*c[Integer.parseInt(ss.Xb[i].substring(1))];
					//System.out.print(Xb2[i]+"="+b2[i]+"   ");
				}
				/*
				System.out.print("�����ͨ�����׶η����յ����α��еĳ�������");
				for(int i=0;i<M;i++){
					System.out.print(b2[i]+" ");
				}
				*/
				System.out.println("��������յ�ϵ������");
				for(int i=0;i<M;i++){
					for(int j=0;j<N+M;j++){
						System.out.print(ss.A[i][j]+"     ");
					}
					System.out.println();
				}
				System.out.print("\n�����ͨ�����׶η��õ������Ž⣺X={");
				for(int i=0;i<N-1;i++){
					System.out.print(X[i]+",");
				}
				System.out.print(X[N-1]+"}\n");
				System.out.println("\n�����ͨ�����׶η��õ�������ֵ�ǣ�"+z);
			}
		}
	}
}
package sy1;

public class TwoStepMethod {
	public double z=0;
	public double[] X;
	public boolean flag=true;
	public TwoStepMethod(double A[][],double b[],String[] D,double C[]){
		//��׼���Լ�����˹�����
		int M=b.length;
		int N=C.length;
		System.out.println("b(i)  \n");
		for(int i = 0;i < b.length;i ++)
		{
			System.out.println(b[i] +  "   ");
		}
		System.out.println("\n");
		
		X=new double[N];//�������Ž�
		BzhAndJrg bar=new BzhAndJrg(M,N,A,b,D,C);//��׼��
		double Cb[]=bar.bc();//��׼����Ŀ�꺯����ϵ������
		double Ar[][]=bar.jrgbl();//���˹��������ϵ������
		//��һ�׶�
		FirstStep fs=new FirstStep(M,N,Ar,b);
		//��һ�׶��һ�����
		fs.A();
		if(fs.flag){
			//�ڶ��׶�
			//���ڶ��׶β�����ϵ�������ǰM+N��ȡ����
			double A1[][]=new double[M][M+N];
			for(int i=0;i<M;i++){
				for(int j=0;j<M+N;j++){
					A1[i][j]=fs.A[i][j];
				}
			}
			SecondStep ss=new SecondStep(M,N,A1,fs.b,fs.Xb,Cb);
			ss.danchunxing();//���еڶ��׶εĵ������㷨
			if(!ss.flag){
				flag=false;//�ڶ��׶��޿��н�
			}
			double X1[]=new double[M+N];
			//�������Ž�
			for(int i=0;i<M;i++){
				X1[Integer.parseInt(ss.Xb[i].substring(1))]=ss.b[i];
			}
			X=X1;
			//��������ֵ
			for(int i=0;i<M;i++){
				z=z+ss.b[i]*Cb[Integer.parseInt(ss.Xb[i].substring(1))];
			}
		}
		else{
			flag=false;//�޿��н�
			//System.out.println("�޿��н�");
		}
	}
}
package OtherProblems;
/*
 * �ж�һ�����Ƿ����������ڲ�
 */

public class IsInTriangle {

	//�ж�һ������һ������ߵ���߻����ұߣ��������������������(���)����⹫ʽ
	public double crossProduct(double x1, double y1,double x2, double y2){
		return x1 * y2 - x2 * y1;
	}
	//�ж��Ƿ����ڲ�����������ζ��㿪ʼ��ʱ�����У������Ƿ�ʼ�����������������
	public boolean isInside(double x1, double y1,double x2, double y2,double x3, double y3,double x, double y){
		//��������β�����ʱ�����룬�ı�һ��˳��
		if(crossProduct(x3 - x1, y3 - y1, x2 - x1, y2 - y1) >= 0){
			double tmpx = x2;
			double tmpy = y2;
			x2= x3;
			y2= y3;
			x3= tmpx;
			y3= tmpy;
		}
		if(crossProduct(x2 - x1, y2 - y1, x - x1, y - y1) < 0)
			return false;
		if(crossProduct(x3 - x2, y3 - y2, x - x2, y - y2) < 0)
			return false;
		if(crossProduct(x1 - x3, y1 - y3, x - x3, y - y3) < 0)
			return false;
		return true;
	}
}

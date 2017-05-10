package OtherProblems;
/*
 * 判断一个点是否在三角形内部
 */

public class IsInTriangle {

	//判断一个点在一条有向边的左边还是右边，利用这个集合上向量积(叉乘)的求解公式
	public double crossProduct(double x1, double y1,double x2, double y2){
		return x1 * y2 - x2 * y1;
	}
	//判断是否在内部，则从三角形顶点开始逆时针运行，看点是否始终在三条向量的左侧
	public boolean isInside(double x1, double y1,double x2, double y2,double x3, double y3,double x, double y){
		//如果三角形不是逆时针输入，改变一下顺序
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

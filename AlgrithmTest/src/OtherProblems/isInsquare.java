package OtherProblems;
/*
 * 判断一个带你是否在矩形内部
 * 	分情况，看是否平行于坐标系，如果不平行，则进行转换
 */
public class isInsquare {

	//左上右下的点
	public boolean isInside(double x1,double y1,double x4,double y4,double x,double y){
		if(x <= x1)
			return false;
		if(x >= x4)
			return false;
		if(y >= y1)
			return false;
		if(y <= y4)
			return false;
		return true;
	}
	//如果不平行
	public boolean isInside(double x1,double y1,double x2,double y2,
			double x3,double y3,double x4,double y4,double x,double y){
		if(y1 == y2){
			return isInside(x1, y1, x4, y4, x, y);
		}
		double l = Math.abs(y4 - y3);
		double k = Math.abs(x3 - x4);
		double s = Math.sqrt(k * k + l * l);
		double sin = l /s;
		double cos = k /s ;
		double x1R = cos*x1 + sin * y1;
		double y1R = -x1*sin + y1 * cos;
		double x4R = cos*x4 + sin * y4;
		double y4R = -x4*sin + y4 * cos;
		double xR = cos*x + sin * y;
		double yR = -x*sin + y * cos;
		return isInside(x1R, y1R, x4R, y4R, xR, yR);
	}
}

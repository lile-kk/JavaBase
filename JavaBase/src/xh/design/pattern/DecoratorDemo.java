package xh.design.pattern;
/**
 * 装饰器模式
 * @author Administrator
 *
 */
public class DecoratorDemo {
	
	public static void main(String[] args){
		Human person = new Person();
		Decorator decorator = new Decorator2(new Decorator1(person));
		decorator.wear();
		decorator.walkToWhere();
	}

}

//定义被装饰者接口
interface Human{
	public void wear();
	public void walkToWhere();
	
}

//定义被装饰着具体类
class Person implements Human{

	@Override
	public void wear() {
		System.out.println("穿什么呢。。？");
		
	}

	@Override
	public void walkToWhere() {
		System.out.println("去哪里呢。。？");
		
	}
	
}
//定义装饰者,抽象类可以不实现接口的所有方法，只选自己想要的方法
//但是抽象类实现接口，可以完全覆盖/重写 接口中的方法，也可只重写接口中的某几个方法
//子类再继承抽象类时，子类重写的方法即为抽象类中未重写接口中的方法。
abstract class Decorator implements Human{
	private Human human;
	
	public Decorator(Human human){
		this.human = human;
	}
	public void wear(){
		human.wear();
	}
	public void walkToWhere(){
		human.walkToWhere();
	}
}

//下面定义两种装饰类
class Decorator1 extends Decorator{

	public Decorator1(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	
	public void getHome(){
		System.out.println("进房子。。");
	}
	
	public void findMap(){
		System.out.println("书房找找Map。。");
	}
	
	@Override
	public void wear() {
		// TODO Auto-generated method stub
		super.wear();
		getHome();
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		findMap();
	}
	
	
}

 class Decorator2 extends Decorator {

	public Decorator2(Human human) {
		super(human);
	}

	public void goClothespress() {
		System.out.println("去衣柜找找看。。");
	}

	public void findPlaceOnMap() {
		System.out.println("在Map上找找。。");
	}

	@Override
	public void wear() {
		// TODO Auto-generated method stub
		super.wear();
		goClothespress();
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		findPlaceOnMap();
	}
}
 
 
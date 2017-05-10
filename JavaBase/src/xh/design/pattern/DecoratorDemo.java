package xh.design.pattern;
/**
 * װ����ģʽ
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

//���屻װ���߽ӿ�
interface Human{
	public void wear();
	public void walkToWhere();
	
}

//���屻װ���ž�����
class Person implements Human{

	@Override
	public void wear() {
		System.out.println("��ʲô�ء�����");
		
	}

	@Override
	public void walkToWhere() {
		System.out.println("ȥ�����ء�����");
		
	}
	
}
//����װ����,��������Բ�ʵ�ֽӿڵ����з�����ֻѡ�Լ���Ҫ�ķ���
//���ǳ�����ʵ�ֽӿڣ�������ȫ����/��д �ӿ��еķ�����Ҳ��ֻ��д�ӿ��е�ĳ��������
//�����ټ̳г�����ʱ��������д�ķ�����Ϊ��������δ��д�ӿ��еķ�����
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

//���涨������װ����
class Decorator1 extends Decorator{

	public Decorator1(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	
	public void getHome(){
		System.out.println("�����ӡ���");
	}
	
	public void findMap(){
		System.out.println("�鷿����Map����");
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
		System.out.println("ȥ�¹����ҿ�����");
	}

	public void findPlaceOnMap() {
		System.out.println("��Map�����ҡ���");
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
 
 
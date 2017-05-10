package xh.design.pattern;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * ����ģʽ�����֣�
 * 	1.���󹤳�����������һ����������ĳ��󹤳�������������̳�ʵ��ʵ��������
 * 	2.���󹤳�ģʽ���ṩ��һ���ӿڣ����ڴ�����ػ������Ķ�����壬������Ҫ��ȷָ���������
 * @author Administrator
 *
 */
public class FactoryPattern {

	public static void main(String[] args){
		NYPizzaStore nyStore= new NYPizzaStore();
		ChicagoPizzaStore chiStore = new ChicagoPizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		out.println("Ethan ordered a " + pizza.getName() + "\n" );
		
		pizza = chiStore.orderPizza("cheese");
		out.print("Join ordered a " + pizza.getName() + "\n");
	}
}

//���󹤳�����
abstract class PizzaStore{
	public Pizza orderPizza(String type){
		Pizza pizza;
		
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	public abstract Pizza createPizza(String type);
	
}

class NYPizzaStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		if(type == "cheese")
			return new NYStyleCheesePizza();
		else {
			return null;
		}
	}
}

class ChicagoPizzaStore extends PizzaStore{
	public Pizza createPizza(String type){
		if(type == "cheese"){
			return new ChicagoStyleCheesePizza();
		}else {
			return null;
		}
	}
}

abstract class Pizza{
	String name;
	String dough;
	String sauce;
	ArrayList toppings = new ArrayList();
	
	void prepare(){
		out.println("Prepareing " + name);
		out.println("Tossing dough...");
		out.println("Adding sauce...");
		out.println("Adding toppings: ");
		for(int i = 0; i < toppings.size(); i++){
			out.println(" " + toppings.get(i));
		}
	}
	void bake(){
		out.println("Bake for 25 minutes at 350 ");
	}
	void cut(){
		out.println("Cutting the pizza into diagonal slices");
	}
	void box(){
		out.println("Place pizza in offical PizzaStore box");
	}
	public String getName(){
		return name;
	}
}

class NYStyleCheesePizza extends Pizza{
	public NYStyleCheesePizza(){
		name= "NY style sauce and cheese pizza";
		dough= "Thin crust Dough";
		sauce = "Marinara Sauce";
		
		toppings.add("Crated Reggiano cheese");
	}
}

class ChicagoStyleCheesePizza extends Pizza{
	public ChicagoStyleCheesePizza(){
		name= "Chicago style Deep dish cheese pizza";
		dough = "Extra thick crust dough";
		sauce = "Plum tomato sauce";
		toppings.add("Shredded Mozzarella cheese");
	}
}

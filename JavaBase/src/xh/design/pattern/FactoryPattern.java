package xh.design.pattern;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * 工厂模式有两种：
 * 	1.抽象工厂方法：定义一个创建对象的抽象工厂方法，由子类继承实现实例化对象；
 * 	2.抽象工厂模式：提供了一个接口，用于创建相关或依赖的对象家族，而不需要明确指定具体的类
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

//抽象工厂方法
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

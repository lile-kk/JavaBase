package xh.design.pattern;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * 命令模式
 * @author Administrator
 *
 */
public class CommanPattern {

	public static void main(String[] args){
		RemoteControl rc = new RemoteControl();
		Light light = new Light();
		TV tv= new TV();
		GarageDoor garageDoor = new GarageDoor();
		
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		TVOnCommand tvOn = new TVOnCommand(tv);
		TVOffCommand tvOff = new TVOffCommand(tv);
		GarageDoorOnCommand garageOn = new GarageDoorOnCommand(garageDoor);
		GarageDoorOffCommand garageOff = new GarageDoorOffCommand(garageDoor);
		
		rc.setCommand(0, lightOn,lightOff);
		rc.setCommand(1, tvOn, tvOff);
		rc.setCommand(2, garageOn, garageOff);
		
		System.out.println(rc);
		
		rc.onButtonWasPressed(0);
		rc.offButtonWasPressed(0);
		rc.onButtonWasPressed(1);
		rc.offButtonWasPressed(1);
		rc.onButtonWasPressed(2);
		rc.offButtonWasPressed(2);
	}
	
}

//调用者，封装请求到命令对象，并调用被请求对象的execute方法
class RemoteControl{
	Command[] onCommands;
	Command[] offCommands;
	
	public RemoteControl(){
		onCommands = new Command[3];
		offCommands = new Command[3];
		
		Command noCommand = new NoCommand();
		for(int i = 0; i < 3; i++){
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}
	
	public void setCommand(int slot,Command on,Command off){
		onCommands[slot] = on;
		offCommands[slot] = off;
	}
	
	public void onButtonWasPressed(int slot){
		onCommands[slot].execute();
	}
	
	public void offButtonWasPressed(int slot){
		offCommands[slot].execute();
	}
	
	public String toString(){
		StringBuffer stringBuf = new StringBuffer();
		stringBuf.append("\n------Remote Control------\n");
		for(int i = 0; i < onCommands.length; i++){
			stringBuf.append("[slot " + i + " ]" + onCommands[i].getClass().getName()
					+ " " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuf.toString();
	}
	
	
}

interface Command{
	public void execute();
}

class NoCommand implements Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
}
//各对象的命令对象
class LightOnCommand implements Command{
	Light light;
	
	public LightOnCommand(Light light){
		this.light = light;
	}
	public void execute() {
		light.on();
	}
}
class LightOffCommand implements Command{
	Light light;
	
	public LightOffCommand(Light light){
		this.light = light;
	}
	public void execute() {
		light.off();
	}
}
class TVOnCommand implements Command{
	TV tv;
	
	public TVOnCommand(TV tv){
		this.tv = tv;
	}
	public void execute() {
		tv.on();
	}
}
class TVOffCommand implements Command{
	TV tv;
	
	public TVOffCommand(TV tv){
		this.tv = tv;
	}
	public void execute() {
		tv.off();
	}
}
class GarageDoorOnCommand implements Command{
	GarageDoor garage;
	
	public GarageDoorOnCommand(GarageDoor garage) {
		this.garage = garage;
	}
	public void execute() {
		garage.on();
	}
}
class GarageDoorOffCommand implements Command{
	GarageDoor garageDoor;
	
	public GarageDoorOffCommand(GarageDoor garage){
		this.garageDoor = garage;
	}
	public void execute() {
		garageDoor.off();
	}
}


/*
 * 各被请求的对象，也就是动作实际的执行者
 */
class Light{
	public void on(){
		System.out.println("Light is on!");
	}
	public void off(){
		System.out.println("Light is off!");
	}
}

class TV{
	public void on(){
		System.out.println("TV is on!");
	}
	public void off(){
		System.out.println("TV is off!");
	}
}

class GarageDoor{
	public void on(){
		System.out.println("GarageDoor is on!");
	}
	public void off(){
		System.out.println("GarageDoor is off!");
	}
}
package Day5;
import java.util.Scanner;
public class FanSol {

	public static void main(String[] args) {
		FanSir khaitan=new FanSir();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Press a key and press enter...");
			scan.next();
			khaitan.pull();
		}
		//Fan khaitan=new Fan();
	}
}
class FanSir{
	State state=new SwitchOffState();
	public void pull() {
		state.pull(this);
	}
}
abstract class State{
	public abstract void pull(FanSir fan);
}
class SwitchOffState extends State{
	@Override
	public void pull(FanSir fan) {
		fan.state=new SwitchOnState();
		System.out.println("switch on state....");
	}
}
class SwitchOnState extends State{
	@Override
	public void pull(FanSir fan) {
		fan.state=new MediumSpeedState();
		System.out.println("Medium speed state....");
	}
}
class MediumSpeedState extends State{
	@Override
	public void pull(FanSir fan) {
		fan.state=new HighSpeedState();
		System.out.println("High speed state....");	
	}
}
class HighSpeedState extends State{
	@Override
	public void pull(FanSir fan) {
		fan.state=new SwitchOffState();
		System.out.println("Switch off state....");
	}
}







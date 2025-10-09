package mindGymDay1;

public class CommandPattern2 {
	public static void main(String[] args) {
		PoliceStation p1=new PoliceStation();
		Corporation cc=new Corporation();
		Hospital gh=new Hospital();
		Command2 deathCommand=new DeathCertificateCommand(gh,cc,p1);
		
		RealSeva seva=new RealSeva();
		seva.setCommand(1, deathCommand);
		seva.runCommand(1);
	}
}
class RealSeva{
	Command2 commands[]=new Command2[5];
	public RealSeva() {
		for(int i=0;i<commands.length;i++) {
			commands[i]=new DummyCommand2();
		}
	}
	public void setCommand(int slot,Command2 command) {
		commands[slot]=command;
	}
	public void runCommand(int slot) {
		commands[slot].execute();
	}
}
class Hospital{
	//private Hospital() {}
	public  void doPostMortem() {
		System.out.println("post mortem done....");
	}
}
class Corporation{
	//private Corporation() {}
	public  void doGiveDeathCertificate() {
		System.out.println("death certificate given...");
	}
}
class PoliceStation{
	//private PoliceStation() {}
	public  void doInvestigation() {
		System.out.println("Police doing investigation...");
	}
}
abstract class Command2{
	public Command2() {
		// TODO Auto-generated constructor stub
	}
	Hospital hospital;Corporation corporation;PoliceStation policeStation;
	
	public Command2(Hospital hospital, Corporation corporation, PoliceStation policeStation) {
		this.hospital = hospital;
		this.corporation = corporation;
		this.policeStation = policeStation;
	}
	public abstract void execute();
}
class DummyCommand2 extends Command2{
	@Override
	public void execute() {
		System.out.println("I am dummy yet to be operational.....");
	}
}
class DeathCertificateCommand extends Command2{
	public DeathCertificateCommand() {
		// TODO Auto-generated constructor stub
	}
	public DeathCertificateCommand(Hospital hospital, Corporation corporation, PoliceStation policeStation) {
		super(hospital,corporation,policeStation);
	}
	@Override
	public void execute() {
		//logic to execute the command
		System.out.println("The process of Death certificate started...");
		this.policeStation.doInvestigation();
		this.hospital.doPostMortem();
		this.corporation.doGiveDeathCertificate();
		System.out.println("Process over...take the Death certificate...");
		
	}
	
}




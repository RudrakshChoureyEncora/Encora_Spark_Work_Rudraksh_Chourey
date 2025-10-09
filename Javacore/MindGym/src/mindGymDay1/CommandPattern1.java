package mindGymDay1;

public class CommandPattern1 {

		public static void main(String[] args) {
			Tv tv=new Tv();
			Ss ss=new Ss();
			
			PapaTvCmd ptc=new PapaTvCmd(tv, ss);
			
			Remote myremote=new Remote();
			myremote.setCommand(0, ptc);
			
			myremote.runCommand(0);
		}
	}

	 class Remote {
		
		Command commands[]=new Command[5];
		public Remote() {
			for(int i=0;i<commands.length;i++) {
				commands[i]=new DummyCommand();
			}
		}
		public void runCommand(int slot) {
			commands[slot].execute();
		}
		public void setCommand(int slot,Command command) {
			commands[slot]=command;
		}
		
	}

	
	

	abstract class Command {
		
		public abstract void execute();
		
	}

class DummyCommand extends Command{
		@Override
		public void execute() {
			System.out.println("i am dummy yet to be operational...");
		}
	}
	class PapaTvCmd extends Command{
		Tv tv;Ss ss;
		public PapaTvCmd(Tv tv, Ss ss) {
			// TODO Auto-generated constructor stub
			this.tv=tv;this.ss=ss;
		}
		@Override
		public void execute() {
			// TODO Auto-generated method stub
			this.tv.switchOnTv();
			this.tv.selectMode(new M1());
			this.tv.newsChannel();
			this.ss.loudNoise();
		}
	}


	class Tv {
		
		public void newsChannel() {
			// TODO Auto-generated method stub
			System.out.println("News Channel On....");
			
		}
		
		public void openChannelMenu() {
			// TODO Auto-generated method stub
			System.out.println("Channel Menu Opened...");
		}
		
		public void serialChannel() {
			// TODO Auto-generated method stub
			System.out.println("Serial Channel on...");
		}
		
		public void switchOnTv() {
			// TODO Auto-generated method stub
			System.out.println("TV Turnned on...");
		}
		
		public void selectMode(Mode m) {
			m.printMode();
		};
	}


	abstract class Mode{
		public abstract void printMode();
	}

	class M1 extends Mode{
		@Override
		public void printMode() {
			// TODO Auto-generated method stub
			System.out.println("Tv Mode....");
		}
	}
	class M2 extends Mode{
		@Override
		public void printMode() {
			// TODO Auto-generated method stub
			System.out.println("Non-Tv Mode....");
		}
	}



	class Ss  {
		
		public void loudNoise() {
			// TODO Auto-generated method stub
			System.out.println("Loud Noise Selected");
		}
		
		public void lowNoice() {
			// TODO Auto-generated method stub
			System.out.println("Low Noise Selected");
		}
	}
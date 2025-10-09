package mindGymDay1;

public class BuilderPattern {
	public static void main(String[] args) {
		Computer mycomputer=new BuilderPattern().new Computer();
		System.out.println(mycomputer);
		mycomputer.setCabinet(new BuilderPattern().new Cabinet());
		System.out.println(mycomputer);
		Computer c =mycomputer.build();
		System.out.println(c);
	}
	class Computer{
		Cpu cpu; Ram ram;Cabinet cabinet;
		public Computer() {
			
		}
		public Computer(Cpu cpu, Ram ram, Cabinet cabinet) {
			this.cpu = cpu;
			this.ram = ram;
			this.cabinet = cabinet;
		}
		public Computer setCpu(Cpu cpu) {
			this.cpu=cpu;
			return this;
		}
		public Computer setRam(Ram ram) {
			this.ram=ram;
			return this;
		}
		public Computer setCabinet(Cabinet cabinet) {
			this.cabinet=cabinet;
			return this;
		}
		public Computer build() {
			return new Computer(cpu,ram,cabinet);
			//return new this;
		}
		@Override
		public String toString() {
			return "Computer [cpu=" + cpu + ", ram=" + ram + ", cabinet=" + cabinet + "]";
		}
		
	}
	class Cpu{
		@Override
		public String toString() {
			return "Cpu Present";
		}
		
	}
	class Ram{
		@Override
		public String toString() {
			return "Ram Present";
		}
		
	}
	class Cabinet{
		@Override
		public String toString() {
			return "Cabinet Present";
		}
		
	}
}









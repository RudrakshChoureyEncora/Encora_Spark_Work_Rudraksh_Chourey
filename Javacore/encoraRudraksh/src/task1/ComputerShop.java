package task1;
/*
 * Nouns should be classes 
 * verbs can not be class names 
 * 
 * common nouns should be abstract
 */




/*
 * Inner classes, Constructor and incapsulation CASE STUDY
 */
public class ComputerShop {
	public static void main(String[] args) {
		
//		Computer mycomp = new ComputerShop().new Computer();// if the computer class is not static
		
//		ComputerShop.Computer mycomp = new ComputerShop.Computer(new ComputerShop.CPU(),null,new ComputerShop.Cab()).build();	
		ComputerShop.Computer mycomp = new ComputerShop.Computer()
				.build();	
		
		mycomp.setCab(new ComputerShop.Cab());
		System.out.println("print res of comp Cab: "+mycomp.cab+"   ,Ram:"+mycomp.ram+"    ,CPU:"+mycomp.cpu);
	}
	static class Computer{
		//properties of computer
		CPU cpu;
		RAM ram;
		Cab cab;
		
		public Computer() {
			// TODO Auto-generated constructor stub
		}
		
		public Computer(CPU cpu, RAM ram, Cab cab) {
			this.cpu=cpu;
			this.cab=cab;
			this.ram=ram;
			// TODO Auto-generated constructor stub
		}
		
		public void setCPU(CPU cpu) {
			this.cpu=cpu;
		}
		
		public void setCab(Cab cab) {
			this.cab=cab;
		}
		
		public void setRAM(RAM ram) {
			this.ram=ram;
		}
		
		
		public Computer build() {
			// TODO Auto-generated constructor stub
			return new Computer(cpu,ram,cab);
//			return new Computer();
			}
	}
	
	static class CPU{
		
	}
	
	static class RAM{
		
	}
	
	static class Cab{
		
	}
	
	
	
	
	class AssemblyLine{
		
	}
}





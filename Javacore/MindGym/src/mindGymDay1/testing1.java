package mindGymDay1;

public class testing1 {
	public static void main(String[] args) {
		
	}
}

interface SoftwareCon{
	public void DevlopSoft();
	public void putAttendance();
}

interface CloudArch{
	public void DevlopCloud();
	public void putAttendance();
}

abstract class Emplyee implements SoftwareCon,CloudArch{
	
	
	@Override
	public void putAttendance() {
		// TODO Auto-generated method stub
		System.out.println("Print Attendance");
	}

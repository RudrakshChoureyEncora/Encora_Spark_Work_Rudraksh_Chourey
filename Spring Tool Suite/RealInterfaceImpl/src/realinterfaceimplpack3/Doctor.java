package realinterfaceimplpack3;

public interface Doctor {
	public void doCure();
}

//the below is the implementation of interface
class MedicalCollege implements Doctor
{
	@Override
	public void doCure() {
		System.out.println("cure method called...");
	}
}
class AyurvedCollege implements Doctor{
	@Override
	public void doCure() {
		System.out.println("cure via ayurved naturopathy....");
		
	}
}
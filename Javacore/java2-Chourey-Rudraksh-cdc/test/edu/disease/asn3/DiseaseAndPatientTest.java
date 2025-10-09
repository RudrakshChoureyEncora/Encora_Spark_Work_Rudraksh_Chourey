package edu.disease.asn3;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class DiseaseAndPatientTest {
	
	@Test
	public void testing() throws Exception{
		DiseaseFileRepository dfp=new DiseaseFileRepository();
		System.out.println(dfp.folderPath);
		try {
			dfp.init("C:\\Users\\Rudraksh.Chourey\\Downloads\\Testing");
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(dfp.folderPath);
		Patient[] p= {new Patient(1,1),new Patient(1,1)};
		p[0].setFirstName("Ram");
		p[1].setFirstName("Shyam");
		p[0].setLastName("Sharma");
		p[1].setLastName("Verma");
		Disease[] d= {new InfectiousDisease(),new NonInfectiousDisease()};
		dfp.save(d, p);
		DiseaseAndPatient dap=dfp.init("C:\\Users\\Rudraksh.Chourey\\Downloads\\Testing");
		System.out.println(dap.getDiseases()[1].getClass());

	}
}

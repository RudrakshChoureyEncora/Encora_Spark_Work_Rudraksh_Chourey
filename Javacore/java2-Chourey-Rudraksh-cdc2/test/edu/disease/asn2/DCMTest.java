package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class DCMTest {
	
	@Test
	public void cunstructorTest() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(5,5);
		dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertEquals(dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81")).getFirstName(),
				dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82")).getFirstName());
		assertThrows(IllegalArgumentException.class,()->{DiseaseControlManager dcm2=new DiseaseControlManagerImpl(-1,-1);});
	}
	
	@Test
	public void addPatientTest() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertEquals(dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81")).getFirstName(),
				dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82")).getFirstName());
		assertThrows(IllegalArgumentException.class,()->{
			dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		});
	}
	
}

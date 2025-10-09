package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class PatientTest {
	
	
	@Test
	public void patientConstructorTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals("Ram",p1.getFirstName());
		assertEquals("Sharma",p1.getLastName());
		assertThrows(IllegalArgumentException.class,()->{Patient p3=new Patient(-1,-1);});
	}
	
	
	@Test
	public void setterGetterTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals("Ram",p1.getFirstName());
		assertEquals("Sharma",p1.getLastName());
		assertEquals("3ca5e924-0521-4034-b0a6-9fe3069eef84", p1.getPatientID().toString());
		
	}
	
	@Test
	public void hashCodeTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		Patient p2=new Patient(2,2);
		p2.setFirstName("Shyam");
		p2.setLastName("Sharma");
		p2.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals(p1.hashCode(),p2.hashCode());
	}
	
	@Test
	public void toStringTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals("Pateint Full Name: Ram Sharma PatientID: 3ca5e924-0521-4034-b0a6-9fe3069eef84", p1.toString());
	}
	
	@Test
	public void equalsTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		Patient p2=new Patient(2,2);
		p2.setFirstName("Shyam");
		p2.setLastName("Sharma");
		p2.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertTrue(p1.equals(p1));
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(null));
		assertFalse(p1.equals(new String()));
	}
	

	@Test
	public void addDiseaseTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertThrows(IndexOutOfBoundsException.class,()->{p1.addDiseaseId(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		p1.addDiseaseId(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));});
	}
	
	@Test
	public void addExposureTest() {
		Patient p1=new Patient(2,2);
		p1.setFirstName("Ram");
		p1.setLastName("Sharma");
		p1.setPatientID(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertThrows(IndexOutOfBoundsException.class,()->{p1.addExposure(new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84")));
		p1.addExposure(new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84")));});
	}
}

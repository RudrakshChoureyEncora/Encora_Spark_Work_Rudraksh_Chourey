package edu.disease.asn3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import edu.disease.asn3.Exposure;

/**
 * Unit tests for {@link DiseaseControlManagerImpl}
 */
public class DCMTest {
	 /**
     * Tests the constructor and basic setters/getters.
     */
	@Test
	public void cunstructorTest() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(5,5);
		dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertEquals(dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81")).getFirstName(),
				dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82")).getFirstName());
		assertThrows(IllegalArgumentException.class,()->{DiseaseControlManager dcm2=new DiseaseControlManagerImpl(-1,-1);});
	}
	
	/**
	 * Testing addPateint and getPatient Methods Properly 
	 */
	@Test
	public void addGetPatientTest() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertEquals(dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81")).getFirstName(),
				dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82")).getFirstName());
		assertThrows(IllegalArgumentException.class,()->{
			dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		});
		assertThrows(IllegalArgumentException.class,()->{
			dcm.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef87"));
		});
	}
	
	/**
	 * Testing addDisease Methods Properly 
	 */
	@Test
	public void addDiseaseTest() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addDisease("SomeDisease", true,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		dcm.addDisease("SomeDisease", false,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertThrows(IllegalArgumentException.class,()->{
			dcm.addDisease("SomeDisease", false,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		});
	}
	
	/**
	 * Testing getDisease Methods Properly 
	 */
	@Test
	public void getDiseaseTest() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addDisease("SomeDisease", true,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		dcm.addDisease("SomeDisease", false,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertThrows(IllegalArgumentException.class,()->{
			dcm.addDisease("SomeDisease", false,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		});
		dcm.getDisease(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		assertThrows(IllegalArgumentException.class,()->{
			dcm.getDisease(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef89"));
		});
	}
	
	/**
	 * Testing addDiseaseToPatient Methods Properly 
	 */
	
	@Test
	public void addDiseaseToPatientTest() throws Exception {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addPatient("Abc", "c", 1, 1,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		
		dcm.addDiseaseToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"),UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef71"));
		assertThrows(IllegalArgumentException.class,()->{ 
			dcm.addDiseaseToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"),UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef71"));
			});
	}
	
	/**
	 * Testing addExposureToPetient Methods Properly 
	 */
	
	@Test
	public void addExposureToPatientTest() throws Exception {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addPatient("Abc", "c", 1, 1,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
		dcm.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"),new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef71")));
		assertThrows(IllegalArgumentException.class,()->{ 
			dcm.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"),new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef72")));
			
		});
	}
	
	
}

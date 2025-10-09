package edu.disease.asn3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;


/**
 * Unit tests for the {@link Exposure} class.
 */
public class ExposureTest {
//	@Test
//	public void exposureTest() throws Exception {
//		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
//		assertEquals("3ca5e924-0521-4034-b0a6-9fe3069eef84",ex.getPatientID().toString());
//		ex.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
//		assertEquals(LocalDateTime.of(2002, 03, 02, 02, 02), ex.getDateTime());
//		ex.setExposureType("I");
//		assertEquals("I",ex.getExposureType());
//		assertThrows(IllegalArgumentException.class, ()->{ex.setExposureType("j");});
//		assertEquals("Patient ID: 3ca5e924-0521-4034-b0a6-9fe3069eef84 | local Date Time: 2002-03-02T02:02 | Exposure Type: I",ex.toString());
//		Exposure ex2=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
//		ex2.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
//		ex2.setExposureType("I");
//		Exposure ex3=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
//		assertEquals(ex2.hashCode(),ex.hashCode());
//		assertTrue(ex.equals(ex2));
//		assertFalse(ex.equals(ex3));
//		assertFalse(ex.equals(null));
//		assertFalse(ex.equals(new String()));
//		assertTrue(ex.equals(ex));
//		Exposure ex4=new Exposure(UUID.fromString("3ca5e824-0521-4034-b0a6-9fe3069eef84"));
//		assertFalse(ex.equals(ex4));
//	}
	
	 /**
     * Tests that the constructor correctly sets the patient ID.
     */
	@Test
	public void constructorTest() {
		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals("3ca5e924-0521-4034-b0a6-9fe3069eef84",ex.getPatientID().toString());
	}
	
	/**
     * Tests the setter and getter methods for patient ID, dateTime, and exposure type.
     */
	@Test
	public void setterGetterTest() throws Exception{
		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals("3ca5e924-0521-4034-b0a6-9fe3069eef84",ex.getPatientID().toString());
		ex.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		assertEquals(LocalDateTime.of(2002, 03, 02, 02, 02), ex.getDateTime());
		ex.setExposureType("I");
		assertEquals("I",ex.getExposureType());
		ex.setExposureType("D");
		assertEquals("D",ex.getExposureType());
		assertThrows(IllegalArgumentException.class, ()->{ex.setExposureType("j");});
	} /**
     * Tests the equals method under different scenarios.
     */
	
	
	/**
     * Tests the hashCode method to ensure consistent hashing.
     */
	@Test
	public void hashCodeTest() throws Exception {
		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		Exposure ex2=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex2.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		assertEquals(ex2.hashCode(),ex.hashCode());
	}
	
	 /**
     * Tests the equals method under different scenarios.
     */
	@Test
	public void equalsTest() {
		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		Exposure ex2=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex2.setDateTime(LocalDateTime.of(2004, 03, 02, 02, 02));
		assertTrue(ex.equals(ex));
		assertFalse(ex.equals(ex2));
		assertFalse(ex.equals(null));
		assertFalse(ex.equals(new String()));
		assertTrue(ex.equals(ex));
		Exposure ex4=new Exposure(UUID.fromString("3ca5e824-0521-4034-b0a6-9fe3069eef85"));
		ex4.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		assertFalse(ex.equals(ex4));
		Exposure ex5=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex5.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		assertTrue(ex.equals(ex5));
	}
	
	/**
     * Tests the string representation of the Exposure class.
     */
	@Test
	public void toStringTest() throws Exception{
		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		ex.setExposureType("I");
		assertEquals("Patient ID: 3ca5e924-0521-4034-b0a6-9fe3069eef84 | local Date Time: 2002-03-02T02:02 | Exposure Type: I",ex.toString());
	}
	
}

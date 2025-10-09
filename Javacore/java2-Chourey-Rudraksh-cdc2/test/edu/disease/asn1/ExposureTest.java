package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class ExposureTest {
	@Test
	public void exposureTest() throws Exception {
		Exposure ex=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals("3ca5e924-0521-4034-b0a6-9fe3069eef84",ex.getPatientID().toString());
		ex.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		assertEquals(LocalDateTime.of(2002, 03, 02, 02, 02), ex.getDateTime());
		ex.setExposureType("I");
		assertEquals("I",ex.getExposureType());
		assertThrows(IllegalArgumentException.class, ()->{ex.setExposureType("j");});
		assertEquals("Patient ID: 3ca5e924-0521-4034-b0a6-9fe3069eef84 | local Date Time: 2002-03-02T02:02 | Exposure Type: I",ex.toString());
		Exposure ex2=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		ex2.setDateTime(LocalDateTime.of(2002, 03, 02, 02, 02));
		ex2.setExposureType("I");
		Exposure ex3=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
		assertEquals(ex2.hashCode(),ex.hashCode());
		assertTrue(ex.equals(ex2));
		assertFalse(ex.equals(ex3));
		assertFalse(ex.equals(null));
		assertFalse(ex.equals(new String()));
		assertTrue(ex.equals(ex));
		Exposure ex4=new Exposure(UUID.fromString("3ca5e824-0521-4034-b0a6-9fe3069eef84"));
		assertFalse(ex.equals(ex4));
	}
}

package edu.disease.asn2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class DiseaseTest {
	@Test
	public void getterSetterTest() {
		Disease d=new InfectiousDisease();
		d.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d.setName("SomeName");
		String nameCheck=d.getName();
		String uuidCheck=d.getDiseaseID().toString();
	}
	
	
	@Test
	public void hashCodeTest() {
		Disease d=new InfectiousDisease();
		d.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d.setName("SomeName");
		Disease d2=new InfectiousDisease();
		d2.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d2.setName("SomeName");
		assertEquals(d.hashCode(),d2.hashCode());
	}
	
	
	@Test
	public void equalsTest() {
		Disease d=new InfectiousDisease();
		d.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d.setName("SomeName");
		Disease d2=new InfectiousDisease();
		d2.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d2.setName("SomeName");
		assertFalse(d.equals(new String()));
		assertTrue(d.equals(d));
		assertFalse(d.equals(null));
		assertTrue(d.equals(d2));
	}
	
	@Test
	public void InfectiousDiseaseExampleTest() {
		Disease d=new InfectiousDisease();
		d.getExamples();
	}
	
	@Test
	public void toStringTest() {
		Disease d=new InfectiousDisease();
		d.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d.setName("SomeName");
		assertEquals("Name: SomeNameDisease id :e3beeb2e-4188-4ef8-ac33-ec3cf72901e9" ,d.toString());
		


	}
	
	@Test
	public void NonInfectiousDiseaseExampleTest() {
		Disease d=new NonInfectiousDisease();
		String[] a= {"Actinomycosis", "Anthrax", "Boutonneuse fever", "Brucellosis", "Spondylitis"};
		String[] b= d.getExamples();
		
	}
}

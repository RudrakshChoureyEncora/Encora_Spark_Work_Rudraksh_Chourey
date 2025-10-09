package edu.disease.asn3;

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
		String[] a= {"Actinomycosis", "Anthrax", "Boutonneuse fever", "Brucellosis", "Spondylitis"};
		String[] b= d.getExamples();
		String a1="";
		String a2="";
		for(String x :b) {
			a1+=x;
		}
		for(String x:a) {
			a2+=x;
		}
		assertEquals(a1,a2);
	}
	
	/**
     * Tests the {@code toString()} method of the {@link Disease} class.
     */
	@Test
	public void toStringTest() {
		Disease d=new InfectiousDisease();
		d.setDiseaseID(UUID.fromString("e3beeb2e-4188-4ef8-ac33-ec3cf72901e9"));
		d.setName("SomeName");
		assertEquals("Name: SomeNameDisease id :e3beeb2e-4188-4ef8-ac33-ec3cf72901e9" ,d.toString());
		


	}
	
	/**
     * Tests the {@code getExamples()} method of {@link NonInfectiousDisease}.
     */
	@Test
	public void NonInfectiousDiseaseExampleTest() {
		Disease d=new NonInfectiousDisease();
		String[] a= {
			    "Diabetes",
			    "Hypertension",
			    "Asthma",
			    "Cancer",
			    "Osteoporosis"
			};
		
		String[] b= d.getExamples();
		String a1="";
		String a2="";
		for(String x :b) {
			a1+=x;
		}
		
		for(String x:a) {
			a2+=x;
		}
		assertEquals(String.join("", a),String.join("", d.getExamples()));
	}
}

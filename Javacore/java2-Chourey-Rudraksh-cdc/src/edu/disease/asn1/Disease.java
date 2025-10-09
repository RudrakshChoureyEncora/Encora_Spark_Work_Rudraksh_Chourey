package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;

/**
 * The {@code Disease} class represents a general disease entity 
 * with a unique identifier and a name.
 * <p>
 * This class provides basic functionality for setting and retrieving
 * disease information and overrides {@code equals()}, {@code hashCode()}, 
 * and {@code toString()} methods for comparison and display.
 * </p>
 * 
 * @author Rudraksh Chourey
 */

public class Disease {
	UUID diseaseID;
	String name;
	public UUID getDiseaseID() {
		return diseaseID;
	}
	public void setDiseaseID(UUID diseaseID) {
		this.diseaseID = diseaseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diseaseID);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this==obj||(
				obj!=null && 
				obj.getClass()==this.getClass() &&
				Objects.equals(this.diseaseID, ((Disease) obj).diseaseID)
				)
				;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+getName()+"Disease id :"+getDiseaseID().toString();
	}
}

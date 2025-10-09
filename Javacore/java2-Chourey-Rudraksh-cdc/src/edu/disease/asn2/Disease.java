package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;

/**
 * The abstract {@code Disease} class represents a general model of a disease entity.
 * <p>
 * Each disease has a unique identifier and a name. This class also defines a contract
 * for subclasses to provide example diseases using the {@code getExamples()} method.
 * </p>
 * 
 * This class provides equality comparison, string representation, and UUID-based hashing.
 * 
 * @author Rudraksh Chourey
 */

public abstract class Disease {
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
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Disease other = (Disease) obj;
//		return Objects.equals(diseaseID, other.diseaseID);
//	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj==this||(
				obj!=null&&
				this.getClass()==obj.getClass()&&
				Objects.equals(diseaseID, ((Disease) obj).diseaseID)
				);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+getName()+"Disease id :"+getDiseaseID().toString();
	}
	
	public abstract String[] getExamples();
}


/**
 * Represents an infectious disease.
 * <p>
 * Examples include contagious or transmissible illnesses.
 * </p>
 */
class InfectiousDisease extends Disease{
	@Override
	public String[] getExamples() {
		// TODO Auto-generated method stub
		String[] a= {"Actinomycosis", "Anthrax", "Boutonneuse fever", "Brucellosis", "Spondylitis"};
		return a;
	}
}

/**
 * Represents a non-infectious disease.
 * <p>
 * Examples include non-contagious illnesses often caused by genetics, environment, or lifestyle.
 * </p>
 */
class NonInfectiousDisease extends Disease{
	@Override
	public String[] getExamples() {
		// TODO Auto-generated method stub
		String[] a= {"Actinomycosis", "Anthrax", "Boutonneuse fever", "Brucellosis", "Spondylitis"};
		return a;
	}
}

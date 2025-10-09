package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;

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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(diseaseID, other.diseaseID);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+getName()+"Disease id :"+getDiseaseID().toString();
	}
	
	public abstract String[] getExamples();
}

class InfectiousDisease extends Disease{
	@Override
	public String[] getExamples() {
		// TODO Auto-generated method stub
		String[] a= {"Actinomycosis", "Anthrax", "Boutonneuse fever", "Brucellosis", "Spondylitis"};
		return a;
	}
}

class NonInfectiousDisease extends Disease{
	@Override
	public String[] getExamples() {
		// TODO Auto-generated method stub
		String[] a= {"Actinomycosis", "Anthrax", "Boutonneuse fever", "Brucellosis", "Spondylitis"};
		return a;
	}
}

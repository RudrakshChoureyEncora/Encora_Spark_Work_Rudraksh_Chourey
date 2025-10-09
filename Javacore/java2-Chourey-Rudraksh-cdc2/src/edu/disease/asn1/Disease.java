package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;

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
}

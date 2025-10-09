package edu.disease.asn1;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Patient {
	UUID patientID;
	String firstName;
	String lastName;
	Exposure[] exposures;
	UUID[] diseaseIds;
	int i;
	public Patient(int maxDiseases,int maxExposure) {
		// TODO Auto-generated constructor stub
		try {
			this.diseaseIds= new UUID[maxDiseases];
			this.exposures=new Exposure[maxExposure];
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}
	
	public void addDiseaseId(UUID diseaseId) throws Exception{
		boolean flag=false;
		for(i=0;i<diseaseIds.length;i++){
			flag=!Optional.ofNullable(diseaseIds[i]).isPresent();
			Optional.ofNullable(diseaseIds[i])
			.ifPresentOrElse((s)->{}, ()->{diseaseIds[i]=diseaseId;});
		}
		Optional.ofNullable(!flag)
	     .filter(n -> n==true)
	     .ifPresent(str->{
	    	 throw new IndexOutOfBoundsException("Array has reached its maximum capacity");
		 }
		 );
	}
	
	
	public void addExposure(Exposure exposure) throws Exception{
		boolean flag=false;
		for(i =0;i < exposures.length; i++) {
			flag=!Optional.ofNullable(exposures[i]).isPresent();
			Optional.ofNullable(exposures[i])
			.ifPresentOrElse((s)->{}, ()->{exposures[i]=exposure;});
		}
		Optional.ofNullable(!flag)
	     .filter(n -> n==true)
	     .ifPresent(str->{
	    	 throw new IndexOutOfBoundsException("Array has reached its maximum capacity");
		 }
		 );
	}


	public UUID getPatientID() {
		return patientID;
	}

	public void setPatientID(UUID patientID) {
		this.patientID = patientID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patientID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(patientID, other.patientID);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pateint Full Name: "+getFirstName()+" "+getLastName()+" PatientID: "+getPatientID();
	}
	
}

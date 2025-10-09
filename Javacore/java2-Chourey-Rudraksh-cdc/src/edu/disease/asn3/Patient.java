package edu.disease.asn3;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


/**
 * Represents a patient in the disease control system.
 * Each patient has an ID, name, a list of disease IDs, and a record of exposures.
 * This class supports comparison by name and handles adding exposures and diseases without using if-else statements.
 * Implements {@link Comparable} for sorting patients by last name and first name.
 * 
 * @author Rudraksh Chourey
 */
public class Patient implements Comparable<Patient>,Serializable{
	UUID patientID;
	String firstName;
	String lastName;
	Exposure[] exposures;
	UUID[] diseaseIds;
	public Exposure[] getExposures() {
		return this .exposures;
	}
	
	


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
	int i=0;//part of ifElse Elimination 
	public void addDiseaseId(UUID diseaseId){
		boolean flag=false;
//		for(int i =0;i < diseaseIds.length; i++) {
			//-------------Trying to eliminate
//			if(diseaseIds[i]==null) {
//				diseaseIds[i]=diseaseId;
//				flag=true;
//			}
			//---------------Elimination implementation 
		i=0;
		while(flag==false && i>=exposures.length) {
			flag=!Optional.ofNullable(diseaseIds[i]).isPresent();
			Optional.ofNullable(diseaseIds[i])
			.ifPresentOrElse((s)->{}, ()->{diseaseIds[i]=diseaseId;});
			i++;
		}
			
		
		
		Optional.ofNullable(!flag)
	     .filter(n -> n==true)
	     .ifPresent(str->{throw new IndexOutOfBoundsException("Array has reached its maximum capacity");});
		
	}
	
	
	public void addExposure(Exposure exposure) throws Exception{
		boolean flag=false;
		i=0;
//		System.out.println("Length of exposure array"+exposures.length);
		while(flag==false && i<exposures.length) {
//			System.out.println(i);
//			System.out.println(i+"  "+exposures[i]);
			//-------------------------------------
//			if(exposures[i]==null) {
//				try {
//				exposures[i]=exposure;}
//				catch(Exception e) {
//					System.out.println("yaha par");
//				}
//				flag=true;
//			}
//			System.out.println(i+"  "+exposures[i]+" "+flag);
//			i++;
			//-------------------------------------Elimination
			flag=!Optional.ofNullable(exposures[i]).isPresent();
			Optional.ofNullable(exposures[i])
			.ifPresentOrElse((s)->{}, ()->{exposures[i]=exposure;});
			i++;
		}
//		System.out.println("Added");

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

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Patient other = (Patient) obj;
//		return Objects.equals(patientID, other.patientID);
//	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this==obj||(
				obj!=null &&
				obj.getClass()==this.getClass() &&
				Objects.equals(this.patientID, ((Patient) obj).patientID)
				);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pateint Full Name: "+getFirstName()+" "+getLastName()+" PatientID: "+getPatientID();
	}
	
	@Override
	public int compareTo(Patient o) {
		// TODO Auto-generated method stub
		int res=(this.lastName+this.firstName).compareTo(o.lastName+o.firstName);
		return res;
	}
	
}

package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Exposure {
	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println(UUID.randomUUID());
	}
	UUID patientID;
	LocalDateTime dateTime;
	private String exposureType;
	public Exposure(UUID uuid) {
		// TODO Auto-generated constructor stub
		setPatientID(uuid);
	}
	public UUID getPatientID() {
		return patientID;
	}
	public void setPatientID(UUID patientID) {
		this.patientID = patientID;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getExposureType() {
		return exposureType;
	}
	public void setExposureType(String exposureType) throws Exception{
		
		//----------Working Code to be eliminated
//		if(exposureType =="I" || exposureType=="D")
//		this.exposureType = exposureType;
//		else throw new IllegalArgumentException();
		//----------------------\
		Optional.ofNullable(exposureType)
		.filter(str ->str=="I"||str=="D")
		.ifPresentOrElse(str ->{
			this.exposureType = exposureType;
		}, ()->{
			throw new IllegalArgumentException();
		});
		;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, patientID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientID, other.patientID);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Patient ID: "+getPatientID().toString()+
				" | local Date Time: " +getDateTime()+
				" | Exposure Type: "+getExposureType();
	}
	
}

package edu.disease.asn3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


/**
 * The {@code Exposure} class represents an exposure event for a patient,
 * including the type of exposure (direct or indirect), the date/time of exposure,
 * and the patient's unique identifier.
 * <p>
 * Valid exposure types are:
 * <ul>
 *   <li>"D" for direct exposure</li>
 *   <li>"I" for indirect exposure</li>
 * </ul>
 * </p>
 * 
 * Each {@code Exposure} instance must be associated with a {@code UUID} identifying the patient.
 * 
 * @author Rudraksh Chourey
 */

public class Exposure implements Serializable{
	
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
	    return this == obj || (
	        obj != null &&
	        obj.getClass() == this.getClass() &&
	        Objects.equals(this.dateTime, ((Exposure) obj).dateTime) &&
	        Objects.equals(this.patientID, ((Exposure) obj).patientID)
	    );
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Patient ID: "+getPatientID().toString()+
				" | local Date Time: " +getDateTime()+
				" | Exposure Type: "+getExposureType();
	}
}
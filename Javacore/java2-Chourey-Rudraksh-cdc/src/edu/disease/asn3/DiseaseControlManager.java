package edu.disease.asn3;

import java.util.UUID;

import edu.disease.asn3.Exposure;

/**
 * The {@code DiseaseControlManager} interface defines methods for managing diseases,
 * patients, and their relationships in a healthcare application.
 * <p>
 * It allows adding and retrieving diseases and patients, as well as assigning
 * exposures and diseases to patients.
 * </p>
 * 
 * This interface is typically implemented by a manager class that maintains
 * internal data structures such as arrays or lists of diseases and patients.
 * 
 * @author Rudraksh Chourey
 */

public interface DiseaseControlManager {
	public Disease addDisease(String name,boolean infectious,UUID diseaseId);
	public Disease getDisease(UUID diseaseId);
	public Patient addPatient(String firstName,String lastName,int maxDiseases,int maxExposures,UUID patientID);
	public Patient getPatient(UUID patientID);
	public void addDiseaseToPateint(UUID pateintId,UUID diseaseId)throws Exception; 
	public void addExposureToPateint(UUID PateintId,Exposure exposure) throws Exception;
	public Patient[] getPetients() ;
	public Disease[] getDiseases() ;
}

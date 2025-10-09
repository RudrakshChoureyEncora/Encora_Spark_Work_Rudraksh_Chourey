package edu.disease.asn3;


import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;


/**
 * Implementation of the {@link DiseaseControlManager} interface.
 * <p>
 * Manages diseases and patients using internal arrays, allowing addition and retrieval
 * of diseases and patients, as well as assigning exposures and disease records to patients.
 * </p>
 * 
 * @author Rudraksh  Chourey
 */

public class DiseaseControlManagerImpl implements DiseaseControlManager{
	private Disease[] disease;
	private Patient[] patients;
	int i;
		
	
	
	public DiseaseControlManagerImpl(int maxDisease,int maxPatient) {
		// TODO Auto-generated constructor stub
		try {
			this.disease=new Disease[maxDisease];
			this.patients=new Patient[maxPatient];
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public Disease addDisease(String name, boolean infectious,UUID diseaseId) {
		// TODO Auto-generated method stub
		return IntStream.range(0, this.disease.length)
	        .filter(i -> this.disease[i] == null)
	        .findFirst()
	        .stream()  // convert OptionalInt to IntStream
	        .mapToObj(i -> {
	            Disease d = infectious ? new InfectiousDisease() : new NonInfectiousDisease();
	            d.setDiseaseID(diseaseId);
	            d.setName(name);
	            this.disease[i] = d;
	            return d;
	        })
	        .findFirst()
	        .orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public void addDiseaseToPateint(UUID patientId, UUID diseaseId)  {
		// TODO Auto-generated method stub
		
		Arrays.stream(this.patients)
//	        .filter(p -> p != null)
	        .filter(p -> p.getPatientID().equals(patientId))
	        .findFirst()
	        .map(p -> {
	            p.addDiseaseId(diseaseId);
	            
	            return p;
	        })
	        .orElseThrow(() -> new IllegalArgumentException("Patient with given ID not found"));
	}


	@Override
	public void addExposureToPateint(UUID patientId, Exposure exposure) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("Called");
		Patient patient = Arrays.stream(this.patients)
//	        .filter(p -> p != null)
	        .filter(p -> p.getPatientID().equals(patientId))
	        .findFirst()
	        .orElseThrow(() -> new IllegalArgumentException("Patient with given ID not found"));
		
		patient.addExposure(exposure);
//		for(Exposure e:patient.exposures) {
//			System.out.println("in dcm"+e);
//		}
//		System.out.println();
	}


	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures, UUID patientID) {
		// TODO Auto-generated method stub
		return IntStream.range(0, this.patients.length)
	        .filter(i -> this.patients[i] == null)
	        .findFirst()
	        .stream()              
	        .mapToObj(i -> {       
	            Patient p = new Patient(maxDiseases, maxExposures);
	            p.setFirstName(firstName);
	            p.setLastName(lastName);
	            p.setPatientID(patientID);
	            this.patients[i] = p;
	            return p;
	        })
	        .findFirst()           
	        .orElseThrow(() -> new IllegalArgumentException("No empty slot to add patient"));
	}


	@Override
	public Disease getDisease(UUID diseaseId) {
		// TODO Auto-generated method stub
//		for(Disease x:this.disease) {
//			
//			if(x.getDiseaseID()==diseaseId) {
//				return x;
//			}
//		}
		return Arrays.stream(this.disease)
//			.filter(p->p!=null)
			.filter(p->p.getDiseaseID().equals(diseaseId))
			.findFirst()
			.orElseThrow(()->new IllegalArgumentException("Disease with this id not found"));
	}
	
	
	
	@Override
	public Patient getPatient(UUID patientID) {
		// TODO Auto-generated method stub
//		for(Patient x:this.patients) {
//			
//			if(x.getPatientID().toString().equals(patientID.toString())) {
//				return x;
//			}
//		}
		return Arrays.stream(this.patients)
//		        .filter(p -> p != null)
		        .filter(p -> p.getPatientID().equals(patientID))
		        .findFirst()
		        .orElseThrow(() -> new IllegalArgumentException("Patient with given ID not found"));
	}
	
	@Override
	public Disease[] getDiseases() {
		// TODO Auto-generated method stub
		return this.disease;
	}
	
	
	
	@Override
	public Patient[] getPetients() {
		// TODO Auto-generated method stub
		return this.patients;
	}
	
	
}

package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

import edu.disease.asn1.Exposure;

public class DiseaseControlManagerImpl implements DiseaseControlManager{
	private Disease[] disease;
	private Patient[] patients;
	int curPat=0;
	int curD=0;
	int i;
	public Patient[] getPets() {
		return this.patients;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello");
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(5,5);
		dcm.addPatient("Abc", "c", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
		dcm.addPatient("Abc", "b", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
	}
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
	public Disease addDisease(String name, boolean infectious) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for(int i =0;i<this.patients.length;i++) {
			if(this.patients[i]==null) {
				flag=true;
				if(infectious) {
					this.disease[i]=new InfectiousDisease();
					this.disease[i].setDiseaseID(UUID.randomUUID());
					this.disease[i].setName(name);
				}
				else {
					this.disease[i]=new NonInfectiousDisease();
					this.disease[i].setDiseaseID(UUID.randomUUID());
					this.disease[i].setName(name);
				}
				return this.disease[i];
			}
		}
		Optional.ofNullable(!flag)
	     .filter(n -> n==true)
	     .ifPresent(str->{
	    	 throw new IllegalArgumentException();
		 }
		 );
		
		return null;
	}
	@Override
	public void addDiseaseToPateint(UUID pateintId, UUID diseaseId) throws Exception{
		// TODO Auto-generated method stub
		boolean flag=false;
		for(Patient p : this.patients) {
			if(p.patientID==pateintId) {
				flag=true;
				p.addDiseaseId(diseaseId);
			}
		}
		Optional.ofNullable(!flag)
	     .filter(n -> n==true)
	     .ifPresent(str->{
	    	 throw new IllegalArgumentException();
		 }
		 );
	}
	@Override
	public void addExposureToPateint(UUID PateintId, Exposure exposure) throws Exception{
		// TODO Auto-generated method stub
		boolean flag=false;
		for(Patient p : this.patients) {
			if(p.patientID==PateintId) {
				flag=true;
				p.addExposure(exposure);
			}
		}
		Optional.ofNullable(!flag)
	     .filter(n -> n==true)
	     .ifPresent(str->{
	    	 throw new IllegalArgumentException();
		 }
		 );
	}
//	@Override
//	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures,UUID patientID) {
//		Patient p=null;
//		boolean flag=Optional.ofNullable(curPat)
//		.filter(inta-> inta<=this.patients.length)
//		.isPresent(Optional<Integer>->{
//					throw new IllegalArgumentException();
//					}
//				);
//		return null;
//		//-------------------------------------------------------------------------------------
//		
//		// TODO Auto-generated method stub
////		for(i=0;i<this.patients.length;i++) {
//////			---------------------------------------
////			flag=!Optional.ofNullable(this.patients[i]).isPresent();
////			p=Optional.ofNullable(this.patients[i])
////			.or(() -> {
////	            this.patients[i] = new Patient(maxDiseases, maxExposures);
////	            this.patients[i].setFirstName(firstName);
////	            this.patients[i].setLastName(lastName);
////	            this.patients[i].setPatientID(patientID);
////	            return Optional.of(this.patients[i]);
////	        }).get();
////			
////	}
////			
////			
//		
//		Optional.of(!flag).filter(n -> n==true).ifPresent(str->{
//	    	 throw new IllegalArgumentException();
//		 }
//		 );
//		return p;
//	
//	}
////	
//	
//	
	
	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures, UUID patientID) {
	    return IntStream.range(0, this.patients.length)
	        .filter(i -> this.patients[i] == null)
	        .findFirst()
	        .stream()              // converts OptionalInt to IntStream of 0 or 1 element
	        .mapToObj(i -> {       // now map to object Patient
	            Patient p = new Patient(maxDiseases, maxExposures);
	            p.setFirstName(firstName);
	            p.setLastName(lastName);
	            p.setPatientID(patientID);
	            this.patients[i] = p;
	            return p;
	        })
	        .findFirst()           // Optional<Patient>
	        .orElseThrow(() -> new IllegalArgumentException("No empty slot to add patient"));
	}


	@Override
	public Disease getDisease(UUID diseaseId) {
		// TODO Auto-generated method stub
		for(Disease x:this.disease) {
			
			if(x.getDiseaseID()==diseaseId) {
				return x;
			}
		}
		return null;
	}
	
	
	
	
//	@Override
//	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures, UUID patientID) {
//		// TODO Auto-generated method stub
//		
//		Patient p=null;
//		boolean flag=false;
//		for(i=0;i<this.patients.length;i++) {
//			System.out.println(i);
//			System.out.println(this.patients.length);
//			System.out.println(patientID);
//			if(this.patients[i]==null) {
//				flag=true;
//				this.patients[i]=new Patient(maxDiseases,maxExposures);
//				this.patients[i].setFirstName(firstName);
//				this.patients[i].setLastName(lastName);
//				this.patients[i].setPatientID(patientID);
//				p=this.patients[i];
//				break;
//			}
//		}
//		
//		
//		Optional.of(!flag).filter(n -> n==true).ifPresent(str->{
//	    	System.out.println("This is running"); 
//			throw new IllegalArgumentException();
//		 }
//		 );
//		return p;
//		
//	}
	@Override
	public Patient getPatient(UUID patientID) {
		// TODO Auto-generated method stub
		for(Patient x:this.patients) {
			
			if(x.getPatientID().toString().equals(patientID.toString())) {
				return x;
			}
		}
		return null;
	}
	
	
	
}

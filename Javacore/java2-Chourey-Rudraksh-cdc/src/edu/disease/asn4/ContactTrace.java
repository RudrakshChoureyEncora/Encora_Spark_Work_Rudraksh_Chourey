package edu.disease.asn4;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.Patient;

public class ContactTrace {
	private DiseaseControlManager DCM;
	
	public ContactTrace(DiseaseControlManager DCM) {
		this.DCM=DCM;
		// TODO Auto-generated constructor stub
	}
	
	public PatientZero findPatientZero(Patient patient,LocalDateTime ld) {
		System.out.println("Entered The Function with"+patient+" and DT: "+ld);
		PatientZero p=null;
		for(Exposure i : patient.getExposures()) {
			System.out.println("Iterator Exposure"+i+ld+"  Dif  "+i.getDateTime());
//			if(i.getExposureType().equals("D") && ld.isAfter(i.getDateTime()) && i!=null) {
//				System.out.println("exposure Passed the Condition: "+i+ld);
//				System.out.println(DCM.getPatient(i.getPatientID()));
//				p=findPatientZero(DCM.getPatient(i.getPatientID()),i.getDateTime());
//				
//			}
			//Optional Implementation with lembda
			p=Optional.ofNullable(i)
					.filter(t->{return t.getExposureType().equals("D") && ld.isAfter(t.getDateTime());})
					.map(t->{return findPatientZero(DCM.getPatient(t.getPatientID()),t.getDateTime());})
					.orElse(p);
			//to access a local variable or parametere which is accessible in lambda bt not in class implementation pass it as parameter in constructor
		}
		
//		if(p==null) {
//					
//			System.out.println("returning"+patient);
//			return p;
//		}
//		
		PatientZero px=new PatientZero();
		px.setPatient(patient);
		px.setExposureDateTime(ld);	
		//Optional Implementation
		p=Optional.ofNullable(p)
				.orElse(px);
				
		return p;
	}
	
	class myMap implements Function<Exposure, PatientZero>{
		@Override
		public PatientZero apply(Exposure t) {
			// TODO Auto-generated method stub
			return findPatientZero(DCM.getPatient(t.getPatientID()),t.getDateTime());
		}
	}
	
}

class myFilter implements Predicate<Exposure>{
	@Override
	public boolean test(Exposure t) {
		// TODO Auto-generated method stub
		return t.getExposureType().equals("D")  ;
	}
}



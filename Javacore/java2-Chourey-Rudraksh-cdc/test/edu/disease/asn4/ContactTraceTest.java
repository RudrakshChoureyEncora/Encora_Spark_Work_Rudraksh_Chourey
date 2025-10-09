package edu.disease.asn4;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.Patient;

public class ContactTraceTest {
	public static void main(String[] args) {
		try {
			DiseaseControlManager DCM= new DiseaseControlManagerImpl(10,10);
			DCM.addPatient("J", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"));
			DCM.addPatient("A", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
			DCM.addPatient("B", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef83"));
			DCM.addPatient("C", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
			DCM.addPatient("D", "L", 0, 0,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			DCM.addPatient("E", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef86"));
			DCM.addPatient("F", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef87"));
			DCM.addPatient("G", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef88"));
			DCM.addPatient("H", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef89"));
			DCM.addPatient("I", "L", 3, 3,UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef90"));
			Exposure e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"));
			e.setDateTime(LocalDateTime.of(2025, 4, 01, 0, 0));
			e.setExposureType("D");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef83"));
			e.setDateTime(LocalDateTime.of(2025, 3, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
			e.setDateTime(LocalDateTime.of(2025, 2, 01, 0, 0));
			e.setExposureType("D");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"));
			e.setDateTime(LocalDateTime.of(2025, 1, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 12, 01, 0, 0));
			e.setExposureType("D");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 11, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef82"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 12, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef83"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 12, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef83"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 12, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef83"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 12, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 12, 01, 0, 0));
			e.setExposureType("I");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"),e );
			e=new Exposure(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef85"));
			e.setDateTime(LocalDateTime.of(2024, 10, 01, 0, 0));
			e.setExposureType("D");
			DCM.addExposureToPateint(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef84"),e );
			
			
			
//			for(Patient pa : DCM.getPetients()) {
//				System.out.println(pa);
//			}
			ContactTrace c= new ContactTrace(DCM);
			PatientZero pz=c.findPatientZero(DCM.getPatient(UUID.fromString("3ca5e924-0521-4034-b0a6-9fe3069eef81")), LocalDateTime.now());
			System.out.println(pz.getPatient().getPatientID().toString()+"   "+pz.getExposureDateTime());
//			System.out.println(p.getExposures());
//			c.findPatientZero(p,LocalDateTime.now());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	
}

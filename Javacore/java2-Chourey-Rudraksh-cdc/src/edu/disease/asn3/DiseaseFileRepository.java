package edu.disease.asn3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class DiseaseFileRepository {
	String folderPath;
	
	
	
	public void save(Disease[] diseases,Patient[] patients) throws Exception{
	
		Optional.ofNullable(this.folderPath)
		.ifPresentOrElse(c->{
			try {
				ObjectOutputStream OOS1=new ObjectOutputStream(new FileOutputStream(this.folderPath+"\\diseaes.dat"));
				ObjectOutputStream OOS2=new ObjectOutputStream(new FileOutputStream(this.folderPath+"\\patients.dat"));
				OOS1.writeObject(diseases);
				OOS2.writeObject(patients);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}, ()->new IllegalArgumentException());
		
//		if (this.folderPath!=null) {
//			ObjectOutputStream OOS1=new ObjectOutputStream(new FileOutputStream(this.folderPath+"\\diseaes.dat"));
//			ObjectOutputStream OOS2=new ObjectOutputStream(new FileOutputStream(this.folderPath+"\\patients.dat"));
//			OOS1.writeObject(diseases);
//			OOS2.writeObject(patients);
//		} else {
//			throw new IllegalArgumentException();
//		}
	}
	
	public DiseaseAndPatient init(String folderPath) throws Exception{
		
//		DiseaseAndPatient dap=new DiseaseAndPatient();
//		Optional.ofNullable(this.folderPath)
//		.ifPresent(c-> {
//			this.folderPath=folderPath;
//			try {
//				ObjectInputStream OISD= new ObjectInputStream(new FileInputStream(this.folderPath+"\\diseaes.dat"));
//				ObjectInputStream OISP= new ObjectInputStream(new FileInputStream(this.folderPath+"\\patients.dat"));
//				dap.setPatients((Patient[])OISP.readObject());
//				dap.setDiseases((Disease[])OISD.readObject());
//			}catch(Exception e){
//				System.out.println(e);
//			}
//		});
		
		return Optional.ofNullable(folderPath)
				.map(str-> {
					this.folderPath=folderPath;
					try {
					ObjectInputStream OISD= new ObjectInputStream(new FileInputStream(this.folderPath+"\\diseaes.dat"));
					ObjectInputStream OISP= new ObjectInputStream(new FileInputStream(this.folderPath+"\\patients.dat"));		
					DiseaseAndPatient dap= new DiseaseAndPatient();
					dap.setPatients((Patient[])OISP.readObject());
					dap.setDiseases((Disease[])OISD.readObject());
					return dap;
					}catch(Exception e) {
						System.out.println(e);
						return null;
					}
				})
				.orElseThrow(()->new IllegalArgumentException());
		
//		if(folderPath!=null) {
//			this.folderPath=folderPath;
//			DiseaseAndPatient dap=new DiseaseAndPatient();
//			ObjectInputStream OISD= new ObjectInputStream(new FileInputStream(this.folderPath+"\\diseaes.dat"));
//			ObjectInputStream OISP= new ObjectInputStream(new FileInputStream(this.folderPath+"\\patients.dat"));
//			dap.setPatients((Patient[])OISP.readObject());
//			dap.setDiseases((Disease[])OISD.readObject());
//			
//			
//			return dap;
//		}else {
//			throw new IllegalArgumentException();
//		}
		
	}

}

package SelfPractise;



public class RemoteEX {
	public static void main(String[] args) {
		TeePoi teepoi = new TeePoi(new TvRemote(),new SSRemote(),null,null);
		teepoi.operateTV();
	}
}



interface TeePoiRoles{
	public void operateTV();
}



class TeePoi implements TeePoiRoles{
	Remote TVRemote;
	Remote SSRemote;
	Remote VGameRemote;
	Remote XBoxRemote;
	public TeePoi(Remote TVRemote, Remote SSRemote,Remote VGameRemote, Remote XBoxRemote) {
		// TODO Auto-generated constructor stub
		this.TVRemote=TVRemote;
		this.SSRemote=SSRemote;
		this.VGameRemote=VGameRemote;
		this.XBoxRemote=XBoxRemote;
	}
	

	@Override
	public void operateTV() {
		// TODO Auto-generated method stub
		TVRemote.switchOnTv();
		TVRemote.selectMode(new M1());
		TVRemote.openChannelMenu();
		TVRemote.newsChannel();
		SSRemote.loudNoise();
	}
}

abstract class Remote implements TvRemoteRoles, SSRemoteRoles{
	
}


interface TvRemoteRoles{
	public void serialChannel();
	public void newsChannel();
	public void switchOnTv() ;
	public void openChannelMenu();
	public void selectMode(Mode m);
}


interface SSRemoteRoles{
	public void loudNoise();
	public void lowNoice();
}


class TvRemote extends Remote {
	public void serialChannel() {
		System.out.println("serial channel on...");
	}
	public void newsChannel() {
		System.out.println("news channel on");
	}
	public void switchOnTv() {
		System.out.println("switch on tv...");
	}
	public void openChannelMenu() {
		System.out.println("Channel menu opened...");
	}
	public void selectMode(Mode m) {
		// TODO Auto-generated method stub
		m.printMode();
	}
	
	// Does Not Perform Any Task As They are not related
	@Override
	public void loudNoise() {
		// TODO Auto-generated method stub
		
	}@Override
	public void lowNoice() {
		// TODO Auto-generated method stub
		
	}
	
}

class SSRemote extends Remote {
	public void loudNoise() {
		System.out.println("loud noise selected....");
	}
	public void lowNoice() {
		System.out.println("low noise selected..");
	}
	
	// Does Not Perform Any Task As They are not related
	@Override
	public void newsChannel() {
		// TODO Auto-generated method stub
		
	}@Override
	public void openChannelMenu() {
		// TODO Auto-generated method stub
		
	}@Override
	public void selectMode(Mode m) {
		// TODO Auto-generated method stub
		
	}@Override
	public void serialChannel() {
		// TODO Auto-generated method stub
		
	}@Override
	public void switchOnTv() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class Mode{
	public abstract void printMode();
}

class M1 extends Mode{
	@Override
	public void printMode() {
		// TODO Auto-generated method stub
		System.out.println("Tv Mode....");
	}
}
class M2 extends Mode{
	@Override
	public void printMode() {
		// TODO Auto-generated method stub
		System.out.println("Non-Tv Mode....");
	}
}


//class VGameRemote extends Remote{
//	
//}
//
//class XBoxRemote extends Remote{
//	
//}


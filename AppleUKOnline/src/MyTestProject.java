import java.io.IOException;


public class MyTestProject {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		IosSerachPage SearchPage = new IosSerachPage ();
		SearchPage.iosSearchpage();
		
		IosInspectionPage iosInspectionPage = new IosInspectionPage ();
		iosInspectionPage.InspectionPage();
	}

}

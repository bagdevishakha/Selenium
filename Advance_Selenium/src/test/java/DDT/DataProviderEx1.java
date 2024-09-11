package DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTickets(String src, String dest)
	{
		System.out.println("Books tickets from" +src+"to"+dest+"");
	}
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] ObjArr = new Object[3][2];
		
		ObjArr[0][0]="Banglore"; 
		ObjArr[0][1]="Goa"; 
		
		ObjArr[1][0]="Banglore"; 
		ObjArr[1][1]="Chennai"; 
		
		ObjArr[2][0]="Banglore"; 
		ObjArr[2][1]="Mysore";
		return ObjArr; 
		
	}

}

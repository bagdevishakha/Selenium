package TestNG;
	
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class DataProviderEx2 {
		
		@Test(dataProvider = "dataProvider_BookTickets")
		public void bookTickets(String src, String dest, String noOfPeople)
		{
			System.out.println("Books tickets from" +" "+src+" "+"to"+" "+dest+" "+" "+noOfPeople);
		}
		@DataProvider
		public Object[][] dataProvider_BookTickets()
		{
			Object[][] ObjArr = new Object[3][3];
			
			ObjArr[0][0]="Banglore"; 
			ObjArr[0][1]="Goa"; 
			ObjArr[0][2]="5";
			
			ObjArr[1][0]="Banglore"; 
			ObjArr[1][1]="Chennai"; 
			ObjArr[1][2]="3";
			
			ObjArr[2][0]="Banglore"; 
			ObjArr[2][1]="Mysore";
			ObjArr[2][2]="2";
			return ObjArr; 
			
		}

	}



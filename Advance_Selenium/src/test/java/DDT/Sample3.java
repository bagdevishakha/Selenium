package DDT;

import org.testng.annotations.Test;

public class Sample3 {
	
	
	@Test(invocationCount = 4)
	public void createContact()
	{

		System.out.println("Contact created");
	}
	
	@Test(priority = -1)
	public void modifyContact()
	{
		System.out.println("Contact modified");
	}
	
	@Test(dependsOnMethods= "createContact")
	public void deleteContact()
	{
		System.out.println("Contact deleted");
	}


}

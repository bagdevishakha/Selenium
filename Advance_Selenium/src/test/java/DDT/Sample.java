package DDT;

import org.testng.annotations.Test;

public class Sample {
	
	
	@Test
	public void createContact()
	{

		System.out.println("Contact created");
	}
	
	@Test(dependsOnMethods= "createContact")
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

package Rengaraj_test_files;

import org.testng.annotations.Test;

import baseclass.launchezhour;
import page_object_rengaraj.Tenant_object;

public class Tenantlogin extends launchezhour {
	
	
	
	@Test
	public void correct_tenantlogin() throws InterruptedException
	{
		Tenant_object tenant_choose=new Tenant_object(driver);
		
		tenant_choose.tenant(proporty.getProperty("tenant_name"));
		tenant_choose.tenant_continue();
	
		
		
	}
	
	

}

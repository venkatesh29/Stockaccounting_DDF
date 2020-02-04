package driverFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonFunLibrary.ERP_Functions;
import Utilities.ExcelFileUtil;

public class NewTest {
  
		ERP_Functions erp=new ERP_Functions();
		
		@BeforeMethod
		public void adminLogin() throws Throwable{
			erp.lanchAPP("http://webapp.qedge.com");
		    erp.login("admin", "master");
		}
		
		@Test
		 public void f() throws Throwable {
				  
			ExcelFileUtil exl=new ExcelFileUtil();	
			int rc=exl.rowCount("Supplier");
			
			for(int i=1;i<=rc;i++){
				
				String sname=exl.getData("Supplier", i, 0);
				String address=exl.getData("Supplier", i, 1);
				String city=exl.getData("Supplier", i, 2);
				String country=exl.getData("Supplier", i, 3);
				String pnumber=exl.getData("Supplier", i, 5);
				String cperson=exl.getData("Supplier", i, 4);
				String mail=exl.getData("Supplier", i, 6);
				String mnumber=exl.getData("Supplier", i, 7);
				String note=exl.getData("Supplier", i, 8);
				
				String result=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
				exl.setData("Supplier", i, 9, result);		
					
			}
				
		 }	
		
		@AfterMethod
		public void logout() throws Exception{
			erp.logout();
			erp.closebrw();
		}
			 
}

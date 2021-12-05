package Dealership;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Variables {

	public static WebDriver driver;
	
	public static String 
	url, username, password, browser, addnew, customer, smallheader, firstname, lastname,
	accounttypedropdown, accounttypevalue, country, countryname, state, statename, create,
	verifyemail, vendor, vendorHeader, companyname, vendorAccountNumber, shippingaddressflag,
	part_Purchases, merchandise_Purchases, unit_Purchases, sublet_Purchases, 
	claims_for_Service_Work, deal_Products, flooring_Company, finance_Company, financing_Products,
	save, purchaseTaxLevel, vendorAccountTypeIcon, part, partheader, parttype, tags, location,
	tag_1, inStockQty,  verifyPart, labor, laborheader, laborcode, verifylabor, kit, kitheader,
	formstag, selecttag, applicabletax, savebutton, kitcode, servicekitchechbox, make, model,
	submodel, savekit, makeoption, modeloption, submodeloption, verifykit
	 
	 ;
	
	public static void test() throws IOException
	{
	Property.testProperty();
	
	}
	
}

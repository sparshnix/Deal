package Dealership;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Variables {

	public static WebDriver driver;
	
	public static String 
	//Used for Masterdata
	browser, url, username, password, addnew, customer, smallheader, firstname, lastname,
	accounttypedropdown, accounttypevalue, country, countryname, state, statename, create,
	verifyemail, vendor, vendorHeader, companyname, vendorAccountNumber, shippingaddressflag,
	part_Purchases, merchandise_Purchases, unit_Purchases, sublet_Purchases, 
	claims_for_Service_Work, deal_Products, flooring_Company, finance_Company, financing_Products,
	saveVendor, purchaseTaxLevel, vendorAccountTypeIcon, part, partheader, parttype, tags, location,
	tag_1, inStockQty,  verifyPart, labor, laborheader, laborcode, verifylabor, kit, kitheader,
	formstag, selecttag, applicabletax, savebutton, kitcode, servicekitchechbox, make, model,
	submodel, savekit, makeoption, modeloption, submodeloption, verifykit, fee, feeheader, feetype,
	Tags_fee, feecode, taxableflag, applicable_tax, savefee, verifyfee, unit, unitheader, unitVIN,
	unitmake, unitmodel, unitSubModel, year, new_unit, exterior_colour, stock, unitApplicable_tax,
	verifyunit,
	
	//used for Workspace
	home, storesummary, today, last_7_days, last_30_days, invoices, payments, new_customers, 
	searchtag1, servicejobs, customerpay, thirdparty, internal, deal, new_link, active, completed,
	searchtag2, vendor_orders, active_orders1, active_receiving, parts_needed, searchtag3,
	customer_orders, active_orders2, deposits, balance_due, searchtag4
	
	 
	 ;
	
	public static void test() throws IOException
	{
	Property.testProperty();
	
	}
	
}

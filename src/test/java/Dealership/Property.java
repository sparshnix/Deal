package Dealership;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property extends Variables {
	public static Properties prop;
	public static Properties locators;
	public static void testProperty() throws IOException
	
	{
		FileInputStream inputP = new FileInputStream(System.getProperty("user.dir")+ 
				File.separator + "src" + 
				File.separator + "test" + 
				File.separator + "java" + 
				File.separator + "config.properties");
		prop = new Properties();
		prop.load(inputP);	
		
		FileInputStream inputL = new FileInputStream(System.getProperty("user.dir")+ 
				File.separator + "src" + 
				File.separator + "test" + 
				File.separator + "java" + 
				File.separator + "locators.properties");
		locators = new Properties();
		locators.load(inputL);	
		
		
		//Fetch the values from config.properties 
		browser  					=	prop.getProperty("browser");
		url 						=	prop.getProperty("url");
		username  					=	prop.getProperty("username");
		password  					=	prop.getProperty("password");
		firstname  					=	prop.getProperty("firstname");
		lastname  					=	prop.getProperty("lastname");
		companyname  				=	prop.getProperty("companyname");
		vendorAccountNumber  		=	prop.getProperty("vendorAccountNumber");
		laborcode 					=	prop.getProperty("laborcode");
		kitcode						=	prop.getProperty("kitcode");
		feecode						=	prop.getProperty("feecode");
		unitVIN						=   prop.getProperty("unitVIN");
		
		
		
		
		//Fetch the values from locators.properties 
		//used for Masterdata
		addnew                      =   locators.getProperty("addnew");
		customer                    =   locators.getProperty("customer");
		smallheader 				=	locators.getProperty("smallheader");
		accounttypedropdown 		=	locators.getProperty("accounttypedropdown");
		accounttypevalue  			=	locators.getProperty("accounttypevalue");
		country  					=	locators.getProperty("country");
		countryname  				=	locators.getProperty("countryname");
		state  						=	locators.getProperty("state");
		statename  					=	locators.getProperty("statename");
		create 						=	locators.getProperty("create");
		verifyemail  				=	locators.getProperty("verifyemail");
		vendor  					=	locators.getProperty("vendor");
		shippingaddressflag  		=	locators.getProperty("shippingaddressflag");
		saveVendor 					=	locators.getProperty("saveVendor");
		vendorHeader  				=	locators.getProperty("vendorHeader");
		purchaseTaxLevel  			=	locators.getProperty("purchaseTaxLevel");
		vendorAccountTypeIcon  		=	locators.getProperty("vendorAccountTypeIcon");
		part  						=	locators.getProperty("part");
		partheader  				=	locators.getProperty("partheader");
		parttype  					=	locators.getProperty("parttype");
		tags  						=	locators.getProperty("tags");
		location 					=	locators.getProperty("location");
		tag_1  						=	locators.getProperty("tag_1");
		inStockQty  				=	locators.getProperty("inStockQty");
		verifyPart  				=	locators.getProperty("verifyPart");
		labor  						=	locators.getProperty("labor");
		laborheader 				=	locators.getProperty("laborheader");
		verifylabor  				=	locators.getProperty("verifylabor");
		kit  						=	locators.getProperty("kit");
		kitheader					=	locators.getProperty("kitheader");
		formstag					=	locators.getProperty("formstag");
		selecttag					=	locators.getProperty("selecttag");
		applicabletax				=	locators.getProperty("applicabletax");
		savebutton					=	locators.getProperty("savebutton");
		servicekitchechbox			=	locators.getProperty("servicekitchechbox");
		make						=	locators.getProperty("make");
		model						=	locators.getProperty("model");
		submodel					=	locators.getProperty("submodel");
		savekit						=	locators.getProperty("savekit");
		makeoption					=	locators.getProperty("makeoption");
		modeloption					=	locators.getProperty("modeloption");
		submodeloption				=	locators.getProperty("submodeloption");
		verifykit					=	locators.getProperty("verifykit");
		fee							= 	locators.getProperty("fee");
		feeheader					=	locators.getProperty("feeheader");
		feetype						=	locators.getProperty("feetype");
		Tags_fee					=	locators.getProperty("Tags_fee");
		taxableflag					=	locators.getProperty("taxableflag");
		applicable_tax				=   locators.getProperty("applicable_tax");
		savefee						=   locators.getProperty("savefee");
		verifyfee					=   locators.getProperty("verifyfee");
		unit						=   locators.getProperty("unit");
		unitheader					=   locators.getProperty("unitheader");
		unitmake					=   locators.getProperty("unitmake");				
		unitmodel					=   locators.getProperty("unitmodel");
		unitSubModel				=   locators.getProperty("unitSubModel");
		year						=   locators.getProperty("year");
		new_unit					=   locators.getProperty("new_unit");
		exterior_colour				=   locators.getProperty("exterior_colour");
		stock						=   locators.getProperty("stock");
		unitApplicable_tax			=   locators.getProperty("unitApplicable_tax");
		verifyunit					=   locators.getProperty("verifyunit");
		kititemplusicon				=   locators.getProperty("kititemplusicon");
		
		//used for workspace
		home						=   locators.getProperty("home");
		storesummary				=   locators.getProperty("storesummary");
		today						=   locators.getProperty("today");
		last_7_days					=   locators.getProperty("last_7_days");
		last_30_days				=   locators.getProperty("last_30_days");
		invoices					=   locators.getProperty("invoices");
		searchtag1					=   locators.getProperty("searchtag1");
		payments					=   locators.getProperty("payments");
		new_customers				=   locators.getProperty("new_customers");
		servicejobs					=   locators.getProperty("servicejobs");
		customerpay					=   locators.getProperty("customerpay");
		thirdparty					=   locators.getProperty("thirdparty");
		internal					=   locators.getProperty("internal");
		deal						=   locators.getProperty("deal");
		new_link					=   locators.getProperty("new_link");
		active						=   locators.getProperty("active");
		completed					=   locators.getProperty("completed");
		searchtag2					=   locators.getProperty("searchtag2");
		vendor_orders				=   locators.getProperty("vendor_orders");
		active_orders1 				= 	locators.getProperty("active_orders1");
		active_receiving 			= 	locators.getProperty("active_receiving");
		parts_needed 				=   locators.getProperty("parts_needed");
		searchtag3					=   locators.getProperty("searchtag3");
		customer_orders				=   locators.getProperty("customer_orders");
		active_orders2				=   locators.getProperty("active_orders2");
		deposits					=   locators.getProperty("deposits");
		balance_due					=   locators.getProperty("balance_due");
		searchtag4					=   locators.getProperty("searchtag4");
		activity_feed				=   locators.getProperty("activity_feed");
		myactivity					=   locators.getProperty("myactivity");
		storeactivity				=   locators.getProperty("storeactivity");
		
		//used for Sell
		sell						=   locators.getProperty("sell");
		selectcustomerdropdown		=   locators.getProperty("selectcustomerdropdown");
		sellpartandaccs				=   locators.getProperty("sellpartandaccs");
		activeorders				=   locators.getProperty("activeorders");
		activeorderbutton			=   locators.getProperty("activeorderbutton");
		merchandiseSectionId		=   locators.getProperty("merchandiseSectionId");
		checkout_button				=   locators.getProperty("checkout_button");
		setCashDrawerModalWindow	=   locators.getProperty("setCashDrawerModalWindow");
		selectdrawerbutton			=   locators.getProperty("selectdrawerbutton");
		cashoption					=   locators.getProperty("cashoption");
		addpayment					=   locators.getProperty("addpayment");
		finalizebutton				=   locators.getProperty("finalizebutton");
		invoicewindow				=   locators.getProperty("invoicewindow");
		invoiceclosebutton			=   locators.getProperty("invoiceclosebutton");
		costatus					=   locators.getProperty("costatus");
		cancel						=   locators.getProperty("cancel");
		servicejob					=   locators.getProperty("servicejob");
		servicejobstatus			=   locators.getProperty("servicejobstatus");
		servicejobdropdown			=   locators.getProperty("servicejobdropdown");
		servicejobdetails			=   locators.getProperty("servicejobdetails");
		addcustomerunit				=   locators.getProperty("addcustomerunit");
		tempUnitMmodalWindow		=   locators.getProperty("tempUnitMmodalWindow");
		addbutton					=   locators.getProperty("addbutton");
		odometer_on_arrival			=   locators.getProperty("odometer_on_arrival");
		odometer_on_departure		=   locators.getProperty("odometer_on_departure");
		productwindow				=	locators.getProperty("productwindow");
		lpjItems					=	locators.getProperty("lpjItems");
		notes_for_customers			=	locators.getProperty("notes_for_customers");
		techniciantime				=	locators.getProperty("techniciantime");
		clockingStaffPopupforCO		=	locators.getProperty("clockingStaffPopupforCO");	
		technician1					=	locators.getProperty("technician1");
		documents					=	locators.getProperty("documents");
		addforms					=	locators.getProperty("addforms");
		documentFormModalWindowHeader=	locators.getProperty("documentFormModalWindowHeader");
		docCheckbox					=	locators.getProperty("docCheckbox");
		addselected					=	locators.getProperty("addselected");
		customerapproval			=	locators.getProperty("customerapproval");
		sellAUnit					=	locators.getProperty("sellAUnit");
		unitdealstatus				=	locators.getProperty("unitdealstatus");
		unitoptionsstatus			=	locators.getProperty("unitoptionsstatus");
		summary						=	locators.getProperty("summary");
		unit1						=	locators.getProperty("unit1");
		unitName					=	locators.getProperty("unitName");
		option_fee					=	locators.getProperty("option_fee");
		notesforcustomer			=	locators.getProperty("notesforcustomer");
		dealstatuswindow			=	locators.getProperty("dealstatuswindow");
		saveStatus					=	locators.getProperty("saveStatus");
		optionstatuswindow			=	locators.getProperty("optionstatuswindow");
		commitoptions				=	locators.getProperty("commitoptions");
		dealservice1				=	locators.getProperty("dealservice1");
		serviceitems				=	locators.getProperty("serviceitems");
		serviceoption				=	locators.getProperty("serviceoption");
		jobstatus					=	locators.getProperty("jobstatus");
		savejobstatus				=	locators.getProperty("savejobstatus");
		savefinalizejob				=	locators.getProperty("savefinalizejob");
		internalhistory				=	locators.getProperty("internalhistory");
		saveCustomerApproval		=	locators.getProperty("saveCustomerApproval");
		approvalID					=	locators.getProperty("approvalID");
		customerownedunit			=	locators.getProperty("customerownedunit");
		searchentitytext			=	locators.getProperty("searchentitytext");
		verifyTechnician			=	locators.getProperty("verifyTechnician");
		completestatus				=	locators.getProperty("completestatus");
		servicejobelement			=	locators.getProperty("servicejobelement");
		
		
		
		
		
		
		
		
		
		
	 }
}

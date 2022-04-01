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
		defaultUser					=	prop.getProperty("defaultUser");
		firstname  					=	prop.getProperty("firstname");
		lastname  					=	prop.getProperty("lastname");
		companyname  				=	prop.getProperty("companyname");
		vendorAccountNumber  		=	prop.getProperty("vendorAccountNumber");
		laborcode 					=	prop.getProperty("laborcode");
		kitcode						=	prop.getProperty("kitcode");
		feecode						=	prop.getProperty("feecode");
		unitVIN						=   prop.getProperty("unitVIN");
		bulkUnitCount				=   prop.getProperty("bulkUnitCount");
		vendor_Input				=   prop.getProperty("vendor_Input");
		searchPart					=   prop.getProperty("searchPart");
		outofstockPart				=   prop.getProperty("outofstockPart");
		appointmentCustomer			=   prop.getProperty("appointmentCustomer");
		defaultTechnician			=	prop.getProperty("defaultTechnician");
		dealAppointmentCO			=	prop.getProperty("dealAppointmentCO");
		filename					=	prop.getProperty("filename");
		linkedfee					=	prop.getProperty("linkedfee");
		templateMsg					=	prop.getProperty("templateMsg");
		adminUser					=	prop.getProperty("adminUser");
		adminusername				=	prop.getProperty("adminusername");
		adminpassword				=	prop.getProperty("adminpassword");
		
		
		
		
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
		infogeneral					=   locators.getProperty("infogeneral");
		
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
		optionaAndfee				=	locators.getProperty("optionaAndfee");
		inprogresscheckbox			=	locators.getProperty("inprogresscheckbox");
		completeStatus				=	locators.getProperty("completeStatus");
		closeBrandingPopup			=	locators.getProperty("closeBrandingPopup"); 
		cancelbranding				=	locators.getProperty("cancelbranding");
		approvecheckbox				=	locators.getProperty("approvecheckbox");
		scanandsearch				=	locators.getProperty("scanandsearch");
		
		//Cash Sale
		sellpart					=	locators.getProperty("sellpart");
		
		//print invoice
		brandingconfirmbutton		=	locators.getProperty("brandingconfirmbutton");	
		printselectedbutton			=	locators.getProperty("printselectedbutton");
		
		
		//temporary unit
		quotetoggle					=	locators.getProperty("quotetoggle");
		settempunit					=	locators.getProperty("settempunit");
		tempUnitModelWindow			=	locators.getProperty("tempUnitModelWindow");
		exteriorcolor				=	locators.getProperty("exteriorcolor");
		nextButton					=	locators.getProperty("nextButton");
		savePrice					=	locators.getProperty("savePrice");
		saveTempUnit				=	locators.getProperty("saveTempUnit");
		temporaryunit1				=	locators.getProperty("temporaryunit1");
		tempUnitName				=	locators.getProperty("tempUnitName");	
		editpricing					=	locators.getProperty("editpricing");	
		editpricingwindow			=	locators.getProperty("editpricingwindow");
		rideawaytoggle				=	locators.getProperty("rideawaytoggle");
		saveBtnStampDuty			=	locators.getProperty("saveBtnStampDuty");
		savePriceBtn				=	locators.getProperty("savePriceBtn");
		addTradeIn					=	locators.getProperty("addTradeIn");
		tradein1					=	locators.getProperty("tradein1");
		addCOU						=	locators.getProperty("addCOU");
		tradeinunitname				=	locators.getProperty("tradeinunitname");
		printCO						=	locators.getProperty("printCO");
		appraisalMethod				=	locators.getProperty("appraisalMethod");
		printModelWindow			=	locators.getProperty("printModelWindow");	
		offertoPurchase				=	locators.getProperty("offertoPurchase");
		printSelected				=	locators.getProperty("printSelected");
		printPreview1				=	locators.getProperty("printPreview1");
		printPreview2				=	locators.getProperty("printPreview2");
		printPreview3				=	locators.getProperty("printPreview3");
		printPreview4				=	locators.getProperty("printPreview4");
		printClose					=	locators.getProperty("printClose");
		
		// Change and Delete Customer on CO
		customerHeader				=	locators.getProperty("customerHeader");
		customerName				=	locators.getProperty("customerName");
		deleteButton				=	locators.getProperty("deleteButton");
		customerWarning				=	locators.getProperty("customerWarning");
		warning1					=	locators.getProperty("warning1");
		customerlabel				=	locators.getProperty("customerlabel");
		sectionHeader				=	locators.getProperty("sectionHeader");
		confirm						=	locators.getProperty("confirm");
		addCustomerButton			=	locators.getProperty("addCustomerButton");
		priceLevel					=	locators.getProperty("priceLevel");
		taxExemption1				=	locators.getProperty("taxExemption1");	
		subtotal1					=	locators.getProperty("subtotal1");	
		changeCustomerButton		=	locators.getProperty("changeCustomerButton");	
		customerErrorModal			=	locators.getProperty("customerErrorModal");	
		errorMessage				=	locators.getProperty("errorMessage");	
		okButton1					=	locators.getProperty("okButton1");	
		okButton2					=	locators.getProperty("okButton2");	
		okButton3					=	locators.getProperty("okButton3");	
		okButton4					=	locators.getProperty("okButton4");	
		okButton5					=	locators.getProperty("okButton5");	
		invoiceHistory				=	locators.getProperty("invoiceHistory");
		reopenCO					=	locators.getProperty("reopenCO");
		invoiceReOpeningModalWindow	=	locators.getProperty("invoiceReOpeningModalWindow"); 
		reopenButton				=	locators.getProperty("reopenButton");
		entityQty					=	locators.getProperty("entityQty");
		partStatus					=	locators.getProperty("partStatus");
		stroreCreditOption			=	locators.getProperty("stroreCreditOption");
		closePaymentWindow			=	locators.getProperty("closePaymentWindow");
		createAppointment			=	locators.getProperty("createAppointment");	
		
		//Order(Unit)
		order						=	locators.getProperty("order");
		orderoptions				=	locators.getProperty("orderoptions");
		unitorder					=	locators.getProperty("unitorder");
		vendoroptions				=	locators.getProperty("vendoroptions");
		firstVendor					=	locators.getProperty("firstVendor");
		orderunitButton				=	locators.getProperty("orderunitButton");
		yearDropdown				=	locators.getProperty("yearDropdown");
		conditionDropdown			=	locators.getProperty("conditionDropdown");
		colorfield					=	locators.getProperty("colorfield");
		factoryfield				=	locators.getProperty("factoryfield");
		stockNumber					=	locators.getProperty("stockNumber");
		baseUnitPrice				=	locators.getProperty("baseUnitPrice");
		baseUnitCost				=	locators.getProperty("baseUnitCost");
		addPricing					=	locators.getProperty("addPricing");
		createSingleOrderButton		=	locators.getProperty("createSingleOrderButton");
		orderunitinfo				=	locators.getProperty("orderunitinfo");
		vinField					=	locators.getProperty("vinField");
		invoiceToggle				=	locators.getProperty("invoiceToggle");
		invoiceNumber				=	locators.getProperty("invoiceNumber");
		
		//Order(Part)
		partorder					=	locators.getProperty("partorder");
		partReceiving				=	locators.getProperty("partReceiving");	
		partCheckbox				=	locators.getProperty("partCheckbox");	
		printReceiving				=	locators.getProperty("printReceiving");	
		partInvoices				=	locators.getProperty("partInvoices");
		qtyinStock					=	locators.getProperty("qtyinStock");
		setBrandingLocationModalWindow =locators.getProperty("setBrandingLocationModalWindow"); 
		confirmButton				=	locators.getProperty("confirmButton");
		partstatus					=	locators.getProperty("partstatus");
		partqty						=	locators.getProperty("partqty");
		oversoldPopUpText			=	locators.getProperty("oversoldPopUpText");
		merchandise_Section			=	locators.getProperty("merchandise_Section");
		addSelectedButton			=	locators.getProperty("addSelectedButton");
	
		//Return(Part)
		partReturn					=	locators.getProperty("partReturn");
		rma							=	locators.getProperty("rma");
		creditMemo					=	locators.getProperty("creditMemo");
		
		//Schedule
		appointmenttable1			=	locators.getProperty("appointmenttable1");
		appointment_schedule_contentText = locators.getProperty("appointment_schedule_contentText");
		schedule					=	locators.getProperty("schedule");
		customernamecard			=	locators.getProperty("customernamecard");
		unitnamecard				=	locators.getProperty("unitnamecard");
		unitCheckinCloseArrow		=	locators.getProperty("unitCheckinCloseArrow");
		assign_tech_inputs			=	locators.getProperty("assign_tech_inputs");
		dateDueInField				=	locators.getProperty("dateDueInField");
		datePromisedField			=	locators.getProperty("datePromisedField");
		appointmentName				=	locators.getProperty("appointmentName");
		techNameandTime				=	locators.getProperty("techNameandTime");
		deleteAppointmentModalWindow = 	locators.getProperty("deleteAppointmentModalWindow");
		appointmenttable2			=	locators.getProperty("appointmenttable2");
		appointmentTime				=	locators.getProperty("appointmentTime");
		moveto						=	locators.getProperty("moveto");
		uaarrow						=	locators.getProperty("uaarrow");
		apSearchfield				=	locators.getProperty("apSearchfield");
		testAppointment				=	locators.getProperty("testAppointment");
		allTech						=	locators.getProperty("allTech");
		appointmentinfo				=	locators.getProperty("appointmentinfo");
		dropDownresult				=	locators.getProperty("dropDownresult");
		createApt					=	locators.getProperty("createApt");
		aptonCO						=	locators.getProperty("aptonCO");
		appointmentCONumber			=	locators.getProperty("appointmentCONumber");
		unitNameonCard				=	locators.getProperty("unitNameonCard");
		
		//SystemSettings
		acandset					=	locators.getProperty("acandset");
		settingsTiles				=	locators.getProperty("settingsTiles");
		accheader					=	locators.getProperty("accheader");
		accountingDropDown			=	locators.getProperty("accountingDropDown");
		accountingoptions			=	locators.getProperty("accountingoptions");
		lastSyncTime				=	locators.getProperty("lastSyncTime");
		accountsListPopUp			=	locators.getProperty("accountsListPopUp");
		okButton					=	locators.getProperty("okButton");
		controlAccFields			=	locators.getProperty("controlAccFields");
		undepositedFundsFields		=	locators.getProperty("undepositedFundsFields");
		defaultAccountsFields		=	locators.getProperty("defaultAccountsFields");
		addCategorybutton			=	locators.getProperty("addCategorybutton");
		addCategoryWindow			=	locators.getProperty("addCategoryWindow");
		addCategoryType				=	locators.getProperty("addCategoryType");
		categories					=	locators.getProperty("categories");	
		categoryName				=	locators.getProperty("categoryName");	
		incomeGL					=	locators.getProperty("incomeGL");
		accheader2					=	locators.getProperty("accheader2");
		addSaleTypeWindow			=	locators.getProperty("addSaleTypeWindow");
		activeLabel					=	locators.getProperty("activeLabel");
		listoflocations				=	locators.getProperty("listoflocations");
		brandHeader					=	locators.getProperty("brandHeader");
		addNewLocationIcon			=	locators.getProperty("addNewLocationIcon");
		allinputfields				=	locators.getProperty("allinputfields");
		businessname				=	locators.getProperty("businessname");
		businessPhone				=	locators.getProperty("businessPhone");
		businessEmail				=	locators.getProperty("businessEmail");
		taxID						=	locators.getProperty("taxID");
		streetaddress1				=	locators.getProperty("streetaddress1");
		streetaddress2				=	locators.getProperty("streetaddress2");
		city						=	locators.getProperty("city");
		pincode						=	locators.getProperty("pincode");
		filelabel					=	locators.getProperty("filelabel");
		fileSize					=	locators.getProperty("fileSize");
		customerInvoiceTextField	=	locators.getProperty("customerInvoiceTextField");
		serviceJobDisclaimerSlider	=	locators.getProperty("serviceJobDisclaimerSlider");
		serviceJobTextField			=	locators.getProperty("serviceJobTextField");
		orderDipositDisclaimerSlider=	locators.getProperty("orderDipositDisclaimerSlider");
		orderDepositTextField		=	locators.getProperty("orderDepositTextField");
		dealDocumentDisclaimerSlider=	locators.getProperty("dealDocumentDisclaimerSlider");
		dealDocumentTextField		=	locators.getProperty("dealDocumentTextField");
		receiptAddSignatureSlider	=	locators.getProperty("receiptAddSignatureSlider");
		receiptDisclaimerSlider		=	locators.getProperty("receiptDisclaimerSlider");
		receiptTextField			=	locators.getProperty("receiptTextField");
		brandingHeaders				=	locators.getProperty("brandingHeaders");
		brandingNames				=	locators.getProperty("brandingNames");
		confirmbrandingbutton		=	locators.getProperty("confirmbrandingbutton");
		invoiceCheckBox				=	locators.getProperty("invoiceCheckBox");
		printReceiptCheckBox		=	locators.getProperty("printReceiptCheckBox");
		printHeader					=	locators.getProperty("printHeader");
		profileHeader				=	locators.getProperty("profileHeader");
		businessName				=	locators.getProperty("businessName");
		abrbusinessName				=	locators.getProperty("abrbusinessName");
		shippingAddress				=	locators.getProperty("shippingAddress");
		accountName					=	locators.getProperty("accountName");
		listofdrawers				=	locators.getProperty("listofdrawers");
		drawerHeader				=	locators.getProperty("drawerHeader");
		addnewDrawerheader			=	locators.getProperty("addnewDrawerheader");
		drawerNameField				=	locators.getProperty("drawerNameField");
		createdrawerbutton			=	locators.getProperty("createdrawerbutton");
		cashDrawers					=	locators.getProperty("cashDrawers");
		drawerNames					=	locators.getProperty("drawerNames");
		feesections					=	locators.getProperty("feesections");
		lFeeHeader					=	locators.getProperty("lFeeHeader");
		dealFeesection				=	locators.getProperty("dealFeesection");
		feelist						=	locators.getProperty("feelist");
		feelistCO					=	locators.getProperty("feelistCO");
		servicejobFeesection		=	locators.getProperty("servicejobFeesection");
		merchandiseFeesection		=	locators.getProperty("merchandiseFeesection");
		formHeader					=	locators.getProperty("formHeader");	
		dealFormsection				=	locators.getProperty("dealFormsection");
		formlist					=	locators.getProperty("formlist");
		formlistco					=	locators.getProperty("formlistco");
		unlink						=	locators.getProperty("unlink");
		financingFormsection		=	locators.getProperty("financingFormsection");
		adddealfinancing			=	locators.getProperty("adddealfinancing");
		dfformlistco				=	locators.getProperty("dfformlistco");
		serviceFormsection			=	locators.getProperty("serviceFormsection");
		servieformlistco			=	locators.getProperty("servieformlistco");
		vpFormsection				=	locators.getProperty("vpFormsection");
		allMakes					=	locators.getProperty("allMakes");
		saveNewMakebtn				=	locators.getProperty("saveNewMakebtn");
		editmake					=	locators.getProperty("editmake");
		deletemake					=	locators.getProperty("deletemake");
		plHeader					=	locators.getProperty("plHeader");
		editLocationfield			=	locators.getProperty("editLocationfield");
		locationinfo				=	locators.getProperty("locationinfo");
		allLocations				=	locators.getProperty("allLocations");
		tagHeader					=	locators.getProperty("tagHeader");
		editTagfield				=	locators.getProperty("editTagfield");
		taginfo						=	locators.getProperty("taginfo");
		allTags						=	locators.getProperty("allTags");
		taxHeader					=	locators.getProperty("taxHeader");
		taxrates					=	locators.getProperty("taxrates");
		addnewrate					=	locators.getProperty("addnewrate");
		taxname						=	locators.getProperty("taxname");
		formslabel					=	locators.getProperty("formslabel");
		rate						=	locators.getProperty("rate");
		taxcodes					=	locators.getProperty("taxcodes");
		taxCodeName					=	locators.getProperty("taxCodeName");
		formslabelcode				=	locators.getProperty("formslabelcode");
		activeToggle				=	locators.getProperty("activeToggle");
		closebutton					=	locators.getProperty("closebutton");
		taxcodelist					=	locators.getProperty("taxcodelist");
		taxratelist					=	locators.getProperty("taxratelist");
		assignTaxRateButton			=	locators.getProperty("assignTaxRateButton");
		assignedRate				=	locators.getProperty("assignedRate");
		assignedrateCheckbox		=	locators.getProperty("assignedrateCheckbox");
		rateinclude					=	locators.getProperty("rateinclude");
		taxinfo						=	locators.getProperty("taxinfo");
		activetaxtoggle				=	locators.getProperty("activetaxtoggle");
		taxcodesavebtn				=	locators.getProperty("taxcodesavebtn");
		taxcodedeletebtn			=	locators.getProperty("taxcodedeletebtn");
		editTaxrate					=	locators.getProperty("editTaxrate");
		editsavetaxrates			=	locators.getProperty("editsavetaxrates");
		deletetaxrate				=	locators.getProperty("deletetaxrate");
		purchasetaxratelist			=	locators.getProperty("purchasetaxratelist");
		purchasetaxcodelist			=	locators.getProperty("purchasetaxcodelist");
		templetHeader				=	locators.getProperty("templetHeader");
		plusicon					=	locators.getProperty("plusicon");
		templateList				=	locators.getProperty("templateList");
		templatename				=	locators.getProperty("templatename");
		deleteTemplate				=	locators.getProperty("deleteTemplate");
		unitpricingheader			=	locators.getProperty("unitpricingheader");
		makeheader					=	locators.getProperty("makeheader");
		userpermissionheader		=	locators.getProperty("userpermissionheader");
		assigncolor					=	locators.getProperty("assigncolor");
		newgroupname				=	locators.getProperty("newgroupname");
		userslist					=	locators.getProperty("userslist");
		firstgroup					=	locators.getProperty("firstgroup");
		plusicon2					=	locators.getProperty("plusicon2");
		sorticon					=	locators.getProperty("sorticon");
		deleteicon					=	locators.getProperty("deleteicon");
		
		
		//Tax Calculation
		checkoutTotal				=	locators.getProperty("checkoutTotal");
		
		
		
		
		
		
		
		
		
		
	 }
}

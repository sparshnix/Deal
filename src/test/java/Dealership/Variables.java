package Dealership;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Variables {

	public static WebDriver driver;
	
	public static String 
	//Used for Masterdata
	browser, url, username, password, defaultUser, addnew, customer, smallheader, firstname, lastname,
	accounttypedropdown, accounttypevalue, country, countryname, state, statename, create,
	verifyemail, vendor, vendorHeader, companyname, vendorAccountNumber, shippingaddressflag,
	part_Purchases, merchandise_Purchases, unit_Purchases, sublet_Purchases, 
	claims_for_Service_WoAptonCOrk, deal_Products, flooring_Company, finance_Company, financing_Products,
	saveVendor, purchaseTaxLevel, vendorAccountTypeIcon, part, partheader, parttype, tags, location,
	tag_1, inStockQty,  verifyPart, labor, laborheader, laborcode, verifylabor, kit, kitheader,
	formstag, selecttag, applicabletax, savebutton, kitcode, servicekitchechbox, make, model,
	submodel, savekit, makeoption, modeloption, submodeloption, verifykit, fee, feeheader, feetype,
	Tags_fee, feecode, taxableflag, applicable_tax, savefee, verifyfee, unit, unitheader, unitVIN,
	unitmake, unitmodel, unitSubModel, year, new_unit, exterior_colour, stock, unitApplicable_tax,
	verifyunit, kititemplusicon, infogeneral,
	
	//used for Workspace
	home, storesummary, today, last_7_days, last_30_days, invoices, payments, new_customers, 
	searchtag1, servicejobs, customerpay, thirdparty, internal, deal, new_link, active, completed,
	searchtag2, vendor_orders, active_orders1, active_receiving, parts_needed, searchtag3,
	customer_orders, active_orders2, deposits, balance_due, searchtag4, activity_feed, myactivity,
	storeactivity,
	
	//used for Sell
	sell, selectcustomerdropdown, sellpartandaccs, activeorders, activeorderbutton, 
	merchandiseSectionId, checkout_button, setCashDrawerModalWindow, selectdrawerbutton, cashoption,
	addpayment, finalizebutton, invoicewindow, invoiceclosebutton, costatus, cancel, servicejob,
	servicejobstatus, servicejobdropdown, servicejobdetails, addcustomerunit, tempUnitMmodalWindow,
	addbutton, odometer_on_arrival, odometer_on_departure, productwindow, lpjItems, notes_for_customers,
	techniciantime, clockingStaffPopupforCO, technician1, documents, addforms,	
	documentFormModalWindowHeader, docCheckbox, addselected, customerapproval, sellAUnit,
	unitdealstatus, unitoptionsstatus, summary, unit1, unitName, option_fee, notesforcustomer,
	dealstatuswindow, saveStatus, optionstatuswindow, commitoptions, dealservice1, serviceitems,
	serviceoption, jobstatus, savejobstatus, savefinalizejob, internalhistory, saveCustomerApproval,
	approvalID, customerownedunit, searchentitytext, verifyTechnician, completestatus,
	servicejobelement, optionaAndfee, inprogresscheckbox, completeStatus, closeBrandingPopup,
	cancelbranding, approvecheckbox, scanandsearch, sellpart, brandingconfirmbutton, 
	printselectedbutton, quotetoggle, settempunit, tempUnitModelWindow, exteriorcolor, nextButton,
	savePrice, saveTempUnit, temporaryunit1, tempUnitName, editpricing, editpricingwindow,
	rideawaytoggle, saveBtnStampDuty, savePriceBtn, addTradeIn, tradein1, addCOU, tradeinunitname,
	printCO, appraisalMethod, printModelWindow, offertoPurchase, printSelected, printPreview1, 
	printPreview2,	printPreview3, printPreview4, printClose,
	
	//Change and Delete Customer on CO
	customerHeader, customerName, deleteButton, customerWarning, warning1, customerlabel, 
	sectionHeader, confirm, addCustomerButton, priceLevel, taxExemption1, subtotal1,
	changeCustomerButton, customerErrorModal, errorMessage, okButton1, okButton2, okButton3,
	okButton4, okButton5, invoiceHistory, reopenCO,	invoiceReOpeningModalWindow, reopenButton, 
	entityQty, partStatus, stroreCreditOption, closePaymentWindow, createAppointment,
	
	//Order(Unit)
	order, orderoptions, unitorder, vendoroptions, firstVendor, orderunitButton, yearDropdown,
	conditionDropdown, colorfield, factoryfield, stockNumber, baseUnitPrice, baseUnitCost,
	addPricing, createSingleOrderButton, orderunitinfo, vinField, invoiceToggle, invoiceNumber,
	bulkUnitCount,
	
	//Order(Part)
	partorder, vendor_Input, searchPart, partReceiving, partCheckbox, printReceiving, partInvoices,
	qtyinStock, setBrandingLocationModalWindow, confirmButton, outofstockPart, partstatus, partqty,
	oversoldPopUpText, merchandise_Section, addSelectedButton,

	//Return(Part)
	partReturn, rma, creditMemo,
	
	//Schedule
	appointmenttable1, appointment_schedule_contentText, schedule, appointmentCustomer, 
	customernamecard, unitnamecard, unitCheckinCloseArrow, assign_tech_inputs, dateDueInField,
	datePromisedField, defaultTechnician, appointmentName, techNameandTime, deleteAppointmentModalWindow,
	appointmenttable2, appointmentTime, moveto, uaarrow, apSearchfield, testAppointment, allTech,
	appointmentinfo, dropDownresult, createApt, aptonCO, appointmentCONumber, dealAppointmentCO,
	unitNameonCard,
	
	
	//SystemSettings
	acandset, settingsTiles, accheader, accountingDropDown, accountingoptions, lastSyncTime,
	accountsListPopUp, okButton, controlAccFields, undepositedFundsFields, defaultAccountsFields,
	addCategorybutton, addCategoryWindow, addCategoryType, categories, categoryName, incomeGL,
	accheader2, addSaleTypeWindow, activeLabel
	
	;
	
	public static void test() throws IOException
	{
	Property.testProperty();
	
	}
	
}

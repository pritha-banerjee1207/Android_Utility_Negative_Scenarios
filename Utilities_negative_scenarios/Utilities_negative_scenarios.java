package Utilities_negative_scenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Reusable_functions.Generic_functions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_negative_scenarios  extends Generic_functions{
	static boolean value;
	static String balance,text,ere,str;
	public static String exacttext,Save;
	
	/*Browser opens and user is on home page */ 	
	@When("User is on home page")
	public void user_is_on_home_page() {
		try {
			app_launch();
			page_wait(20);
			click("welcome_login");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("Object Locator","login_phone_number"))).sendKeys(td_reader("login_phone_number",1));
			driver.findElement(By.xpath(OR_reader("Object Locator","login_password"))).sendKeys(td_reader("login_password",1));
			page_wait(20);
			click("login");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* TC_001 -Validate that the user is able to navigate to Utilities screen */
	@Then("User should redirect to Utilities Dashboard when clicks on Utilities tab")
	public static void utilities_negative_tc_001() throws Exception {
		try {
			click("utilities");
			Thread.sleep(1000);
			click("utilities_wallet");
			page_wait(20);
			click("utilities_add_payment_method");
			page_wait(30);
			click("utilities_walletaddcredit");
			}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_001");
		}	
	}
	
	/* TC_002 -Validate that user gets validation message on leaving fields blank in the Add Card page */
	@Then("User should get validation message on leaving fields blank")
	public void utilities_negative_tc_002() throws IOException {
		try {
			page_wait(30);
			scrollAndClick("Save");
			scrollAndClick("Save as");
			str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcard_add_line_one_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_addcard_add_line_one_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcard_state_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_addcard_state_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcard_city_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_addcard_city_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcard_phone_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_addcard_phone_no_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcard_saveas_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_addcard_saveas_valid_msg"));
			page_wait(5);
			click("utilities_back_arrow");
			page_wait(5);
			click("utilities_add_payment_method");
			page_wait(10);
			click("utilities_walletaddcredit");
			}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_002");
		}	
		
	}
	
	/* TC_003 -Validate that user gets validation message on entering invalid details in the Add Card page*/
	@Then("User should get validation message on entering invalid details")
	public static void utilities_negative_tc_003() throws Exception {
		try {
		driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcardname"))).sendKeys(td_reader("utilities_addcardname",0));
		click("utilities_addcardphonenumber");
		driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcardphonenumber"))).sendKeys(td_reader("utilities_addcardphonenumber",1));
		scrollAndClick("Save");
		scrollAndClick("Save as");
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addcardphonenumber_assert"))).getText();
		Assert.assertEquals(str,td_reader("utilities_addcardphonenumber_assert"));
		page_wait(5);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_003");
		}
	}
	
	/*TC_004- Validate that user gets validation message on leaving fields blank in the Add Bank page */
	@Then("User should get validation message on leaving fields blank in Add Bank page")
	public static void utilities_negative_tc_004() throws Exception {
		try {
		click("utilities_back_arrow");
		click("utilities_add_payment_method");
		page_wait(10);
		click("utilities_addbank");
		click("utilities_addbanksaveas");
		click("utilities_addbankname");
		click("utilities_addbankrouting");
		click("utilities_addbankaccountno");
		scrollAndClick("Save");
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addbank_saveas_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("utilities_addbank_saveas_valid_msg"));
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_account_holder_name_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("utilities_account_holder_name_valid_msg"));
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addbank_routing_no_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("utilities_addbank_routing_no_valid_msg"));
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addbank_account_no_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("utilities_addbank_account_no_valid_msg"));
		Thread.sleep(1000);
		click("utilities_back_arrow");
		page_wait(5);
		click("utilities_add_payment_method");
		page_wait(10);
		click("utilities_addbank");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_004");
		}
		
	}
	
	/* TC_005 - Validate that user gets validation message on entering invalid details in the Add Bank page*/
	@Then("User should get validation message on entering invalid details in Add Bank page")
	public static void utilities_negative_tc_005() throws IOException {
		try {
		page_wait(10);
		click("utilities_addbankrouting");
		driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addbankrouting"))).sendKeys(td_reader("utilities_addbankrouting",0));
		click("utilities_addbankaccountno");
		driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addbankaccountno"))).sendKeys(td_reader("utilities_addbankaccountno",0));
		Thread.sleep(1000);
		scrollAndClick("Save");
		Thread.sleep(1000);
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_addbank_routing_no_valid_msg_two"))).getText();
		Assert.assertEquals(str,td_reader("utilities_addbank_routing_no_valid_msg_two"));
		str= driver.findElement(By.xpath(OR_reader("Object Locator","utilities_account_no_valid_msg_two"))).getText();
		Assert.assertEquals(str,td_reader("utilities_account_no_valid_msg_two"));
		Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_005");
		}
	}
	
	/* TC_006 - Validate that user is not able to redeem when the balance is less than 2000 */
	@Then("User is not able to click on redeem")
	public static void utilities_negative_tc_006()throws IOException {
	 try {
	   click("utilities_back_arrow");
	   click("utilities_addpayment_page_back_arrow");
	   click("utilities_awardspoints");
	   click("award_points_redeem_points_button");
	   page_wait(10);
	   driver.closeApp();
	 }catch(Exception e) {
		 e.printStackTrace();
		 takeScreenShot("utilities_negative_tc_006");
	 }
	}
	
}
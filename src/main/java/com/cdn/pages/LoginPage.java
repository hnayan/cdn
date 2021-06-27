package com.cdn.pages;



import org.testng.Reporter;
import com.cdn.utils.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BaseClass{

	//Android
	@AndroidFindBy (accessibility = "Close") private MobileElement userNametxtField;
	@AndroidFindBy (accessibility = "accesility id") private MobileElement passwordtxtField;
	@AndroidFindBy(id="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.TextView") private MobileElement existingSubscriptionLink;
	@AndroidFindBy (id = "uk.co.condenast.wired:id/userID") private MobileElement userNameField;
	@AndroidFindBy (id = "uk.co.condenast.wired:id/password") private MobileElement passwordField;
	@AndroidFindBy (id = "uk.co.condenast.wired:id/loginButton") private MobileElement loginBtn;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView") private MobileElement loginPageHeader;
	
	//iOS
	//@iOSXCUITFindBy (accessibility = "Close") private MobileElement userNametxtField1;


	public LoginPage enterUserName(String userName) {
		sendKeys(userNameField, userName);
		Reporter.log("User name is entered");
		return this;

	}

	public String loginPageheader() {
		return getAttribute(loginPageHeader, "text");
	}

	public LoginPage enterPassword(String password) {
		sendKeys(passwordField, password);
		Reporter.log("Password is entered");
		return this;

	}

	public HomePage clickLogin() {
		if(isElementDisplayed(loginBtn)) {
			click(loginBtn);
			Reporter.log("Login is clicked");
		}else {
			Reporter.log("Login Button is not available");
		}
		return new HomePage();
	}



}

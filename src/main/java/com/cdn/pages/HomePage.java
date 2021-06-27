package com.cdn.pages;


import org.testng.Reporter;
import com.cdn.utils.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseClass{

	//Android

	@AndroidFindBy (id = "uk.co.condenast.wired:id/documentPickerToolbar") private MobileElement homePageToolbar;
	@AndroidFindBy (accessibility = "More options") private MobileElement moreOptionIcon;
	@AndroidFindBy (accessibility = "Search") private MobileElement searchIcon;
	@AndroidFindBy (accessibility = "ALL ISSUES") private MobileElement allIssuesLink;
	@AndroidFindBy (accessibility = "DOWNLOADED") private MobileElement downloadedLink;
	@AndroidFindBy (xpath = "//android.widget.Button[contains(@text,'₹')]") private MobileElement priceButton;
	@AndroidFindBy (xpath = "//android.widget.Button[@text='SUBSCRIBE']") private MobileElement subscribeButton;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Account']") private MobileElement accountLink;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='EXISTING SUBSCRIPTIONS']") private MobileElement existingSubscriptionLink;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='1 Month']") private MobileElement monthSubscriptionLink;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='1 Year']") private MobileElement yearSubscriptionLink;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Add credit or debit card']") private MobileElement addCreditCardButton;

	
	public HomePage clickAllIssuesSection() {
		if (isElementDisplayed(allIssuesLink)) {
			click(allIssuesLink);
			Reporter.log("All Issue section link is clicked");
		}else {
			Reporter.log("All Issue section link is not available");
		}
		return this;

	}

	public HomePage clickDownloaded() {
		if (isElementDisplayed(allIssuesLink)) {
			click(downloadedLink);
			Reporter.log("Downloaded link is clicked");
		}else {
			Reporter.log("Downloaded link is not available");
		}
		return this;

	}

	public HomePage clickSearchIcond() {
		if (isElementDisplayed(searchIcon)) {
			click(searchIcon);
			Reporter.log("Search icon is clicked");
		}else {
			Reporter.log("Search icon is not available");
		}

		return this;

	}

	public HomePage clickMoreOptions() {
		if(isElementDisplayed(moreOptionIcon)) {
			click(moreOptionIcon);
			Reporter.log("More Option icon is clicked");
		}else {
			Reporter.log("More Option icon is not available");
		}

		return this;

	}

	public LoginPage clickAccountButton() {
		if(isElementDisplayed(accountLink)) {
			click(accountLink);
			Reporter.log("Account Button is clicked");
		}else {
			Reporter.log("Account Button is not available");
		}

		return new LoginPage();

	}


	public HomePage clickPriceButton() {
		if(isElementDisplayed(priceButton)) {
			click(priceButton);
			Reporter.log("Price Button is clicked");
		}else {
			Reporter.log("Price Button is not available");
		}
		return this;

	}

	public HomePage clickSubscribeButton() {
		if(isElementDisplayed(subscribeButton)) {
			click(subscribeButton);
			Reporter.log("Subscribe Button is clicked");
		}else {
			Reporter.log("Subscribe Button is not available");
		}

		return this;

	}


	public HomePage clickExistingSubscribeLink() {
		if(isElementDisplayed(existingSubscriptionLink)) {
			click(existingSubscriptionLink);
			Reporter.log("Existing Subscription link is clicked");
		}else {
			Reporter.log("Existing Subscription link is not available");
		}
		return this;

	}

	public HomePage clickMonthSubscriptionLink() {
		if(isElementDisplayed(monthSubscriptionLink)) {
			click(monthSubscriptionLink);
			Reporter.log("Monthly Subscription link is clicked");
		}else {
			Reporter.log("Monthly Subscription link is not available");
		}
		return this;

	}

	public HomePage clickYearSubscriptionLink() {
		if(isElementDisplayed(yearSubscriptionLink)) {
			click(yearSubscriptionLink);
			Reporter.log("Yearly Subscription link is clicked");
		}else {
			Reporter.log("Yearly Subscription link is not available");
		}
		return this;

	}

	public HomePage clickAddCreditCard() {
		if(isElementDisplayed(addCreditCardButton)) {
			click(addCreditCardButton);
			Reporter.log("Add Credit card Button is clicked");
		}else {
			Reporter.log("Add Credit card Button is not available");
		}
		return this;

	}

	public boolean creditCardOptionAvailable() {
		if(isElementDisplayed(addCreditCardButton)) {
			Reporter.log("Credit Card option is available and displayed");
			return true;
		}else {
			Reporter.log("Credit Card option is not displayed");
			return false;
		}
	}

	public HomePage enterCreditCard(String cardNum) {
		sendKeysThroughKeyBoard(cardNum);
		Reporter.log("Credit card num is selected");
		return this;

	}
}

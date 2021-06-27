package tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cdn.pages.HomePage;
import com.cdn.pages.LoginPage;
import com.cdn.pages.WelcomePage;
import com.cdn.utils.BaseClass;
import com.cdn.utils.TestData;

public class CheckoutTest extends BaseClass {

	LoginPage loginPage;
	HomePage homepage;
	WelcomePage welcomepage;

	@BeforeMethod
	public void beforeMethod(Method m) {
		loginPage = new LoginPage();
		welcomepage = new WelcomePage();
		homepage = new HomePage();
	}


	@Test  
	public void subscribeItem() {

		welcomepage.clickClose();
		homepage.clickSubscribeButton();
		homepage.clickMonthSubscriptionLink();
		homepage.clickAddCreditCard();
		Assert.assertTrue(homepage.creditCardOptionAvailable(), "Credit Card option is not displayed");
		homepage.enterCreditCard(TestData.CREDITCARD);

	}

}

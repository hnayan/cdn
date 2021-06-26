package tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cdn.pages.LoginPage;
import com.cdn.pages.WelcomePage;
import com.cdn.utils.BaseClass;

public class WelcomeTest extends BaseClass {
	LoginPage loginPage;
	WelcomePage welcomePage;
	
	@BeforeMethod
	  public void beforeMethod(Method m) {
		  loginPage = new LoginPage();
		  welcomePage = new WelcomePage();
	  }
	


  @Test
  public void scrollWelcomePageImages() {
	  welcomePage.scrollAllImages();
	  Assert.assertTrue(welcomePage.validateWelcomePageLanding(),"Welcome page is not displayed successfully");
  }

}

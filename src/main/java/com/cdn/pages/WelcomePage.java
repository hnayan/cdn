package com.cdn.pages;


import java.util.List;
import org.testng.Reporter;
import com.cdn.utils.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WelcomePage extends BaseClass{

	//Android
	@AndroidFindBy (accessibility = "Close") private MobileElement closeIcon;
	@AndroidFindBy (id = "uk.co.condenast.wired:id/page_indicator") private MobileElement navigationBar;
	@AndroidFindBy (xpath= "//android.widget.LinearLayout/android.view.View") private List <MobileElement> welcomeImages;
	@AndroidFindBy (id = "uk.co.condenast.wired:id/slideshow_image") private MobileElement welcomePageImage;
	//iOS
	@iOSXCUITFindBy (accessibility = "Close") private MobileElement closeIconiOS;

	public boolean validateWelcomePageLanding() {
		if(isElementDisplayed(welcomePageImage)) {
			Reporter.log("Welcome page is Displayed");
			return true;
		} else {
			Reporter.log("Welcome page is not Displayed");
			return false;
		}

	}

	public HomePage clickClose() {
		click(closeIcon);
		Reporter.log("close icon is clicked");
		return new HomePage();

	}

	public WelcomePage scrollAllImages() {
		if(welcomeImages.size()>0) {
			int imagesCount = welcomeImages.size();		
			while(imagesCount>0) {
				swipeScreen(Direction.LEFT);			
				imagesCount --;
			}
			Reporter.log("All pagination Screens are scrolled");
		}else {
			Reporter.log("No pagination Screen is displayed");
		}
		return this;
	}


	public String getCloseButtonContent() {
		return getAttribute(closeIcon,"content-desc");

	}


}

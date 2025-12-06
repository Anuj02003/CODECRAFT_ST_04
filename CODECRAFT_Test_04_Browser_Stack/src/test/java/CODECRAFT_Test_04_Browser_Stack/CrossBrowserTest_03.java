package CODECRAFT_Test_04_Browser_Stack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CrossBrowserTest_03 {
	
	 public static final String USERNAME = "anujpatil_7obZ0j";
	    public static final String ACCESS_KEY = "Z1utK6sgpKSSBCWizo9x";
	    public static final String URL_STRING = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

	    @Test
	    public void loginTest() throws Exception {
	        DesiredCapabilities caps = new DesiredCapabilities();

	        // CHANGE BROWSERS HERE
	        caps.setCapability("browserName", "Edge");
	        caps.setCapability("browserVersion", "latest");
	        caps.setCapability("bstack:options", new java.util.HashMap<String, Object>() {{
	            put("os", "Windows");
	            put("osVersion", "10"+ "");
	            put("sessionName", "SauceDemo Login");
	        }});

	        WebDriver driver = new RemoteWebDriver(new URL(URL_STRING), caps);

	        driver.get("https://www.saucedemo.com/");
	        Thread.sleep(2000);

	        driver.findElement(By.id("user-name")).sendKeys("visual_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	        Thread.sleep(3000);

	        boolean loggedIn = driver.getPageSource().contains("Products");
	        System.out.println("Login Successful? -> " + loggedIn);

	        driver.quit();
	    }

}

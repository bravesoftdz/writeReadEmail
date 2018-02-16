package by.mail.test.drivers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import by.mail.test.constants.Constants;

public class WebDrivers {
	Constants con = new Constants();

	public WebDriver ChromeDriver(String url) throws IOException {

		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(con.chromeDriverPath))
				.usingAnyFreePort()
				.build();
		service.start();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");

		WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(service);
		driver.get(con.url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

}

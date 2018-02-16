package by.mail.test.logic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.mail.test.constants.Constants;
import by.mail.test.drivers.WebDrivers;

public class LogicChrome {

	Constants con = new Constants();
	WebDrivers wb = new WebDrivers();

	public void processSendWriteEmailChrome(String user, String password, String email)
			throws IOException, InterruptedException {
		WebDriver driver = wb.ChromeDriver(con.url);
		driver.findElement(By.id("mailbox:login")).sendKeys(con.user);
		driver.findElement(By.id("mailbox:password")).sendKeys(con.password);
		driver.findElement(By.id("mailbox:submit")).click();

		Thread.sleep(5000);

		driver.findElement(By.className("b-toolbar__item")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]"))
				.sendKeys(con.email);

		driver.findElement(By.name("Subject")).sendKeys(con.subjectTo);

		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'composeEditor_ifr')]"));
		driver.switchTo().frame(frame);

		WebElement eMessageBody = driver.findElement(By.id("tinymce"));
		eMessageBody.sendKeys(con.messageTo);
		driver.switchTo().defaultContent();

		// send email
		driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div")).click();
		
		// list letters
		driver.findElement(By.xpath("//*[@id=\"b-compose__sent\"]/div/div[1]/div/a[2]")).click();

		Thread.sleep(5000);

		//clic on message
		driver.findElement(By.xpath("//div[@id='b-letters']/div/div[2]/div/div[2]/div/div/a/div[4]/div[3]/div/div"))
				.click();

		Thread.sleep(5000);
		
		//get message from
		String messageFrom = driver.findElement(By.className("b-letter__head__addrs__from")).getText();
		System.out.println("MESSAGE FROM: " + messageFrom);

		//get subject from
		String subjectFrom = driver.findElement(By.className("b-letter__head__subj__text")).getText();
		System.out.println("SUBJECT: " + subjectFrom);

		//get message from
		String bodyMessage = driver.findElement(By.className("b-letter__body")).getText();
		System.out.println("MESSAGE: " + bodyMessage);

		Thread.sleep(5000);

		// rabbishs
		driver.findElement(By.xpath("//div[@id='b-nav_folders']/div/div/a/span")).click();

		Thread.sleep(5000);
		// select letter
		driver.findElement(By.xpath("//div[@id='b-letters']/div/div[2]/div/div[2]/div/div/a/div/div/div")).click();

		Thread.sleep(5000);
		// delete letter
		driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[2]/div/div[1]")).click();

		Thread.sleep(5000);
		// rabbishes
		driver.findElement(By.xpath("//div[@id='b-nav_folders']/div/div[5]/a/span[2]")).click();

		Thread.sleep(5000);
		// select rabbish letter
		driver.findElement(By.xpath("//div[@id='b-letters']/div/div[5]/div/div[2]/div/div/a/div/div/div")).click();

		Thread.sleep(5000);
		// delete rabbish letter
		driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div[5]/div/div[2]/div[2]/div/div[1]")).click();

		Thread.sleep(5000);
		// close account
		driver.findElement(By.id("PH_logoutLink")).click();

		//close driver and window
		driver.close();

	}

}

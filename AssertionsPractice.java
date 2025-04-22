import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertionsPractice 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//Assertions in automation testing to validate tests
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //This will throw an error because we are expecting that the checkbox here is checked but we did not automate the checking of the checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click(); //checkbox was now clicked thru this code
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		//Clicking the Passenger: Adult plus icon 5 times
		int passengerAdult = 1;
		while (passengerAdult < 5) 
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			passengerAdult++;
		}
				
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); //actual result, expected result (try to change expected result to 4 and this will throw an error here
	}
}

package Com.qualitystrem.prueba;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaTest {

	private WebDriver driver; 
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get( "https://www.choucairtesting.com/empleos-testing/");
		
	}
	
	@Test
	public void testchoucairtesting() {
		 WebElement searchbox = driver.findElement(By.name("search_keywords")); 
		/* WebElement searchbox = driver.findElement(By.name("q")); */
		searchbox.clear();
		searchbox.sendKeys("probador");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("hola mija", driver.getTitle());
	}
	@After
	public void tearDown(){
		driver.quit();
	}
}

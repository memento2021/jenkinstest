

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HotelWebAppTest extends AbstractTest {
	
	public boolean returnTown(String townName){
		
		//int currentLine = 1;
		List<WebElement> l_lignes = driver.findElements(By.xpath("//table/tbody/tr"));
		for(WebElement ligne : l_lignes) {
			List<WebElement> l_cell = ligne.findElements(By.xpath("td"));
			for(WebElement cell : l_cell) {
				if(cell.getText().equals(townName)) {
					return true;
				}
			}
		//currentLine++;
		}
		return false;
	}
	
	
	@Before
	public void setup() {
		selectBrowser(browser);
	}
	
	@After
	public void teardown() {
		//driver.quit();
	}
	
	@Test
	public void hotelWebAppTest() {
		String town = "Paris";
		
		driver.get("http://192.168.0.17:8080/HotelWebapp");
		
		WebElement townSelect = driver.findElement(By.name("ville"));
		WebElement searchHotelButton = driver.findElement(By.xpath("//*[@type='submit']"));
		Select selectTown = new Select(townSelect);
		
		selectTown.selectByValue(town);
		searchHotelButton.click();
		
		//Assert.assertTrue(returnTown(town));
		
	}
	
}

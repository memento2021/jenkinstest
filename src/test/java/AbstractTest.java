

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractTest {
	
	protected WebDriver driver;
	WebDriverWait wait;
	EBrowser browser = EBrowser.Chrome;
	
	public void selectBrowser(EBrowser brow) {
		if (brow.equals(EBrowser.Firefox)) {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (brow.equals(EBrowser.Edge)) {
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else if (brow.equals(EBrowser.Chrome)) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}
}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisplayPlayerTanksByTier {
    //globalne varijable za chrome driver i link stranice
    public WebDriver driver;
    public String testURL = "https://wot-life.com/";

    @BeforeMethod
    public void setupTest() {
        //postavljanje putanje za chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

        //postavljanje chrome driver-a i maksimiziranje prozora
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
        driver.manage().window().maximize();

        //klik na gumb accept za kolačiće
        WebElement accept = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div"));
        accept.click();
    }

    @Test
    public void wot_life_display_player_tanks_by_tier() throws InterruptedException {
        //pretraga korisnika
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Hauba");
        search.submit();
        Thread.sleep(2000);
        //scrollanje 1000 pixela
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        //sortiranje tenkova korisnika prema tier vrijednosti
        WebElement tanks = driver.findElement(By.xpath("/html/body/main/div[7]/h2"));
        tanks.click();
        WebElement tier = driver.findElement(By.xpath("/html/body/main/div[7]/div/div[2]/table/thead/tr/th[7]"));
        tier.click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void teardownTest() {
        //prekid testa
        driver.quit();
    }
}

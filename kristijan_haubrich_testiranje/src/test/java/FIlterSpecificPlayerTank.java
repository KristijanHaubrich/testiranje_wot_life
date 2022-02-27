import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FIlterSpecificPlayerTank {
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
    public void wot_life_filter_specific_player_tank() throws InterruptedException {
        //pretraga korisnika
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Hauba");
        search.submit();
        Thread.sleep(2000);
        //scrollanje za 1000 pixela
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        //klik na tanks tab i upisivanje imena tenka u search bar
        WebElement tanks = driver.findElement(By.xpath("/html/body/main/div[7]/h2"));
        tanks.click();
        WebElement search_tank = driver.findElement(By.xpath("/html/body/main/div[7]/div/div[1]/div/input"));
        search_tank.sendKeys("isu");
        Thread.sleep(2000);
        //provjera je li dobar tank filtriran preko id tenka
        WebElement tank = driver.findElement(By.className("tank7425"));
        Assert.assertEquals(tank.getAttribute("class"), "tank7425");
    }

    @AfterMethod
    public void teardownTest() {
        //prekid testa
        driver.quit();
    }
}

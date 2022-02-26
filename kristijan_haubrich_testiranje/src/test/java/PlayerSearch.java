
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
    public class PlayerSearch {

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
        public void wot_life_player_search() throws InterruptedException {
            //pretrazivanje igraca pomocu search bar-a
            Thread.sleep(2000);
            WebElement search = driver.findElement(By.name("search"));
            search.sendKeys("Hauba");
            search.submit();
            Thread.sleep(2000);

            //usporedivanje trazenog imena igraca sa imenom koji se dobije nakon pretrazivanja u naslovu
            WebElement username = driver.findElement(By.xpath("/html/body/main/div[3]/div/div[1]/h1"));
            Thread.sleep(1000);
            Assert.assertEquals(username.getText(), "Hauba");
        }

        @AfterMethod
        public void teardownTest() {
            //prekid testa
            driver.quit();
        }
    }

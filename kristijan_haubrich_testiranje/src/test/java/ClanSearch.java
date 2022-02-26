import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClanSearch {

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
    public void wot_life_clan_search() throws InterruptedException {
       //prebacivanje na pretrazivanje za klanove
        Thread.sleep(2000);
        WebElement clan = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[1]/div/label[2]"));
        clan.click();
        Thread.sleep(2000);
        //upisivanje stringa za pronalazak klana
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("fa");
        Thread.sleep(2000);
        //prebacivanje na profil klana koji se pojavio u prijedlozima preko naziva klana
        WebElement clan_search = driver.findElement(By.xpath("//*[text()='[FAIR] Fair Play Clan']"));
        //izbjegavanje preusmjeravanja na reklame koristenjem atributa za link
        String clan_search_string = clan_search.getAttribute("href");
        driver.navigate().to(clan_search_string);

        //provjeravanje klana preko njihovog mota
        WebElement moto = driver.findElement(By.xpath("/html/body/main/div[5]/h4"));
        Assert.assertEquals(moto.getText(), "we play in all game's fair");

    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod

    public void teardownTest() {
        //prekid testa
        driver.quit();
    }
}

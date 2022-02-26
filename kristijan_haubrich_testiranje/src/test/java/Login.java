import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
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
    public void wot_life_login() throws InterruptedException {
        //klik na login i izbjegavanje preusmjeravanja na reklame koristenjem atributa za link
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("/html/body/header/nav/div/nav/ul/li[1]/a"));
        String login_string = login.getAttribute("href");
        driver.navigate().to(login_string);

        //odabir servera preko kojeg je korisnik prijavljen
        Thread.sleep(2000);
        WebElement eu_server = driver.findElement(By.xpath("/html/body/main/div[3]/p[2]/a"));
        eu_server.click();
        Thread.sleep(2000);
        //odabir prihvata kolacica na stranici
        WebElement accept = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/div/div/button"));
        accept.click();
        Thread.sleep(2000);

        //upisivanje podataka korisnickog racuna
        WebElement email = driver.findElement(By.name("login"));
        email.sendKeys("rlovac@yahoo.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Policija1984");
        //LOGIRANJE
        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[1]/span/form/div/fieldset[2]/span[1]/button"));
        submit.click();
        Thread.sleep(5000);
        //  vracanje na wot-life stranicu
        WebElement go = driver.findElement(By.xpath("//*[text()='Continue']"));
        go.click();
        Thread.sleep(2000);
        //provjera podudarnosti imena korisnika
        WebElement username = driver.findElement(By.xpath("//*[text()='lovc1984']"));
        if(username.getText().equals("lovc1984")) System.out.print("Test is successfull");
    }

    @AfterMethod
    public void teardownTest() {
        //prekid testa
        driver.quit();
    }
}

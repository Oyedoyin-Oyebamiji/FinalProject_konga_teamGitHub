import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class KongawebSigninTest {

    //Import the Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //Locate the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //Start Ordering flow of Konga as an existing customer by 1. Opening Chrome browser
        driver = new ChromeDriver();
    }

    @Test(priority = 0)
    public void OpenUrl() throws InterruptedException {
        //2. Inputting and opening Konga page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //3. Making sure the URL page fully loads by delaying by 5000 millisecond
        Thread.sleep(5000);
        //Test case 1: Verify that user inputs the right url and is directed to the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Valid webpage");
        else
            //Fail
            System.out.println("Invalid webpage");
        //4. Maximising browser page
        driver.manage().window().maximize();
        //5. Getting the page title
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void Validcredentialtest() throws InterruptedException {
        //6. Clicking on Login/Signup button to open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //Test case 2: Verify that when user clicks login/Signup button, user is directed to login page
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Valid webpage");
        else
            //Fail
            System.out.println("Invalid webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void login_emailaddress() throws InterruptedException {
        //7. Locating and inputting valid email address in the email address or phone number field
        driver.findElement(By.id("username")).sendKeys("");
        //Test case 3: Verify that user can log in with valid email address
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void login_password() throws InterruptedException {
        //8. Locating and inputting valid password in the password field
        driver.findElement(By.id("password")).sendKeys("");
        //Test case 4:Verify that User can log in with valid password
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void click_login_button() throws InterruptedException {
        //9. Clicking on Login button to log into account
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //10. Making sure the URL page fully loads by delaying by 5000 millisecond
        Thread.sleep(5000);
        //11. Logging out of the account
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        //Test case 5: Verify that User is redirected to homepage at the click logout button
        String logoutUrl = "https://www.konga.com/";
        String homeUrl = driver.getCurrentUrl();
        if (homeUrl.contains(logoutUrl))
            //Pass
            System.out.println("Valid webpage");
        else
            //Fail
            System.out.println("Invalid webpage");
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //12. Quitting browser
        driver.quit();
    }

}

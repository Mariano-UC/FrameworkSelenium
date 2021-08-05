import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccount {
    @Test
    public void Test_Login_Succesful(){

        String username = "mariano12castro@hotmail.com";
        String password = "Password123";

        String pathToDriver = Test.class.getResource("/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        //Go to Log in page
        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //Lenar Formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

    }
}

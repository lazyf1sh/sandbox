import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Ivan Kopylov
 */
public class WaitTest
{

    private WebDriver  driver;
    private String     baseUrl;
    private WebElement element;

    @BeforeClass
    public static void init()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\1\\apps\\geckodriver-v0.25.0-win64\\geckodriver.exe");
    }

    @Before
    public void setUp()
    {
        driver = new FirefoxDriver();
        baseUrl = "http://www.yandex.ru";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception
    {
        driver.get(baseUrl);
        element = driver.findElement(By.className("input__control"));
        System.out.println(1);
        element.sendKeys("Selenium WebDriver Interview questions");
        System.out.println(2);
        element.sendKeys(Keys.RETURN);
        List<WebElement> list = driver.findElements(By.className("_Rm"));
        System.out.println(3);
        System.out.println(list.size());
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}

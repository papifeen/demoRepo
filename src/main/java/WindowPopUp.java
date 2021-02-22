import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopUp {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/papifeen/Desktop/FacebookLogin/src/main/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //maximize window
        driver.manage().deleteAllCookies(); //delete cookies

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.webroot.com/services/popuptester1.htm");

        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it= handles.iterator();

        String parentWindowId = it.next();
        System.out.println("Parent window Id:" + parentWindowId);

        String childWindowId = it.next();
        System.out.println("Child window Id:" + childWindowId);

        driver.switchTo().window(childWindowId);

        System.out.println("child window title:" + driver.getTitle());

        driver.close();

        driver.switchTo().window(parentWindowId);

        System.out.println("parent window title:" + driver.getTitle());


    }
    public void Dropdown(){
        System.out.println("hi");
    }

}

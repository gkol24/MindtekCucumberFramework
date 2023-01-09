package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class BrowserUtils {
    /**
     * This method will accept WebElement of dropdown
     * and String value of dropdown and will select
     * provided value in dropdown
     */
    public static void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * This method will accept WebElement of dropdown
     * and String visible text of dropdown and will select
     * provided value in dropdown
     */

    //public

    /**
     * This method will takes screenshots
     * Ex: takeScreenshot("SauceDemo Test")
     */
    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "/Users/malgorzatakolinski/IdeaProjects/MindtekTestNGFramework/src/test/resources/screenshots" + testName + ".png";
        File file = new File(path);

        FileUtils.copyFile(screenshot, file);

    }

    /**
     * This method generates random emails.
     * EX:
     * getRandomEmail(); -. returns testUser647123@gmail.com
     */
    public static String getRandomEmail() {
        String username = "testUser";
        Random random = new Random();
        int number = random.nextInt(999_999);
        return username + number + "@hotmail.com";

    }

    /**
     * This method generates very strong password
     * ex: getRandomStrongPassword():-> returns random very strong password
     */

    public static String getRandomStrongPassword() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();


    }
}
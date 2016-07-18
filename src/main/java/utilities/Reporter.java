package utilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;

public class Reporter {
    public static void report(ITestResult testResult, WebDriver driver, ExtentTest extentTest) throws IOException{
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = extentTest.addScreenCapture(path);
            extentTest.log(LogStatus.FAIL, testResult.getName() + " Failed", imagePath);
        } else if (testResult.getStatus() == ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS, testResult.getName() + " Passed");
        }
    }
}

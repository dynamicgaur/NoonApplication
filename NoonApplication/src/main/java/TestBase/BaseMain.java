package TestBase;
	
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
//import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;

import static java.lang.System.getProperty;

	public class BaseMain {

		 public static Properties prop;
		    public static WebDriver driver;
		    public static ExtentHtmlReporter htmlReporter;//look and feel of report
		    public static ExtentReports extent;//create entries i report, environment, browser details etc
		    public static ExtentTest extentTest;

		    public BaseMain() {
		        try {
		            System.out.println("Base main constructor");
		            prop = new Properties();
		            FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/utility/configuration.properties");
		    
		            prop.load(fi);
		        } catch (FileNotFoundException e2) {
		            e2.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    public static String takeScreenShot(WebDriver driver,String screenshot) throws IOException
		    {
		        String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		        System.out.println(datename);
		        TakesScreenshot ts=(TakesScreenshot)driver;
		        File source=ts.getScreenshotAs(OutputType.FILE);
		        String dest=System.getProperty("user.dir")+"/test-output/failed"+screenshot+datename+".png";
		        System.out.println(dest);
		        File finaldest=new File(dest);
		        FileUtils.copyFile(source,finaldest);
		        return dest;
		    }
		    @BeforeSuite
		    public void setExtent() {

		      /*
		        htmlReporter = new ExtentHtmlReporter(getProperty("user.dir") + "/test-output/myReport.html");

		        //path where extent report is to be stored
		        htmlReporter.config().setDocumentTitle("Automation Report");
		        //title defined
		        htmlReporter.config().setReportName("Functional Report");
		        htmlReporter.config().setTheme(Theme.DARK);
		        extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
		        extent.setSystemInfo("OS", "windows");
		        extent.setSystemInfo("browser", "chrome");*/


		        extent= new ExtentReports (System.getProperty("user.dir") +"/test-output/readOutputFile.html", true);
		        //extent.addSystemInfo("Environment","Environment Name")
		        extent.addSystemInfo("Host Name", "SoftwareTestingMaterial");
		        extent.addSystemInfo("Environment", "Automation Testing");
		        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

		    }


		    public void browserInitialise() {
		        String browsername = prop.getProperty("browser");
		        if (browsername.equalsIgnoreCase("chrome")) {
		            System.out.println("Chrome browser initialised");
		            System.setProperty("webdriver.chrome.driver", getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
		            driver = new ChromeDriver();

		        } else if (browsername.equalsIgnoreCase("firefox")) {
		            System.out.println("Firefox browser initialised");
		            System.setProperty("webdriver.gecko.driver", getProperty("user.dir") + "\\src\\main\\java\\drivers\\geckodriver.exe");
		            driver = new FirefoxDriver();
		        }

		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();

		        driver.get(prop.getProperty("url"));
		        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		    }



		    @AfterMethod
		    public void getResult(ITestResult result) throws IOException {

		        if (result.getStatus() == ITestResult.SUCCESS) {
		           // extentTest.pass(MarkupHelper.createLabel(result.getName() + "test case has passed", ExtentColor.GREEN));
		            extentTest.log(LogStatus.PASS,result.getName()+"PASSED");


		        } else if (result.getStatus() == ITestResult.FAILURE) {

		            //extentTest.fail(MarkupHelper.createLabel(result.getName() + "test case has failed", ExtentColor.RED));
		            //extentTest.pass(result.getThrowable());
		            extentTest.log(LogStatus.FAIL,result.getName()+"Test failed");
		            extentTest.log(LogStatus.FAIL,result.getThrowable());
		           String shot= BaseMain.takeScreenShot(driver,result.getName());
		            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(shot)+"TEST FAILED");

		            //extentTest.log(Status.FAIL,extentTest.addScreenCaptureFromPath(shot)+"TEST FAILED");




		        } else if (result.getStatus() == ITestResult.SKIP) {
		            //extentTest.skip(MarkupHelper.createLabel(result.getName() + "test case has passed", ExtentColor.YELLOW));
		            //extentTest.pass(result.getThrowable());
		            extentTest.log(LogStatus.SKIP,result.getName()+"Test SKIPPED");
		            extentTest.log(LogStatus.SKIP,result.getThrowable());
		        }
		        driver.quit();
		    }

		    @AfterSuite
		    public void endReport() {
		        extent.flush();

		    }

	}
	
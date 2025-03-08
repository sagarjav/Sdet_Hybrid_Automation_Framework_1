package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

 public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public WebDriverWait wait;
	public Properties p;
	protected Actions action;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		switch(br.toLowerCase())
		{
			case "chrome":  driver=new ChromeDriver ();break;
			case "edge":  driver=new EdgeDriver ();break;
			case "firefox":  driver=new FirefoxDriver ();break;
			default: System.out.println("Invalid browser name.....");
			return;
		
		}
		
		// Initialize the Actions object
        action = new Actions(driver); // Initialize action with driver
        
		
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Loading config.properties file
				FileReader file=new FileReader("E:\\New Volume D\\Software Testing\\Project -Groww details\\Sdet_Hybrid_Automation_Framework\\src\\test\\resources\\config.properties");
				 p=new Properties();
				 p.load(file);
				
				logger=LogManager.getLogger(this.getClass()); //log4j2
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));   //URL taken from config.properties file
		//driver.get("https://groww.in/");
		
	}
	

	
	
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot  takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path="E:\\New Volume D\\Software Testing\\Project -Groww details\\Sdet_Hybrid_Automation_Framework\\screenshots\\"+tname+" "+timeStamp+".png";
		File targetfile=new File(path);
		
		sourceFile.renameTo(targetfile);
		return path;
		
		
		
	}
	
	
 @AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	
}

package com.wbl.qa.basePage;

import com.wbl.qa.util.WebEventListner;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage
{



   public static WebDriver driver;
   public static Properties prop;

    public BasePage() {
        try {
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sunil\\IdeaProjects\\WhiteboxQA" +
                    "\\src\\main\\java\\com\\wbl\\qa\\config\\config.properties");
            prop.load(fileInputStream);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

        public static  void initialization ()
        {
            String browserName = prop.getProperty("browser");
            if (browserName.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "C:\\Shilpa\\Chromedriver\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            else
            {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\sunil\\Desktop\\geckodriver.exe");
                driver = new FirefoxDriver();
            }

            // To call event listener class we have to create the object of eventfiringWebDriver
            EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
            //now create the object of EVEntListenerHandler to register it with Event firing WebDriver
           WebEventListner eventListener = new WebEventListner();
            e_driver.register(eventListener);
            driver = e_driver;


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

            driver.get(prop.getProperty("url"));
        }
    }

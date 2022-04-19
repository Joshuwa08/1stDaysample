package org.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public static WebDriver driver;
//		---------Browserlaunch-----------
		public static WebDriver  launchBrowser(String browserName ) {
			if(browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			} else if(browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}else {
				System.out.println("browser not valid");
			}
			return driver;}
//			switch(browserName) {
//				case "chrome":
//					WebDriverManager.chromedriver().setup();
//					driver=new ChromeDriver();
//					break;
//				case "firefox":
//					WebDriverManager.firefoxdriver().setup();
//					driver=new FirefoxDriver();
//					break;
//				case "edge":
//					WebDriverManager.edgedriver().setup();
//					driver=new EdgeDriver();
//			}
//			return driver;}
//		----------launch Url----window maximize-------
		public static void launchUrl(String Url) {
			driver.get(Url);
			driver.manage().window().maximize();}
//		-------implicityWait----------
		public static void implicityWait(long wait ) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
//		--------ThreadSleep-----------
		public static void threadSleep(int time) throws InterruptedException {
			Thread.sleep(time);
		}
//		--------getTitle----------
		public static String getTitle() {
			String title = driver.getTitle();
			return title;}
//		---------getcurrenturl-----------
		public static String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;}
//		------browserQuit----
		public static void browserQuit() {
			driver.quit();}
//		--------browserClose---------
		public static void windowClose() {
			driver.close();}
//		-------button Click--------
		public static void btnClick(WebElement w) {
			w.click();}
//		--------clear----------
		public static void clear(WebElement w) {
			w.clear();}
//		------get Text----------
		public static String getText(WebElement w) {
			String text = w.getText();
			return text;}
//		--------sendkeys-----------
		public static void sendkeys(WebElement w,String value) {
			w.sendKeys(value);}
//		--------- getAttribute------------
		public static String getAttribute(WebElement w) {
			String attribute = w.getAttribute("value");
			return attribute;}
//		----------findElement--------
		public static WebElement findElement(String locatorName,String locatorValue) {
			WebElement value = null;
			if(locatorName.equals("id")) {
				 value = driver.findElement(By.id(locatorValue));
			}else if(locatorName.equals("name")) {
				 value = driver.findElement(By.name(locatorValue));
			}else if(locatorName.equals("className")) {
				 value = driver.findElement(By.className(locatorValue));
			}else if(locatorName.equals("xpath")) {
				 value = driver.findElement(By.xpath(locatorValue));
			}else if(locatorName.equals("tagName")) {
				 value = driver.findElement(By.tagName(locatorValue));
			}return value;}
//		--------javaScript-----------
//		----------insert----------------
//		public static void jsInsertValue() {
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript(arg0, arg1)
//		}
//		----------get attribute value------------
		public static Object jsGetAttributeValue(WebElement w) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", w);
			return executeScript;
		}
//		----------scroll up----------
		public static void jsScrollUp(WebElement w) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			Object executeScript = js.executeScript("arguments[0].scrollIntoView(true)", w);
		}
//		---------scroll down--------------------
	    public static void jsScrollDown(WebElement w) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguents[0].scrollIntoView(false)", w);
		}
//	    ----------click-------------
	    public static void jsClick(WebElement w) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", w);
		}
//	    -------------ScreenShot---------------
	    
	    public static void screenshot(String name) throws IOException {
			TakesScreenshot tk= (TakesScreenshot)driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			System.out.println(src);
			
			File des =new File (System.getProperty("user.dir")+("\\src\\test\\resources\\screenshot\\" +name+ ".png"));
			FileUtils.copyFile(src, des);
		}
	//  -----------Actions----------------  
	  //----------MovetoElements---------
	  	public static void moveToElements(WebElement tgt){
	  		Actions a=new Actions(driver);
	  		a.moveToElement(tgt);
	  	}
	  	//---------Sendkeys------------
	  	public static void SendKeysAction(WebElement tgt,String value) {
	  		Actions a=new Actions(driver);
	  		a.sendKeys(tgt, value).perform();
	  	}
	  //--------click---------------
	  	public static void clickAction(WebElement tgt) {
	  		Actions a=new Actions(driver);
	  		a.click(tgt).perform();
	  	}
	  	//----------drag and drop---------------------------
	  	public static void dragAndDrop(WebElement src,WebElement des) {
	  		Actions a=new Actions(driver);
	  		a.dragAndDrop(src, des);
	  	}
	  //----------clickAndHold-------------------------
	  	public static void clickAndHoldRelease(WebElement src, WebElement des) {
	  		Actions a=new Actions(driver);
	  		a.clickAndHold(src).release(des).perform();
	  	}
	  //---------contextclick---------------------------
	  	public static void contextClick(WebElement tgt) {
	  		Actions a=new Actions(driver);
	  		a.contextClick(tgt);
	  	}
	  	//----------DoubleClick-------------------------
	  	public static void doubleclick(WebElement tgt) {
	  		Actions a=new Actions(driver);
	  		a.doubleClick(tgt).perform();
	  	}
//	  	-------Release---------
	  	public static void release() {
			Actions a=new Actions(driver);
			a.release().perform();
		}
//	  	-----------Navigation----------
//	  	------back---------
	  	public static void back() {
			driver.navigate().back();
		}
	//-------forward------------
	  	public static void forward() {
	  		driver.navigate().forward();
	  	}
	//-----------refresh-------------
	  	public static void refresh() {
	  		driver.navigate().refresh();
	  	}
	//--------navigateToUrl----------
	  	public static void navigateto(String url) {
	  		driver.navigate().to(url);
	  	}
	// --------windowHandling ----------
	  	public static String WindowHandling() {
			String windowHandle = driver.getWindowHandle();
			return windowHandle;	
		}
	//----------windoeHandles-------------
	  	public static Set<String> WindowAllHandling() {
	  		Set<String> windowHandles = driver.getWindowHandles();
	  		return windowHandles;
	  	}
	  	
	  	// -- list window Handles---
	  	public static List<String> WindowHandlingList() {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> li=new ArrayList<String>();
			li.addAll(windowHandles);
			return li;
		}
	  	
	  	
	  	
	//----------isselected-----------
	  	public static boolean isSelected(WebElement w) {
	  		boolean selected = w.isSelected();
	  		return selected;
	  	}
	//----------isEnabled-----------
	  	public static boolean isEnabled(WebElement w) {
	  		boolean selected = w.isEnabled();
	  		return selected;
	  	}
	//----------isDisplayed-------------
	  	public static boolean isDisplayed(WebElement w) {
	  		boolean selected = w.isDisplayed();
	  		return selected;
	  	} 	
//	  	-----------Alert-----------
	//-------AcceptAlert-----------
	  	public static void acceptAlert( ) {
	  		Alert a=driver.switchTo().alert();
	  		a.accept();
	  	}
	//--------dismissAlert------------
	  	public static void dismissAlert() {
	  		Alert a=driver.switchTo().alert();
	  		a.dismiss();
	  	}
	// ---------confirmAlert------------
		public static void confirmAlert(String alertType,String con) {
			if(alertType.equals("simpleAlert")) {
				Alert a=driver.switchTo().alert();
				a.accept();
			}
			else if(alertType.equals("confirmAlert")) {
				Alert a=driver.switchTo().alert();
				if(con.equals("accept")) {
					a.accept();
				}if(con.equals("dismiss")) {
					a.dismiss();
				}
			}
		}
	//--------promptAlert--------
			public static void promptAlert(String action,String value) {
				if(action.equals("accept")){
					Alert a=driver.switchTo().alert();
					a.sendKeys(value);
					a.accept();}
				if(action.equals("dismiss")){
					Alert a=driver.switchTo().alert();
					a.sendKeys(value);
					a.dismiss();
				}
			}
	//  -------DropDown---------
//	  	-------Select---------
		//-------select by index----------
			public static void selectByIndex(WebElement w,int index) {
				Select a=new Select(w);
				a.selectByIndex(index);
			}
		//------select by value----------
			public static void selectByValue(WebElement w,String value) {
				Select a=new Select(w);
				a.selectByValue(value);
			}
		//-------select by VisibleText
			public static void selectByVisibleText(WebElement w,String name) {
				Select a=new Select(w);
				a.selectByVisibleText(name);
			}	
		//------is Multiple-------
			public static boolean isMultiple(WebElement w) {
				Select s=new Select(w);
				boolean multiple = s.isMultiple();
				return multiple;
			}	
		// -----DeSelect ----------------
		//-----deSelect by index----------
			public static void UnselectByIndex(WebElement w,int index) {
				Select a=new Select(w);
				a.deselectByIndex(index);
			}
		//--------deSelectByValue----------
			public static void deSelectByValue(WebElement w,String value) {
				Select a=new Select(w);
				a.deselectByValue(value);
			}
		//------deSelectByVisibleText----------
			public static  void deSelectByVisibleText(WebElement w,String value) {
				Select a=new Select(w);
				a.deselectByVisibleText(value);
			}
		//------deselectAll---------
			public static void deSelectAll(WebElement w) {
				Select a=new Select(w);
				a.deselectAll();
			}
	  	
	  

}

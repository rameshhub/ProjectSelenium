package MavenDemoQaTest.DemoArtifact1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTest {
WebDriver d;
@BeforeMethod
public void TY()
{
	d=new FirefoxDriver();
	  d.get("http://www.gmail.com");
	  d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
  @Test(dataProvider="M2")
  public void M(String r,String y) {
	  
	  
    //throw new RuntimeException("Test not implemented");
	  
	  //First comment
	  //second comment
	  
	  //thired comment
	  
	  
	  
	  //super test
	  
	  
	  
	  
	  //four comment 
	  
	  d.findElement(By.id("Email")).sendKeys(r);
	  d.findElement(By.id("next")).click();
	  d.findElement(By.id("Passwd")).sendKeys(y);
	  String t=d.getTitle();
	  System.out.println("hello"+t);
    
  }
  /*
  @Test(dependsOnMethods={"M"})
  public void M1(){
	  d.findElement(By.id("lst-ib")).sendKeys("hii");
	  String t=d.getTitle();
	  System.out.println("hello"+t);
  }
  */
  @DataProvider
  public Object[][] M2()
  {
	  Object[][] u=new Object[2][2];
	  u[0][0]="workshare2013";
	  u[0][1]="second@123";
	  u[1][0]="testingbasics500";
	  u[1][1]="second@123";
	  return u;
  }
  @AfterMethod
  public void K()
  {
	  d.close();
  }
}

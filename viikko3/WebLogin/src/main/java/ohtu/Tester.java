package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Tester {

    public static void main(String[] args) {

        WebDriver driver = new HtmlUnitDriver();
        //WebDriver driver = new ChromeDriver();
        
        System.out.println("Sisaamkirjautuminen oikeilla tunnuksilla");
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());        
        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
        
        System.out.println("Sisaankirjautuminen epaonnistuu vaaralla salasanalla");
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());      

        sleep(2);
       
        element = driver.findElement(By.linkText("login"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("aepaa");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
        
        System.out.println("Luo uusi käyttäjätunnus");
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());      

        sleep(2);
       
        Random r = new Random();
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("outi"+r.nextInt(100000));;
        element = driver.findElement(By.name("password"));
        element.sendKeys("juupaseipas1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("juupaseipas1");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);        
        driver.quit();
        
        System.out.println("Luo uusi käyttäjätunnus ja kirjaudu sen jälkeen ulos");
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());      

        sleep(2);
       
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("otddti"+r.nextInt(100000));;
        element = driver.findElement(By.name("password"));
        element.sendKeys("eipasjoopas2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("eipasjoopas2");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);       
        
        driver.quit();           
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}

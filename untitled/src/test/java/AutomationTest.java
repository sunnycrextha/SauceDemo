import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import Util.Util;
public class AutomationTest {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url); //selenium script
        driver.manage().window().maximize();

        // login to Saucedemo via system variable
        String username = System.getenv("Sauce_Demo_username");
        String password = System.getenv("Sauce_Demo_Password");
        driver.findElement(By.id("user-name")).sendKeys(username);
//        Util.delay(2000);
        driver.findElement(By.name("password")).sendKeys(password);
//        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        //product page assertion
        WebElement actualvalue = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String act = actualvalue.getText();
        System.out.println(act);
        Assert.assertEquals("Sauce Labs Backpack", actualvalue.getText());

        //Add to cart
//        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
//        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
//        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();

        //remove one product
//        Util.delay(3000);
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();

        //Go to shopping cart
        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        //verify product from shopping cart
        WebElement shoppingCartValue = driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']"));
        String act1 = shoppingCartValue.getText();
        System.out.println(act1);
        Assert.assertEquals("Sauce Labs Bike Light", shoppingCartValue.getText());

        WebElement shoppingCartValue1 = driver.findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']"));
        String act2 = shoppingCartValue1.getText();
        System.out.println(act2);
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", shoppingCartValue1.getText());

        //Remove any one product
        Util.delay(3000);
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();

        //checkout
        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //input details in checkout
//        Util.delay(1000);
        driver.findElement(By.id("first-name")).sendKeys("Sunny");
//        Util.delay(1000);
        driver.findElement(By.id("last-name")).sendKeys("Shrestha");
//        Util.delay(1000);
        driver.findElement(By.id("postal-code")).sendKeys("44100");
//        Util.delay(1000);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

        //Finish the process
//        Util.delay(1000);
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();

        //verify order is successful
        WebElement VerifyCheckout = driver.findElement(By.xpath("//*[text()='Thank you for your order!']"));
        String Verifychk = VerifyCheckout.getText();
        System.out.println(Verifychk);
        Assert.assertEquals("Thank you for your order!", VerifyCheckout.getText());



        //Back to home
        Util.delay(3000);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        //logout
        Util.delay(1000);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Util.delay(2000);
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

        Util.delay(2000);
        driver.close();
    }
}

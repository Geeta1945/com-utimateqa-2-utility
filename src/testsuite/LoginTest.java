package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility_package.Utility_Class;

public class LoginTest extends Utility_Class {

    @Before
    public void loadUrl() {

        openBrowser();
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully(){

        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));
        Assert.assertEquals("Welcome Back!",getTextFromElement(By.xpath("//h1[normalize-space()='Welcome Back!']")));
        sendTextToElement(By.name("user[email]"),"geeta1945p@gmail.com");
        sendTextToElement(By.xpath("//input[@name='user[password]']"),"secret_sauce");
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        // first we find webelement with xpath in above line and then we used clicked method
         Assert.assertEquals("Invalid email or password.",getTextFromElement(By.xpath("//li[@class='form-error__list-item']")));


    }

    @After

    public void closeUrl(){

        quitAllUrl();
    }

}

package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Parabank Login")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    @Test(description = "Geçersiz bilgilerle login başarısız olmalı")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanıcı adı ve şifre yanlış girildiğinde sistem uyarı vermeli")
    public void loginWithInvalidCredentials() {
        waitForElement(By.name("username")).sendKeys("wronguser");
        waitForElement(By.name("password")).sendKeys("wrongpass");
        waitForElement(By.xpath("//input[@value='Log In']")).click();

        String errorMessage = waitForElement(By.cssSelector(".error")).getText();
        Assert.assertEquals(errorMessage, "The username and password could not be verified.", "Hata mesajı eşleşmiyor!");
    }

    @Test(description = "Boş bilgilerle login denemesi")
    @Severity(SeverityLevel.MINOR)
    @Description("Boş alanlarla login denemesi yapıldığında sistem uyarı vermeli")
    public void loginWithEmptyFields() {
        waitForElement(By.name("username")).clear();
        waitForElement(By.name("password")).clear();
        waitForElement(By.xpath("//input[@value='Log In']")).click();

        String warning = waitForElement(By.cssSelector(".error")).getText();
        Assert.assertEquals(warning, "Please enter a username and password.", "Uyarı mesajı beklenildiği gibi değil!");
    }

    @Test(description = "Geçerli bilgilerle login başarılı olmalı")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Doğru bilgilerle login olduktan sonra anasayfaya yönlendirme doğrulanır")
    public void loginWithValidCredentials() {
        waitForElement(By.name("username")).sendKeys("john");
        waitForElement(By.name("password")).sendKeys("demo");
        waitForElement(By.xpath("//input[@value='Log In']")).click();

        boolean loggedIn = driver.findElements(By.linkText("Log Out")).size() > 0;
        Assert.assertTrue(loggedIn, "Login sonrası yönlendirme başarısız!");
    }
}

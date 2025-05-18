package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {

    @Test
    public void successfulUserRegistration() {
        String uniqueUsername = "test" + System.currentTimeMillis();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigateToRegisterPage();
        registerPage.fillForm(uniqueUsername, "123456");
        registerPage.clickRegister();

        String welcome = registerPage.getWelcomeMessage();
        Assert.assertTrue(welcome.contains("Welcome"), "Kayıt sonrası hoş geldiniz mesajı görünmüyor!");
    }

    @Test
    public void registrationWithMissingFields() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigateToRegisterPage();
        registerPage.fillForm("", "");
        registerPage.clickRegister();

        String error = registerPage.getErrorMessage();
        Assert.assertEquals(error, "Please enter a username and password.", "Hata mesajı eşleşmiyor!");
    }
}

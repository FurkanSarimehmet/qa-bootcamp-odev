package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By firstNameField = By.id("customer.firstName");
    private By lastNameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipCodeField = By.id("customer.address.zipCode");
    private By phoneField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");
    private By welcomeMessage = By.cssSelector(".title");

    // ============ FILL METHODS ============

    public void fillFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(name);
    }

    public void fillLastName(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(surname);
    }

    public void fillAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(address);
    }

    public void fillCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
    }

    public void fillState(String state) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateField)).sendKeys(state);
    }

    public void fillZipCode(String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zip);
    }

    public void fillPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void fillSSN(String ssn) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ssnField)).sendKeys(ssn);
    }

    public void fillUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    public void fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void fillRepeatedPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(password);
    }

    // ============ ACTIONS ============

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public String getWelcomeMessage() {
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
            return message.getText();
        } catch (Exception e) {
            return "";
        }
    }
}

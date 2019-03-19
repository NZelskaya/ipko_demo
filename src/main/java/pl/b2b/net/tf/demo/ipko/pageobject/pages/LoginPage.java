package pl.b2b.net.tf.demo.ipko.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".r-login-box input")
    protected WebElement loginTextField;

    @FindBy(css = ".r-login-box input[type='password']")
    protected WebElement passwordTextField;

    @FindBy(css = ".r-login-box .ui-button-text")
    protected WebElement nextBtn;

    protected WebElement loginBtn() {
        return driver.findElements(By.cssSelector(".r-login-box .ui-button-text"))
                .stream()
                .filter(e -> e.getText().equals("Zaloguj"))
                .findFirst().get();
    }
}

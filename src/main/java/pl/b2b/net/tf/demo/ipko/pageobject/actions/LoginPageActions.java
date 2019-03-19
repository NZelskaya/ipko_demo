package pl.b2b.net.tf.demo.ipko.pageobject.actions;

import org.openqa.selenium.WebDriver;
import pl.b2b.net.tf.demo.ipko.pageobject.pages.LoginPage;


import static pl.b2b.net.tf.demo.GlobalDefinitions.IPKO_URL;

public class LoginPageActions extends LoginPage {
    public LoginPageActions(WebDriver driver) {
        super(driver);
    }

    private static final String FUll_URL = IPKO_URL + "/login.html";

    public LoginPageActions loginToAccount(String pid, String password) {
        navigateToUrl(FUll_URL);

        waitForPageLoadComplete(FUll_URL);

        type(loginTextField, pid);
        click(nextBtn);
        waitForAjax();

        type(passwordTextField, password);
        waitForAjax();
        click(nextBtn);

        waitForPageLoadComplete();

        return this;
    }
}

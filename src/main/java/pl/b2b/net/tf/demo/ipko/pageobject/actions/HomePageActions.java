package pl.b2b.net.tf.demo.ipko.pageobject.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pl.b2b.net.tf.demo.ipko.pageobject.pages.HomePage;

import static pl.b2b.net.tf.demo.GlobalDefinitions.IPKO_URL;


public class HomePageActions extends HomePage {
    public HomePageActions(WebDriver driver) {
        super(driver);
    }

    private static final String FULL_URL = IPKO_URL + "/index.html#home";

    public void openTransfers() {
        waitForPageLoadComplete(FULL_URL);
        waitForElementToBeVisible(lastOperationsTable);

        click(transactionsLink);

        waitForElementToBeVisible(transfersLink);
        click(transfersLink);
    }
}

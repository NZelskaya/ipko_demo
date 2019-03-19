package pl.b2b.net.tf.demo.ipko.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".r-data table")
    protected WebElement lastOperationsTable;

    @FindBy(css = "a[href='#transactions']")
    protected WebElement transactionsLink;

    @FindBy(css = ".x-transfers a[href='#transactions/transfers']")
    protected WebElement transfersLink;
}

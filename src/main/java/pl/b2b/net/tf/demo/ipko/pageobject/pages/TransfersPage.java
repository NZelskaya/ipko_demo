package pl.b2b.net.tf.demo.ipko.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransfersPage extends AbstractPageObject {
    private static final String NA_RACHUNEK = "Na rachunek";
    private static final String Z = "Z";

    public TransfersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'f-title')]")
    protected WebElement titleTextFiled;

    @FindBy(xpath = "//*[contains(@class,'f-amount')]")
    protected WebElement amountInput;

    @FindBy(xpath = "//*[contains(@class,'f-recipient-address')]")
    protected WebElement adressInput;

    @FindBy(xpath = "//*[contains(@class,'f-recipient-name')]")
    protected WebElement recipientNameInput;

    @FindBy(xpath = "//*[contains(@class,'f-account-to')]")
    protected WebElement toAccountInput;

    @FindBy(xpath = "//*[contains(@class,'f-currency')]/..//div/b")
    protected WebElement currencyIconDropDown;

    protected WebElement currencyValue(String currency) {
        return driver.findElements(By.xpath("//span[contains(@class,'size-currency-short')]//*[@class='jspPane']//li"))
                .stream()
                .filter(e -> e.getText().equals(currency))
                .findFirst().get();
    }

    protected WebElement dalejBtn() {
        return nextBtn("Dalej");
    }

    protected WebElement wykonajBtn() {
        return nextBtn("Wykonaj");
    }

    @FindBy(css = ".columns h4")
    protected WebElement transactionResultMessage;

    protected WebElement transactionResultToAccountValue() {
        return getParentElement(
                driver.findElements(By.cssSelector(".columns label"))
                        .stream()
                        .filter(e -> e.getText().contains(NA_RACHUNEK))
                        .findFirst().get())
                .findElement(By.cssSelector("span"));
    }

    private WebElement nextBtn(String text) {
        return driver.findElements(By.cssSelector(".ui-dialog-button-right"))
                .stream()
                .filter(e -> e.getText().equals(text))
                .findFirst().get().findElement(By.cssSelector("span"));
    }

    protected WebElement transferTab(String transferName) {
        return driver.findElements(By.cssSelector("ul[role='tablist'] a"))
                .stream()
                .filter(e -> e.getText().replace("\n", " ").contains(transferName))
                .findFirst().get();
    }

    protected WebElement fromAccountDropDown(String accountPart) {
        return accountDropDown(Z, accountPart);
    }

    protected WebElement toAccountDropDown(String accountPart) {
        return accountDropDown(NA_RACHUNEK, accountPart);
    }

    private WebElement accountDropDown(String dropDownName, String accountPart) {
        return getParentElement(getAccountDropDownLabel(dropDownName)).findElements(By.cssSelector(".jspPane li"))
                .stream()
                .filter(e -> e.getText().contains(accountPart))
                .findFirst().get();
    }

    protected WebElement fromAccountIconDropDown() {
        return accountIconDropDown(Z);
    }

    protected WebElement toAccountIconDropDown() {
        return accountIconDropDown(NA_RACHUNEK);
    }

    private WebElement accountIconDropDown(String dropDownName) {
        return getParentElement(getAccountDropDownLabel(dropDownName)).findElement(By.cssSelector("div b"));
    }

    private WebElement getAccountDropDownLabel(String dropDownName) {
        return driver.findElements(By.cssSelector("ul.form-set li>label"))
                .stream()
                .filter(e -> e.getText().equals(dropDownName))
                .findFirst().get();
    }
}

package pl.b2b.net.tf.demo.ipko.pageobject.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pl.b2b.net.tf.demo.ipko.pageobject.TransfersEnum;
import pl.b2b.net.tf.demo.ipko.pageobject.pages.TransfersPage;

import static pl.b2b.net.tf.demo.GlobalDefinitions.IPKO_URL;
import static pl.b2b.net.tf.demo.ipko.pageobject.TransfersEnum.*;

public class TransfersPageActions extends TransfersPage {
    public TransfersPageActions(WebDriver driver) {
        super(driver);
    }

    private static final String FULL_ENDPOINT = IPKO_URL + "/index.html#transactions/transfers";

    public void makeTransfer(String transfer, String title, String fromAccount, String toAccount) {
        waitForAjax();
        waitForPageLoadComplete(FULL_ENDPOINT);

        switch (TransfersEnum.valueOf(transfer)) {
            case ONE_TIME:
                makeOneTimeTransfer(title, fromAccount);
                break;
            case OWN_ACCOUNT:
                makeOwnAccountTransfer(title, fromAccount, toAccount);
                break;
            case ZUS:
                makeZUSTransfer(fromAccount);
                break;
            case TAX:
                makeTaxTransfer(fromAccount);
                break;
            case FROM_CARD:
                makeFromCardTransfer(title);
                break;
            case CARD_PAYMENT:
                makeCardPaymentTransfer(fromAccount);
                break;
            case FOREIGN:
                makeForeignTransfer(fromAccount);
                break;
            default:
                System.out.println("No enum found for transaction type " + transfer);
                break;
        }
    }

    public void verifyToAccountValueResult(String expectedToValue) {
        waitForAjax();
        String text = transactionResultToAccountValue().getText();
        Assert.assertTrue(text.contains(expectedToValue), String.format("Expected message %s to contain %s", text, expectedToValue));
    }

    private void makeOneTimeTransfer(String title, String fromAccount) {
        click(transferTab(ONE_TIME.getFullName()));
        waitForAjax();

        type(titleTextFiled, title);

        click(fromAccountIconDropDown());
        click(fromAccountDropDown(fromAccount));
        waitForAjax();

        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }

    private void makeOwnAccountTransfer(String title, String fromAccount, String toAccount) {
        click(transferTab(OWN_ACCOUNT.getFullName()));

        waitForElementToBeVisible(fromAccountIconDropDown());
        waitForAjax();

        click(fromAccountIconDropDown());
        click(fromAccountDropDown(fromAccount));
        waitForAjax();

        click(toAccountIconDropDown());
        click(toAccountDropDown(toAccount));

        type(titleTextFiled, title);
        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }

    private void makeZUSTransfer(String fromAccount) {
        click(transferTab(ZUS.getFullName()));

        waitForAjax();
        click(fromAccountIconDropDown());
        click(fromAccountDropDown(fromAccount));

        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }

    private void makeTaxTransfer(String fromAccount) {
        click(transferTab(TAX.getFullName()));

        waitForAjax();
        click(fromAccountIconDropDown());
        click(fromAccountDropDown(fromAccount));
        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }

    private void makeFromCardTransfer(String title) {
        click(transferTab(FROM_CARD.getFullName()));

        waitForElementToBeVisible(fromAccountIconDropDown());
        waitForAjax();

        type(titleTextFiled, title);
        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }

    private void makeCardPaymentTransfer(String fromAccount) {
        click(transferTab(CARD_PAYMENT.getFullName()));

        waitForAjax();
        click(fromAccountIconDropDown());
        click(fromAccountDropDown(fromAccount));
        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }

    private void makeForeignTransfer(String fromAccount) {
        click(transferTab(FOREIGN.getFullName()));

        waitForAjax();
        click(fromAccountIconDropDown());
        click(fromAccountDropDown(fromAccount));
        click(dalejBtn());

        waitForAjax();
        click(dalejBtn());

        waitForAjax();
        click(dalejBtn());

        waitForAjax();
        click(wykonajBtn());

        waitForAjax();
        Assert.assertEquals(transactionResultMessage.getText(), "Przelew został zarejestrowany", "Something went wrong with transaction");
    }
}

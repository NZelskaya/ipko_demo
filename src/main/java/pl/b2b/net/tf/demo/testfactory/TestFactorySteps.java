package pl.b2b.net.tf.demo.testfactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pl.b2b.net.tf.demo.driver.DriverSetup;
import pl.b2b.net.tf.demo.ipko.pageobject.actions.HomePageActions;
import pl.b2b.net.tf.demo.ipko.pageobject.actions.LoginPageActions;
import pl.b2b.net.tf.demo.ipko.pageobject.actions.TransfersPageActions;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class TestFactorySteps extends BaseTF {
    private HomePageActions homePage;
    private LoginPageActions loginPage;
    private TransfersPageActions transferPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverSetup.getDriver();
        loginPage = new LoginPageActions(driver);
        homePage = new HomePageActions(driver);
        transferPage = new TransfersPageActions(driver);
    }

    @Test
    @TestFactoryMethod(value = "Logowanie", description = "Logowanie na konto", group = "Logowanie")
    @Parameters({"pid", "haslo"})
    public void login(String pid, String haslo) {
        loginPage.loginToAccount(pid, haslo);
    }

    @Test
    @TestFactoryMethod(value = "Transakcje -> Przelewy", description = "Otwórzyc formularz Przelewy", group = "Strona glówna")
    public void openTransfers() {
        homePage.openTransfers();
    }

    @Test
    @TestFactoryMethod(value = "Wykonaj przelew", description = "ONE_TIME,OWN_ACCOUNT,ZUS,TAX,FROM_CARD,CARD_PAYMENT,FOREIGN", group = "Przelewy")
    @Parameters({"typPrzelewu", "zKonta", "naKonto", "kwota", "tytul", "adres"})
    public void makeTransfer(String typPrzelewu, String zKonta, String naKonto, String kwota, String tytul, String adres) {
        transferPage.makeTransfer(typPrzelewu, tytul, zKonta, naKonto);
    }

    @Test
    @TestFactoryMethod(value = "Sprawdz na jaki rachunek transakcja była zrealizowana", description = "Podaj numer rachunku", group = "Przelewy")
    @Parameters({"numerKonta"})
    public void verifyTransfer(String numerKonta) {
        transferPage.verifyToAccountValueResult(numerKonta);
    }
}

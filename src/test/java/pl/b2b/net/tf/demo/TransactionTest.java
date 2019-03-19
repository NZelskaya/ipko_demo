package pl.b2b.net.tf.demo;

import org.testng.annotations.Test;
import pl.b2b.net.tf.demo.ipko.testfactory.*;

public class TransactionTest {
    @Test
    public void transactionTest1() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("ONE_TIME", "PKO", null, null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("37 1020 5561 0000 0000 0000 0000");

        BaseTF.tearDown();
    }

    @Test
    public void transactionTest2() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("OWN_ACCOUNT", "BIZNES", "PKO", null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("98 1020 0003 0000 0000 0000 0000");

        BaseTF.tearDown();
    }

    @Test
    public void transactionTest3() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("ZUS", "BIZNES", null, null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("83 1010 1023 0000 2613 9510 0000");

        BaseTF.tearDown();
    }

    @Test
    public void transactionTest4() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("TAX", "PKO", null, null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("84 1010 1010 0164 3422 2300 0000");

        BaseTF.tearDown();
    }

    @Test
    public void transactionTest5() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("FROM_CARD", null, null, null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("56 1160 2202 0000 0000 0000 0000");

        BaseTF.tearDown();
    }

    @Test
    public void transactionTest6() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("CARD_PAYMENT", "SUPER", null, null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("56 1160 2202 0000 0000 0000 0000");

        BaseTF.tearDown();
    }

    @Test
    public void transactionTest7() throws Exception {
        BaseTF.setUp("FF");
        TestFactorySteps testFactorySteps = new TestFactorySteps();
        testFactorySteps.setUp();
        testFactorySteps.login("12345678", "12345678");
        testFactorySteps.setUp();
        testFactorySteps.openTransfers();
        testFactorySteps.setUp();
        testFactorySteps.makeTransfer("FOREIGN", "RACHUNEK", null, null, "test", null);
        testFactorySteps.setUp();
        testFactorySteps.verifyTransfer("GB24MIDL00000000000000");

        BaseTF.tearDown();
    }
}

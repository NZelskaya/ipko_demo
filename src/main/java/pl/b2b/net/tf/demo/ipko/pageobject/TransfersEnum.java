package pl.b2b.net.tf.demo.ipko.pageobject;

public enum TransfersEnum {
    ONE_TIME("Krajowy"),
    OWN_ACCOUNT("Na rachunek własny"),
    ZUS("Do ZUS"),
    TAX("Podatkowy"),
    FROM_CARD("Z karty"),
    CARD_PAYMENT("Spłata karty"),
    FOREIGN("Zagraniczny");

    private String fullName;

    TransfersEnum(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}

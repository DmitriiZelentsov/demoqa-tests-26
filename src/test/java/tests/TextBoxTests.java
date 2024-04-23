package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Dmitrii")
                .setUserEmail("test@test.ru")
                .setCurrentAddress("Samara")
                .setPermanentAddress("Address, 1/2")
                .pressSubmit();

        textBoxPage.checkResult("#name","Dmitrii")
                .checkResult("#email","test@test.ru")
                .checkResult("#currentAddress","Samara")
                .checkResult("#permanentAddress","Address, 1/2");
    }
}

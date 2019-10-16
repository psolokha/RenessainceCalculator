package ru.aplana.renessains.steps;

import io.qameta.allure.Step;
import ru.aplana.renessains.pages.DepositPage;
import ru.aplana.renessains.pages.IndexPage;

public class AllureSteps {

    @Step("Открываем сайт: https://rencredit.ru")
    public void openIndexPage() {
        IndexPage index = new IndexPage();
    }

    @Step("Перейти в меню – {menu}")
    public void gotoMenu(String menu) {
        IndexPage index = new IndexPage();
        index.openSection(menu);
    }

    @Step("Выбрать – {currency}")
    public void chooseCurrency(String currency) {
        DepositPage deposit = new DepositPage();
        deposit.chooseCurrency(currency);
    }

//    @Step("Сумма вклада – {sum}")
//    public void dipositAmount(String sum) {
//
//    }
}

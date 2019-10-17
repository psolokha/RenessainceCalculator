package ru.aplana.renessains.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import ru.aplana.renessains.pages.DepositPage;
import ru.aplana.renessains.pages.IndexPage;
import ru.aplana.renessains.utils.InitDriver;

class AllureSteps{

    @Step("Открываем сайт - {url}")
    void openIndexPage(String url) {
        InitDriver.getDriver().get(url);
    }

    @Step("Перейти в меню – {menu}")
    void gotoMenu(String menu) {
        IndexPage index = new IndexPage();
        index.openSection(menu);
    }

    @Step("Выбрать – {currency}")
    void chooseCurrency(String currency) {
        DepositPage deposit = new DepositPage();
        deposit.chooseCurrency(currency);
    }

    @Step("Сумма вклада – {sum}")
    void depositAmount(String sum) {
        DepositPage deposit = new DepositPage();
        deposit.setDeposit(Integer.parseInt(sum.replaceAll("(\\D)", "")));
    }

    @Step("Срок на {months} месяцев")
    void setTime(String months) {
        DepositPage deposit = new DepositPage();
        deposit.setTerm(months);
    }

    @Step("Ежемесячное пополнение – {sum}")
    void monthPayment(String sum) {
        DepositPage deposit = new DepositPage();
        deposit.setMonthPayment(Integer.parseInt(sum.replaceAll("(\\D)", "")));
    }

    @Step("Нажать – Ежемесячная капитализация")
    void capitalize() {
        DepositPage deposit = new DepositPage();
        deposit.clickCapital();
    }

    @Step("Проверить рассчеты")
    void confirmResults(String results) {
        DepositPage deposit = new DepositPage();
        new Actions(InitDriver.getDriver()).pause(1500).build().perform();
        Assert.assertTrue(results.contains(deposit.getRate()));
        Assert.assertTrue(results.contains(deposit.getWithdrawal()));
        Assert.assertTrue(results.contains(deposit.getInvestment()));
        Assert.assertTrue(results.contains(deposit.getAccured()));
    }

    @Step("Нажать – частичное снятие")
    void tickPartWithdrowal() {
        DepositPage deposit = new DepositPage();
        deposit.tickPartWithdrowalCheckbox();
    }
}

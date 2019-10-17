package ru.aplana.renessains.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import ru.aplana.renessains.utils.InitDriver;

public class CucumberSteps {


    private AllureSteps allure = new AllureSteps();

    @Дано("Перейти по ссылке - (.*)")
    public void openSite(String url){
        allure.openIndexPage(url);
    }

    @Дано("Перейти в меню – (.*)")
    public void gotoMenu(String menu) {
        allure.gotoMenu(menu);
    }

    @Дано("Выбрать – (.*)")
    public void chooseCurrency(String currency) {
        allure.chooseCurrency(currency);
    }

    @Дано("Сумма вклада – (.*)")
    public void depositAmount(String sum) {
        allure.depositAmount(sum);
    }

    @Дано("Срок – (.*) месяцев")
    public void setTime(String months) {
        allure.setTime(months);
    }

    @Дано("Ежемесячное пополнение – (.*)")
    public void monthPayment(String sum) {
        allure.monthPayment(sum);
    }

    @Дано("Отметить – Ежемесячная капитализация")
    public void tickCapital() {
        allure.capitalize();
    }

    @Дано("Отметить – частичное снятие")
    public void tickPartWithdrawal(){
        allure.tickPartWithdrowal();
    }

    @Дано("Проверить расчеты по вкладу:")
    public void confirmResults(String results) {
        allure.confirmResults(results);
    }

}

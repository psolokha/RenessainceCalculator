package ru.aplana.renessains.steps;

import cucumber.api.java.ru.Дано;

public class CucumberSteps {



    AllureSteps allure = new AllureSteps();

    @Дано("Перейти по ссылке - https://rencredit.ru")
    public void openSite(){
        allure.openIndexPage();
    }

    @Дано("Перейти в меню – (.*)")
    public void gotoMenu(String menu) {
        allure.gotoMenu(menu);
    }

    @Дано("Выбрать – (.*)")
    public void chooseCurrency(String currency) {
        allure.chooseCurrency(currency);
    }

//    @Дано("Сумма вклада – (.*)")
//    public void depositAmount(String sum) {
//        allure.dipositAmount(sum);
//    }

}

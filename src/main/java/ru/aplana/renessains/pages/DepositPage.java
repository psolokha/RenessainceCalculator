package ru.aplana.renessains.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DepositPage extends IndexPage {

    @FindBy(xpath = "//input[@name = 'replenish']")
    private WebElement inputMonthPayment;

    @FindBy(xpath = "//span[text() = 'Ежемесячная капитализация']")
    private WebElement everyMonthCheckbox;

    @FindBy(xpath = "//span[text() = 'Частичное снятие']")
    private WebElement PartWithdrowalCheckbox;

    @FindBy(xpath = "//select")
    private WebElement selectTerm;

    @FindBy(xpath = "//input[@name = 'amount']")
    private WebElement inputAmount;

    @FindBy(xpath = "//div[@class = 'calculator__currency-content']//input")
    private List<WebElement> currencyList;

    @FindBy(xpath = "//span[@class = 'js-calc-rate']")
    private WebElement checkRate;

    @FindBy(xpath = "//span[@class = 'js-calc-earned']")
    private WebElement checkWithdrawal;

    @FindBy(xpath = "//span[@class = 'js-calc-replenish']")
    private WebElement checkInvestment;

    @FindBy(xpath = "//span[@class = 'js-calc-result']")
    private WebElement checkAccured;



    public void chooseCurrency(String currency) {
        for (WebElement element: currencyList) {
            if (currency.equalsIgnoreCase(element.findElement(By.xpath("./following::span[contains(@class, 'currency-field-text')]")).getText())){
                waitElementandClick(element.findElement(By.xpath("./following::span[contains(@class, 'currency-field-text')]")));
                return;
            }
        }
        Assert.fail("No such currency.");
    }

    public void setDeposit(int sum) {
        waitElementandClick(inputAmount);
        inputAmount.sendKeys(String.valueOf(sum));
    }

    public void setTerm(String months) {
        new Select(selectTerm).selectByVisibleText(months + " месяцев");
    }

    public void setMonthPayment(int sum) {
        waitElementandClick(inputMonthPayment);
        inputMonthPayment.clear();
        inputMonthPayment.sendKeys(String.valueOf(sum));
    }

    public void clickCapital() {
        waitElementandClick(everyMonthCheckbox);
    }

    public String getRate() {
        return checkRate.getText();
    }


    public String getWithdrawal() {
        return checkWithdrawal.getText();
    }

    public String getInvestment() {
        return checkInvestment.getText();
    }

    public String getAccured() {
        return checkAccured.getText();
    }

    public void tickPartWithdrowalCheckbox() {
        waitElementandClick(PartWithdrowalCheckbox);
    }
}

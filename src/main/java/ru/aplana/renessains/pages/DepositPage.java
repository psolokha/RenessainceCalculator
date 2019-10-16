package ru.aplana.renessains.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends IndexPage {

    @FindBy(xpath = "//div[@class = 'calculator__currency-content']//input")
    List<WebElement> currencyList;

    public void chooseCurrency(String currency) {
        for (WebElement element: currencyList) {
            if (currency.equalsIgnoreCase(element.findElement(By.xpath("./following::span[contains(@class, 'currency-field-text')]")).getText())){
                waitElementandClick(element.findElement(By.xpath("./following::span[contains(@class, 'currency-field-text')]")));
                return;
            }
        }
        Assert.fail("No such currency.");
    }



}

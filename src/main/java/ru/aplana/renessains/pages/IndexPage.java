package ru.aplana.renessains.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.renessains.utils.InitDriver;

import java.util.List;

public class IndexPage {

    WebDriver driver;

    public IndexPage() {
        driver = InitDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'services services_main')]//div[@class='service__title-text']")
    List<WebElement> listElements;

    public void waitElementandClick(WebElement element) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void openSection(String name) {

        for (WebElement element: listElements) {
            if (name.equalsIgnoreCase(element.getText())) {
                waitElementandClick(element.findElement(By.xpath("./preceding-sibling::a")));
                return;
            }
        }
        Assert.fail("No such menu element.");
    }

}

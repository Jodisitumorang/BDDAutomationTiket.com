package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventPage {
    public static WebDriver webDriver;

    public EventPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    //Homepage
    @FindBy(xpath = "//img[@alt='Tiket.com logo']")
    private WebElement tiketLogo;
    @FindBy(xpath = "//h2[@class='index_greeting__DDvGj Text_text__qgZxv Text_size_h2__Lvan9']")
    private WebElement haiKamu;
    @FindBy(xpath = "//div[@class='SearchBox_input_box__7os4R SearchBox_size_md__0ZVYR']")
    private WebElement homeSearch;
    @FindBy(xpath = "//img[@alt='Tiket Events']")
    private WebElement eventButton;

    //EventPage
    @FindBy(xpath = "//div[@class='ChipsCarousel_container__YZPjt']")
    private WebElement categoryCarousel;
    @FindBy(xpath = "//div[@class='search_upper_list__Xrs4q']")
    private WebElement filterList;

    @FindBy(xpath = "//span[.='Seminar']")
    private WebElement seminarBtn;
    @FindBy(xpath = "//span[.='Konser']")
    private WebElement konserBtn;
    @FindBy(xpath = "//span[.='Horor']")
    private WebElement hororBtn;
    @FindBy(xpath = "//span[.='Komedi']")
    private WebElement komediBtn;
    @FindBy(xpath = "//span[.='Olahraga']")
    private WebElement olahragaBtn;
    @FindBy(xpath = "//span[.='Pameran']")
    private WebElement pameranBtn;

    public boolean verifyHome() {
        boolean a = tiketLogo.isDisplayed();
        boolean b = haiKamu.isDisplayed();
        boolean c = homeSearch.isDisplayed();
        return a && b && c;
    }

    public void clickEventButton() {
        eventButton.click();
    }

    public boolean verifyEventPage() {
        boolean a = categoryCarousel.isDisplayed();
        boolean b = filterList.isDisplayed();
        return a && b;
    }

    public void clickFilterButton(String filter) {
        WebElement elementToClick = null;
        switch (filter.toLowerCase()) {
            case "seminar":
                elementToClick = seminarBtn;
                break;
            case "konser":
                elementToClick = konserBtn;
                break;
            case "horor":
                elementToClick = hororBtn;
                break;
            case "komedi":
                elementToClick = komediBtn;
                break;
            case "olahraga":
                elementToClick = olahragaBtn;
                break;
            case "pameran":
                elementToClick = pameranBtn;
                break;
            default:
                System.out.println("Invalid button: + " + filter);
        }
        if ((elementToClick != null)) {
            elementToClick.click();
        }
    }

    public String getTicketResult(String ticket) {
        String xpath = "//div/main/div/div[3]/div[4]/div/a/div[3]/div[2]/h2[contains(text(), '" + ticket + "')]";
        try {
            WebElement ticketResult = webDriver.findElement(By.xpath(xpath));
            return ticketResult.getText();
        } catch (NoSuchElementException e) {
            // Element not found, return empty string
            return "";
        }
    }

}

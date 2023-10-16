package se.cagcontactor.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Locale;

public class ConnectPage {
    Page page;
    Browser browser;
    BrowserContext browserContext;
    static String url = "https://careers.contactor.cag.se/connect";

    // Locators
    Locator fieldOfInterestSpan;

    public ConnectPage(Browser browser) {
        this.browser = browser;
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);
    }

    public void selectFieldOfInterest(String filedOfInterest) {
        fieldOfInterestSpan = page.getByText(filedOfInterest);
        fieldOfInterestSpan.focus();
        fieldOfInterestSpan.click();

        String dummy = "lalala";
    }
}

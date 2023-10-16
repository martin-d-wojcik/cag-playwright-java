package se.cagcontactor.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Locale;

public class ConnectPage {
    Page page;
    Browser browser;
    BrowserContext browserContext;
    static String url = "https://careers.contactor.cag.se/connect";

    // Locators
    Locator fieldOfInterestSpan;
    Locator fortsattBtn;

    public ConnectPage(Browser browser) {
        this.browser = browser;
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);

        fortsattBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fortsätt"));
    }

    public void selectFieldOfInterest(String fieldOfInterest) {
        fieldOfInterestSpan = page.locator("span").filter(new Locator.FilterOptions().setHasText(fieldOfInterest));
        fieldOfInterestSpan.focus();
        fieldOfInterestSpan.click();
    }

    public void clickFortsattButton() {
        fortsattBtn.click();
    }

    public void enterEmail(String email) {
        page.getByRole(AriaRole.TEXTBOX).fill(email);

        String dummy = "tadaaa";
    }
}

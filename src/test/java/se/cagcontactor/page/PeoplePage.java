package se.cagcontactor.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PeoplePage {

    Page page;
    Browser browser;
    BrowserContext browserContext;
    static String url = "https://careers.contactor.cag.se/people";

    // Locators
    Locator coworker;

    public PeoplePage(Browser browser) {
        this.browser = browser;
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);
    }

    public void clickOneCoworker(String corkerName) {
        coworker = page.getByText(corkerName);
        coworker.focus();
        coworker.click();
    }

    public void jagRekryterarVisible() {
        assertThat(page.getByText("Jag rekryterar")).isVisible();
    }
}

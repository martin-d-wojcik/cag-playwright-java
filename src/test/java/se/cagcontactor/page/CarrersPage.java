package se.cagcontactor.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CarrersPage {

    Page page;
    Browser browser;
    BrowserContext browserContext;
    static String url = "https://careers.contactor.cag.se/";

    // Locators
    Locator ledigaJobbBtn;
    Locator availableJobsSpan;
    Locator coworkersLink;

    public CarrersPage(Browser browser) {
        this.browser = browser;
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);

        // Instantiate locators
        ledigaJobbBtn = page.getByText("Lediga jobb");
        availableJobsSpan = page.getByText("Just nu söker vi");
        coworkersLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Medarbetare"));
    }

    public void clíckLedigaJobb() {
        ledigaJobbBtn.focus();
        ledigaJobbBtn.click();
        assertThat(availableJobsSpan).isVisible();
    }

    public void clickMedarbetare() {
        coworkersLink.focus();
        coworkersLink.click();
    }
}

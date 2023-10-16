package se.cagcontactor.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CareerPage {

    Page page;
    Browser browser;
    BrowserContext browserContext;
    static String url = "https://careers.contactor.cag.se/";

    // Locators
    Locator ledigaJobbBtn;
    Locator availableJobsSpan;
    Locator careerMenuBtn;
    Locator coworkerLink;
    Locator connectLink;

    public CareerPage(Browser browser) {
        this.browser = browser;
        browserContext = browser.newContext(new Browser.NewContextOptions().
                setViewportSize(1920, 1080));
        page = browserContext.newPage();
        page.navigate(url);

        // Instantiate locators
        ledigaJobbBtn = page.getByText("Lediga jobb");
        availableJobsSpan = page.getByText("Just nu söker vi");
        careerMenuBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Karriärmeny"));
        connectLink = page.locator("#section-25084344").
                getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Connect"));
    }

    public void clíckLedigaJobb() {
        ledigaJobbBtn.focus();
        ledigaJobbBtn.click();
        assertThat(availableJobsSpan).isVisible();
    }

    public void clickMedarbetareInCareerMenu() {
        // Expand Karriärmeny
        careerMenuBtn.click();

        // Click Medarbetare
        coworkerLink = page.getByRole(AriaRole.NAVIGATION).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Medarbetare"));
        coworkerLink.focus();
        coworkerLink.click();
    }

    public void clickConnect() {
        connectLink.focus();
        connectLink.click();
    }
}

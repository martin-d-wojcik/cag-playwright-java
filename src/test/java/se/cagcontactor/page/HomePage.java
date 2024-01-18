package se.cagcontactor.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.Assert;
import se.cagcontactor.util.BrowserHelper;

import java.util.List;

public class HomePage {

    Page page;
    Browser browser;
    BrowserContext browserContext;
    static String url = "https://www.cag.se/om-oss/vara-bolag/cag-contactor/";

    // Locators
    Locator adress;
    Locator jobbaHar;

    public HomePage(Browser browser) {
        page = BrowserHelper.setUpBrowserContext(browser);
        page.navigate(url);

        // Instantiate locators
        adress = page.getByText("Adress:");
        jobbaHar = page.getByText("Jobba här");
    }

    public void assertAdress() {
        Assert.assertTrue(adress.isVisible());
    }

    public void clickJobbaHar(String expectedPageTitle) {
        // Go to new tab once the Jobba här button is clicked
        Page newTab = page.waitForPopup(()->{
            jobbaHar.focus();
            jobbaHar.click();
        });

        Assert.assertEquals(expectedPageTitle, newTab.title());
    }

    public void assertTitlePage(String expectedTitle) {
        Assert.assertEquals(expectedTitle, page.title());
    }
}

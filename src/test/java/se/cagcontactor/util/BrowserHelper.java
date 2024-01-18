package se.cagcontactor.util;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class BrowserHelper {

    public static Page setUpBrowserContext(Browser browser) {
         BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().
                setViewportSize(1920, 1080));
         return browserContext.newPage();
    }
}

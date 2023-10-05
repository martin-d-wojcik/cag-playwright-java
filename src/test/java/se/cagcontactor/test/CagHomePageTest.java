package se.cagcontactor.test;

import com.microsoft.playwright.*;
import org.junit.*;
import se.cagcontactor.page.CarrersPage;
import se.cagcontactor.page.HomePage;

public class CagHomePageTest {


    static Playwright playwright;
    static Browser browser;

    // Page objects
    HomePage homePage;
    CarrersPage carrersPage;

    @BeforeClass
    public static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Test
    public void testCheckOutOneCoworker() {
        carrersPage = new CarrersPage(browser);
        carrersPage.clickMedarbetare();
    }

    @Test
    public void testSeeAvaibleJobs() {
        homePage = new HomePage(browser);
        homePage.assertTitlePage("CAG Contactor – CAG");
        homePage.assertAdress();
        homePage.clickJobbaHar("Konsultbolaget med dig i fokus - CAG Contactor");

        carrersPage = new CarrersPage(browser);
        carrersPage.clíckLedigaJobb();
    }
}

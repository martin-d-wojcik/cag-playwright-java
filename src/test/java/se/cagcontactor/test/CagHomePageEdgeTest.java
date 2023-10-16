package se.cagcontactor.test;

import com.microsoft.playwright.*;
import org.junit.*;
import se.cagcontactor.page.CareerPage;
import se.cagcontactor.page.ConnectPage;
import se.cagcontactor.page.HomePage;
import se.cagcontactor.page.PeoplePage;

public class CagHomePageEdgeTest {


    static Playwright playwright;
    static Browser browser;

    // Page objects
    HomePage homePage;
    CareerPage careerPage;
    PeoplePage peoplePage;
    ConnectPage connectPage;

    @BeforeClass
    public static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Test
    public void testCheckOutOneCoworkerShouldSeeHeadline() {
        careerPage = new CareerPage(browser);
        careerPage.clickMedarbetareInCareerMenu();

        peoplePage = new PeoplePage(browser);
        peoplePage.clickOneCoworker("David Caro");
        peoplePage.jagRekryterarVisible();
    }

    @Test
    public void testSeeAvaibleJobsShouldSeeList() {
        homePage = new HomePage(browser);
        homePage.assertTitlePage("CAG Contactor – CAG");
        homePage.assertAdress();
        homePage.clickJobbaHar("Konsultbolaget med dig i fokus - CAG Contactor");

        careerPage = new CareerPage(browser);
        careerPage.clíckLedigaJobb();
    }

    @Test
    public void testConnectWithUsEnterEmailOk() {
        careerPage = new CareerPage(browser);
        careerPage.clickConnect();

        connectPage = new ConnectPage(browser);
        // TODO: specify locator 
        connectPage.selectFieldOfInterest("Alla");
    }
}

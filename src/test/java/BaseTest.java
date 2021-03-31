import org.junit.Test;

import java.util.List;

public class BaseTest {

    @Test
    public void testOne() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        PageService pageService = new PageService();
        pageService.setup();
        pageService.baseUrlControl();
        pageService.forSaleClick();
        pageService.setProvince("izmir");
        pageService.setCountry("bornova");
        pageService.clickWorkPlace();
        pageService.scrollElement("500");
        pageService.setMinPrice("1000");
        pageService.setMaxPrice("2000000");
        pageService.scrollElement("500");
        pageService.buildingAge();
        pageService.scrollElement("1000");
        pageService.searchClick();
        pageService.countryAssert("Bornova");
        pageService.cityAssert("İzmir");
        pageService.priceRangeAssert();
        pageService.closeDriver();
    }

    @Test
    public void testTwo() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        PageService pageService = new PageService();
        pageService.setup();
        pageService.baseUrlControl();
        pageService.forSaleClick();
        pageService.setProvince("ankara");
        pageService.setCountry("Çankaya");
        pageService.clickWorkPlace();
        pageService.scrollElement("1000");
        pageService.searchClick();
        pageService.thirtPageClick();
        pageService.phoneNumberClick();
        pageService.closeDriver();
    }

}

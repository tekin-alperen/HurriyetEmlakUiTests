import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

public class PageService {

    private static final By btnForSale = By.xpath("/html/body/div[1]/div/div/section/div[1]/div/div[2]/div/ul/li[1]/a");
    private static final By cmbProvince = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[1]/section[1]/div/div/div/div/div/div[1]");
    private static final By txtProvince = By.cssSelector("div > div > div > div > div.he-popper.he-select-base__dropdown > input");
    private static final By cbmOneIndexProvince = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[1]/section[1]/div/div/div/div/div/div[2]/div/div[1]/ul/li");
    private static final By cmbCountry = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[1]/section[2]/div/div/div/div[1]");
    private static final By txtCountry = By.cssSelector("section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-popper.he-select-base__dropdown > input");
    private static final By cbmOneIndexCountry = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/section[2]/div/section[1]/section[2]/div/div/div/div[2]/div/div[1]/ul/li");
    private static final By chkWorkplace = By.cssSelector("section.filter-item-wrap.categoryMainSec > div > ul > li:nth-child(2) > div");
    private static final By closePopUp = By.cssSelector("p > span");
    private static final By txtMinprice = By.cssSelector("section.filter-item-wrap.priceSec > div > div:nth-child(1) > input");
    private static final By txtMaxprice = By.cssSelector("section.filter-item-wrap.priceSec > div > div:nth-child(2) > input");
    private static final By txtBuildAge = By.cssSelector("section.buildingAgeSec > section > div > div.custom-select");
    private static final By cmbZeroBuildAge = By.cssSelector("div > div > ul > li:nth-child(1) > label > span");
    private static final By cmbOneFiveBuildAge = By.cssSelector("div > div > ul > li:nth-child(2) > label > span");
    private static final By cmbSixTenBuildAge = By.cssSelector("div > div > ul > li:nth-child(3) > label > span");
    private static final By btnSearch = By.cssSelector("a.btn.btn-red.btn-large");
    private static final By btnThirdPage = By.cssSelector("section > ul > li:nth-child(4) > a");
    private static final By btnPhoneNumber = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/button[1]");
    private static final By lblCountry = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div[3]/div[1]/div[2]/div[3]/span[1]");
    private static final By lblCity = By.cssSelector("span.applied-filters-list-item.last--item");
    private final By lblPrice = By.cssSelector("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div/div/div[" + priceValue + "]/div/div/div[2]/div[1]");
    private static final By btnPrice = By.cssSelector("li:nth-child(4) > span.applied-filters-list-item.last--item");

    static String priceValue = "";
    Elements elements;
    Random random;
    private static final String baseUrl = "https://www.hurriyetemlak.com/";


    public PageService() {
        elements = new Elements();
    }

    public void setup() {
        elements.oneWaitElement(15);
        elements.setup();
    }

    public void baseUrlControl() {
        Assert.assertEquals(elements.currentUrl(), baseUrl);
    }

    public void forSaleClick() {
        elements.clickElement(btnForSale);
    }

    public void setProvince(String province) {
        elements.clickElement(cmbProvince);
        elements.getSendKeyElement(txtProvince, province);
        elements.clickElement(cbmOneIndexProvince);
    }

    public void scrollElement(String scroll) {
        elements.scrollElement(scroll);
        elements.sleep(1000);
    }


    public void setCountry(String country) {
        elements.clickElement(cmbCountry);
        elements.getSendKeyElement(txtCountry, country);
        elements.clickElement(cbmOneIndexCountry);
        elements.clickElement(cmbCountry);
        elements.clickElement(closePopUp);
    }

    public void clickWorkPlace() {
        elements.clickElement(chkWorkplace);
    }

    public void setMinPrice(String minPrice) {
        elements.clearElement(txtMinprice);
        elements.getSendKeyElement(txtMinprice, minPrice);
        elements.getSendKeyKeyTab(txtMinprice);
        elements.sleep(1000);

    }

    public void setMaxPrice(String maxPrice) {
        elements.clearElement(txtMaxprice);
        elements.getSendKeyElement(txtMaxprice, maxPrice);
        elements.getSendKeyKeyTab(txtMaxprice);
    }

    public void buildingAge() {
        elements.clickElement(txtBuildAge);
        elements.sleep(1000);
        elements.clickElement(cmbZeroBuildAge);
        elements.sleep(1000);
        elements.clickElement(cmbOneFiveBuildAge);
        elements.sleep(1000);
        elements.clickElement(cmbSixTenBuildAge);
    }

    public void searchClick() {
        elements.clickElement(btnSearch);
    }

    public void thirtPageClick() {
        elements.clickElement(btnThirdPage);
    }

    public void phoneNumberClick() {
        elements.clickElement(btnPhoneNumber);
    }

    public void countryAssert(String country) {
        Assert.assertTrue("hata! ilçe yanlış :" + country + " gelmesi bekleniyordu.", elements.findElement(lblCountry).getText().contains(country));
    }

    public void cityAssert(String city) {
        Assert.assertTrue("hata! şehir yanlış :" + city + " gelmesi bekleniyordu.", elements.findElement(lblCity).getText().contains(city));
    }


    public void priceRange(int minPrice, int maxPrice) {
        int randomIndex = random.nextInt(10);
        randomIndex++;
        boolean isRange;
        priceValue = Integer.toString(randomIndex);
        String price = elements.findElement(lblPrice).getText();
        int priceNumber = Integer.parseInt(price);
        if (priceNumber > minPrice && priceNumber < maxPrice) {
            isRange = true;
        } else {
            isRange = false;
        }
        Assert.assertTrue("fiyat aralığı dışı değerler geldi", isRange);
    }

    public void priceRangeAssert() {
        Assert.assertTrue("fiyat aralığı dışı değer", elements.findElement(lblCity).getText().contains("1.000 TL - 2.000.000 TL"));
    }

    public void closeDriver() {
        elements.closeDriver();
    }

}


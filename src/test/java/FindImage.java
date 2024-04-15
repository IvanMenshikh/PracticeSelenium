import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindImage {
    WebDriver driver = new EdgeDriver();
    Data getDate = new Data();

    private final By buttonOnGlobalSearch = By.xpath("//div[@id = 'popover-visual-search-form-nav']//button[@type = 'button']");
    private final By buttonOpenImage = By.xpath("//div[@class = 'ZptFz uTZ52 bu8rE']//input[@type = 'file']");
    private final By errorChecking = By.xpath("//div[@class = 'b8JcU ec_09 Niw9H _UNLg']//div[@class = 'K6wLX dgYec']//h1[@data-test = 'page-header-title']");

    @Test
    public void findImage() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get(getDate.getUrl);
        driver.findElement(buttonOnGlobalSearch).click();
        Thread.sleep(1000);
        driver.findElement(buttonOpenImage).sendKeys(getDate.imgAlexPereira);
        Thread.sleep(3000);
        //Пишем кейс с проверкой, что изображение загрузилось и мы перешли на след. страничку
        String getError = driver.findElement(errorChecking).getText();
        Assert.assertEquals(getError, "Visual search");
        driver.quit();
    }
}

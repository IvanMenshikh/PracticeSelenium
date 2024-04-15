import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//Авторизация на сайте, после регистрации
public class Authorization {

    WebDriver driver = new EdgeDriver();
    Data getDate = new Data();

    final By btnLogin = By.xpath("//div[@class = 'NKrLq']//a[@class = 'wcgxB ogSND ZR5jm cs1e4 oLkUH xMiih ZR5jm GcCli iHTme I3Ayg']");
    final By inputEmailAddress = By.xpath("//input[@name = 'email']");
    final By inputPassword = By.xpath("//input[@name = 'password']");
    private final By buttonLogin = By.xpath("//button[@class = 'IUoDf Qzy6N ogSND ZR5jm cs1e4 ibgtd LoCAy mP89P szXtT DA6Wz']");

    private  final By getErrorTextWindow = By.xpath("//div[@class = 'ESPog']//p[@class = 'vZMI9 N46Vv']");

    @Test
    public void authorization() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get(getDate.getUrl);
        driver.findElement(btnLogin).click();
        Thread.sleep(1000);
        driver.findElement(inputEmailAddress).sendKeys(getDate.emailAddress);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        Thread.sleep(1000);
        driver.findElement(buttonLogin).click();
        Thread.sleep(3000);
        driver.quit();
    }
//Далее описываю кейс по проверке ошибки при вводе неправильного пароля
    @Test
    public void negativeAuthorization() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get(getDate.getUrl);
        driver.findElement(btnLogin).click();
        Thread.sleep(1000);
        driver.findElement(inputEmailAddress).sendKeys(getDate.emailAddress);
        driver.findElement(inputPassword).sendKeys(getDate.negativePassword);
        Thread.sleep(1000);
        driver.findElement(buttonLogin).click();
        String getError = driver.findElement(getErrorTextWindow).getText();
        Assert.assertEquals(getError, "Invalid email or password.");//Сравнение ошибки фактической и ожидаемой
        driver.quit();

    }
}
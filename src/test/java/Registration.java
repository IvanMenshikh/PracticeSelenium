import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
//Регистрации пользователя на тестовом сайте
public class Registration extends Data{

    private final By  btnLogin = By.xpath("//div[@class = 'NKrLq']//a[@class = 'wcgxB ogSND ZR5jm cs1e4 oLkUH xMiih ZR5jm GcCli iHTme I3Ayg']");
    private final By  btnJoinFree = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/a");
    private final By  inputFirstName = By.xpath("//div[@class = 'PFE58']//label[@class = 'R9duZ']//input[@name = 'first_name']");
    private final By  inputLastName = By.xpath("//div[@class = 'PFE58']//label[@class = 'R9duZ']//input[@name = 'last_name']");
    private final By  inputEmailAddress = By.xpath("//label[@class = 'R9duZ']//input[@name = 'email']");
    private final By  inputUserName = By.xpath("//label[@class = 'R9duZ']//input[@name = 'username']");
    private final By  inputPassword = By.xpath("//label[@class = 'R9duZ']//input[@name = 'password']");
    //private final By  checkBoxVerify = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"); КапчаГугл, решение не найдено, временно пропускаю.
    private final By  btnJoin = By.xpath("//button[@class = 'IUoDf Qzy6N ogSND ZR5jm cs1e4 ibgtd LoCAy mP89P szXtT']");
//Выше описаны пути к полям регистрации
    @Test
    public void registration() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        Data getDate = new Data();
        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        driver.findElement(btnLogin).click();
        Thread.sleep(2000);
        driver.findElement(btnJoinFree).click();
        Thread.sleep(2000);
        driver.findElement(inputFirstName).sendKeys(getDate.firstName);
        driver.findElement(inputLastName).sendKeys(getDate.lastName);
        driver.findElement(inputEmailAddress).sendKeys(getDate.emailAddress);
        driver.findElement(inputUserName).sendKeys(getDate.userName);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        Thread.sleep(10000);//На тестовом сайте присутствует КапчаГугл, решение дать таймайут и отжать руками, не останавливаться на поиске решения, тк обучение азов тестирования стопориться, вернусь к решению позже.
        driver.findElement(btnJoin).click();
        Thread.sleep(3000);
        driver.quit();
    }

}


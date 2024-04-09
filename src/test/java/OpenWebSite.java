import org.openqa.selenium.WebDriver; //Selenium driver включается после написания команды "WebDriver"
import org.openqa.selenium.edge.EdgeDriver; //Edge driver включается после написания команды "= new EdgeDriver();"

public class OpenWebSite {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver(); //driver выступает в данном случае переменной, которую можно обозвать по разному
        driver.get("https://www.selenium.dev/"); //строчка кода открывает ссылку в браузере


    }
}

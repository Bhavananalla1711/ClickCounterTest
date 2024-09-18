import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ClickCounterTest {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Navigate to the url https://qaclickcounter.ccbp.tech/
        driver.get("https://qaclickcounter.ccbp.tech/");
        //Find the "Click Me!" button - use contains() method with text() method.
        //use the text content as Click Me!
        WebElement clickMeEl = driver.findElement(By.xpath("/html/body/div/div/div/button"));
        clickMeEl.click();
        //Find the <span> element whose class attribute value contains counter
        WebElement counterEl = driver.findElement(By.xpath("/html/body/div/div/h1/span"));
        //Repeat the following steps for 100 iterations(use a for loop),
        //Click the "Click Me!" button.
        for(int i = 1; i <= 100; i++){
            clickMeEl.click();
            //Get the text from the <span> element
            String counterElText = counterEl.getText();
            //verify whether the text matches with the iteration count.
            //if the text does not match, print "Mismatch in count" and break the loop.
            if(counterElText.equals(String.valueOf(i))){
                System.out.println("Mismatch in count");
                break;
            }
            //Print "Click Counter App: Working as expected", if all the 100 iterations are successfully executed.
            if (i == 100) {
                System.out.println("Click Counter App: Working as expected");
            }
        }
        //close the browser
        driver.quit();
    }
}



package Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Homework4Daji {
    @Test
    public void PositiveTest1(){
        Selenide.open("https://redmed.ge");
        Configuration.browserSize = "1920x1080";
        $(byText("ავტორიზაცია")).click();
        $(byText("პაციენტი")).is(Condition.exist);
        $(byText("პაციენტი")).click();
        $(byText("შესვლა")).shouldBe(Condition.visible);
        $(byText("რეგისტრაცია")).click();
        $(By.xpath("/html/body/app-root/div/app-register-page/div/div/div/div/form/h1/span[1]")).shouldBe(Condition.visible);
        sleep(5000);
    }

    @Test
    public void PositiveTest2(){
        Selenide.open("https://redmed.ge/ka/user/register");
        Configuration.browserSize = "1920x1080";
        $("#user-registration-button").click();
        $("#userName").getCssValue("border-color").equals("#da1f3d");
        $("#userName").setValue("დარეჯან");
        $("#userName").getCssValue("border-color").equals("#00bbe0");
        $("#lastName").setValue("უსანეთაშვილი");
        $("#terms").shouldNotBe(Condition.checked);
        $("#email").setValue("d.usanetashvili@gmail.com");
        $("#email").getCssValue("border-color").equals("#00bbe0");
        sleep(5000);
    }

    @Test
    public void NegativeTest1(){
        Selenide.open("https://redmed.ge/ka/user/register");
        Configuration.browserSize = "1920x1080";
        $("#email").setValue("დარეჯანი");
        $("#email").getCssValue("border-color").equals("#da1f3d");
        $("#email").setValue("mail@com");
        sleep(2000);
        $("#email").getCssValue("border-color").equals("#da1f3d");
        sleep(2000);
        $("#email").setValue("d.usanetashviligmail.com");
        $("#email").getCssValue("border-color").equals("#da1f3d");
        sleep(2000);
    }

}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSearchIssuesWithListener {
    @BeforeAll
    static void beforeAll(){
       // Configuration.holdBrowserOpen = true;
    }
    @Test
    void selenideSearchIssuesListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("/DimaKarpuk").pressEnter();
        $(byText("/demoqa-tests-23")).click();
        $("#issues-tab").click();
        $("[class = 'opened-by']").shouldHave(text("#1 opened"));
    }
}

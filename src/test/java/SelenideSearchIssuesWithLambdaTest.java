import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideSearchIssuesWithLambda {
    SelenideSearchIssuesWithSteps selenideSearchIssuesWithSteps = new SelenideSearchIssuesWithSteps();
    private static final String REPOSITORY = "/DimaKarpuk";
    private static final String NameREPOSITORY = "/demoqa-tests-23";
    private static final int ISSUE = 1;
    @Test
    void selenideSearchIssuesLambda(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + NameREPOSITORY, () -> {
            $(byText(NameREPOSITORY)).click();
        });
        step("Открываем таб issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issues с номером " + ISSUE, () -> {
            $("[class = 'opened-by']").shouldHave(text("#" + ISSUE));
        });
    }
    @Test
    void selenideTestWithSteps(){
        selenideSearchIssuesWithSteps.openMainPage();
        selenideSearchIssuesWithSteps.searchRepository(REPOSITORY);
        selenideSearchIssuesWithSteps.clickOnRepositoryLink(NameREPOSITORY);
        selenideSearchIssuesWithSteps.openIssuesTab();
        selenideSearchIssuesWithSteps.searchIssuesWithNumb(ISSUE);
    }
}

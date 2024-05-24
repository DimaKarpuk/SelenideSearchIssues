import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSearchIssuesWithSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo){
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }
    @Step("Кликаем по ссылке репозитория {nameRepo}")
    public void clickOnRepositoryLink(String nameRepo){
        $(byText(nameRepo)).click();
    }
    @Step("Открываем таб issues")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие issues с номером {numb}")
    public void searchIssuesWithNumb(int numb){
        $("[class = 'opened-by']").shouldHave(text("#" + numb));
    }
}

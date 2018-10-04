package com.wanderset.steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TopMenuSteps {
    private final String SUBMENU_HEADER_SELECTOR = "//li[contains(@class, 'list-dropdown-menu__item--heading') and contains(., '%s')]";

    @When("^hoover \"([^\"]*)\" top menu$")
    public void hooverTopMenu(String menu) {
        $(".navbar").$(byText(menu)).hover();
    }

    @Then("^submenu item \"([^\"]*)\" should be visible$")
    public void submenuItemShouldBeVisible(String item) {
        $x(String.format("//a[contains(@class, 'list-dropdown-menu__link') and text()='%s']", item)).shouldBe(visible);
    }

    @And("^\"([^\"]*)\" submenu items should be links$")
    public void submenuItemsShouldBeLinks(String title) {
        SelenideElement submenuEl = $x(String.format(SUBMENU_HEADER_SELECTOR, title)).parent();
        for (SelenideElement item : submenuEl.$$("li.list-dropdown-menu__item")) {
            item.$("a.list-dropdown-menu__link").shouldBe(visible);
        }
    }

    @And("^\"([^\"]*)\" submenu should have (\\d+) items$")
    public void submenuShouldHaveItems(String title, int itemNum) {
        $x(String.format(SUBMENU_HEADER_SELECTOR, title)).parent()
                .$$("li.list-dropdown-menu__item:not(.list-dropdown-menu__item--heading)").shouldHave(size(itemNum));
    }
}

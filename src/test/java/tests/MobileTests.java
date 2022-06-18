package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class MobileTests extends TestBase {

    @Test
    @DisplayName("Check Search input")
    void searchTest() {
        back();
        step("Search BrowserStack in Wikipedia", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Verify results", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        });

    }

    @Test
    @DisplayName("Check title")
    void openContent() {
        back();
        step("Search Liverpool F.C. in Wikipedia", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Liverpool F.C.");
        });

        step("Open content", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });

        step("Verify title", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Liverpool F.C.']")).shouldHave(Condition.text("Liverpool F.C."));
        });
    }
}
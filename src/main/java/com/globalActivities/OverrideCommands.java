package com.globalActivities;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.*;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OverrideCommands {
    public static class MyClick extends Click {
        @Override
        protected void click(Driver driver, WebElement element) {
            waitUntilAllProgressBarsAreCompleted();
            $(element).waitUntil(visible, 40000);
            super.click(driver, element);
            waitUntilAllProgressBarsAreCompleted();
        }
    }

    public static class MyClick2 extends Click {
        @Override
        protected void click(Driver driver, WebElement element, int offsetX, int offsetY) {
            waitUntilAllProgressBarsAreCompleted();
            $(element).waitUntil(visible, 40000);
            super.click(driver, element, offsetX, offsetY);
            waitUntilAllProgressBarsAreCompleted();
        }
    }

    public static class MyClick3 extends Click {
        @Override
        public Void execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            $(locator.findAndAssertElementIsInteractable()).waitUntil(visible, 40000);
            super.execute(proxy, locator, args);
            waitUntilAllProgressBarsAreCompleted();
            return null;
        }
    }

    public static class MyShould extends Should {
        @Override
        public SelenideElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MyExists extends Exists {
        @Override
        public Boolean execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MyFind extends Find {
        @Override
        public SelenideElement execute(SelenideElement proxy, WebElementSource locator, Object... args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MyFindAll extends FindAll {
        @Override
        public ElementsCollection execute(SelenideElement parent, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(parent, locator, args);
        }
    }

    public static class MyGetAttribute extends GetAttribute {
        @Override
        public String execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MyGetText extends GetText {
        @Override
        public String execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MyGetValue extends GetValue {
        @Override
        public String execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MyIsDisplayed extends IsDisplayed {
        @Override
        public Boolean execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MySelectRadio extends SelectRadio {
        @Override
        public SelenideElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MySelectOptionByTextOrIndex extends SelectOptionByTextOrIndex {
        @Override
        public Void execute(SelenideElement proxy, WebElementSource selectField, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, selectField, args);
        }
    }

    public static class MySelectOptionByValue extends SelectOptionByValue {
        @Override
        public Object execute(SelenideElement proxy, WebElementSource selectField, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, selectField, args);
        }
    }

    public static class MySelectOptionContainingText extends SelectOptionContainingText {
        @Override
        public Void execute(SelenideElement proxy, WebElementSource selectField, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, selectField, args);
        }
    }

    public static class MyShouldHave extends ShouldHave {
        @Override
        public SelenideElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    public static class MySetValue extends SetValue {
        @Override
        public WebElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
            waitUntilAllProgressBarsAreCompleted();
            return super.execute(proxy, locator, args);
        }
    }

    private static void waitUntilAllProgressBarsAreCompleted() {
        //write your conditions here - it is usually not essential to add it unless Selenide methods are not working.
        //additionally, you have to import changes by calling out applyNewCommands. Do it in Configuration class
    }

    public static void applyNewCommands() {
        Commands.getInstance().add("click", new MyClick3());
        Commands.getInstance().add("getText", new GetText());
        Commands.getInstance().add("should", new MyShould());
        Commands.getInstance().add("exists", new MyExists());
        Commands.getInstance().add("find", new MyFind());
        Commands.getInstance().add("findAll", new MyFindAll());
        Commands.getInstance().add("getAttribute", new MyGetAttribute());
        Commands.getInstance().add("getText", new MyGetText());
        Commands.getInstance().add("getValue", new MyGetValue());
        Commands.getInstance().add("isDisplayed", new MyIsDisplayed());
        Commands.getInstance().add("selectRadio", new MySelectRadio());
        Commands.getInstance().add("selectOptionByTextOrIndex", new MySelectOptionByTextOrIndex());
        Commands.getInstance().add("selectOptionByValue", new MySelectOptionByValue());
        Commands.getInstance().add("selectOptionContainingText", new MySelectOptionContainingText());
        Commands.getInstance().add("shouldHave", new MyShouldHave());
        Commands.getInstance().add("setValue", new MySetValue());
    }
}

package ch.martinelli.demo.vaadin.views.about;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.H2Element;
import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchTestCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutViewTest extends TestBenchTestCase {

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        setDriver(new ChromeDriver());
        getDriver().get("http://localhost:8080/");

        login();
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

    private void login() {
        $(TextFieldElement.class).id("vaadinLoginUsername").setValue("user");
        $(PasswordFieldElement.class).id("vaadinLoginPassword").setValue("user");
        $(ButtonElement.class).first().click();
    }

    @Test
    public void about() {
        H2Element h2 = $(H2Element.class).first();

        assertEquals("About", h2.getText());
    }

}

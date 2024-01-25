package pl.akademiaqa;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pl.akademiaqa.factory.BrowserFactory;
import pl.akademiaqa.utils.Properties;
import pl.akademiaqa.utils.StringUtils;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

//    private static Playwright pw;
//    protected static Browser browser;

    protected BrowserContext browserContext;
    private BrowserFactory browserFactory;
    private Browser browser;

    protected Page page;

    @BeforeAll
    void launchBrowser() {

        System.out.println("READING SECRETS FROM GT: " + System.getProperty("API_KEY"));
        System.out.println("READING VARIABLES FROM GT: " + System.getProperty("UI_URL"));
        browserFactory = new BrowserFactory();
        browser = browserFactory.getBrowser();
    }

    @BeforeEach
    void createContextAndPage() {
        browserContext = browser.newContext();

        if (isTracingEnabled()) {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }

        page = browserContext.newPage();
        page.setViewportSize(1980, 1000);
        page.navigate(Properties.getProperty("app.url"));

    }

    @AfterEach
    void closeContext(TestInfo testInfo) {
        if (isTracingEnabled()) {
            String traceName = "traces/trace_"
                    + StringUtils.removeRoundBrackets(testInfo.getDisplayName())
                    + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(Properties.getProperty("tracing.data.format"))) + ".zip";
            browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        }
        //TERMINAL - mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace traces/trace.zip"

        browserContext.close();
    }

    @AfterAll
    void closeBrowser() {
        browserFactory.getPlaywright().close();
    }

    private Boolean isTracingEnabled() {
        return Boolean.parseBoolean(Properties.getProperty("tracing.enabled"));
    }

}

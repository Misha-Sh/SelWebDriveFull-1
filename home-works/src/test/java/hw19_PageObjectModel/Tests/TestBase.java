package hw19_PageObjectModel.Tests;

import hw19_PageObjectModel.App.Application;
import org.junit.Before;

public class TestBase {

        public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
        public Application app;

        @Before
        public void start() {
            if (tlApp.get() != null) {
                app = tlApp.get();
                return;
            }

            app = new Application();
            tlApp.set(app);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { app.quit(); app = null; }));
        }

    }







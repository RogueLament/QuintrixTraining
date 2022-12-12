import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeDriverManager extends WebDriverManager {

	private ChromeDriverService driverService;
	
	@Override
	protected void startService() throws IOException {
		if (driverService == null) {
			driverService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("chromedriver.exe"))
					.usingAnyFreePort()
					.build();
			driverService.start();
		}
		
	}

	@Override
	protected void stopService() {
		if (driverService != null && driverService.isRunning()) {
			driverService.stop();
		}
	}

	@Override
	protected void createDriver() {
        driver = new ChromeDriver(driverService);
	}

}

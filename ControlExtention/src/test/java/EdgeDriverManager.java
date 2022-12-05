import java.io.File;
import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

public class EdgeDriverManager extends WebDriverManager {

	private EdgeDriverService driverService;
	
	@Override
	protected void startService() throws IOException {
		if (driverService == null) {
			driverService = new EdgeDriverService.Builder()
					.usingDriverExecutable(new File("msedgedriver.exe"))
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
        driver = new EdgeDriver(driverService);
	}
}

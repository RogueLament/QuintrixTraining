package foundation;

public class DriverManagerFactory {

	public static DriverManager getManager(String browserType) {

		if(browserType.equals(BrowserTypes.chrome) ) {
			return new ChromeDriverManager();
		}
		if(browserType.equals(BrowserTypes.edge)) {
			return new EdgeDriverManager();
		}

		throw new RuntimeException(browserType + " is not a supported browsertype.");	
	}
}

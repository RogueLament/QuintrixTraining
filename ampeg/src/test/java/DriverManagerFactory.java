
public class DriverManagerFactory {
	
	public static WebDriverManager getManager(String browser) {
		
		WebDriverManager webDriver;
		
		//defaults to Google Chrome
		if (browser.toLowerCase().contains("edge"))
		{
			webDriver = new EdgeDriverManager();
		}
		else
		{
			webDriver = new ChromeDriverManager();
		}
		
		return webDriver;
	}
	
}

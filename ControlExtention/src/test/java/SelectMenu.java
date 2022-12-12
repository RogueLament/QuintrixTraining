import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMenu {

	private WebElement menuElement;
	private WebElement oldStyleMenu;
	private WebElement multiSelectMenu;
	private Select oldStyleSelect;
	private Select multiSelectSelect;
	
	public SelectMenu(WebElement menuElement) {
		this.menuElement = menuElement;
		oldStyleMenu = this.menuElement.findElement(By.id("oldSelectMenu"));
		oldStyleSelect = new Select(oldStyleMenu);
		multiSelectMenu = this.menuElement.findElement(By.id("cars"));
		multiSelectSelect = new Select(multiSelectMenu);
	}
	
	public void oldStyleSelect(String value) {		
		oldStyleSelect.selectByValue(value);
	}
	
	public String getOldStyleValue() {
		return oldStyleSelect.getFirstSelectedOption().getText();
	}
	
	public String[] getAllOldStyleMenuValues() {
		String[] values = new String[11];
		values[0] = getOldStyleValue();
		for (int i = 1; i <= 10; i++) {
			oldStyleSelect(String.valueOf(i));
			values[i] = getOldStyleValue();
		}
		
		return values;
	}
	
	public void multiSelectMeneSelect(String value) {
		multiSelectSelect.selectByValue(value);
	}
	
	public String[] getAllMultiSelectMeneSelectedValues() {
		var listValues = multiSelectSelect.getAllSelectedOptions();
		String[] values = new String[listValues.size()];
		for (int i = 0; i < listValues.size(); i++) {
			values[i] = listValues.get(i).getText();
		}
		
		return values;
	}
	
	
}

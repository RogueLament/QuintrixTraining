import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {
	SelectMenu selectMenu;
	@BeforeMethod
	public void launch() {
		this.driver.navigate().to(baseURL+"select-menu/");
		var element = driver.findElement(By.id("selectMenuContainer"));
		selectMenu = new SelectMenu(element);
	}
	
	@Test
	public void selectValueInOldStyleMenu() {
		String expectedValue = "White";
		selectMenu.oldStyleSelect("6");
		String actualValue = selectMenu.getOldStyleValue();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
	
	@Test
	public void getValuesInOldStyleMenu() {
		String[] expectedValue = {"Red","Blue","Green","Yellow","Purple","Black","White","Voilet","Indigo","Magenta","Aqua"};
		String[] actualValue = selectMenu.getAllOldStyleMenuValues();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
	
	@Test
	public void selectAndGetValuesInMultiSelectMenu() {
		String[] expectedValue = {"Saab","Opel"};
		selectMenu.multiSelectMeneSelect("saab");
		selectMenu.multiSelectMeneSelect("opel");
		String[] actualValue = selectMenu.getAllMultiSelectMeneSelectedValues();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
}

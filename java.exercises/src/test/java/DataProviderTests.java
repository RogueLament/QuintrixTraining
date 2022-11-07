import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetTexasStateName() {
		var expectedState = "Texas";

		var actualState = States.Texas.Name;

		Assert.assertEquals(actualState, expectedState,"Expected state name.");
	}

	@Test
	public void canGetStateTexasAbbreviation() {
		var expectedAbberviation = "TX";

		var actualAbbreviation = States.Texas.Abbreviation;

		Assert.assertEquals(actualAbbreviation, expectedAbberviation,"Expected Abbreviation.");
	}
	
	@Test
	public void canGetTexasStateViaCity() {
		var expectedState = "Texas";
		
		var actualState = getState(LocationObjectMothers.Houston());
		
		Assert.assertEquals(actualState, expectedState,"Expected State for city.");
	}
	
	@Test
	public void canGetTexasCityViaState() {
		var expectedCity = "Houston";
		
		var actualCity = getCity(LocationObjectMothers.Texas());
		
		Assert.assertEquals(actualCity, expectedCity,"Expected State for city.");
	}
	
	@Test
	public void canGetLouisianaStateName() {
		var expectedState = "Louisiana";

		var actualState = States.Louisiana.Name;

		Assert.assertEquals(actualState, expectedState,"Expected state name.");
	}

	@Test
	public void canGetStateLouisianaAbbreviation() {
		var expectedAbberviation = "LA";

		var actualAbbreviation = States.Louisiana.Abbreviation;

		Assert.assertEquals(actualAbbreviation, expectedAbberviation,"Expected Abbreviation.");
	}
	
	@Test
	public void canGetLouisianaStateViaCity() {
		var expectedState = "Louisiana";
		
		var actualState = getState(LocationObjectMothers.NewOrleans());
		
		Assert.assertEquals(actualState, expectedState,"Expected State for city.");
	}
	
	@Test
	public void canGetLouisianaCityViaState() {
		var expectedCity = "New Orleans";
		
		var actualCity = getCity(LocationObjectMothers.Louisiana());
		
		Assert.assertEquals(actualCity, expectedCity,"Expected State for city.");
	}

	@Test
	public void canGetOregonStateName() {
		var expectedState = "Oregon";

		var actualState = States.Oregon.Name;

		Assert.assertEquals(actualState, expectedState,"Expected state name.");
	}

	@Test
	public void canGetStateOregonAbbreviation() {
		var expectedAbberviation = "OR";

		var actualAbbreviation = States.Oregon.Abbreviation;

		Assert.assertEquals(actualAbbreviation, expectedAbberviation,"Expected Abbreviation.");
	}
	
	@Test
	public void canGetOregonStateViaCity() {
		var expectedState = "Oregon";
		
		var actualState = getState(LocationObjectMothers.Salem());
		
		Assert.assertEquals(actualState, expectedState,"Expected State for city.");
	}
	
	@Test
	public void canGetOregonCityViaState() {
		var expectedCity = "Salem";
		
		var actualCity = getCity(LocationObjectMothers.Oregon());
		
		Assert.assertEquals(actualCity, expectedCity,"Expected State for city.");
	}

	@Test
	public void canGetNewJerseyStateName() {
		var expectedState = "NewJersey";

		var actualState = States.NewJersey.Name;

		Assert.assertEquals(actualState, expectedState,"Expected state name.");
	}

	@Test
	public void canGetStateNewJerseyAbbreviation() {
		var expectedAbberviation = "NJ";

		var actualAbbreviation = States.NewJersey.Abbreviation;

		Assert.assertEquals(actualAbbreviation, expectedAbberviation,"Expected Abbreviation.");
	}
	
	@Test
	public void canGetNewJerseyStateViaCity() {
		var expectedState = "NewJersey";
		
		var actualState = getState(LocationObjectMothers.Trenton());
		
		Assert.assertEquals(actualState, expectedState,"Expected State for city.");
	}
	
	@Test
	public void canGetNewJerseyCityViaState() {
		var expectedCity = "Trenton";
		
		var actualCity = getCity(LocationObjectMothers.NewJersey());
		
		Assert.assertEquals(actualCity, expectedCity,"Expected State for city.");
	}
	
	private String getState(LocationObjectMother mother) {
		return mother.State.Name;
	}
	
	private String getCity(LocationObjectMother mother) {
		return mother.City.Name;
	}
}

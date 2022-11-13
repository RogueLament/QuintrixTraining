package data.access;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jdbcTests {
	private DatabaseUtility accessor;

	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility();
	}

	@Test
	public void canGetSingleColumn() throws SQLException {
		var sql = "SELECT city FROM CITY ORDER BY city DESC LIMIT 10;";
		List<String> actualCities = this.accessor.ExecuteSingleColumn(sql);
		List<String> expectedCities = Arrays.asList("Ziguinchor", "Zhoushan", "Zhezqazghan", "Zeleznogorsk", "Zaria", "Zapopan", "Zaoyang", "Zanzibar", "Zalantun", "Yuzhou");

		Assert.assertEquals(actualCities, expectedCities,"Got Incorrect Cities.");
	}

	@Test
	public void canGetSingleCell() throws SQLException {
		var sql = "SELECT MAX(amount) FROM payment;";
		String actualHighest = this.accessor.ExecuteSingleCell(sql);
		String expectedHighest = new String("11.99");

		Assert.assertEquals(actualHighest, expectedHighest,"Got Incorrect Highest Payment Amount.");
	}

	@Test
	public void canUseView() throws SQLException {
		var sql = "SELECT film_info FROM actor_info WHERE first_name = \"Bob\" AND last_name = \"Fawcett\";";
		String actualFilmInfo = this.accessor.ExecuteSingleCell(sql);
		String expectedFilmInfo = new String("Action: DARN FORRESTER; Animation: DARES PLUTO, LAWLESS VISION, OSCAR GOLD; Children: CIRCUS YOUTH; Classics: DYNAMITE TARZAN; Comedy: CONTROL ANTHEM, HATE HANDICAP, SADDLE ANTITRUST; Documentary: ADAPTATION HOLES, PELICAN COMFORTS; Drama: JACKET FRISCO, SCORPION APOLLO; Family: HOMICIDE PEACH; Games: DAZED PUNK; Horror: ACE GOLDFINGER; Music: PERSONAL LADYBUGS, RUNNER MADIGAN, TAXI KICK; New: CHINATOWN GLADIATOR, JUMANJI BLADE, RUN PACIFIC; Sci-Fi: RAGING AIRPLANE; Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE");

		Assert.assertEquals(actualFilmInfo, expectedFilmInfo,"Got Incorrect Film Info.");
	}

	@Test
	public void canUseStoredProcedures() throws SQLException {
		var sql = "CALL film_in_stock(?,?,?);";
		var sqlid = "(SELECT film_id FROM film WHERE title = 'Alien Center')";
		var args = Arrays.asList(this.accessor.ExecuteSingleCell(sqlid),"2");
		List<String> actualInvFilmStoreLastUpdate = this.accessor.ExecuteStoredProcedure(sql,args);
		List<String> expectedInvFilmStoreLastUpdate = Arrays.asList("73", "74", "75", "76");

		Assert.assertEquals(actualInvFilmStoreLastUpdate, expectedInvFilmStoreLastUpdate,"Got Incorrect Ids or Dates.");
	}
}

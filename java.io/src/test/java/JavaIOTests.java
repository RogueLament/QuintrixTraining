import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class JavaIOTests {
	private String fileName = "9_basses.csv";
	CSVReader csv;

	@BeforeMethod
	public void Reader() throws FileNotFoundException {
		csv = new CSVReader(new FileReader(fileName));
	}
	@Test
	public void ReadCsvintoHashmap() throws CsvValidationException, IOException {
		Map<String,List<String>> expectedResults = new HashMap<String,List<String>>() {
			private static final long serialVersionUID = 1L; 
			{ 
				put("Warwick",new ArrayList<>() {
					private static final long serialVersionUID = 1L;
					{ add("Corvette"); add("Thumb"); add("Streamer"); }
				});
				put("Fender",new ArrayList<>() {
					private static final long serialVersionUID = 1L;
					{ add("Precision"); add("Jazz"); }
				});
				put("Yamaha",new ArrayList<>() {
					private static final long serialVersionUID = 1L;
					{ add("BB500"); }
				});
			}};

			Map<String,List<String>> actualResults = new MakesandModels().getMakesandModels(csv);
			Assert.assertEquals(actualResults, expectedResults, "Should contain all makes and models and no labels");
	}
	@Test
	public void HydrateBassObjects() throws CsvValidationException, IOException {
		var expectedResults = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			{ add(new Bass("Warwick",new ArrayList<>() {
				private static final long serialVersionUID = 1L;
				{ add("Corvette"); add("Thumb"); add("Streamer"); }
			})); 
			add(new Bass("Fender",new ArrayList<>() {
				private static final long serialVersionUID = 1L;
				{ add("Precision"); add("Jazz"); }
			})); 
			add(new Bass("Yamaha",new ArrayList<>() {
				private static final long serialVersionUID = 1L;
				{ add("BB500"); }
			})); 
			}
		};
		Map<String,List<String>> makesAndModels = new MakesandModels().getMakesandModels(csv);
		var actualResults = new ArrayList<>();
		
        Iterator<Entry<String, List<String>>> makesIterator = makesAndModels.entrySet().iterator();
		while (makesIterator.hasNext()) {
			Entry<String, List<String>> bass = (Entry<String, List<String>>)makesIterator.next();
			actualResults.add(new Bass(bass.getKey(),bass.getValue()));
		}
		
		Assert.assertEquals(actualResults, expectedResults, "Should contain all makes and models and no labels");
	}
}

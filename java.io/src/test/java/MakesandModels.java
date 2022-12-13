import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MakesandModels {
	Map<String,List<String>> makesAndModels;

	public MakesandModels() {
		makesAndModels = new HashMap<String,List<String>>();
	}

	public Map<String,List<String>> getMakesandModels(CSVReader csv) throws CsvValidationException, IOException {
		String[] row;
		//This skips the header
		row = csv.readNext();
		while((row = csv.readNext()) != null) 
		{
			if(makesAndModels.containsKey(row[0]))
			{ 
				makesAndModels.get(row[0]).add(row[1]);
			}
			else {
				List<String> cities = new ArrayList<>();
				cities.add(row[1]);
				makesAndModels.put(row[0], cities);
			}
		}
		return makesAndModels;
	}
}

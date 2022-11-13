package data.access;

import java.util.List;

public interface DatabaseAccessor {
	List<String> ExecuteSingleColumn(String sql);	
	  
	String ExecuteSingleCell(String sql);
	  
	List<String[]> Execute(String sql);
}

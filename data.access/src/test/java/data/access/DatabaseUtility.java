package data.access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


import java.sql.ResultSet;

public class DatabaseUtility implements DatabaseAccessor{
	private String url = "jdbc:mysql://localhost:3306/sakila";

	public List<String> ExecuteSingleColumn(String sql) {
		List<String> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				String row = null;
				Object obj = rs.getObject(1);
				if (obj != null) {
					row = obj.toString();
				}
				result.add(row);
			}
		} catch (SQLException e) {
			throw new IllegalStateException("SQL Error", e);
		}
		return result;
	}

	public String ExecuteSingleCell(String sql) {
		String result = null;
		try (Connection connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			rs.next();
			result = rs.getObject(1).toString();
		} catch (SQLException e) {
			throw new IllegalStateException("SQL Error", e);
		}
		return result;
	}

	public List<String> ExecuteStoredProcedure(String sql, List<String> args) {
		List<String> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url);
				CallableStatement statement = connection.prepareCall(sql)) {
			int i = 1;
			for (String arg : args) {
				statement.setString(i,arg);
				i++;
			}
			statement.registerOutParameter(i, Types.INTEGER);
			boolean hasRs = statement.execute();
			
			if (hasRs) {
				try (ResultSet rs = statement.getResultSet()) {
					while (rs.next()) {
						String row = null;
						Object obj = rs.getObject(1);
						if (obj != null) {
							row = obj.toString();
						}
						result.add(row);
					}
				}
			}

			while (statement.getMoreResults()) {
				try (ResultSet rs = statement.getResultSet()){
					String row = null;
					Object obj = rs.getObject(1);
					if (obj != null) {
						row = obj.toString();
					}
					result.add(row);
				}
			}

		} catch (SQLException e) {
			throw new IllegalStateException("SQL Error", e);
		}
		return result;
	}

	public List<String[]> Execute(String sql) {
		List<String[]> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			int columns = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				String[] row = new String[columns];
				for (int i = 1; i <= columns; i++) {
					Object obj = rs.getObject(i);
					if (obj != null) {
						row[i-1] = obj.toString();
					}
				}
				result.add(row);
			}
		} catch (SQLException e) {
			throw new IllegalStateException("SQL Error", e);
		}
		return result;
	}

}

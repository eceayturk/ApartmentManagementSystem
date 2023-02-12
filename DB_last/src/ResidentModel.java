import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class ResidentModel implements ModelInterface {
	
	

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception {
	
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO Residentt (" + fieldNames + ") " );
		sql.append(" VALUES ");

		String[] fieldList = fieldNames.split(",");

		int rowCount = 0;
		for (int i=0; i<rows.size(); i++) {
			if (rows.get(i) instanceof Resident) {
				rowCount++;
				
				Resident resident = (Resident)rows.get(i); 
	
				sql.append("(");
				for (int j=0; j<fieldList.length; j++) {
					String fieldName = fieldList[j].trim();
					sql.append(DatabaseUtilities.formatField(resident.getByName(fieldName)));
					if (j < fieldList.length - 1) {
						sql.append(", ");
					}
				}
				sql.append(")");
				
				if (i < rows.size() - 1) {
					sql.append(", ");
				}				
			}
		}		
		//System.out.println(sql.toString());
		
		
		// execute constructed SQL statement
		if (rowCount > 0) {
			Connection connection = DatabaseUtilities.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			//System.out.println(sql.toString());
			rowCount = preparedStatement.executeUpdate(); //count row and execute query.
			preparedStatement.close();
		}
		
		return rowCount;
	}

	@Override
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
				StringBuilder sql = new StringBuilder();
				sql.append(" DELETE FROM Residentt ");

				List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
				sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
				//System.out.println(sql.toString());

			
				// execute constructed SQL statement
				Connection connection = DatabaseUtilities.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
				DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);		
				int rowCount = preparedStatement.executeUpdate();
				preparedStatement.close();
				
				return rowCount;
		
	}

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class DuesModel implements ModelInterface{

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
				StringBuilder sql = new StringBuilder();
				sql.append(" SELECT ");
				sql.append("	duesId, Date, Amount, FlatNumber "); 
				sql.append(" FROM Dues ");

				List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
				sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
				
				sql.append("ORDER BY duesId");		
				//System.out.println(sql.toString() + "\n");

				
				// execute constructed SQL statement
				Connection connection = DatabaseUtilities.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
				DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
				ResultSet result = preparedStatement.executeQuery();
				
				return result;
	}

	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception {
		// construct SQL statement
				StringBuilder sql = new StringBuilder();
				sql.append(" INSERT INTO Dues (" + fieldNames + ") " );
				sql.append(" VALUES ");

				String[] fieldList = fieldNames.split(",");

				int rowCount = 0;
				for (int i=0; i<rows.size(); i++) {
					if (rows.get(i) instanceof Dues) {
						rowCount++;
						
						Dues dues = (Dues)rows.get(i); 
			
						sql.append("(");
						for (int j=0; j<fieldList.length; j++) {
							String fieldName = fieldList[j].trim();
							sql.append(DatabaseUtilities.formatField(dues.getByName(fieldName)));
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
		// TODO Auto-generated method stub
		return 0;
	}

}

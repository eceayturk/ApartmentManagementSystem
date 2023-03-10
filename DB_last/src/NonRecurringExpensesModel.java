import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class NonRecurringExpensesModel implements ModelInterface{

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
				StringBuilder sql = new StringBuilder();
				sql.append(" SELECT ");
				sql.append("  Year, Innovation, PaintMaintenance, Repair "); 
				sql.append(" FROM NonRecurringExpenses");

				List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
				sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
				
			    //	sql.append("order by ? ");		
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
		// TODO Auto-generated method stub
		return 0;
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

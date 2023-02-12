import java.sql.*;
import java.util.*;

public class DatabaseUtilities {
  
	private static Connection  connection  ; // private and static ?
	public static String host ;
	public static String databaseName ;
	
	
	public DatabaseUtilities() {
		this.connection = null ; 
	}
	public  DatabaseUtilities(String host,String databaseName) { // private ?? 
		this.connection =  null ; 
		this.host = host ;
		this.databaseName = databaseName ;		
	}
	// database connection 
	public static Connection getConnection() throws SQLException {
	
		if(connection == null ) {
			String conUrl = "jdbc:sqlserver://localhost:49681; databaseName=ApartmentManagement; encrypt=true;trustServerCertificate=true; integratedSecurity=true;" ;
					//"jdbc:sqlserver://" + host+";" +"databaseName="+databaseName+"; encrypt=true; trustServerCertificate=true; integratedSecurity=true;" ;
	        connection = DriverManager.getConnection(conUrl) ;
		}
		return connection ;  
	}
	public static void disconnect() throws SQLException{
		// what if connection object is not null ??  or where do we know it is null or not ??
		if(connection == null) {
			connection.close(); 
		}
	}
	// common function 
	public static List<Map.Entry<String,Object>> createWhereParameterList(Map<String,Object> parameters) {
	
		List<Map.Entry<String, Object>> whereParameters = new ArrayList<Map.Entry<String,Object>>() ;  // map interface 
		
		if(parameters != null) {
			for(Map.Entry<String, Object> entry : parameters.entrySet()) {
				whereParameters.add(entry) ;
			}
		}	
		return whereParameters ;
	}
	public static String prepareWhereStatement(List<Map.Entry<String, Object>> whereParameters) {
		StringBuilder whereStatement = new StringBuilder() ;
		
		if(whereParameters != null) {
			for(int i=0;i<whereParameters.size();i++) {
				Map.Entry<String, Object> entry = whereParameters.get(i) ;
				String key = entry.getKey() ;
				Object value = entry.getValue() ;
				
				String pref = (i == 0 ? " where ":"and") ;
				if(value instanceof String && value.toString().contains("%")) 
					whereStatement.append(pref+key+" LIKE ?") ; // why is the question mark ?
				else 
					whereStatement.append(pref+key+" = ?") ;
			}
		}
	return whereStatement.toString() ;	
	}
	public static void setWhereStatementParameters(PreparedStatement preparedStatement,List<Map.Entry<String, Object>> whereParameters) throws Exception{
		
		if(whereParameters != null) {
			for(int i=0;i<whereParameters.size();i++) {
				Map.Entry<String, Object> entry = whereParameters.get(i) ;
				Object value = entry.getValue() ;
				
				if(value instanceof Integer) {
					preparedStatement.setInt(i+1,(Integer)value) ;
				}
				if(value instanceof String) {
					preparedStatement.setString(i+1,(String)value) ;
				}
			}
		}
	}
	public static String formatField(Object value) {
		if(value instanceof String) {
			return "'" + value +"'" ;
		}
		
		return value.toString() ;
	}
}


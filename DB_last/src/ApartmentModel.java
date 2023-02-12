import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class ApartmentModel implements ModelInterface{

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("	ApartmentId, ApartmentName, NumberOfFlats, EntryPassword,IBAN,Income,Expense,NetMoney "); 
		sql.append(" FROM Apartment ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		//sql.append("ORDER BY duesId");		
	    //	System.out.println(sql.toString() + "\n");

		
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
		// construct SQL statement
		float electricityBill = 0 ,waterBill = 0,otherBill = 0,cleaning= 0
				,liftMaintenance = 0,totalDues = 0,totalBill =0,paintMaintenance = 0,repair = 0,
				totalNon = 0;
		
		StringBuilder sql= new StringBuilder();
		Connection connection = DatabaseUtilities.getConnection();
		sql.append("SELECT SUM(Amount) as totalIncome From Dues");
		PreparedStatement prp = connection.prepareStatement(sql.toString());
		ResultSet rs = prp.executeQuery();
		
		while(rs.next()) {
			totalDues = rs.getFloat("totalIncome");
			}
		
		
	   sql = new StringBuilder();
	   sql.append("SELECT ElectrictyBill,WaterBill,OtherBill,Cleaning,LiftMaintenance FROM RecurringExpenses");
	   prp = connection.prepareStatement(sql.toString());
	   rs = prp.executeQuery();

	   while(rs.next()) {
			 electricityBill = rs.getFloat("ElectrictyBill");
			 waterBill = rs.getFloat("WaterBill");
			 otherBill = rs.getFloat("OtherBill");
			 cleaning = rs.getFloat("Cleaning");
			liftMaintenance = rs.getFloat("LiftMaintenance");
			}
	    totalBill = electricityBill+waterBill+otherBill+cleaning+liftMaintenance;
		//System.out.println(totalBill);
		
		   sql = new StringBuilder();
		   sql.append("SELECT PaintMaintenance,Repair FROM NonRecurringExpenses");
		   prp = connection.prepareStatement(sql.toString());
		   rs = prp.executeQuery();
		   
		   while(rs.next()) {
			   paintMaintenance = rs.getFloat("PaintMaintenance");
			   repair = rs.getFloat("Repair");
		   }
		   totalNon = (paintMaintenance+repair)/12; //(totalBill+totalNon) yazılacak.
		   //System.out.println(totalNon+totalBill);
		
		
		//System.out.println(totalDues);
				sql = new StringBuilder();
				sql.append(" UPDATE Apartment SET Income= "+totalDues+" WHERE ApartmentId= '30B'");
				sql = new StringBuilder();
				sql.append(" UPDATE Apartment SET Expense= "+(totalNon+totalBill)+" WHERE ApartmentId= '30B'"); //??
				sql = new StringBuilder();
				sql.append(" UPDATE Apartment SET NetMoney= "+(totalDues-(totalNon+totalBill))+" WHERE ApartmentId= '30B'");
				
				//sql.append(" UPDATE Apartment SET Income "+totalNon);
				
				int appendCount = 0;
				/*for (Map.Entry<String, Object> entry : updateParameters.entrySet()) {
					sql.append(entry.getKey() + " = " + DatabaseUtilities.formatField(entry.getValue()));
					if (++appendCount < updateParameters.size()) {
						sql.append(", ");
					}
				}
				List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
				sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
				//System.out.println(sql.toString());
				*/
			
				// execute constructed SQL statement
				//DatabaseUtilities.disconnect();
				Connection connectionn = DatabaseUtilities.getConnection();
				PreparedStatement preparedStatementt = connectionn.prepareStatement(sql.toString());
				//DatabaseUtilities.setWhereStatementParameters(preparedStatementt, whereParameterList);		
				int rowCount = preparedStatementt.executeUpdate();
				preparedStatementt.close();
				
				return rowCount;
		
	}

	@Override
	public int delete(Map<String, Object> whereParameters) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

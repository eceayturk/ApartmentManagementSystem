import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApartmentView implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		switch(operationName) {
		//case "select": 	return selectOperation(modelData) ;
		//case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		//case "delete": return deleteOperation(modelData);	
		//case "select.gui": return selectGUI(modelData);
		//case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
	//	case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("Controller", "");
		
		
	}
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
	
		
		if (resultSet != null) {
		 
			// !!!!!!!!!!!!!!
			System.out.print(" ApartmentName\tFlat Number\tDate\t\tAmount\n");
			while (resultSet.next()) {
				// Retrieve by column name
				String apartName = resultSet.getString("ApartmentName"); 	
				float income = resultSet.getFloat("Income");
	     		float expense = resultSet.getFloat("Expense");
	     		float netAmount = resultSet.getFloat("NetMoney");
				
				// Display values
				System.out.print(" "+apartName+"\t");
				System.out.print(income+"\t\t");
				System.out.print(expense+"\t");
				System.out.println(netAmount);
						
		    }
		resultSet.close();	
	   }
	return new ViewData("Controller", "");
	}
	ViewData updateOperation(ModelData modelData) throws Exception {
		
		
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("Manager", "");
	}
	
	

	ViewData updateGUI(ModelData modelData) throws Exception {
		
		//Map<String, Object> updateParameters = new HashMap<>();
		//if (income != null) updateParameters.put("Income", income);
		
		Map<String, Object> parameters = new HashMap<>();
		//parameters.put("updateParameters", updateParameters);
		//parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UpdateIncome", "update", parameters);
	}
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		String apartmentId = getString("Apartment ID : ", true);
		
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (apartmentId!= null) whereParameters.put("ApartmentId", apartmentId);
	
		
		return whereParameters;
	}

}

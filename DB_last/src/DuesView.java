import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuesView implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		switch(operationName) {
		case "select": 	return selectOperation(modelData) ;
		case "insert": return insertOperation(modelData);	
		//case "update": return updateOperation(modelData);	
		//case "delete": return deleteOperation(modelData);	
		//case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
	//	case "update.gui": return updateGUI(modelData);
	//	case "delete.gui": return deleteGUI(modelData);
		}
		
		//return new ViewData("Controller", "");
		return new ViewData("Manager","");
		
		
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
	
		
		if (resultSet != null) {
		
			System.out.print(" DuesId\tFlat Number\tDate\t\tAmount\n");
			while (resultSet.next()) {
				// Retrieve by column name
				int duesId = resultSet.getInt("DuesId");
				Date date = resultSet.getDate("Date");
	     		float amount = resultSet.getFloat("Amount");
		     	int flatNumber = resultSet.getInt("FlatNumber");
	      		
				
				// Display values
				System.out.print(" "+duesId+"\t");
				System.out.print(flatNumber+"\t\t");
				System.out.print(date+"\t");
				System.out.println(amount);
						
		    }
		resultSet.close();	
	   }
	return new ViewData("Controller", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("Manager", "");//?
	}
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "DuesId,Date,Amount,FlatNumber");
		
		List<Object> rows = new ArrayList<>();
		
		Integer duesId,flatNumber;
		String date;
		Double amount;
		

		do
		{
			System.out.println("Fields to insert:");
			duesId = getInteger("Due Id Number: ",true);
			date = getString("Date : ", true);
			amount = getDouble("Enter paid amount: ",true);
			flatNumber = getInteger("Flat Number: ",true);
			System.out.println();
					
			if (duesId != null && date !=null &&amount!=null &&flatNumber!=null) {
				rows.add(new Dues(duesId, date,amount,flatNumber));
			}
			
		}
		while (duesId != null && date !=null &&amount!=null &&flatNumber!=null);
	
		parameters.put("rows", rows);
		
		return new ViewData("Dues", "insert", parameters);
		
		

	}
	
	
	

	
}

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NonRecurringExpensesView implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		switch(operationName) {
		case "select": 	return selectOperation(modelData) ;
		//case "insert": return insertOperation(modelData);	
		//case "update": return updateOperation(modelData);	
		//case "delete": return deleteOperation(modelData);	
		//case "select.gui": return selectGUI(modelData);
		//case "insert.gui": return insertGUI(modelData);
	//	case "update.gui": return updateGUI(modelData);
	//	case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("Controller", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
			
		if (resultSet != null) {

			System.out.print(" Year\tInnovation   Paint Maintance\tRepair\n");
			while (resultSet.next()) {
				// Retrieve by column name
				Date year = resultSet.getDate("Year");
	     		float innovation = resultSet.getFloat("Innovation"); 		
	     		float paintMaintance = resultSet.getFloat("PaintMaintenance") ;
	     		float repair = resultSet.getFloat("Repair");
	     		
				// Display values
				System.out.print(" "+year.toString().substring(0, 4)+"\t");
				System.out.print(innovation+"\t\t");	
				System.out.print(paintMaintance+"\t\t");
				System.out.print(repair+"\t");
				
		    }
		resultSet.close();	
	   }
	return new ViewData("Controller", "");
	}
	
	
	

}

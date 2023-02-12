import java.sql.ResultSet;
import java.util.Date;

public class RecurringExpensesView implements ViewInterface{

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

			System.out.print(" ExpenseId\tDate\t  Electricty Bill\t  Water Bill\t  Cleaning\tLiftMaintenance\n");
			while (resultSet.next()) {
				// Retrieve by column name
				int ExpenseId = resultSet.getInt("ExpenseId");
				Date date = resultSet.getDate("Date");
	     		float ElectrictyBill = resultSet.getFloat("ElectrictyBill");
	     		String electBillFlag = resultSet.getString("ElectrictyBillPaidFlag") ;
	     		float WaterBill = resultSet.getFloat("WaterBill");
	     		String waterBillFlag = resultSet.getString("WaterBillPaidFlag") ;
	     		float Cleaning = resultSet.getFloat("Cleaning");
	     		float LiftMaintenance = resultSet.getFloat("LiftMaintenance");
	     		
	  
				
				// Display values
				System.out.print(" "+ExpenseId+"\t\t");
				System.out.print(date+"\t");
				if(electBillFlag.charAt(0)=='T')
				    System.out.print(ElectrictyBill+"(Paid)\t ");
				else 
			        System.out.print(ElectrictyBill+"(Not Paid)\t");
				if(waterBillFlag.charAt(0)=='T')
					 System.out.print(WaterBill+"(Paid)\t ");
				else 
				     System.out.print(WaterBill+"(Not Paid)\t");	
				System.out.print(Cleaning+"\t\t");
				System.out.print(LiftMaintenance+"\t");
				
		    }
		resultSet.close();	
	   }
	return new ViewData("Controller", "");
	}	
		
		
		
	

}

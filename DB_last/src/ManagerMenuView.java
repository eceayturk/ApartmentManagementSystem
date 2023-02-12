import java.util.HashMap;
import java.util.Map;

public class ManagerMenuView implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		Integer choice;
		do {
			System.out.println("1. Collect Dues ");
			System.out.println("2. Update Aparment's Income and Expense");
			System.out.println("3. Add Resident");
			System.out.println("4. Remove Resident");
			System.out.println("5. Exit");
			System.out.println();

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 6);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "insert.gui";  
		    return new ViewData("Dues", operationName, new HashMap<>());   
		case 2: operationName = "update.gui";
	    	return new ViewData("UpdateIncome", operationName, new HashMap<>()); 
		case 3: operationName = "insert.gui";	
			return new ViewData("Resident", operationName, new HashMap<>());
		case 4: operationName = "delete.gui";
			return new ViewData("Resident",operationName,new HashMap<>());
		default: return new ViewData(null,null);
		
		}
		
		//return new ViewData("","");
		
	}

}

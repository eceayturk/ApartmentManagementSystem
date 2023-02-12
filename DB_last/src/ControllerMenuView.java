import java.util.HashMap;
import java.util.Map;

public class ControllerMenuView implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		Integer choice;
		do {
			System.out.println("1. Show All Dues");
			System.out.println("2. Show Recurring Expenses ");
			System.out.println("3. Show NonRecurring Expenses ");
			System.out.println("4. Net Amount of Money  ");
			System.out.println("5. Exit");
	     	System.out.println();

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 6);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1:operationName = "select";	
	           return new ViewData("Dues", operationName, new HashMap<>());    	
		case 2: operationName = "select";
		       return new ViewData("Recurring Expenses",operationName,new HashMap<>()) ; 
		case 3: operationName = "select";	
		       return new ViewData("NonRecurring Expenses",operationName,new HashMap<>()) ; 
		case 4:operationName = "select";
		       return new ViewData("NetAmount",operationName,new HashMap<>()) ;  
		default: return new ViewData(null,null);   // 5. exit 
		}
		
		
		
		
	}

	
	
	
}

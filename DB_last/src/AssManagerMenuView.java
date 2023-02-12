import java.util.HashMap;
import java.util.Map;

public class AssManagerMenuView implements ViewInterface{

	
	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		Integer choice;
		do {
			System.out.println(" 1. Add resident");
			System.out.println(" 2. Remove resident");
			System.out.println(" 3. Exit");
			
			System.out.println();

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 3);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "insert.gui";	
			return new ViewData("Resident", operationName, new HashMap<>());
	    case 2: operationName = "delete.gui";
			return new ViewData("Resident",operationName,new HashMap<>());
		default:  return new ViewData(null,null);
		}
		
		
		
	}	
		
	
	
}

import java.util.HashMap;
import java.util.Map;

public class MainMenuView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		Integer choice;
		do {
			 System.out.println("APARTMANT MANAGEMENT\n");
			System.out.println(" 1. Manager");
			System.out.println(" 2. Controller");
			System.out.println(" 3. Assistant Manager");
			System.out.println(" 4. Exit");
	 		System.out.println();

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 4);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: functionName = "ManagerMVC";		    break;
		case 2: functionName = "ControllerMVC";	    break;
		case 3: functionName = "AssManagerMVC";	break;
		default: return new ViewData(null,null); 
		}
		
		return new ViewData(functionName, ""); // , new HashMap<>()
	}

}

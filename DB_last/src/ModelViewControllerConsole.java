import java.util.HashMap;
import java.util.Map;

public class ModelViewControllerConsole {

	public static void main(String[] args) throws Exception {

		connectToDatabase();
		
		Map<String, Controller> router = new HashMap<>();
		router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
		router.put("ManagerMVC", new Controller(new ManagerMVC(), new NopModel()));
		router.put("ControllerMVC", new Controller(new ControllerMVC(), new NopModel()));
		router.put("AssManagerMVC", new Controller(new AssManagerMVC(), new NopModel()));
		
		
		ViewData viewData = new ViewData("MainMenu", "");
		
		do {
			
		 //   System.out.println(viewData.functionName);	
	        System.out.println();
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);		
			ModelData modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			System.out.println("******************************************************");
			System.out.println();
		}
		while (viewData.functionName != null);
	    
		
		disconnectFromDatabase() ;
		System.out.println("End of the program ... ");
	}
	
// connect to database 
	public static void connectToDatabase() {
		DatabaseUtilities.host = "localhost:49681";
		DatabaseUtilities.databaseName = "ApartmentManagement";
		
		try {
			DatabaseUtilities.getConnection();
		}
		catch(Exception e) {
			System.out.println("Exception occured : " + e);
			return;
		}		
	}
// disconnect
	public static void disconnectFromDatabase() {
		try {
			DatabaseUtilities.disconnect();
		}
		catch(Exception e) {
			System.out.println("Error disconnecting from database : " + e);
			return;
		}		
	}

}

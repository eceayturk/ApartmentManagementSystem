import java.util.HashMap;
import java.util.Map;

public class AssManagerMVC implements ViewInterface{

	
	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
	  
		
		
		Map<String, Controller> router = new HashMap<>();
		router.put("Manager", new Controller(new AssManagerMenuView(), new NopModel()));
		router.put("Resident", new Controller(new ResidentView(), new ResidentModel()));	
		router.put("Residentt", new Controller(new ResidentView(), new ResidentModel()));	
		
	
		
		ViewData viewData = new ViewData("Manager", "");
		
		do {
			if(viewData.functionName.equals("Manager")) {
				 System.out.println("Assistant "+viewData.functionName);
			}else {
				 System.out.println(viewData.functionName);
			}
		   
		    System.out.println();
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);		
			modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			System.out.println("******************************************************");
			System.out.println();
		}
		while (viewData.functionName != null);
		
		
		//	disconnectFromDatabase() ;
		System.out.println("Turning to Main Menu ... ");
				
		return new ViewData("MainMenu", ""); // the last 
	
	}

	
}

import java.util.HashMap;
import java.util.Map;

public class ManagerMVC implements ViewInterface{


	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		// //connectToDatabase();
		
		Map<String, Controller> router = new HashMap<>();
		router.put("Manager", new Controller(new ManagerMenuView(), new NopModel()));
		router.put("Dues", new Controller(new DuesView(), new DuesModel()));	
		router.put("UpdateIncome", new Controller(new ApartmentView(), new ApartmentModel()));	
		router.put("Resident", new Controller(new ResidentView(), new ResidentModel()));	
		router.put("Residentt", new Controller(new ResidentView(), new ResidentModel()));	
	
		
		ViewData viewData = new ViewData("Manager", "");
		
		do {
			
		    System.out.println(viewData.functionName);	
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
		
		
		
		
		return new ViewData("MainMenu","") ;
	}

}

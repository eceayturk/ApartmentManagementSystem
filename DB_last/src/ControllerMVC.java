import java.util.HashMap;
import java.util.Map;

public class ControllerMVC  implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
	
		Map<String, Controller> router = new HashMap<>();
		router.put("Controller", new Controller(new ControllerMenuView(), new NopModel()));
		router.put("Dues", new Controller(new DuesView(), new DuesModel() ));
		router.put("Recurring Expenses", new Controller(new RecurringExpensesView(), new RecurringExpensesModel() ));
		router.put("NonRecurring Expenses", new Controller(new NonRecurringExpensesView(), new NonRecurringExpensesModel() ));
		router.put("NetAmount", new Controller(new ApartmentView(), new ApartmentModel() ));
		
		
		
		ViewData viewData = new ViewData("Controller", "");
		
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
	    
	
		System.out.println("Turning to Main Menu ... ");
				
		return new ViewData("MainMenu", ""); // the last 
	}

}

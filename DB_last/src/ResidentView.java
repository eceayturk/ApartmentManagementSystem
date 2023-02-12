import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResidentView implements ViewInterface{

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		switch(operationName) {
		//case "select": 	return selectOperation(modelData) ;
		case "insert": return insertOperation(modelData);	
		//case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		//case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
	//	case "update.gui": return updateGUI(modelData);
	    case "delete.gui": return deleteGUI(modelData);
		}
		
		//return new ViewData("Controller", "");
		return new ViewData("Manager","");
		
	}

	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("Manager", "");
	}
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", 
		"IDNumber,Name,MiddleName,Surname,Gender,BirthDate,FlatNumber,LivedApartmentId,startDate,endDate,phoneNumber,email"
				);
		
		List<Object> rows = new ArrayList<>();
		

		
		Integer flatNumber;
		String IDNumber,name,middleName,surname,gender,
		birthDate,livedApartmentId,startDate,endDate,email,phoneNumber;
	
		do
		{
			System.out.println("Fields to insert:");
			IDNumber = getString("ID Number: ",true);
			name = getString("Name: ",true);
			middleName = getString("Middle Name: ",true);
			surname = getString("Surname: ",true);
			gender = getString("Gender: ",true);
			birthDate = getString("Birth Date: ",true);
			flatNumber = getInteger("Flat Number: ",true);
			livedApartmentId = getString("Lived Apartment ID: ",true);
			startDate = getString("Start Date: ",true);
			endDate = getString("End Date: ",true);
			phoneNumber = getString("Phone Number: ",true);
			email = getString("Email : ", true);

			
			System.out.println();
					//hepsini eklemek zorunda kaldık nullable problemlerini çözemedik.
			if (IDNumber != null && name !=null && middleName!=null&& surname!=null && gender!=null&&
					birthDate !=null &&  flatNumber!=null && livedApartmentId!=null && startDate!=null &&endDate!=null
					&&phoneNumber!=null &&email!=null) {
				rows.add(new Resident(IDNumber,name,middleName,surname,gender,birthDate,flatNumber,livedApartmentId,
						startDate,endDate,phoneNumber,email));
			}
			//System.out.println(rows.get(0).toString());
			
		}
		while (IDNumber != null && name !=null && middleName!=null&& surname!=null && gender!=null&&
				birthDate !=null &&  flatNumber!=null && livedApartmentId!=null && startDate!=null &&endDate!=null
				&&phoneNumber!=null &&email!=null );
		
		parameters.put("rows", rows);
		
		return new ViewData("Resident", "insert", parameters);
		
		

	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("Manager", "");
	}	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		String IDNumber = getString("ID Number : ", true);

		
		Map<String, Object> whereParameters = new HashMap<>();
		if (IDNumber != null) whereParameters.put("IDNumber", IDNumber);
		
		
		
		return whereParameters;
	}
	
	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		
		return new ViewData("Residentt", "delete", parameters);//?
	}
	
	
	
	
	
	
}

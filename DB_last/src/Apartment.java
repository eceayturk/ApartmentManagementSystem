
public class Apartment {
     
	private String apartId ,apartName,password,Iban;
	private int numOfFlat;
	private float income , expense, netAmount ;
	
	public Apartment() {
		
	}
    public Apartment(String apartId,String apartName,String password,String Iban,int numOfFlat,float income,float expense,float netAmount) {
		this.apartId = apartId ;
		this.apartName = apartName ;
		this.password = password ;
		this.Iban = Iban  ;
		this.numOfFlat = numOfFlat ;
		this.income = income ;
		this.expense = expense ;
		this.netAmount = netAmount ; 
  	}
	public void setApartId(String apartId) {
		this.apartId = apartId ;
	}
	public void setApartName(String apartName ){
		this.apartName = apartName ;
	}
	public void setPassWord(String password) {
		this.password = password ;
	}
	public void setIban(String Iban) {
		this.Iban = Iban ;
	}
	public void setNumberOfFlat(int numOfFlat) {
		this.numOfFlat = numOfFlat ;
	}
	public void setIncome(float income) {
		this.income= income ;
	}
	public void setExpense(float expense) {
		this.expense = expense ;
	}
	public void setNetAmount(float amount) {
		this.netAmount = amount ;
	}
	public String getApartId() {
		return apartId ;
	}
	public String getAparName() {
		return apartName ;
	}
	public String getGetPassWord() {
		return password ;
	}
	public String getIban() {
		return Iban ; 
	}
    public int getNumOfFlat() {
    	return numOfFlat ;
    }
    public float getIncome()  {
    	return income ; 
    }
    public float getExpense() {
    	return expense ;
    }
    public float getNetAmount() {
    	return netAmount ;
    }
    
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "ApartmentId": return apartId;
		case "ApartmentName": return apartName;
		case "NumberOfFlats": return numOfFlat ;
		case "EntryPassword": return password;
		case "IBAN": return Iban;
		case "Income": return income ;
		case "Expense": return expense;
		case "NetMoney": return netAmount;
		
		default: return null;
		}
	}
    
}

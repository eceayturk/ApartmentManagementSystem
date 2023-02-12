import java.util.Date;

public class Dues {
   
	private int duesId;
	private int flatNumber;
	private double amount;
	private String date;
	
	public Dues() {  }
	
	public Dues(int duesId, String date, double  amount,int flatNumber ) {
	
	   this.duesId = duesId ;
	   this.flatNumber = flatNumber ;
	   this.amount = amount ;
	   this.date = date ;
    }
	
    public int getDuesID() { return duesId ; }
	
	public void setDuesID(short duesId) { this.duesId = duesId; }
	
	public int getFlatNumber() { return flatNumber; }
	
	public void setFlatNumber(Short flatNumber) { this.flatNumber = flatNumber; }
	
	public double getAmount() { return amount; }
	
	public void setAmount(double amount) { this.amount = amount; }
	
	public String getDate() { return date; }	
	
	public void setDate(String date) { this.date = date; }
	 
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "DuesId": return duesId;
		case "FlatNumber": return flatNumber;
		case "Amount": return amount;
		case "Date": return date;
		default: return null;
		}
	}
	@Override
	public String toString() {
		return duesId + ", " + flatNumber + ", " + amount + ", " + date;
	}
	
	
	
}

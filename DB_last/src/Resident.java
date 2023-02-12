
public class Resident {

	
	private String IDNumber;
	
	private String name;
	private String middleName;
	private String surname;
	private String gender;
	private String birthDate;
	private int flatNumber;
	private String livedApartmentId;
	private String startDate;
	private String endDate;
	private String phoneNumber;
	private String email;
	
	public Resident(String iDNumber, String name, String middleName, String surname, String gender, String birthDate,
			int flatNumber, String livedApartmentId, String startDate, String endDate, String phoneNumber,
			String email) {
		this.IDNumber = iDNumber;
		this.name = name;
		this.middleName = middleName;
		this.surname = surname;
		this.gender = gender;
		this.birthDate = birthDate;
		this.flatNumber = flatNumber;
		this.livedApartmentId = livedApartmentId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return birthDate;
	}
	public void setDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getLivedApartmentId() {
		return livedApartmentId;
	}
	public void setLivedApartmentId(String livedApartmentId) {
		this.livedApartmentId = livedApartmentId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "IDNumber": return IDNumber;
		case "Name": return name;
		case "MiddleName": return middleName;
		case "Surname": return surname;
		case "Gender": return gender;
		case "BirthDate": return birthDate;
		case "FlatNumber": return flatNumber;
		case "LivedApartmentId": return livedApartmentId;
		case "startDate": return startDate;
		case "endDate": return endDate;
		case "phoneNumber": return phoneNumber;
		case "email": return email;
		default: return null;
		}
		
	}
	@Override
	public String toString() {
		return IDNumber+ ", " + name+ ", " + middleName + ", " +surname+ ", " +gender+ ", " +
				birthDate+ ", " +flatNumber+ ", " +livedApartmentId+ ", " + startDate+ ", " +endDate+ ", " +
				phoneNumber+ ", " +email;
	}
	
	
	
}

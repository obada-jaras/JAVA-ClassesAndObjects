import java.util.Calendar;
import java.util.GregorianCalendar;

public class Owner implements Cloneable {
	String name;
	String registrationNo;
	String address;
	String tel;
	Calendar dateOfRegistration;
	
	
	
	//constructors 
	public Owner() {
		dateOfRegistration = new GregorianCalendar();			//the default date of registration is now
	}

	
	public Owner(String name, String registrationNo, String address, String tel) {
		super();
		this.name = name;
		this.registrationNo = registrationNo;
		this.address = address;
		this.tel = tel;
		this.dateOfRegistration = new GregorianCalendar();		//the default date of registration is now
	}

	
	public Owner(String name, String registerionNo, String address, String tel, Calendar dateOfRegistration) {
		super();
		this.name = name;
		this.registrationNo = registerionNo;
		this.address = address;
		this.tel = tel;
		this.dateOfRegistration = dateOfRegistration;			//the default date of registration is now
	}
	//**end constructors 

	
	
	
	//setters and getters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegisterionNo() {
		return registrationNo;
	}
	
	public void setRegisterionNo(String registerionNo) {
		this.registrationNo = registerionNo;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Calendar getDateOfRegistration() {
		return dateOfRegistration;
	}
	
	public void setDateOfRegistration(Calendar dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	//end setters and getters
	
	
	
	
	//override toString method to print owner info
	@Override
	public String toString() {
		@SuppressWarnings("static-access")	//to hide warnings
		String dateOfRegistrationStr = dateOfRegistration.get(dateOfRegistration.DATE) + "-" + dateOfRegistration.get(dateOfRegistration.MONTH) + dateOfRegistration.get(dateOfRegistration.YEAR);
		
		return "Name: " + name + ", RegisterionNo: " + registrationNo + ", Address: " + address + ", Telephone: " + tel
				+ ", Date Of Registration: " +dateOfRegistrationStr ;
	}


	
	
	//override the clone method to clone objects
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

package classes;

public class Person{

	private String name;
	private String address;
	private String email;
	private String mobileNo;

	public Person(){};
	public Person(String name, String address, String email, String mobileNo){
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setMobileNo(String mobileNo){
		this.mobileNo = mobileNo;
	}

	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public String getEmail(){
		return email;
	}
	public String getMobileNo(){
		return mobileNo;
	}

	public void showDetails(){
		System.out.println("\nName : " + name);
		System.out.println("Address : " + address);
		System.out.println("Email : " + email);
		System.out.println("Mobile Number : " + mobileNo);
	}
}
package classes;

public class User extends Person{
	private String password;
	private int meterNo;
	private String[] paymentHistory = new String[20];

	public User(){};
	public User(String name, String address, String email, String mobileNo, String password, int meterNo){
		super(name, address, email, mobileNo);
		this.password = password;
		this.meterNo = meterNo;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setMeterNo(int meterNo){
		this.meterNo = meterNo;
	}
	public String getPassword(){
		return password;
	}
	public int getMeterNo(){
		return meterNo;
	}

	public void showDetails(){
		System.out.println("\nName : " + getName());
		System.out.println("Address : " + getAddress());
		System.out.println("Email : " + getEmail());
		System.out.println("Mobile Number : " + getMobileNo());
		System.out.println("Meter No : " + meterNo);
		System.out.println("");
	}

	public void setPaymentHistory(String history){
		for (int i=0; i<20; i++) {
			if (paymentHistory[i] == null) {
				paymentHistory[i] = history;
				break;
			}
		}
	}
	public void getPaymentHistory(){
		for (int i=0; i<20; i++) {
			if (paymentHistory[i] != null) {
				System.out.println(paymentHistory[i]);
			}
		}
		System.out.println("\n");
	}
}
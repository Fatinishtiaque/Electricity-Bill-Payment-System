package classes;
import interfaces.*;

public class ElectricityBilling implements UserOperations, SystemOperations{
	private User user[] = new User[50];

	public void newUser(User us){
		int i=0;
		while(i<50){
			if(user[i] == null){
				user[i] = us;
				System.out.println("\nUser Created.\n");
				break;
			}
		  i++;
		}
	}
	public void deleteUser(int mn){
		int i=0;
		while(i<50){
			if (user[i] != null) {
				if(user[i].getMeterNo() == mn){
					user[i] = null;
					System.out.println("\nUser Deleted.\n");
					break;
				}
			}
		  i++;
		}
	}
	public boolean doesAccountExist(String em){
		int i=0;
		boolean acc = false;
		while(i<50){
			if(user[i] != null){
				if(user[i].getEmail().equals(em)){
					acc = true;
					break;
				}
			}
		  i++;
		}
	  return acc;
	}
	public boolean isPasswordCorrect(String pass){
		int i=0;
		boolean passCorr = false;
		while(i<50){
			if(user[i] != null){
				if(user[i].getPassword().equals(pass)){
					passCorr = true;
					break;
				}
			}
		  i++;
		}
	  return passCorr;
	}
	public boolean isMeterNoCorrect(int mn){
		int i=0;
		boolean meterCorr = false;
		while(i<50){
			if(user[i] != null){
				if(user[i].getMeterNo() == mn){
					meterCorr = true;
					break;
				}
			}
		  i++;
		}
	  return meterCorr;
	}
	public void showAccInfo(int mn){
		int i=0;
		while(i<50){
			if (user[i] != null) {
				if(user[i].getMeterNo() == mn){
					user[i].showDetails();
					break;
				}
			}
		  i++;
		}
	}
	public double calculateBill(double uc){
		double bill = 0.0;
		if (uc<=100) {
			bill = uc*5;
		}else if(uc<=200){
			bill = uc*7;
		}else if(uc<=300){
			bill = uc*10;
		}else if (uc>300) {
			bill = (100*5) + (100*7) + (100*10) + (uc-300)*15;
		}else{
			System.out.println("\nThe Number of Unit is Wrong.\n");
		}
	  return bill;
	}
	public void paymentOption(double uc, double bill, int meter, String month){
		System.out.println("\n\n Payment Succesfull.\n");
		for (int i=0; i<50; i++) {
			if(user[i] != null){
				if(user[i].getMeterNo() == meter){
					user[i].showDetails();
					System.out.println("\nMonth : " + month);
					System.out.println("Total Unit : " + uc);
					System.out.println("Bill : " + bill);
					System.out.println("Payment Method : Bkash.");
					user[i].setPaymentHistory("Bill("+bill+") | Unit("+uc+") | Month("+month+")");
					break;
				}
			}
		}
	}
	public void showPaymentHistory(int meter){
		int i=0;
		while(i<50){
			if (user[i] != null) {
				if(user[i].getMeterNo() == meter){
					user[i].getPaymentHistory();
					break;
				}
			}
		  i++;
		}
	}
	public void showAllUsers(){
		int i=0;
		while(i<50){
			if (user[i] != null) {
				user[i].showDetails();
			}
		  i++;
		}
	}
}
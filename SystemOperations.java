package interfaces;
import classes.*;

public interface SystemOperations{
	double calculateBill(double uc);
	void paymentOption(double uc, double bill, int meter, String month);
	void showPaymentHistory(int meter);
	void showAllUsers();
}
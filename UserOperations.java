package interfaces;
import classes.*;

public interface UserOperations{
	void newUser(User us);
	void deleteUser(int mn);
	void showAccInfo(int mn);
	boolean doesAccountExist(String em);
	boolean isPasswordCorrect(String pass);
	boolean isMeterNoCorrect(int mn);
}
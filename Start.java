import classes.*;
import interfaces.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class Start{
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(isr);
		ElectricityBilling ec = new ElectricityBilling();
		int opt = 0;

		do {
			System.out.println("\n\n");
			System.out.println("Home Page.\n");
			System.out.println("1. User.");
			System.out.println("2. Worker.");
			System.out.println("3. Exit.\n");
			
			try{
				System.out.print("What do you want to do : ");
				opt = myObj.nextInt();
			}
			catch(Exception e){
				myObj.next();
			}

			switch(opt){
				case 1:
					int choice1 = 0;
					do{
						System.out.println("\nUser Page:\n");
						System.out.println("1. New User.");
						System.out.println("2. Existing User.");
						System.out.println("3. Exit.\n");
						System.out.print("What do you want to do : ");
						choice1 = myObj.nextInt();

						switch(choice1){
							case 1:
								{
									String name="", email="", address= "", phone_no="", password = "";
									int meterNo = 0;
									try{
										System.out.print("Name : ");
										name = bfr.readLine();
									}
									catch(IOException ioe) {
			                        	System.out.println("\nSomething is Wrong.\n");
		                        	}
									System.out.print("Email : ");
									email = myObj.next();
									
		                        	try{
										System.out.print("Address : ");
										address = bfr.readLine();
									}
									catch(IOException ioe) {
			                        	System.out.println("\nSomething is Wrong.\n");
		                        	}
		                        	
									System.out.print("Phone No : ");
									phone_no = myObj.next();
									
		                        	
									System.out.print("Password : ");
									password = myObj.next();
									
									
									try{
										System.out.print("Meter No : ");
										meterNo = myObj.nextInt();
									}
									catch(Exception e){
										myObj.next();
									}

									User us = new User(name, address, email, phone_no, password, meterNo);
									ec.newUser(us);
									break;
								}

							case 2:
								{
									String email, password;
									int meterNo = 0;
									boolean accExist = false, passCorr = false, meterCorr = false;

									System.out.println("\n Log In : \n");
									System.out.print("Email : ");
									email = myObj.next();
									accExist = ec.doesAccountExist(email);
									if(!accExist){
										System.out.println("\nAccount Doesn't Exist.\n");
										break;
									}
									else {
										System.out.print("Password : ");
										password = myObj.next();
										passCorr = ec.isPasswordCorrect(password);
										if(!passCorr){
											System.out.println("\nPassword Incorrect.\n");
											break;
										}else{
											try{
												System.out.print("Meter No : ");
												meterNo = myObj.nextInt();
											}
											catch(Exception e){
												myObj.next();
											}

											meterCorr = ec.isMeterNoCorrect(meterNo);
											if (!meterCorr) {
												System.out.println("\nInvalid Meter No,\n");
												break;
											}else{
												int choice2 = 0;
												do{
													System.out.println("\nLog In Succesfull.\n");
													System.out.println("1. Show Account Information.");
													System.out.println("2. Delete Account.");
													System.out.println("3. Pay Bill.");
													System.out.println("4. Show Payment History.");
													System.out.println("5. Return Back.\n");
													try{
														System.out.print("What do you want to do : ");
														choice2 = myObj.nextInt();
													}
													catch(Exception e){
														myObj.next();
													}

													switch(choice2){
														case 1:
															ec.showAccInfo(meterNo);
															break;
														case 2:
															ec.deleteUser(meterNo);
															break;
														case 3:
															{
																double unit = 0, bill;
																String bkashNo, month;
																int pin;
																System.out.print("\nEnter Month Name : ");
																month = myObj.next();

																try{
																	System.out.print("\nTotal Unit Used : ");
																	unit = myObj.nextDouble();
																}
																catch(Exception e){
																	myObj.next();
																}

																bill = ec.calculateBill(unit);
																if(bill > 0){
																	System.out.println("\nPayment Option : \n");
																	System.out.println("Bill : " + bill + "tk");
																	System.out.print("\nEnter Bkash Number : ");
																	bkashNo = myObj.next();

																	try{
																		System.out.print("Enter PIN : ");
																		pin = myObj.nextInt();
																	}
																	catch(Exception e){
																		myObj.next();
																	}
																	ec.paymentOption(unit, bill, meterNo, month);
																}
															}
															break;
														case 4:
															System.out.println("\n\nPayment History\n");
															ec.showPaymentHistory(meterNo);
															break;
														case 5:
															System.out.println("\nReturned Back.\n");
															break;
														default:
															System.out.println("\nWrong Input.\n");
													}
												}while(choice2 != 5);
											}
										}
									}
									break;
								}

							case 3:
								System.out.println("\nExited.\n");
								break;
							default:
								System.out.println("\nWrong Input.\n");
						}
					}while(choice1 != 3);
					break;
				case 2:
					int choice3 = 0;
					do{
						System.out.println("\n\n1. See All Users.");
						System.out.println("2. Return Back.\n");
						try{
							System.out.print("What do you want to do : ");
							choice3 = myObj.nextInt();
						}
						catch(Exception e){
							myObj.next();
						}

						switch(choice3){
							case 1:
								System.out.println("\n\n\nShowing All User Details : ");
								ec.showAllUsers();
								break;
							case 2:
								System.out.println("\nReturned Back.\n");
								break;
							default:
								System.out.println("\nWrong Input.\n");
						}
					}while(choice3 != 2);
					break;
				case 3:
					System.out.println("\nExited.\n");
					break;
				default:
					System.out.println("\nWrong Input.\n");
			}
		} while(opt != 3);
	}
}
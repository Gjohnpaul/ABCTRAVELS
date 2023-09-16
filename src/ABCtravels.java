import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.List;

class User {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private String email;
    private String password;
    private int failedCount;
    private boolean accountStatus;
    public String Exit;

    public String getExit() {
        return Exit;
    }

    public void setExit(String exit) {
        Exit = exit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", failedCount=" + failedCount +
                ", accountStatus=" + accountStatus +
                '}';
    }
}

public class ABCtravels {
    private static List<User> adminUsers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (displayLogo()) {
            boolean loggedIn = login();
            if (loggedIn) {
                
                while (true) {
                    System.out.println("\nMain Menu");
                    System.out.println("1. registerAdminUser");
                    System.out.println("2. plan Journey");
                    System.out.println("3. Reschedule Journey");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                    case 1:
                        registerAdminUser();
                        break;
                        case 2:
                            boolean journeyPlanned = planJourney();
                            if (journeyPlanned) {
                                System.out.println("Journey planned successfully.");
                            }
                            break;
                        case 3:
                            rescheduleJourney();
                            break;
                        case 4:
                            System.out.println("Exiting...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                            break;
                    }
                }
            } else {
                System.out.println("Login failed. Exiting...");
            }
        } else {
            System.out.println("Failed to load the logo. Exiting...");
        }
    }




	private static boolean login() {
		
		return true;
	}




	private static void rescheduleJourney() {
	    System.out.println("\nReschedule Your Journey");
	    System.out.print("Do you want to reschedule the journey (yes/no)? ");
	    String rescheduleChoice = scanner.nextLine();
	    if (rescheduleChoice.equalsIgnoreCase("yes")) {
	    	System.out.println("Journey successfully rescheduled.");
	    } else {
	        System.out.println("Journey rescheduling canceled.");
	    }
	}
	    


	public static boolean planJourney() {
	    System.out.println("\nPlan Your Journey");	    
	    System.out.print("Enter Source: ");
	    String source = scanner.nextLine();
	    System.out.print("Enter Destination: ");
	    String destination = scanner.nextLine();
	    System.out.print("Enter Travel Date (YYYY-MM-DD): ");
	    String travelDate = scanner.nextLine();    

	    System.out.print("Enter Number of Passengers: ");
	    int numberOfPassengers = scanner.nextInt();
	    scanner.nextLine();
	    double baseFare = calculateBaseFare(source, destination, numberOfPassengers);

	    boolean isWeekend = isWeekend(travelDate);	    
	    double gstAmount = calculateGST(baseFare, isWeekend);
	    double totalFare = baseFare + gstAmount;
	    System.out.println("Booking Confirmation:");
	    System.out.println("Source: " + source);
	    System.out.println("Destination: " + destination);
	    System.out.println("Travel Date: " + travelDate);
	    System.out.println("Number of Passengers: " + numberOfPassengers);
	    System.out.println("Base Fare: " + baseFare + " Rupees");
	    System.out.println("GST (20%): " + gstAmount + " Rupees");
	    System.out.println("Total Fare: " + totalFare + " Rupees");
	    System.out.print("Do you want to reschedule the journey (yes/no)? ");
	    String rescheduleChoice = scanner.nextLine();
	    if (rescheduleChoice.equalsIgnoreCase("yes")) {
	    	return  planJourney();
	        
	    }
	    
	   
	    return true;
	}
	

	
	public static double calculateBaseFare(String source, String destination, int numberOfPassengers) {
		double basePricePerPassenger = 500.0;
		 double baseFare = basePricePerPassenger * numberOfPassengers;

		    return baseFare;
		}
	

	public static boolean isWeekend(String travelDate) {
	    	    return false; 
	}

	public static double calculateGST(double calculateBaseFare, boolean isWeekend) {
	    double gstRate = 0.180; 
	    double gstAmount = calculateBaseFare * gstRate;

	    if (isWeekend) {
	        gstAmount += 200.0; 	    }

	    return gstAmount;
	    
	}




	public static boolean displayLogo() {
        try {
            final ImageIcon logoIcon = new ImageIcon(ABCtravels.class.getResource("/john.jpeg"));
            final JFrame frame = new JFrame("Company Logo");
            final JLabel logoLabel = new JLabel(logoIcon);
            frame.add(logoLabel);
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            return true;
        } catch (final Exception e) {
            System.out.println("Error loading the logo: " + e.getMessage());
            return false;
        }
    }

    public static void registerAdminUser() {
        System.out.println("\n User Registration");
        System.out.println("Please enter the following menu details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        String gender;
        do {
            System.out.print("Gender (Male/Female/Other): ");
            gender = scanner.nextLine();
            if (!isValidGender(gender)) {
                System.out.println("Invalid gender. Please enter 'Male,' 'Female,' or 'Other'.");
            }
        } while (!isValidGender(gender));

        String mobileNumber;
        do {
            System.out.print("Mobile Number (10 digits): ");
            mobileNumber = scanner.nextLine();
            if (!isValidMobileNumber(mobileNumber)) {
                System.out.println("Invalid mobile number. Please enter a 10-digit number.");
            }
        } while (!isValidMobileNumber(mobileNumber));
        String email;
        do {
            System.out.print("Email Id: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. ");
            }
        } while (!isValidEmail(email));

        String password;
        do {
            System.out.print("Password at least 6 characters and special characters: ");
            password = scanner.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Invalid password format.");
            }
        } while (!isValidPassword(password));

        boolean loginSuccessful = false;
        int loginAttempts = 0;
        while (!loginSuccessful && loginAttempts < 5) {
            System.out.print("Login (Email): ");
            String loginEmail = scanner.nextLine();
            System.out.print("Password: ");
            String loginPassword = scanner.nextLine();
            if (isValidLogin(loginEmail, loginPassword, email, password)) {
                System.out.println("Login successful.");
                loginSuccessful = true;
                System.exit(0); 
            } else {
                System.out.println("Invalid login credentials. Please try again.");
                loginAttempts++;
            }
        }
        if (loginAttempts >= 5) {
            System.out.println("Too many invalid login attempts. Account locked.");
            loginSuccessful = false;
        }

        scanner.close();
    }

    private static boolean isValidGender(String gender) {
        String confirmation = gender.toLowerCase();
        return confirmation.equals("male") || confirmation.equals("female") || confirmation.equals("other");
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("\\d{10}");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()-=_+\\[\\]{}|;:',.<>/?].*");
    }

    private static boolean isValidLogin(String inputEmail, String inputPassword, String correctEmail, String correctPassword) {
        return inputEmail.equals(correctEmail) && inputPassword.equals(correctPassword);
    }

    private static void rescheduleJourney1() {
        System.out.println("\nReschedule Your Journey");
        System.out.print("Do you want to reschedule the journey (yes/no)? ");
        String rescheduleChoice = scanner.nextLine();
        if (rescheduleChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter the new travel date (YYYY-MM-DD): ");
            String newTravelDate = scanner.nextLine();
            System.out.println("Journey successfully rescheduled to " + newTravelDate + ".");
        } else {
            System.out.println("Journey rescheduling canceled.");
        }
    }
}

    

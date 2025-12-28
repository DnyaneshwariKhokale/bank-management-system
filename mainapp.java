package combankmain;
import java.util.*;

import com.bank.model.Account;

import combankdao.BankDAO;

// Main class that handles user input and calls DAO methods
public class mainapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        BankDAO dao = new BankDAO();

        while (true) {
            System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
            
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter your "
            		+ "choice: ");

            int choice = sc.nextInt();
            

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account No: ");
                        int accNo = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();  
                        dao. addCount(new Account(accNo, name, bal));
                        break;

                    case 2:
                        dao.showAllAccounts();
                        break;

                    case 3:
                        System.out.print("Enter Account No: ");
                        int depAcc = sc.nextInt();
                        System.out.print("Enter Amount to Deposit: ");
                        double amtDep = sc.nextDouble();
                        dao.deposite(depAcc, amtDep);
                        break;

                    case 4:
                        System.out.print("Enter Account No: ");
                        int withAcc = sc.nextInt();
                        System.out.print("Enter Amount to Withdraw: ");
                        double amtWith = sc.nextDouble();
                        dao.withdraw(withAcc, amtWith);
                        break;

                    case 5:
                        System.out.print("Enter Account No to Delete: ");
                        int delAcc = sc.nextInt();
                        dao.delete(delAcc);
                        break;

                    case 6:
                        System.out.println("👋 Thank you for using Bank Management System!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("❌ Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

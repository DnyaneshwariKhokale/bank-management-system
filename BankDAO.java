package combankdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bank.model.Account;

import combankmain.DBconnection;

public class BankDAO {
	  private Connection con; 
	  
	  public BankDAO() {
	        con = DBconnection.getConnection();  // एकदाच constructor मध्ये तयार
	    }
	

	// Add new Account
	public void addCount(Account acc) throws Exception {
		String query = "Insert INTO bank VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, acc.getaccNO());
		ps.setString(2, acc.getname());
		ps.setDouble(3, acc.getbalance());

		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("account created successfully");
		} else {
			System.out.println("failed to creatae account try again");
		}
		con.close();
	}

	// display all account

	public void showAllAccounts() throws Exception {
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM bank");

	    System.out.println("\n================= Accounts ===============");
	    boolean found = false;
	    while (rs.next()) {
	        found = true;
	        System.out.println(
	            "AccNo: " + rs.getInt("ACCNO") +
	            ", Name: " + rs.getString("NAME") +
	            ", Balance: " + rs.getDouble("BALANCE")
	        );
	    }

	    if (!found) {
	        System.out.println("No accounts found.");
	    }

	    con.close();
	}


	// deposite
	public void deposite(int accNo, double amount) throws Exception {
		PreparedStatement ps = con.prepareStatement("update bank set balance = balance + ? where accNo = ?");
		ps.setDouble(1, amount);
		ps.setInt(2, accNo);
		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("deposite successfully");
		} else {
			System.out.println("account not found");
		}
		con.close();
	}

	// step 5 withdraw
	public void withdraw(int accNo, double amount) throws Exception {
		PreparedStatement check = con.prepareStatement(" select balance from  bank where accNo=?");
		check.setInt(1, accNo);
		ResultSet rs = check.executeQuery();

		if (rs.next()) {
			double bal = rs.getDouble(1);
			if (bal >= amount) {
				PreparedStatement ps = con.prepareStatement("update bank set balance = balance -? where accNo=?");
				ps.setDouble(1, amount);
				ps.setInt(2, accNo);
				ps.executeUpdate();
				System.out.println("withdraw successfully");

			} else {
				System.out.println("insufficient balance");
			}
			System.out.println("account not found");
		}
		con.close();
	}

	// delete account
	public void delete(int accNo) throws Exception {
		PreparedStatement ps = con.prepareStatement("delete from bank where accNo=? ");
		ps.setInt(1, accNo);

		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("rows are deleted");
		} else {
			System.out.println("rows not found");
		}
		con.close();
	}

}

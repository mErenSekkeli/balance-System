
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Selahattin
 */
public class Account {
    static int numberOfAccounts=0;
    
    public int account_emp_id;
    public String account_email;
    public int account_role;

    ArrayList<Account> AccountInfo = new ArrayList<>();
    private static Connector db = DatabaseInstance.getDb();
    private String query="SELECT * FROM accounts where account_enabled = 1";
    
//Boş Constructor
    public Account(){}

    public Account(int account_emp_id, String account_email, int account_role) {
        this.account_emp_id = account_emp_id;
        this.account_email = account_email;
        this.account_role = account_role;
    }
    
    
    
     public ArrayList<Account> prepareAccount() {
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                numberOfAccounts++;
                AccountInfo.add(new Account(rs.getInt("account_emp_id"),rs.getString("account_email"), rs.getInt("account_role")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AccountInfo;
    }
    
    @Override
    public String toString() {
        return this.account_emp_id+", "+this.account_email+", "+this.account_role;
    }
}

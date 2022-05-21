import com.oracle.truffle.js.builtins.DebugBuiltins;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeeManager {
    
    static int numberOfEmployee=0;
    
    public int ID;
    public String name;
    public int workTime;
    public int soldCount;
    public Date hiringTime;
    public Date lastLogin;
    
    
    
    ArrayList<EmployeeManager> employeeInfo = new ArrayList<>();
    private static Connector db = DatabaseInstance.getDb();
    private static String query="SELECT * FROM employer";
    
    public EmployeeManager(int ID,String name, int workTime, int soldCount, Date hiringTime, Date lastLogin) {
        this.ID = ID;
        this.name = name;
        this.workTime = workTime;
        this.soldCount = soldCount;
        this.hiringTime = hiringTime;
        this.lastLogin = lastLogin;
    }
    
    
    //Boş Constructor
    public EmployeeManager() {
        
    }
    
        public ArrayList<EmployeeManager> prepareEmployee() {
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                numberOfEmployee++;
                employeeInfo.add(new EmployeeManager(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getInt("emp_work_time"),rs.getInt("emp_sold_count"),rs.getDate("emp_hiring_time"),rs.getDate("emp_last_login")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeeInfo;
    }
    
    //satış olunca veritabanındaki satış sayısını arttırma fonksiyonu
    public static void increaseSoldCountOfEmployee(int employer_id){
        try {
            
            query="UPDATE employer SET emp_sold_count = emp_sold_count + 1 WHERE emp_id = ?";
            
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, employer_id);
            db.preState.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //iade olunca veritabanındaki satış sayısını azaltma fonksiyonu
    public static void decreaseSoldCountOfEmployee(int employer_id){
        try {
            
            query="UPDATE employer SET emp_sold_count = emp_sold_count - 1 WHERE emp_id = ?";
            
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, employer_id);
            db.preState.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Employee getEmployeeFromId(int employer_id) {
        try {
            query = "SELECT * FROM employer WHERE emp_id = ?";
            
            db.preState = db.con.prepareStatement(query);
            db.preState.setInt(1, employer_id);
            ResultSet set = db.preState.executeQuery();
            
            if(!set.next())
                return null;
            
            Employee emp = new Employee(set.getInt("emp_id"), set.getString("emp_name"), set.getInt("emp_work_time"), 
            set.getInt("emp_sold_count"), set.getDate("emp_hiring_time"), set.getDate("emp_last_login"));
            
            return emp;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
        
    @Override
    public String toString() {
        return this.name+", "+this.ID;
    }
}

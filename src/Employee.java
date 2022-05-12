import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Employee {
    
    static int numberOfEmployee=0;
    
    public int ID;
    public String name;
    public int workTime;
    public int soldCount;
    public Date hiringTime;
    public Date lastLogin;
    
    
    
    ArrayList<Employee> employeeInfo = new ArrayList<>();
    private static Connector db=new Connector();
    private String query="SELECT * FROM employer";
    
    public Employee(int ID,String name, int workTime, int soldCount, Date hiringTime, Date lastLogin) {
        this.ID = ID;
        this.name = name;
        this.workTime = workTime;
        this.soldCount = soldCount;
        this.hiringTime = hiringTime;
        this.lastLogin = lastLogin;
    }
    
    
    //Boş Constructor
    public Employee() {
        
    }
    
        public ArrayList<Employee> prepareEmployee() {
        try {
            db.preState=db.con.prepareStatement(query);
         
            ResultSet rs=db.preState.executeQuery();
            while(rs.next()){
                numberOfEmployee++;
                employeeInfo.add(new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getInt("emp_work_time"),rs.getInt("emp_sold_count"),rs.getDate("emp_hiring_time"),rs.getDate("emp_last_login")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(analysisCostProfit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeeInfo;
    }
    
        //satış olunca satış counter'ı arttırma
    public void soldCounter(int employer_id){
        try {
            query="UPDATE employer SET emp_sold_count = emp_sold_count + 1 WHERE emp_id = ?";
            
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, employer_id);
            db.preState.executeUpdate();
            
            query = "SELECT * FROM employer where id = ?";
            
            db.preState=db.con.prepareStatement(query);
            db.preState.setInt(1, employer_id);
            ResultSet rs=db.preState.executeQuery();
            if(rs != null){
                rs.next();
            
                System.out.println(rs.getInt("sold_count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public String toString() {
        return this.name+", "+this.ID;
    }

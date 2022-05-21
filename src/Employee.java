
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author laptop
 */
public class Employee {
    public int id;
    public String name;
    public int work_time;
    public int sold_count;
    public java.util.Date hiring_time;
    public java.util.Date last_login;

    public Employee(int id, String name, int work_time, int sold_count, java.sql.Date hiring_time, java.sql.Date last_login) {
        this.id = id;
        this.name = name;
        this.work_time = work_time;
        this.sold_count = sold_count;
        this.hiring_time = hiring_time;
        this.last_login = last_login;
    }
    
    
    
}

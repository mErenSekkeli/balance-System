/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author laptop
 */
public class DatabaseInstance {
    private static Connector db = null;
    
    public static Connector getDb() {
        if(db != null) 
            return db;
        init();
        return db;
    }
    public static void init() {
        if(db != null ) {
            //System.out.println("error");
        } else {
            db = new Connector();
        }
    }
}

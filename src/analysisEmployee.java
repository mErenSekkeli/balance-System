
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author MUHAMMEDERENŞEKKELİ
 */
public class analysisEmployee {
   private static Employee emp;
   private static Account acc;

    public analysisEmployee() {
        emp=new Employee();
        acc=new Account();
    }

   public static HashMap<Integer,String> getEmployeeSold(){
      ArrayList<Employee> empList=emp.prepareEmployee();
      ArrayList<Account> accList=acc.prepareAccount();
      analysisProductStock anstock=new analysisProductStock();
       HashMap<Integer,String> commonEmp=new HashMap<>();
      for(Employee e : empList){
          for(Account a : accList){
              if(e.ID==a.account_emp_id){
                  if(a.account_role==2){
                  long dateDiff=anstock.timeDifferrence(e.hiringTime);
                  float saleIndex;
                  if(dateDiff!=0){
                  saleIndex=(float)e.soldCount/dateDiff*1000;
                    }else{
                    saleIndex=e.soldCount*1000;
                    } 
                  
                    if(saleIndex==0){
                      commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışan Hiç Satış Yapmadı.");
                    }else if(saleIndex<5){
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli Çok Düşük.");
                    }else if(saleIndex<15){
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli Düşük.");
                    }else if(saleIndex<30){
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli Yeterli Değil.");
                    }else if(saleIndex<60){
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli Yeterli Düzeyde.");
                    }else if(saleIndex<180){
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli Yükesek.");
                    }else if(saleIndex<500){
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli Çok Yüksek.");
                    }else{
                        commonEmp.put(e.ID,"Çalışan "+e.workTime+" Gün Boyunca Çalıştı."+" Çalışanın Satış Potansiyeli En Yüksek Derecede.");
                    }
                  }
              }
          }
      }
      return commonEmp;
   }
   
   public static ArrayList<String> getEmpWork(){
       ArrayList<Employee> empList=emp.prepareEmployee();
       analysisProductStock anstock=new analysisProductStock();
       ArrayList<String> commonEmpWork=new ArrayList<>();
       
       for(Employee e : empList){
           long dateDiff=anstock.timeDifferrence(e.hiringTime);
           long tmp=dateDiff/7;
           while(tmp>0){
               dateDiff-=1;
               tmp--;
           }
           float workIndex;
           if(dateDiff!=0){
                  workIndex=(float)dateDiff/e.workTime*100;
                    }else{
                    workIndex=0;
                    }
           if(workIndex==0){
               commonEmpWork.add("Çalışan İşe Bugün Başladı.");
           }else if(workIndex!=100){
               commonEmpWork.add("Çalışan Sisteme "+(dateDiff-e.workTime)+" Gün Giriş Yapmadı.");
            }else{
               commonEmpWork.add("Çalışan Gelmesi Gereken Tüm Günlerde Sisteme Girdi.");
           }
       }
       return commonEmpWork;
   }
   
   
}

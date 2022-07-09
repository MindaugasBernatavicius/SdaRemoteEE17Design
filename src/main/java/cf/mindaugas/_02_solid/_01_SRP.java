package cf.mindaugas._02_solid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

// POJO + isPromotionDueThisYear()
class Employee {
    private int id;
    private String name;
    private String address;
    private Date startTime;

//    // ... can an employee know about his promotion eligibility
//    // ... some would say, that promotion logic should be separate
//    // ... from Employee class b/c it is not a property of Employee
//    // ... so in the next example, lets move this to another class:
//    // ... PromotionCalculator class
//    public boolean isPromotionDueThisYear() {
//        LocalDate currentDate = new Date().toInstant()
//                .atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate startDate = startTime.toInstant()
//                .atZone(ZoneId.systemDefault()).toLocalDate();
//        return startDate.getYear() > currentDate.getYear();
//    }

    //Getters & Setters


    public Employee(int id, String name, String address, Date startTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(int id, String name, String address, Date startTime) {
        super(id, name, address, startTime);
    }
    // ... we do not need the isPromotionDueThisYear method, but we still get it
    // ... and we could mistakenly call it in some circumstances
}

class PromotionCalculator {
    public static boolean isPromotionDueThisYear(Employee e) {
        LocalDate currentDate = new Date().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = e.getStartTime().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(startDate.getYear());
        System.out.println(currentDate.getYear());
        return startDate.getYear() + 1 >= currentDate.getYear();
    }
}

public class _01_SRP {
    public static void main(String[] args) throws ParseException {
        boolean promotionDue = PromotionCalculator.isPromotionDueThisYear(
                new Employee(1, "John", "Tartu, Estonia",
                        new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-11")));

        System.out.println(promotionDue);
    }
}

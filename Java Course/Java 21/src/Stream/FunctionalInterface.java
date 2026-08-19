package Stream;

import java.util.Comparator;
import java.util.List;
 
@java.lang.FunctionalInterface
interface EmployeeOperation {
    double perform(List<Employee> employees);
}
 
class Employee {
 
    private String name;
    private double salary;
    private String department;
 
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
 
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
 
public class FunctionalInterface {
 
    public static void main(String[] args) {
 
        List<Employee> employees = List.of(
                new Employee("Rameshwar", 90000, "IT"),
                new Employee("Sudhanshu", 12000, "HR"),
                new Employee("Kamlesh", 40000, "IT"),
                new Employee("Joshi", 70000, "Finance")
        );
 
        EmployeeOperation sum = employeeList ->
            employeeList.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum();
 
        EmployeeOperation average = employeeList ->
            employeeList.stream()
                         .mapToDouble(Employee::getSalary)
                         .average()
                         .orElse(0);
 
        EmployeeOperation min = employeeList ->{
            Employee minEmployee = employeeList.stream()
                         .min(Comparator.comparingDouble(Employee::getSalary))
                            .orElse(null);
            System.out.println("Minimum Salary Employee: " +minEmployee);
            return minEmployee == null ? 0 : minEmployee.getSalary();
        };  
 
        EmployeeOperation max = employeeList ->{
            Employee maxEmployee = employeeList.stream()
                         .max(Comparator.comparingDouble(Employee::getSalary))
                            .orElse(null);
            System.out.println("Maximum Salary Employee: " + maxEmployee);
            return maxEmployee == null ? 0 : maxEmployee.getSalary();
        }; 
 
        System.out.println("Total Salary  : " + sum.perform(employees));
        System.out.println("Average Salary: " + average.perform(employees));
        min.perform(employees);
        max.perform(employees);
    }
}

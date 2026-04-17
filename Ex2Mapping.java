import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ex2Mapping {

    static class Employee {
        private String firstName;
        private String lastName;
        private double salary;

        Employee(String firstName, String lastName, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public String getFirstName() { return firstName; }
        public String getLastName()  { return lastName; }
        public double getSalary()    { return salary; }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "Johnson", 72000));
        employees.add(new Employee("Bob", "Smith", 55000));
        employees.add(new Employee("Clara", "Davis", 98000));

        Function<Employee, String> formatCard =
            e -> "Name: [" + e.getLastName() + ", " + e.getFirstName() + "] - Salary: $" + e.getSalary();

        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee e : employees) {
            System.out.println(formatCard.apply(e));
            System.out.println("Salary only: " + salaryPicker.apply(e));
        }
    }
}

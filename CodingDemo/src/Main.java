import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Ashwani", new Address("s1", "delhi", 110059));
        Employee e2 = new Employee(2, "Ashwani3", new Address("s1", "delhi", 110057));
        Employee e3 = new Employee(3, "Ashwani4", new Address("s1", "delhi", 1100591));
        Employee e4 = new Employee(4,"Ashwani2", new Address("s1", "delhi", 110058));

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        employeeList.stream().forEach(System.out::println);
        //Using Java 8
        System.out.println("Sorted by ID ");
        employeeList.stream().sorted((em1,em2)-> em1.getId()-em2.getId()).forEach(System.out::println);

        System.out.println("Sorted by Address ");
        employeeList.stream().sorted((em1,em2)-> em1.getAddress().compareTo(em2.getAddress())).forEach(System.out::println);

        System.out.println("Sorted by Name ");
        employeeList.stream().sorted((em1,em2)-> em1.getName().compareTo(em2.getName())).forEach(System.out::println);

        //Using older Java code by implementing comparator.

        Collections.sort(employeeList, new AdressComparator());
        employeeList.stream().forEach(System.out::println);

        //Usng inline comparator
        System.out.println("Inline Comprator on Name");
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        employeeList.stream().forEach(System.out::println);

    }
}

package objectcomparator.sampleclasses;

public class Employee extends Person {
    int id;
    int salary;

    public Employee(int id, String n, int s) {
        super(n);
        this.id = id;
        this.salary = s;

    }
}


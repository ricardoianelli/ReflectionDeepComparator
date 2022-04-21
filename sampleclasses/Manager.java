package objectcomparator.sampleclasses;

public class Manager extends Employee {
    private int bonus;

    public Manager(int id, String name, int salary, int bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }
}

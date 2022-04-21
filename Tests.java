package objectcomparator;

import objectcomparator.sampleclasses.Employee;
import objectcomparator.sampleclasses.Manager;
import objectcomparator.sampleclasses.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tests {

	private List<Person> getParentClassArrayList() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Tom"));
		list.add(new Person("Harry"));
		list.add(new Person("Joe"));
		return list;
	}

	private List<Employee> getChildClassArrayList() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1003, "Tom", 60000));
		list.add(new Employee(1002, "Harry", 70000));
		list.add(new Employee(1001, "Joe", 50000));
		return list;
	}

	private List<Manager> getGrandChildClassArrayList() {
		List<Manager> list = new ArrayList<>();
		list.add(new Manager(1003, "Tom", 60000, 700));
		list.add(new Manager(1002, "Harry", 70000, 400));
		list.add(new Manager(1001, "Joe", 50000, 500));
		return list;
	}

	@Test
	public void defaultContains_givenAListOfStrings_shouldReturnTrue() {
		List<String> list = Arrays.asList("Bob", "Joe", "Tom");
		String toCheck = "Joe";
		Assert.assertTrue(list.contains(toCheck));
	}

	@Test
	public void objectComparatorContains_givenAListOfStrings_shouldReturnTrue() {
		List<String> list = Arrays.asList("Bob", "Joe", "Tom");
		String toCheck = "Joe";
		Assert.assertTrue(ObjectComparator.contains(list, toCheck));
	}

	@Test
	public void defaultContains_givenAListOfParentClass_shouldReturnFalse() {
		List<Person> list = getParentClassArrayList();
		Person toCheck = new Person("Harry");
		Assert.assertFalse(list.contains(toCheck));
	}

	@Test
	public void objectComparatorContains_givenAListOfParentClass_shouldReturnTrue() {
		List<Person> list = getParentClassArrayList();
		Person toCheck = new Person("Harry");
		Assert.assertTrue(ObjectComparator.contains(list, toCheck));
	}

	@Test
	public void defaultContains_givenAListOfChildClass_shouldReturnFalse() {
		List<Employee> list = getChildClassArrayList();
		Employee toCheck = new Employee(1002, "Harry", 70000);
		Assert.assertFalse(list.contains(toCheck));
	}

	@Test
	public void objectComparatorContains_givenAListOfChildClass_shouldReturnTrue() {
		List<Employee> list = getChildClassArrayList();
		Employee toCheck = new Employee(1002, "Harry", 70000);
		Assert.assertTrue(ObjectComparator.contains(list, toCheck));
	}

	@Test
	public void defaultContains_givenAListOfGrandChildClass_shouldReturnFalse() {
		List<Manager> list = getGrandChildClassArrayList();
		Manager toCheck = new Manager(1001, "Joe", 50000, 500);
		Assert.assertFalse(list.contains(toCheck));
	}

	@Test
	public void objectComparatorContains_givenAListOfGrandChildClass_shouldReturnTrue() {
		List<Manager> list = getGrandChildClassArrayList();
		Manager toCheck = new Manager(1001, "Joe", 50000, 500);
		Assert.assertTrue(ObjectComparator.contains(list, toCheck));
	}
}

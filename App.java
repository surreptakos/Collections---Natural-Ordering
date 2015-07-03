import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	@Override
	public int compareTo(Person person2) {
		// Even though name is private, but can still access it from within the
		// same class, even if it's from another instance of the class
		int len1 = this.name.length();
		int len2 = person2.name.length();

		if (len1 > len2) {
			return 1;
		} else if (len2 > len1) {
			return -1;
		} else {
			// this is how you solve the equals disparity
			// If they're equal length strings, then they will be sorted in
			// alphabetical order
			return name.compareTo(person2.name);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	// equals method must return true for all cases where compareTo would return
	// 0 for the behavior of items in a TreeSet to be well defined
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class App {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		SortedSet<Person> set = new TreeSet<Person>();

		addElements(list);
		addElements(set);

		// Must define natural order first
		Collections.sort(list);

		showElements(list);
		System.out.println();
		showElements(set);
	}

	private static void addElements(Collection<Person> col) {
		col.add(new Person("Joe"));
		col.add(new Person("Sue"));
		col.add(new Person("Juliet"));
		col.add(new Person("Clare"));
		col.add(new Person("Mike"));
	}

	private static void showElements(Collection<Person> col) {
		for (Person element : col) {
			System.out.println(element);
		}
	}

}

package nuisance;
/**
 * Describes a person by their name and age. 
 * 
 * @author Charlotte Saethre
 */
public class Person {

	private String name;
	private int age;
	
	/**
	 * Determines a persons age and initializes fields <code>name</code> and 
	 * <code>age</code>
	 * @param name name
	 * @param age age
	 * @throws IllegalArgumentException age is out of range
	 */
	public Person(String name, int age) {
		if (age < 1 || age > 150)
		throw new IllegalArgumentException("age must be in range from [1 - 150]");
		this.name = name;
		this.age = age;
		
	}

	/**
	 * Returns name of person. 
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns age of person. 
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/* Return the string in the following format:
	 * {name}({age}) 
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "(" + age +")";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

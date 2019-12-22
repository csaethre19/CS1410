package keyValue;
/**
 * Describes a key value pair which can be different reference types. 
 * 
 * @author Charlotte Saethre
 *
 * @param <K> type for field <code>key</code>
 * @param <V> type for field <code>value</code>
 */
public class KeyValuePair <K extends Comparable<K>, V> implements Comparable<KeyValuePair<K, V>> {
	private K key;
	private V value;
	
	/**
	 * Initializes fields <code>key</code> and <code>value</code>.
	 * @param key key
	 * @param value value
	 */
	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Returns the value of key.
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Returns the value of value.
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		@SuppressWarnings("rawtypes")
		KeyValuePair other = (KeyValuePair) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/* Returns string in the following format:
	 * ({key}, {value})
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}

	@Override
	public int compareTo(KeyValuePair<K, V> o) {
		return key.compareTo(o.getKey());
	}

	
}

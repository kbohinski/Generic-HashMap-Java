/**
 * @author Kevin Bohinski <bohinsk1@tcnj.edu>
 * @version 1.0
 * @since 2015-10-14
 *
 * Project Name:  HashMap
 * Description:   Custom HashMap implementation.
 *
 * Filename:      HashMap.java
 * Description:   HashMap implementation.
 * Last Modified: 2015-10-14
 *
 * Copyright (c) 2015 Kevin Bohinski. All rights reserved.
 */

/* Setting Package */
package com.kevinbohinski.algs;

import java.util.Arrays;

public class HashMap<K, V> {

	/* Modular hashing, using prime for less collisions */
	private final static int DEFAULT_CAPACITY = 101;
	private int size;
	private int numEntries;
	private HashMapEntry<K, V> entries[];

	/**
	 * Constructor: Creates a new HashMap object with the params given.
	 * 
	 * @param size
	 */
	public HashMap(int size) {
		this.size = size;
		entries = new HashMapEntry[size];
		numEntries = 0;
	}

	/**
	 * Constructor: Creates a new HashMapEntry object with no params given.
	 */
	public HashMap() {
		size = DEFAULT_CAPACITY;
		entries = new HashMapEntry[size];
		numEntries = 0;
	}

	/**
	 * Returns a hashcode suited for the size of the HashMap.
	 * http://algs4.cs.princeton.edu/34hash/
	 * 
	 * @param key
	 * @return The hashcode suited for this instance of a HashMap.
	 */
	private int getHash(K key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}

	/**
	 * Stores the given key/value pair in the hash map. Returns a boolean value
	 * indicating success / failure of the operation.
	 * 
	 * @param key
	 * @param value
	 * @return A boolean value indicating success / failure of the operation
	 */
	public boolean set(K key, V value) {
		if (key == null) {
			/* Cant store null */
			return false;
		}
		int hc = getHash(key);
		HashMapEntry<K, V> tmp = entries[hc];
		if (tmp != null) {
			if (tmp.getKey().equals(key)) {
				/* Entry with same key exists in the HashMap, overwriting */
				tmp.setValue(value);
				return true;
			} else {
				/* Go to end of list and insert new element */
				while (tmp.getNext() != null) {
					tmp = tmp.getNext();
				}
				HashMapEntry<K, V> newEntry = new HashMapEntry<K, V>(
						key, value);
				tmp.setNext(newEntry);
				numEntries++;
				return true;
			}
		} else {
			/* New element in the HashMap, add it */
			HashMapEntry<K, V> newEntry = new HashMapEntry<K, V>(key,
					value);
			entries[hc] = newEntry;
			numEntries++;
			return true;
		}
	}

	/**
	 * Return the value associated with the given key, or null if no value is
	 * set.
	 * 
	 * @param key
	 * @return The value associated with the given key, or null if no value is
	 *         set.
	 */
	public V get(K key) {
		if (key == null) {
			return null;
		}

		int hc = getHash(key);
		HashMapEntry<K, V> tmp = entries[hc];

		/* If the hash exists in the HashMap, traverse until it is found */
		while (tmp != null) {
			if (tmp.getKey().equals(key)) {
				return tmp.getValue();
			}
			tmp = tmp.getNext();
		}
		/* Does not exist in the HashMap, return null per spec. */
		return null;
	}

	/**
	 * Deletes the value associated with the given key, returning the value on
	 * success or null if the key has no value.
	 * 
	 * @param key
	 * @return The value on success or null if the key has no value.
	 */
	public V delete(K key) {
		int hc = getHash(key);
		HashMapEntry<K, V> tmp = entries[hc];

		if (tmp != null) {
			HashMapEntry<K, V> prev = null;
			while (tmp != null) {
				if (tmp.getKey().equals(key)) {
					if (prev == null) {
						/* Delete first entry */
						V val = (V) entries[hc].getValue();
						entries[hc] = entries[hc].getNext();
						numEntries--;
						return val;
					} else {
						prev.setNext(tmp.getNext());
						numEntries--;
						return prev.getNext().getValue();
					}
				}
				prev = tmp;
				tmp = tmp.getNext();
			}
			/* Does not exist in HashMap */
			return null;
		}
		return null;
	}

	/**
	 * Returns a float value representing the load factor of the data structure.
	 * 
	 * @return A float value representing the load factor of the data structure
	 */
	public float load() {
		return ((float) numEntries / size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HashMap [size=" + size + ", numEntries=" + numEntries
				+ ", entries=" + Arrays.toString(entries) + "]";
	}

}

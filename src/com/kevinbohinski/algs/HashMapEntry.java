/**
 * @author Kevin Bohinski <bohinsk1@tcnj.edu>
 * @version 1.0
 * @since 2015-10-14
 *
 * Project Name:  HashMap
 * Description:   Custom HashMap implementation.
 *
 * Filename:      HashMapEntry.java
 * Description:   Linked element entry for the HashMap.
 * Last Modified: 2015-10-14
 *
 * Copyright (c) 2015 Kevin Bohinski. All rights reserved.
 */

/* Setting Package */
package com.kevinbohinski.algs;

public class HashMapEntry<K, V> {

	private K key;
	private V value;
	private HashMapEntry<K, V> next;

	/**
	 * Constructor: Creates a new HashMapEntry object with the params given.
	 * 
	 * @param key
	 * @param value
	 */
	public HashMapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return the next
	 */
	public HashMapEntry<K, V> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(HashMapEntry<K, V> next) {
		this.next = next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HashMapEntry [key=" + key + ", value=" + value + ", next="
				+ next.toString() + "]";
	}

}
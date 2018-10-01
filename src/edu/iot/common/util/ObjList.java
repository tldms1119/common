package edu.iot.common.util;

public interface ObjList<E> {
	
	void add(E obj);
	void add(int index, E obj);
	Object get(int index);
	void set(int index, E obj);
	Object remove(int index);
	void swap(int i, int j);
	int size();

}

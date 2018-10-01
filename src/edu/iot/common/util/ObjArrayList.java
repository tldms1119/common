package edu.iot.common.util;

import edu.iot.common.util.ListIndexOutOfBoundsException;

public class ObjArrayList<E> implements ObjList<E> {

	final static int INITIAL_SIZE = 10;
	private E[] arr;
	private int size;

	public ObjArrayList() {
		arr = (E[]) new Object[INITIAL_SIZE];
		size = 0;
	}

	public ObjArrayList(int length) {
		arr = (E[]) (new Object[length]);
		size = 0;
	}
	
	private void expand() {
			E[] newArr = (E[]) new Object[arr.length * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
	}

	@Override
	public void add(E obj) {	
		if (size == arr.length) {
			expand();
		} 
		arr[size] = obj;
		size++;
	}

	@Override
	public void add(int index, E obj) {
		// 예외 가능 - size보다 큰 index인 경우
		if(index > size || index < 0) {
			throw new ListIndexOutOfBoundsException("" + index);
		}
		
		if (size == arr.length) {
			expand();
		}
		
		for(int i = size; i > index; i--) {
			arr[i] = arr[i-1];
		}
		
		arr[index] = obj;
		size++;
	}

	@Override
	public E get(int index) {
		// 예외 가능 - size보다 큰 index인 경우
		if(index > size || index < 0) {
			throw new ListIndexOutOfBoundsException("" + index);
		}
		
		return arr[index];
	}

	@Override
	public void set(int index, E obj) {
		// 예외 가능 - size보다 큰 index인 경우
		if(index > size || index < 0) {
			throw new ListIndexOutOfBoundsException("" + index);
		}
		
		arr[index] = obj;
	}

	@Override
	public E remove(int index) {
		// 예외 가능 - size보다 큰 index인 경우
		if(index > size || index < 0) {
			throw new ListIndexOutOfBoundsException("" + index);
		}
		
		E obj = arr[index];
		int i;
		for(i = index; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = null;
		size--;
		return obj;
	}

	@Override
	public void swap(int i, int j) {
		// 예외 가능 - size보다 큰 index인 경우
		if(i < 0 || i > size) {
			throw new ListIndexOutOfBoundsException("i - " + i);
		}
		
		if(j < 0 || j > size) {
			throw new ListIndexOutOfBoundsException("j - " + j);
		}
		
		E temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	@Override
	public int size() {
		return size;
	}

}

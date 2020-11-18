package com.kh.f_array.study;

public class ArrayUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 기능 : 매게변수로 넘어온 두 배열을 합치는 메서드
	public int[] addAll(int a[], int b[]) {
		int relen = a.length + b.length; 
		int result[] = new int[relen];
		
		for(int i=0; i<a.length; i++) {
			result[i] = a[i];
		}
		for(int i=a.length; i<relen; i++) {
			result[i] = b[i-a.length];
		}		
		return result;	
	}
	
	// 기능 : 원하는 인덱스 구간의 데이터를 잘라내어 새로운 배열로 반환하는 메서드
	public int[] subArr(int a[], int x, int y) {
		int relen = y-x;
		int result[] = new int[relen];
		
		for(int i=0; i<relen; i++) {
			result[i] = a[x+i];	
		}		
		return result;
	}
	
	// 원하는 인덱스의 데이터를 삭제하고  배열의 크기를 다시 조정해 반환하는 메서드
	public int[] remove(int a[], int x) {
		int relen = a.length - 1;
		int result[] = new int[relen];
		
		for(int i=0;i<relen;i++) {
			if(i>=x) {
				result[i] = a[i+1];
			}else {
				result[i] = a[i];
			}				
		}		
		return result;
	}
	
	public int[] sort(int a[]) {
		int j=0;
		int temp=0;
		
		for(int i=1; i<a.length-1; i++) {
			j=i-1;
			while(j>=0 && a[j]>a[j+1]){
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
				j--;
			}
		}
		return a;
	}
}

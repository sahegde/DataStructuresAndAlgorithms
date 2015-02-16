package com.programs.dynamic;

public class fibonacci {
	
	private static void firstNFibonnaciNums(int a[],int n) {
		for(int i = 0;i < n;i++) {
			if(i == 0 || i ==1) {
				a[i] = 1;
			}else {
				a[i] = a[i-1] + a[i-2];
			}
		}
	}
	
	private static void display(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+ " ");
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		int a[] = new int[n];
		firstNFibonnaciNums(a,n);
		
		display(a);
	}
}

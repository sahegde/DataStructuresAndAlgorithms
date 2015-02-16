package com.programs.dynamic;

//Find nCk sort of problems.

/* nCk = 1 if n == k || k == 0
 * nCk = n-1Ck-1 + n-1Ck 
 */

public class Combinations {
	
	private static int min(int a,int b) {
		return a<b ? a:b;
	}
	
	private static int findnCk(int a[][],int n, int k) {
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= min(k,i);j++) {
				if(i == j || j == 0 || j < 0 || i == 1) {
					a[i][j] = 1;
					System.out.println(i+" "+j +" "+a[i][j] );
				}else {
					a[i][j] = a[i-1][j-1] + a[i-1][j];
					System.out.println(i+" "+j +" "+a[i][j] );
				}
			}
		}
		
		return a[n][k];
	}
	
	public static void main(String[] args) {
		int a[][] = new int[100][100];
		int n = 6;
		int k = 3;
		
		System.out.println(findnCk(a,n,k));
	}
}

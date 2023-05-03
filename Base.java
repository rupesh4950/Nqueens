package nQueens;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Base {
	static int queen[][] = new int[8][8];
	static int oo=0;

	@Test
	public void run() {
		System.out.println("N_Queens Before Sloved ");
		double t1 = System.currentTimeMillis();
		printl();
		slove(0);
	//	System.out.println(count);
		System.out.println("N_Queens Before Sloved ");
		printl();
		double t2 = System.currentTimeMillis();
		System.out.println("Total time in seconds taken to slove the N-Queens is "+(t2-t1)/1000);
	}	

	public static  void slove(int p) {
		//printl();
		ArrayList<ArrayList> a = findAllZeros(p);
	//	System.out.println(count);
		
		if(countOnces()>=queen.length) {
			return;
		}
		//int k=0;
		for (ArrayList ar : a) {
			int i=(int) ar.get(0);
			int j=(int) ar.get(1);
			boolean b = slove1(i,j);
			if(b) {
				queen[i][j]=1;
			//	count++;
			//	k=1;
				if(countOnces()>=queen.length)
					return;
				slove(i+1);
				
			}
			if(countOnces()>=queen.length)
				return;
			queen[i][j]=0;
//			if(k==1)
//				count--;
		}
	}

	public static int countOnces() {
		int c=0;
		for(int i=0;i<queen.length;i++) {
			for(int j=0;j<queen.length;j++) {
				if(queen[i][j]==1)
					c++;
			}
		}
		return c;
	}

	public static ArrayList<ArrayList> findAllZeros(int p) {
		ArrayList<ArrayList> l=new ArrayList<>();
		for(int i=p;i<queen[0].length;i++) {
			for(int j=0;j<queen[0].length;j++) {
				if(queen[i][j]==0) {
					ArrayList<Integer> a=new ArrayList<>();
					a.add(i);
					a.add(j);
					l.add(a);
				}
			}
		}
		return l;
	}
	public int[] firstZero() {
		int a[]=new int[2];
		for(int i=0;i< queen.length;i++) {
			for(int j=0;j< queen.length;j++) {
				if(queen[i][j]==0) {
					a[0]=i;
					a[1]=j;
					return a;
				}	
			}
		}
		int b[]={-1,-1};
		return b ;
	}
	public static boolean slove1(int i, int j) {
		boolean b1 = rowCheck(j);
	//	System.out.println(b1);
		boolean b2 = cloCheck(i);
		//System.out.println(b2);
		boolean b3 = diagonalCheck(i, j);
	//	System.out.println(b3);
		if (b1 && b2 && b3)
			return true;
		return false;

	}

	private static boolean diagonalCheck(int i, int j) {
		int i1 = i, j1 = j;
		while (i <  queen.length && j < queen.length) {
			if (queen[i][j] == 1)
				return false;
			i++;
			j++;
		}
		i = i1;
		j = j1;
		while (i >= 0 && j >= 0) {
			if (queen[i][j] == 1)
				return false;
			i--;
			j--;
		}
		i = i1;
		j = j1;
		while (i < queen.length && j >= 0) {
			if (queen[i][j] == 1)
				return false;
			i++;
			j--;
		}
		i = i1;
		j = j1;
		while (i >= 0 && j <  queen.length) {
			if (queen[i][j] == 1)
				return false;
			i--;
			j++;
		}
		return true;
	}

	private static boolean cloCheck(int i) {
		for (int j = 0; j < queen.length; j++) {
			if (queen[i][j] == 1)
				return false;
		}
		return true;
	}

	private static boolean rowCheck(int j) {
		for (int i = 0; i < queen.length; i++) {
			if (queen[i][j] == 1)
				return false;
		}
		return true;
	}

	public static void printl() {
		System.out.println("==================================");
		for (int i = 0; i < queen[0].length; i++) {
			for (int j = 0; j < queen[0].length; j++)
				System.out.print(queen[i][j] + " ");
			System.out.println();
		}
		System.out.println("==================================");
	}
//	public void slove() {
//	printl();
//	int[] a = firstZero();
//	int i=a[0];
//	int j=a[1];
//	if(count<8) {
//		if (i==-1)
//			return ;
//		boolean b1 = slove1(i,j);
//		if(b1) {
//			queen[i][j]=1;
//			count++;
//		}
//		else {
//			queen[i][j]=-1;
//		}
//		 slove();
//	}
//	else 
//	{
//		return ;
//	}
//	if(count==8) {
//		return;
//	}
//	else {
//		queen[i][j]=0;
//		count--;
//		slove();
//	}
//}
	
	////////////////////////
//	public void slove() {
	
		//use the find all zeros method to iterate through all the valuses
//		if(count<8) {
//			int[] a = firstZero();
//			int i=a[0];
//			int j=a[1];
//			if(i<0) {
//				return;
//			}
//			boolean b = slove1(i,j);
//			//System.out.println(b);
//			if(b)
//				queen[i][j]=1;
//			else
//				queen[i][j]=-1;
//			slove();
//			if(count==8) {
//				return;
//			}
//			else {
//				queen[i][j]=0;
//				count--;
//			}	
//		}
//	public void slove(int p) {
//		
//		ArrayList<ArrayList> a = findAllZeros(p);
//		if(count==8) {
//		System.out.println(a.size());
//			return;
//			}
//		int n=0;
//		for (ArrayList ar : a) {
//			System.out.println(count);
//			int i=(int) ar.get(0);
//			int j=(int )ar.get(1);
//			boolean b = slove1(i,j);
//	//		System.out.println(b);
//			if(b) {
//				
//				queen[i][j]=1;
//				count++;
//				n++;
//				if(count==8) {
//					printl();
//					return;
//				}
//				slove(i+1);
//			}
//			printl();
//			if(n==1) {
//					count--;
//					queen[i][j]=0;
//					n=0;
//			}
//			if(count==8)
//				return;
//			if(a.size()==64) {
//				queen[i][j]=-1;
//			}
//		}
//		if(count==8)
//			return;
//		
//	}


}

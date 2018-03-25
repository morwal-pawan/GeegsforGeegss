package agoithms.sort;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class QuickSort {

	public static void sort(int arr[]) {
		sort(arr,0,arr.length-1);
	}
	public static void sort3(int arr[]) {
		sort3(arr,0,arr.length-1);
	}
	
	private static void sort(int[] arr, int low, int high) {
		if(low >=high) return ;
		int pivote = partition(arr, low, high);
		printArray(arr);
		sort(arr, low, pivote-1);
		sort(arr, pivote+1, high);
		
		
	}

	private static int partition(int arr[],int low,int high) {
		int left = low ;
		int right = high;
		int value = arr[high];
		while(true)
		{
			while(arr[left] <= value&&left!=high)
			{
				left++;
				
			}
			
			while(arr[right] >= value && right!=low)
			{
				right--;
			}
			if(left >= right) break;
			exchange(arr,left,right);
		}
		
		exchange(arr,high,left);
		return left;
		
	}
	 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
//	 quicksort the subarray arr[low .. high] using 3-way partitioning
	public static void sort3(int[] arr,int low, int high) {
//		System.out.println("In sort3");
		if(low >= high) return;
//		left less then it and right greater then it 
		
		int left = low,index = low ,right = high;
		int partion_element = arr[low];
		
		while(index <= right)
		{
			if   (arr[index] < partion_element) exchange(arr, left++,index++ );  // 3- partitioning
			else if(arr[index] > partion_element) exchange(arr, right--, index); // 3- partitioning
			else index++;														 // 3- partitioning
		}
		sort3(arr, low, left-1);
		sort3(arr, right+1, high);
		
	}
	
	public static int selectElement(int[] arr,int k)
	{
		int low = 0, high = arr.length -1;
		while(low < high)
		{ 
			int partition_index = partition(arr, low, high);
			if		( k < partition_index ) high = partition_index -1;
			else if ( k > partition_index ) low = partition_index +1;
			else  							return arr[k];
		}
		return arr[k];
	}
	
	private static void exchange(int arr[],int a  ,int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static void print(int[] arr) {
		int size = arr.length;
		for (int index = 0; index < size; index++) {
			System.out.print(" " + arr[index]);
		}
		System.out.println("");
	}
	
	public static void main(String[] agrs) throws IOException
	{
        Scanner in = new Scanner(new File("src/files/sort.txt"));
		int size;
		int k = 0;
		int[] arr = null;
		
		try {
			size = Integer.valueOf(in.nextLine());
			arr = new int[size];
			int index = 0;
			while(in.hasNextInt() && index < size)
				arr[index++] = in.nextInt();	
//			k = Integer.valueOf(in.nextInt());;
		} catch (NumberFormatException e) {
			System.out.println(" Values Must be Inetger ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " );
		print(arr);
		
		
		sort(arr);
//		print(arr);
//		System.out.println(" Value of Kth ( "+k+" ): " + selectElement(arr, 1));
		
		
			
	}
}

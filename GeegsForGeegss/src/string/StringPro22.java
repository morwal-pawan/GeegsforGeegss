package string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public  class StringPro22 {

	
	
	static class Node implements Comparable<Node>{
		char ch;
		int freq=0;
		
		Node(char ch,int freq){
			this.ch=ch;
			this.freq= freq;
		}

		@Override
		public int compareTo(Node node) {
			if(this.freq > node.freq) return -1;
			else if(this.freq < node.freq) return 1;
			else return 0;
		}
		
		
	}
	
//	static class MyComparator implements Comparator<Integer>{
//
//		@Override
//		public int compare(Integer arg1, Integer arg2) {
//			if(arg1 > arg2) return -1;
//			else if(arg1 < arg2) return 1;
//			else return 0;
//		}
//		
//	}
	static int[] countFreq(String str) {
		int count[] = new int[256];
		int length = str.length();
		for (int index = 0; index < length; index++) {
			count[str.charAt(index)]++;
		}
		return count;
	}
	static int minSumSquar(String str,int k) {
		
		int length = str.length();
		if(length < k)
			return 0;
		
        Queue<Node> pq = new PriorityQueue<Node>(10); 
        int count[] = countFreq(str);
        
        for (int index = 0; index < count.length; index++) {
        	if(count[index]!=0)
        	{
        		Node node = new Node((char)index,count[index]);
//        		System.out.println(" ch " + node.ch + " freq " + node.freq);
        		pq.add(node);
        		Node temp = pq.peek();
//        		System.out.println(" ch " + temp.ch + " freq " + temp.freq);
        	}
			
		}
        while(k>0)
        {
        	Node temp = pq.poll();
        	temp.freq--;
        	pq.add(temp);
        	k--;
        }
		int squaSum=0;
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	squaSum+=node.freq*node.freq;
        	
        }
		return squaSum;
	}
public static void main(String[] agrs) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/files/input.txt"));
		String str1 = "";
		int K = 0;
		
		try {
			str1 = br.readLine();
			K  = Integer.valueOf(br.readLine());
			
		} catch (NumberFormatException | IOException e) {
			System.out.println(" Values Must be Strings ");
			System.out.println("but   " + e.getMessage());
			System.exit(0);
		}
		System.out.println(" INPUT : " + str1);
		System.out.println(" K : " + K);
		
		System.out.println(" eventNumberSubString : " + minSumSquar(str1,K));
		br.close();
		
	}
}

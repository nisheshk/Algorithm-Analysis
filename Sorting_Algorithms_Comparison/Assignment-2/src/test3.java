import java.util.Random;

import algorithmDesign.*;
public class test3 {
	
	private static final int NUM_ITEMS = 100000;
	
	public static String random_string_generate(int length) {
		
		String possible_strings = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rand = new Random();
		StringBuilder random_strings = new StringBuilder(length); 
		for (int i= 0; i < length; i++) {
			random_strings.append(possible_strings.charAt(rand.nextInt(10)));
		}
		//System.out.println(random_strings);
		return random_strings.toString();
	}
	
	public static void main(String[] args) {
		int[] len = new int[]{ 10,20,50,100 };
		for (int i = 0 ; i< len.length; i++) {
			long startTime = 0; long endTime = 0; int dist = 0; long avg_time = 0;
			for (int j = 0 ; j < NUM_ITEMS ; j++) {
				String s1 = random_string_generate(len[i]);
				String s2 = random_string_generate(len[i]);
				startTime = System.nanoTime();
				dist += Sequences.editDistance(s1, s2);
				endTime = System.nanoTime();
				//System.out.println("Dist between '" + s1 + "' and '" + s2 + "' = " + dist);
				avg_time += (endTime - startTime);
			}
			avg_time = (avg_time) / NUM_ITEMS;
			long avg_dist = dist/NUM_ITEMS;
			System.out.println("Avg CPU time for length "+ len[i] + " for average distance " + avg_dist + " is : " + avg_time + "ns");
		}
	}//end of main function
}//end of class test3

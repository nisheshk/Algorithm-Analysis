
import hashTable.*;
import java.util.*;
public class test {
	
	public static Scanner inp = new Scanner(System.in);
	public static CuckooHashTable<String> CH = new CuckooHashTable<>( new StringHashFamily( 3 ), 10);
	public static QuadraticProbingHashTable<String> QH = new QuadraticProbingHashTable<>();
	public static SeparateChainingHashTable<String> SH = new SeparateChainingHashTable<>();


	public static String random_string_generate() {
	
		String possible_strings = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rand = new Random();
		StringBuilder random_strings = new StringBuilder(10); 
		for (int i= 0; i <= 9; i++) {
			random_strings.append(possible_strings.charAt(rand.nextInt(10)));
		}
		//System.out.println(random_strings);
		return random_strings.toString();
	}
	
	
	public static void insert_into_hash_table(Object obj) {
		
		long insert_duration = 0; long search_duration = 0;
		long duration = 0; int j = 0;  String type="";
		long endTime = 0; long startTime = 0;
		for (int i = 1; i <= 20 ; i++) {
			int freq = (int) (Math.pow(2, i));
			long avg_duration = 0;
			for (j = 0 ; j < freq; j++) {
				String rand_string = random_string_generate();
				
				if (obj == CH) {
					type = "CuckooHashTable";
					startTime = System.nanoTime();
					CH.insert(rand_string);
					endTime = System.nanoTime();
				}
				
				else if (obj == QH) {
					type = "QuadraticProbingHashTable";
					startTime = System.nanoTime();
					QH.insert(rand_string);
					endTime = System.nanoTime();
					}
				
				else if (obj == SH) {
					type = "SeparateChainingHashTable";
					startTime = System.nanoTime();
					SH.insert(rand_string);
					endTime = System.nanoTime();
					}
				
				duration = (endTime - startTime);
				avg_duration = avg_duration + duration;
				//	System.out.println("Insert Duration: " + duration + " nanosecond");
			}//end of for loop
			System.out.println("Average insert duration for " + type + " with input 2^" + i + " is : " + avg_duration/j + " ns");
		}//end of outer for loop
		}
			
	
	public static void find_random_strings(Object obj) {
		long duration = 0; int count = 0; long startTime = 0; boolean found_flag = false;
		int freq = 0; long avg_duration = 0; long endTime = 0; String type = "";
		
		for (int i = 1; i <= 20 ; i++) {
			freq = (int) (Math.pow(2, i));
			avg_duration = 0; found_flag = false; count = 0;
			while (count != freq) {
				String search_string = random_string_generate();
				if (obj == CH) {
					type = "CuckooHashTable";
					startTime = System.nanoTime();
					found_flag = CH.contains(search_string);
					endTime = System.nanoTime();
					if (found_flag) CH.remove(search_string);
				}
				
				else if (obj == QH) {
					type = "QuadraticProbingHashTable";
					startTime = System.nanoTime();
					found_flag = QH.contains(search_string);
					endTime = System.nanoTime();
					if (found_flag) QH.remove(search_string);
					}
				
				else if (obj == SH) {
					type = "SeparateChainingHashTable";
					startTime = System.nanoTime();
					found_flag = SH.contains(search_string);
					endTime = System.nanoTime();
					if (found_flag) SH.remove(search_string);
				}
				duration = (endTime - startTime);
				avg_duration += duration;
				count += 1;
				
				//System.out.println("Search duration: " + duration + " nanosecond");
			}
			System.out.println("Average search duration for " + type + " with input 2^" + i + " is : " + avg_duration/count + " ns");

		}	
	}
	public static void main(String[] args) {
		insert_into_hash_table(CH);
		insert_into_hash_table(SH);
		insert_into_hash_table(QH);
		find_random_strings(CH);
		find_random_strings(SH);
		find_random_strings(QH);
		
	}
			
	}

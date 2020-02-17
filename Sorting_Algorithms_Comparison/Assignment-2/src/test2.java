import sorting.*;
import java.util.*;

public class test2{

  private static final int NUM_ITEMS = 100000;
  private static final int NUM_ITERATION = 4;

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

   public static long quick_sort_analysis(String[] quick_list, int LEN){
  
     long startTime = System.nanoTime();
     Sort.quicksort(quick_list);
     long endTime = System.nanoTime();
     System.out.println("Total time for quick sort for string of length "+LEN+" is: " + (endTime - startTime) + " ns");
     
	 return (endTime - startTime);
   }//end of quick sort
   
   public static long dual_piv_sort_analysis(String[] dual_list, int LEN){
	   
	     long startTime = System.nanoTime();
	     Arrays.sort(dual_list);
	     long endTime = System.nanoTime();
	     System.out.println("Total time for dual pivot quick sort for string of length "+LEN+" is: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   public static long heap_sort_analysis(String[] heap_list, int LEN){
	   
	     long startTime = System.nanoTime();
	     Sort.heapsort(heap_list);
	     long endTime = System.nanoTime();
	     System.out.println("Total time for heap sort for string of length "+LEN+" is: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   public static long merge_sort_analysis(String[] merge_list, int LEN){
	   
	     long startTime = System.nanoTime();
	     Sort.mergeSort(merge_list);
	     long endTime = System.nanoTime();
	     System.out.println("Total time for merge sort for string of length "+LEN+" is: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   public static long radix_sort_analysis(String[] radix_list ,int LEN){
	   
	     long startTime = System.nanoTime();
	     RadixSort.radixSortA( radix_list, LEN );
	     long endTime = System.nanoTime();
	     System.out.println("Total time for radix sort for string of length "+LEN+" is: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   

  public static void main(String[] args){
    String [ ] merge_list = new String[ NUM_ITEMS ];
    String [ ] quick_list = new String[ NUM_ITEMS ];
    String [ ] heap_list = new String[ NUM_ITEMS ];
    String [ ] dualpiv_list = new String[ NUM_ITEMS ];
    String [ ] radix_list = new String[ NUM_ITEMS ];
    long rand_num = 0;
    long quick_sort_time = 0;long merge_sort_time = 0;
    long heap_sort_time = 0;long dual_piv_sort_time = 0;
    long radix_sort_time = 0;
    String random_string=""; int length = 2;
    
    for (int j = 0; j < NUM_ITERATION ; j++) {
    	length = length + 2;
	    for( int i = 0; i < NUM_ITEMS ; i++ ){
	        random_string = random_string_generate(length);
	        merge_list[i] = quick_list[i] = heap_list[i] = dualpiv_list[i ]=radix_list[i]= random_string;
	
	    }//end of inner for loop
	    System.out.println("Merge Sort Analysis: ");
	    merge_sort_time += merge_sort_analysis(merge_list, length);
	    System.out.println("Quick Sort Analysis: ");
	    quick_sort_time += quick_sort_analysis(quick_list, length);
	    System.out.println("Heap Sort Analysis: ");
	    heap_sort_time += heap_sort_analysis(heap_list, length);
	    System.out.println("Dual pivot Sort Analysis: ");
	    dual_piv_sort_time += dual_piv_sort_analysis(dualpiv_list, length);
	    System.out.println("Radix Sort Analysis: ");
	    radix_sort_time += radix_sort_analysis(radix_list, length);
    }//end of outer for loop
   System.out.println("Average time for merge sort is: " + merge_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for heap sort is: " + heap_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for quick sort is: " + quick_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for dual pivot quick sort is: " + dual_piv_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for radix sort is: " + radix_sort_time/NUM_ITERATION + " ns");

  }//end of void main

}//end of class test
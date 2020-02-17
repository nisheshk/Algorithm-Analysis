import sorting.*;
import java.util.*;

public class test{

  private static final int NUM_ITEMS = 10000000;
  private static final int NUM_ITERATION = 100;

  public static long generate_random_numbers() {
    long lowerLimit = 1;
    long upperLimit = 1000;
    long generatedLong = lowerLimit + (long) (Math.random() * (upperLimit - lowerLimit));
    //System.out.println(generatedLong);
    return generatedLong;
	}

   public static long quick_sort_analysis(Long[] quick_list, int j){
  
     long startTime = System.nanoTime();
     Sort.quicksort(quick_list);
     long endTime = System.nanoTime();
     System.out.println("Avg time for quick sort for "+j+"th iteration: " + (endTime - startTime) + " ns");
     
	 return (endTime - startTime);
   }//end of quick sort
   
   public static long dual_piv_sort_analysis(Long[] dual_list, int j){
	   
	     long startTime = System.nanoTime();
	     Arrays.sort(dual_list);
	     long endTime = System.nanoTime();
	     System.out.println("Avg time for dual piv quick sort for "+j+"th iteration: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   public static long heap_sort_analysis(Long[] heap_list, int j){
	   
	     long startTime = System.nanoTime();
	     Sort.heapsort(heap_list);
	     long endTime = System.nanoTime();
	     System.out.println("Avg time for heap sort for "+j+"th iteration: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   public static long merge_sort_analysis(Long[] merge_list, int j){
	   
	     long startTime = System.nanoTime();
	     Sort.mergeSort(merge_list);
	     long endTime = System.nanoTime();
	     System.out.println("Avg time for merge sort for "+j+"th iteration: " + (endTime - startTime) + " ns");
	     
		 return (endTime - startTime);
	   }//end of quick sort
   
   

  public static void main(String[] args){
    Long [ ] merge_list = new Long[ NUM_ITEMS ];
    Long [ ] quick_list = new Long[ NUM_ITEMS ];
    Long [ ] heap_list = new Long[ NUM_ITEMS ];
    Long [ ] dualpiv_list = new Long[ NUM_ITEMS ];
    long rand_num = 0;
    long quick_sort_time = 0;long merge_sort_time = 0;
    long heap_sort_time = 0;long dual_piv_sort_time = 0;
    
    for (int j = 0; j < NUM_ITERATION ; j++) {
	    for( int i = 0; i < NUM_ITEMS ; i++ ){
	        rand_num = generate_random_numbers();
	        merge_list[i] = quick_list[i] = heap_list[i] = dualpiv_list[i ]= rand_num;
	
	    }//end of inner for loop
	    //System.out.println("Merge Sort Analysis: ");
	    merge_sort_time += merge_sort_analysis(merge_list, j+1);
	    //System.out.println("Quick Sort Analysis: ");
	    quick_sort_time += quick_sort_analysis(quick_list, j+1);
	    //System.out.println("Heap Sort Analysis: ");
	    heap_sort_time += heap_sort_analysis(heap_list, j+1);
	    //System.out.println("Dual pivot Sort Analysis: ");
	    dual_piv_sort_time += dual_piv_sort_analysis(dualpiv_list, j+1);
    }//end of outer for loop
   System.out.println("Average time for merge sort for " + NUM_ITERATION + " iteration is: " + merge_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for heap sort for " + NUM_ITERATION + " iteration is: " + heap_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for quick sort for " + NUM_ITERATION + " iteration is: " + quick_sort_time/NUM_ITERATION + " ns");
   System.out.println("Average time for dual pivot quick sort for " + NUM_ITERATION + " iteration is: " + dual_piv_sort_time/NUM_ITERATION + " ns");
  }//end of void main

}//end of class test
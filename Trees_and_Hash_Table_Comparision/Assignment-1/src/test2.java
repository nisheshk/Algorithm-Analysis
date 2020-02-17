import searchtrees.*;
import java.util.*;

public class test2 {
	
	public static int MAXI = 100000;
	
	public static long insert_tree(BinarySearchTree t, int i) {
		long startTime = System.nanoTime();
		t.insert(i);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long insert_tree(AVLTree t, int i) {
		long startTime = System.nanoTime();
		t.insert(i);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long insert_tree(RedBlackBST t, int i) {
		long startTime = System.nanoTime();
		t.put(i,i);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long insert_tree(SplayTree t, int i) {
		long startTime = System.nanoTime();
		t.insert(i);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long search_tree(RedBlackBST t, int random_num) {
		long startTime = System.nanoTime();
		t.contains(random_num);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long search_tree(SplayTree t, int random_num) {
		long startTime = System.nanoTime();
		t.contains(random_num);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long search_tree(BinarySearchTree t, int random_num) {
		long startTime = System.nanoTime();
		t.contains(random_num);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long search_tree(AVLTree t, int random_num) {
		long startTime = System.nanoTime();
		t.contains(random_num);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long delete_tree(AVLTree t, int elem) {
		long startTime = System.nanoTime();
		t.remove(elem);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long delete_tree(BinarySearchTree t, int elem) {
		long startTime = System.nanoTime();
		t.remove(elem);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long delete_tree(SplayTree t, int elem) {
		long startTime = System.nanoTime();
		t.remove(elem);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static long delete_tree(RedBlackBST t, int elem) {
		long startTime = System.nanoTime();
		t.delete(elem);
		long endTime = System.nanoTime();
		//System.out.println(endTime - startTime);
		return (endTime - startTime);
	}
	
	public static int generate_random_numbers() {
		int maximum = MAXI; int minimum = 1;
		Random rn = new Random();
		int range = maximum - minimum + 1;
		return rn.nextInt(range) + minimum;
	}
	
	public static void delete_tree(BinarySearchTree obj_bin, AVLTree obj_avl, RedBlackBST obj_redbl, SplayTree obj_spl, boolean random_flag) {
		long delete_binary_time = 0; long delete_avl_time = 0; int elem = 0;
		long delete_redbl_time = 0; long delete_spl_time = 0;
		for (int i = MAXI; i >= 1; i--) {
			if (random_flag) elem = generate_random_numbers();
			else elem = i;
			//System.out.println("Deleting "+ elem + " in Redblack Tree");
			delete_redbl_time += delete_tree(obj_redbl, elem);
			//System.out.println("Deleting "+ elem + " in Splay Tree");
			delete_spl_time += delete_tree(obj_spl, elem);
			//System.out.println("Deleting "+ elem + " in Binary Search Tree");
			delete_binary_time += delete_tree(obj_bin, elem);
			//System.out.println("Deleting "+ elem + " in AVL Tree");
			delete_avl_time += delete_tree(obj_avl, elem);
		}
		System.out.println("Average deletion time for " + MAXI + " nodes in Binary Search tree is: " + delete_binary_time/MAXI + " ns");
		System.out.println("Average deletion time for " + MAXI + " nodes in AVL tree is: " + delete_avl_time/MAXI + " ns");
		System.out.println("Average deletion time for " + MAXI + " nodes in Red Black BST is: " + delete_redbl_time/MAXI + " ns");
		System.out.println("Average deletion time for " + MAXI + " nodes in Splay tree is: " + delete_spl_time/MAXI + " ns");

		
	}
	
	public static void search_tree(BinarySearchTree obj_bin, AVLTree obj_avl, RedBlackBST obj_redbl, SplayTree obj_spl) {
		long search_binary_time = 0; long search_avl_time = 0;
		long search_redbl_time = 0; long search_spl_time = 0;
		for (int i = 1; i <= MAXI; i++) {
			int random_num = generate_random_numbers();
			//System.out.println("Searching "+ random_num + " in Redblack Tree");
			search_redbl_time += search_tree(obj_redbl, random_num);
			//System.out.println("Searching "+ random_num + " in Splay Tree");
			search_spl_time += search_tree(obj_spl, random_num);
			//System.out.println("Searching "+ random_num + " in Binary Search Tree");
			search_binary_time += search_tree(obj_bin, random_num);
			//System.out.println("Searching "+ random_num + " in AVL Tree");
			search_avl_time += search_tree(obj_avl, random_num);
		}
		System.out.println("Average searching time for " + MAXI + " nodes in Binary Search tree is: " + search_binary_time/MAXI + " ns");
		System.out.println("Average searching time for " + MAXI + " nodes in AVL tree is: " + search_avl_time/MAXI + " ns");
		System.out.println("Average searching time for " + MAXI + " nodes in Red Black BST is: " + search_redbl_time/MAXI + " ns");
		System.out.println("Average searching time for " + MAXI + " nodes in Splay tree is: " + search_spl_time/MAXI + " ns");

	}

	public static void insert_elements(BinarySearchTree obj_bin, AVLTree obj_avl, RedBlackBST obj_redbl, SplayTree obj_spl, boolean random_flag) {
		long insert_binary_time = 0; long insert_avl_time = 0; int elem = 0;
		long insert_redbl_time = 0; long insert_spl_time = 0;
		for (int i = 1; i <= MAXI; i++) {
			if (random_flag) elem = generate_random_numbers();
			else elem = i;
			
			//System.out.println("Inserting into RED Black tree: "+elem);
			insert_redbl_time += insert_tree(obj_redbl, elem);
			//System.out.println("Inserting into Splay tree: "+elem);
			insert_spl_time += insert_tree(obj_spl, elem);
			//System.out.println("Inserting into BST Tree: "+elem);
			insert_binary_time += insert_tree(obj_bin, elem);
			//System.out.println("Inserting into AVL Tree: "+elem);
			insert_avl_time += insert_tree(obj_avl, elem);
			}//end of for
		System.out.println("Average insertion time for " + MAXI + " nodes in Binary Search tree is: " + insert_binary_time/MAXI + " ns");
		System.out.println("Average insertion time for " + MAXI + " nodes in AVL tree is: " + insert_avl_time/MAXI + " ns");
		System.out.println("Average insertion time for " + MAXI + " nodes in Red Black BST is: " + insert_redbl_time/MAXI + " ns");
		System.out.println("Average insertion time for " + MAXI + " nodes in Splay tree is: " + insert_spl_time/MAXI + " ns");

		}
		

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> obj_bin = new BinarySearchTree<>( );
		AVLTree<Integer> obj_avl = new AVLTree<>( );
		RedBlackBST<Integer, Integer> obj_redbl = new RedBlackBST<Integer, Integer>();
		SplayTree<Integer> obj_spl = new SplayTree<Integer>( );
		
		System.out.println("Q4.a) Insertion in progress: ");
		insert_elements(obj_bin, obj_avl, obj_redbl, obj_spl, false);
		System.out.println("Q4.a) Insertion completed: ");
		System.out.println("Q4.b) Searching in progress: ");
		search_tree(obj_bin, obj_avl, obj_redbl, obj_spl);
		System.out.println("Q4.b) Searching Completed: ");
		System.out.println("Q4.c) Deletion in progress: ");
		delete_tree(obj_bin, obj_avl, obj_redbl, obj_spl, false);
		System.out.println("Q4.c) Deletion completed: ");
		
		System.out.println("Q5.a) Insertion in progress: ");
		insert_elements(obj_bin, obj_avl, obj_redbl, obj_spl, true);
		System.out.println("Q4.a) Insertion completed: ");
		System.out.println("Q5.b) Searching in progress: ");
		search_tree(obj_bin, obj_avl, obj_redbl, obj_spl);
		System.out.println("Q5.b) Searching Completed: ");
		System.out.println("Q5.c) Deletion in progress: ");
		delete_tree(obj_bin, obj_avl, obj_redbl, obj_spl, true);
		System.out.println("Q5.c) Deletion completed: ");
	}

}

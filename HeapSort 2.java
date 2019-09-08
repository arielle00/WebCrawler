import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HeapSort {
		
		private int heapSize;
		
		public HeapSort(int size) {
			heapSize=size;
		}
		
		public static void outputLinks(ArrayList<PageURL> A) {
			for(int i=0; i<30; i++) {
				System.out.print(i+1+". ");
				A.get(i).printEverything();
				
			}
		}
		
		public static void outputLinks1(ArrayList<PageURL> A) {
			for(int i=0; i<20; i++) {
				System.out.print(i+1+". ");
				A.get(i).printEverything();
				
			}
		}

		public static void main(String[] args) {
			
			ArrayList<PageURL> ArrayList = new ArrayList<>();
			ArrayList<PageURL> PriorityQueue = new ArrayList<>();
			ArrayList<PageURL> top20 = new ArrayList<>();
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a key word:");
			String keyword =input.nextLine();
			System.out.println("If you would like to see the top 30 URLS enter 'y'");
			String answer = input.next();
			
			
			WebCrawler webby = new WebCrawler(keyword);
			
			webby.search();
			if (answer.equals("y")) {
				for (String links : webby.getUrls()) {
					ArrayList.add(new PageURL(links));
					if (ArrayList.size()==30)
						break;
				}
			}
			
			outputLinks(ArrayList);
			
			HeapSort heappy = new HeapSort(30);
			
			heappy.BuildMaxHeap(ArrayList);
			heappy.Heapsort(ArrayList); //sorted
			
			System.out.println();
			System.out.println();
			System.out.println("Sorted by Heapsort: ");
			outputLinks(ArrayList);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			System.out.println();
			System.out.println();
			System.out.println("If you would like to display top 20 ranked URL type 'y'");
			String answer1=input.next();
			
			if (answer1.equals("y")) {
				
				HeapSort heappy1 = new HeapSort(20);
				heappy1.BuildMaxHeap(ArrayList);
			
				for(PageURL obj: ArrayList) {
					PriorityQueue.add(obj);
				}
			
				for (int i=0; i<=20; i++) {
					top20.add(heappy1.HeapExtractMax(PriorityQueue));
				
				}

				Collections.reverse(top20);
				outputLinks1(top20);
			}
			
//			System.out.println();
//			System.out.println("Enter a URL link to add to the list: ");
//			String link = input.next();
//			
//			ArrayList.add(new PageURL(link));
//			
//			heappy.MaxHeapInsert(link,7);
			
			
			
			
			
//				System.out.println("Here is the first ranked web url based on Rank: ");
//				System.out.println(heappy.HeapExtractMax(PriorityQueue));
		
		
		}
	
		//Parent
			public int Parent(int i) {
				return Math.floorDiv(i,2);
			}
		
		//Left
			public int Left(int i) {
				return 2*i;
			}
		
		//Right
			public int Right(int i) {
				return 2*i+1;
			}
		
		//Heapsize
			public void HeapSize(int size) {
				int heapSize=size;
				
			}
			
		//max-heapify
			public void MaxHeapify(ArrayList<PageURL> A,int i){
				int largest=0;
				int l=Left(i);
				int r=Right(i);
				if (l<=heapSize-1 && A.get(l).getRank()>A.get(i).getRank()) {
					largest = l;
				}
				else
					largest = i;
				if (r<=heapSize-1 && A.get(r).getRank()>A.get(largest).getRank()) {
					largest=r;
				}
				if (largest !=i) {
					Collections.swap(A, i, largest);
					MaxHeapify(A, largest);
				}
					
			}
		
		//build max-heap
			public void BuildMaxHeap(ArrayList<PageURL> A) {
				heapSize=A.size()-1;
				for (int i=Math.floorDiv(A.size()-1,2); i>=0; i--) {
					MaxHeapify(A,i);
				}
			}
		
		//heapsort
			public void Heapsort(ArrayList<PageURL> A) {
				BuildMaxHeap(A);
				for (int i=A.size()-1; i>1; i--) {
					Collections.swap(A, 0, i);
					heapSize=heapSize-1;
					MaxHeapify(A,0);
				}
			}
			
		//max heap insert
			public void MaxHeapInsert(ArrayList<PageURL> A, int key) {
				heapSize=heapSize+1;
//				A.set(heapSize, 100);
//				A.get(30)=100;
				A.add(heapSize, new PageURL(key));
				HeapIncreaseKey(A,heapSize,key);
						
			}
			
		//heap extract max
			public PageURL HeapExtractMax(ArrayList<PageURL>  A) {
				PageURL max;
				if (heapSize<=1)
					System.out.println("Heap Underflow");
				max=A.get(0);
				A.set(0,A.get(heapSize));
				heapSize=heapSize-1;
				MaxHeapify(A,0);
				return max;
			}
		
		//heap increase key
			public void HeapIncreaseKey(ArrayList<PageURL> A,int i,int key) {
				if (key<A.get(i).getRank())
					System.out.println("new key is smaller than current key");
				A.set(i, A.get(key));
				
				while (i>0 && A.get(Parent(i)).getRank()<A.get(i).getRank()) {
					Collections.swap(A, i, Parent(i));
					i=Parent(i);
				}
					
			}
		
		//heap maximum
			public PageURL HeapMaximum(ArrayList<PageURL> A) {
				return A.get(0);
			}
	


		}

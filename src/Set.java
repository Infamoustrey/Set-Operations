import java.util.ArrayList;
import java.util.Collections;

public class Set {

	private ArrayList<Integer> list; // Holds host set
	
	/**
	   * No arguement constructor
	   * @param n/a
	   */
	public Set(){
		list = new ArrayList<Integer>();
	}
	
	/**
	   * Constructor with an int[] array to initialize 
	   * @param array an integer array that will hold the set's data
	   */
	public Set(int[] array){
		list = new ArrayList<Integer>();
		defineSet(array);
	}
	
	/**
	   * Setter
	   * @param array an integer array that will hold the set's data
	   * @return n/a
	   */
	public void defineSet(int[] array){
		for(int i: array){
			list.add(i);
		}
	}
	
	/**
	   * Getter
	   * @param n/a
	   * @return ArrayList<Integer> 
	   */
	public ArrayList<Integer> getSet(){
		return list;
	}
	
	/**
	   * Prints union operation on set to the console
	   * @param array an integer array that will be operated on with the host set
	   * @return n/a
	   */
	public void union(ArrayList<Integer> list2){
		ArrayList<Integer> list1 = list;
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		finalList.addAll(list1);
		finalList.addAll(list2);
		
		for(int i = 0; i < finalList.size(); i++){
			int count = 0;
			for(int k = 0; k < finalList.size(); k++){
				if(finalList.get(i) == finalList.get(k)) {count++;}
			}
			
			if(count > 1){
				finalList.remove(i);
			}
			
		}
		
		Collections.sort(finalList);
		
		System.out.println(finalList);
	}
	
	/**
	   * Prints intersection operation on set to the console
	   * @param array an integer array that will be operated on with the host set
	   * @return n/a
	   */
	public void intersection(ArrayList<Integer> list2){
		ArrayList<Integer> list1 = list;
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		
		for(int i: list1){
			boolean isInList = false;
			for(int k: list2){
				if(i == k){
					isInList = true;
				}
			}
			
			if(isInList){
				finalList.add(i);
			}
		}
		
		Collections.sort(finalList);
		
		System.out.println(finalList);
	}
	
	/**
	   * Prints compliment operation on set to the console
	   * @param array an integer array that will be operated on with the host set
	   * @return n/a
	   */
	public void compliment(ArrayList<Integer> list2){
		ArrayList<Integer> list1 = list;
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		
		for(int i: list1){
			boolean isInList = false;
			for(int k: list2){
				if(i == k){
					isInList = true;
				}
			}
			
			if(!isInList){
				finalList.add(i);
			}
		}
		
		Collections.sort(finalList);
		
		System.out.println(finalList);
	}

	
}

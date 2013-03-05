package stein.interviews;

public class DuplicateInteger {
	public int findDuplicate(int[] array){
		int high=array.length-1;
		int low=0;
		int mid=0;
	
		while(low<high){
			mid=(low+high)/2;
			if(low==mid||high==mid){
				return array[mid];	
			}
			if(array[mid]!=array[low]+mid-low){
				high=mid;
			}else{
				low=mid;
			}
		}
		return -1;
	}

}

package stein.interviews;

public class DuplicateInteger {
	public int findDuplicate(int[] array){
		int high=array.length-1;
		int low=0;
		int mid=0;
	
		while(low<=high){
			mid=(low+high)/2;
			
			if(array[mid]!=array[low]+mid-low){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		
		if(low==mid||high==mid){
			return array[mid];	
		}
		return -1;
	}
public static void main(String[] args){
	DuplicateInteger x=new DuplicateInteger();
	
	int[] array=new int[12];
	
	array[0]=1;
	array[1]=2;
	array[2]=3;
	array[3]=4;
	array[4]=5;
	array[5]=6;
	array[6]=7;
	array[7]=8;
	array[8]=9;
	array[9]=10;
	array[10]=10;
	array[11]=11;
	
	int num=x.findDuplicate(array);
	System.out.println(num);
}
}

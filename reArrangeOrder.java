/*
Suppose you were asked to write a program that takes an array A of n numbers, and rearranges A's elements to get a 
new array B having the property that B[0] < B[l] > B[2] < B[3] > B[4] < B[5] > of the sorted array (Basically Highs and lows or mountains and valleys).
*/


public void reArrange(List<Integer> arr){
  if(arr == null) throw new IllegalArgumentException(); //nothing to reArrange
  
  if(arr.length < 2) throw new IllegalArgumentException(); // nothing to reArrange
  
  for(int i = 0; i < arr.length-1; i++){
    if((i % 2 == 0 && arr.get(i) < arr.get(i+1)) || i % 2 != 0 && arr.get(i) > arr.get(i+1))
    //Basically even indexes needs to be lower than their corresponding odd indexes of i+1. Can be seen by Pattern recognition 
      Collections.swap(arr, i, i+1);
  }
}

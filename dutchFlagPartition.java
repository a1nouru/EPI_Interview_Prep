//
    
    /* 
    //This way of solving this problem does not create an additional arr which explains the Big of O (n^2).
    The alternative way involves creating an additional array and making 3 passes. 1st pass is adding the elements less than pivot,
    2nd pass is adding elements euqal to pivot and finally 3rd pass is adding elements greater than pivot. (Very straight forward)
     */
   public static void sort(List<Integer>arr, int pivot){

       //The way this works: - Well index i will keep track of all the elements less than pivot and j will act as our current 
       // index,
       //hence if arr.get(j) < a.get(pivot) then we swap it with i's element.
       //Same works for Greater values
       for(int i = 0; i < arr.size(); i++){

           for(int j = i+1; j < arr.size(); j++){
               //Look for smaller elements compared to pivot element
               if(arr.get(j) < arr.get(pivot)){
                   Collections.swap(arr, j, pivot);
                   break;
               }
           }

           //Second pass: Looking for greater elements compared to pivot
           for(int i = arr.size(); i >= 0 && arr.get(i) >= arr.get(pivot); i--){
               
               for(int j = i-1; j>= 0 && arr.get(j) > arr.get(pivot); j--){
                   if(arr.get(j) > arr.get(pivot)){
                       Collections.swap(arr,i, j);
                   }
               }
           }
       }
   }

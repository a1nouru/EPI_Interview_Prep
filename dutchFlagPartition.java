//
   public static void sort(List<Integer>arr, int pivot){

       //The way this works: - Well index i will keep track of all the elements less than pivot and j will act as our current 
       // index,
       //hence if arr.get(j) < a.get(pivot) then we swap it with i's element.
       //Same works for Greater values
       int smaller = 0;
       for(int i = 0; i < arr.size(); i++){
               //Look for smaller elements compared to pivot element
               if(arr.get(i) < arr.get(pivot)){
                   Collections.swap(arr, smaller++, i);
                   break;
               }
       }
       
           //Second pass: Looking for greater elements compared to pivot
       int bigger = arr.size()-1;
       for(int i = arr.size()-1; i >= 0 && arr.get(i) >= arr.get(pivot); i--){
           if(arr.get(i) > arr.get(pivot)){
               Collections.swap(arr,bigger--, i);
           }
       }
   }

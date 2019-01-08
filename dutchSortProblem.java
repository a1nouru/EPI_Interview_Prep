Reference https://coderbyte.com/algorithm/dutch-national-flag-sorting-problem
//The Dutch national flag sorting problem

/*

 Create a low pointer at the beginning of the array and a high pointer at the end of the array.
 Create a mid pointer that starts at the beginning of the array and iterates through each element.
 If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
 If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
 If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.

*/

private static void swap (int indx1, int indx2, int [] arr) {
        int temp =  arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = temp;
    }
    public static void dutchSortProblem(int [] arr){
        //Edge cases 
        if (arr == null) return;
        if(arr.length < 3) return;

        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid < high){
            if(arr[mid] == 2){ // case 2
                swap(mid, high, arr);
                high--;
            }
            else if(arr[mid] == 0){ // case 0
                swap(mid, low, arr);
                mid++;
                low++;
            }
            else if(arr[mid] == 1) //case 1
                mid++;
        }
    }

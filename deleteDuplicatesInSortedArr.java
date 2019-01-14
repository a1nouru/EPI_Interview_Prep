/* Write a program which takes as input a sorted array and updates it so that all dupli¬ cates have been removed and the 
remaining elements have been shifted left to fill the emptied indices. Return the number of valid elements. Many languages
have library functions for performing this operation—you cannot use 
these functions.
*/

 public static int findRepeat(List<Integer> arr){
        if(arr == null) return null;
        if (arr.size() == 0) return null;

        if(arr.isEmpty()) return null;

        int indexWritten = 0;
        for(int i = 1; i < arr.size(); i++){
            if(!arr.get(indexWritten).equals(arr.get(i))){
                arr.set(indexWritten++ + 1, arr.get(i));//the 3++ signs. First 2 means postincrement indeWritten and then add 1. 
            }
        }
        return indexWritten;
    }

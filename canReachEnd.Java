
/*
     //Advancing in the array 
     Write a program which takes an array of n integers, where A[i] denotes the maximum you can advance
     from index i, and returns whether it is possible to advance to the last index starting from the beginning
     of the array.
     */
    public static boolean canReachEnd(int [] arr){
        if(arr == null) return false;

        if (arr.length == 0) return false;

        int lastIndex = arr.length-1;
        int indexSoFar = 0;

        //Hint in the question is "maximum you can advance
        //     from index i" which brings in the idea of keeping max so far.
        for (int i  = 0; i <= lastIndex && indexSoFar <= lastIndex; i++){
            //Keeping track of farthest we can go.
            indexSoFar = Math.max(indexSoFar, arr[i] +i);
        }
        return indexSoFar >= lastIndex;
    }

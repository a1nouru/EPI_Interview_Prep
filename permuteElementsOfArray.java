 //Given an array A of n elements and a permutation P, apply P to A.
    //For example, the permutation (2,0,1,3} applied to A = (a,b,c,d} yields the array (b,c,a, d).
    
    
    //Here is how this works: Every time you move element of index i in letters and move it to perm.get(next),
    //You do complete the cycle by swapping element of i and perm.get(next) of letters.
    // You keep doing this so long as the value of per.get(next) is not negative.
    public static void reOrder(List<Integer> perm, List<Character> letters){
        if (perm == null || letters == null) return;
        int next = 0;
        for(int i = 0; i < letters.size(); i++){
            next = i;

            // Check if the element at index i has not been moved by checking if
            // perm.get(i) is non-negative.
            while(perm.get(next) >= 0){
                int temp = perm.get(next);
                Collections.swap(letters, i, perm.get(next));

                // Subtracts perm.sizeO from an entry in perm to make it negative ,
                // which indicates the corresponding move has been performed .
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }

class Solution {

// Person with 2 is celebrity 
    static int MATRIX[][] = { { 0, 0, 1, 0 }, 
                               { 0, 0, 1, 0 },  
                              { 0, 0, 0, 0 }, 
                              { 0, 0, 1, 0 } }; 
  
    // Returns true if a knows 
    // b, false otherwise 
    static boolean knows(int a, int b)  
    { 
        boolean res = (MATRIX[a][b] == 1) ?  
                                     true :  
                                     false; 
        return res; 
    } 
  public static int find Celeb(int n){
    if(arr == null) return -1;
    if(n < 2) return -1;
    
    
    int a = 0;
    int b = n-1
    
    while(a < b){
      if(knows(a,b))
        a++; //a can not be the celeb since a knows somebody in the party
      else 
        b--; //checking if a might know the next b person till a==b
    }
    
    
    // If any person doesn't  (At this point a might know someone who existed previously before a in the array. 
    Ie: if a = 8, we want to check if 8 might know any person from 1-7))
    
    // know 'a' or 'a' doesn't 
    // know any person, return -1 
    for(int i = 0; i < n; i++){
      if(i !0 && (knows(a,i) || !knows(i,a)))
        return -1;
    }
    return a;
  }
}

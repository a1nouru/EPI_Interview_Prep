/*

Write a program that takes an integer argument and returns all the primes between 1 and thatinteger. 
Forexample,if theinputis18,youshould return(2,3,5,7,11,13,17).

  compute the primes and when a number is identified as a prime, to "sieve" it, i.e., remove all its 
  multiples from future consideration. We use a Boolean array to encode the candidates, i.e., if the zth 
  entry in the array is true, then i is potentially a prime.
*/

  public static List<Integer> findPrime(int num){

    if(num < 2) return new ArrayList<>();
    List<Integer> primes = new ArrayList<>(); 
     List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(num+1, true));

     isPrime.set(0,false); //zero and 1 cant be prime.
     isPrime.set(1, false);

      for(int p = 2; p < num; p++){
        if (isPrime.get(p)){
          primes.add(p);
          for(int i = p; i <num; i+=p){
            isPrime.set(i, false); //Remove all the multiples of p which is prime.
          }
         }
       }
       return primes;
      }
      
      /*
      REFERENCE: Elements of programming interview Pg: 73
      We justified the sifting approach over the trial-division algorithm on heuristic grounds. The time to sift out the 
      multiples of p is proportional to n/p, so the overall time complexity is 0(n/2 + n/3 + n/5 + n/7 + n/11 + ... ). 
      Although not obvious, this sum asymptotically tends to n log log n, yielding an 0(n log log n) time bound. 
      The spacecomplexityisdominatedbythestorageforP,i.e.,0(n).
      
      */

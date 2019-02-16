/*

Write a program which takes as input a valid Roman number string s and returns the integer it corresponds to.
*/
//Here we only check for one condition. We check if the current element is smaller than the 
    // next and then subtract it from the sum, otherwise we add it. 
    public static int nextPerm(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int sum = map.get(s.charAt(s.length()-1)); //Initialize the
        for(int i = s.length()-2; i >= 0; i--){
            if(s.charAt(i) < s.charAt(i+1))
                sum -= map.get(s.charAt(i)); //Ie: IV
            else
                sum += map.get(s.charAt(i)); //Ie: VI
        }
        return sum;
    }

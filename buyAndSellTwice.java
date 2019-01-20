    /*
         Write a program that computes the maximum profit that can be made by buying and selling a share at
         most twice. The second buy must be made on another date after the first sale.
         
         How this works according to EPI: 
         For each day, we combine this result with the result from the forward iteration for the previous day—this 
         yields the maximum profit if we buy and sell once before the current day and once at or after the current day. 
     */

    public static double buyAndSell2(List<Integer> arr){
        if(arr == null) return -1;

        if (arr.size() < 2) return -1;

        double minP = Double.MAX_VALUE, profitSoFar = 0;
        List<Double> firstbuySellProfs = new ArrayList<>();

        // Forward phase. For each day, we record maximum profit if we // sell on that day.
        for (int i = 0; i < arr.size(); i++){
            minP = Math.max(minP, arr.get(i));
            profitSoFar = Math.max(profitSoFar, arr.get(i) - minP);
            firstbuySellProfs.add(profitSoFar);
        }

        int maxPrice = Integer.MIN_VALUE;
        // Backward phase. For each day, find the maximum profit if we make // the second buy on that day.
        for (int j = arr.size()-1; j >0; j--){
            maxPrice = Math.max(maxPrice, arr.get(j));
            //Adding backward profits to the forward sell of the previous day sell
            profitSoFar = Math.max(profitSoFar, maxPrice - arr.get(j) + firstbuySellProfs.get(j-1));
        }
         return profitSoFar;
    }

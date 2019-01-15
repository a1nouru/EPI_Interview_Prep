/*
Write a program that computes the maximum profit that can be made by buying and selling a share at most twice. 
The second buy must be made on another date after the first sale.
*/

public static double saleStockTwice(List<Integer> arr){
        if(arr == null) return -1;
        if (arr.size() == 0) return -1;

        double maxProfSoFar = 0;
        double minPrice = Integer.MAX_VALUE;
        List<Double> maxProfList = new ArrayList<>();

        // Forward phase. For each day, we record maximum profit if we // sell on that day.
        for (int i = 0; i < arr.size(); i++){
            minPrice = Math.min(minPrice, arr.get(i));
            maxProfSoFar = arr.get(i) - minPrice;
            maxProfList.add(maxProfSoFar);
        }

        double maxPriceSoFar = Double.MIN_VALUE;

        // Backward phase. For each day, find the maximum profit if we make // the second buy on that day.
        for (int i = arr.size(); i < arr.size(); i++){
            maxPriceSoFar = Math.max(maxPriceSoFar, arr.get(i));
            maxProfSoFar = Math.max(maxProfSoFar, maxPriceSoFar - arr.get(i) + maxProfList.get(i-1)); //Add second
            //sale to prev first sale.
        }
        return maxProfSoFar;
    }

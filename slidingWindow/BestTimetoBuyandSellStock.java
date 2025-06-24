package slidingWindow;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        System.out.println("maxProfit() method start");
        int firstIndex = 0;
        int nextIndex = 1;
        int profit = 0;
        int pricesLength = prices.length;
        int count = 0;
        if (pricesLength<2){
            return 0;
        }
        while(pricesLength>nextIndex){
            count++;
            if(prices[nextIndex]<prices[firstIndex]){
                firstIndex=nextIndex;
                nextIndex++;
                continue;
            }

           profit = Math.max(profit, (prices[nextIndex] - prices[firstIndex]));
           nextIndex++;
        }
        System.out.println("maxProfit() method end::"+count);
        return profit;
    }


}

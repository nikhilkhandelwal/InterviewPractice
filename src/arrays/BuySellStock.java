package arrays;

/**
 * Created by nikhandelwal on 12/7/2015.
 */
public class BuySellStock {

    public static void main(String [] args) {
    }

        public int maxProfit(int[] prices) {

            int min = prices[0];
            int profit = 0;

            for(int i = 1 ; i< prices.length ; i++){

                if(prices[i] < min)
                    min = prices[i] < min ? prices[i] : min;
                else
                    profit = (prices[i] - min) >  profit ? (prices[i] - min) : profit;

            }

            return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {

        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            int previousCash = cash;
            int previousHold = hold;

            // Sell today OR do nothing
            cash = Math.max(
                previousCash,
                previousHold + prices[i] - fee
            );

            // Buy today OR keep holding
            hold = Math.max(
                previousHold,
                previousCash - prices[i]
            );
        }

        return cash;
    }
}

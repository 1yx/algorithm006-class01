package com.aizain.jhome.computer.data.recursive;

/**
 * MaxProfit
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/3/1
 */
public class MaxProfit2 {

    /**
     * 审题：
     * 1 买卖次数不限制
     * 2 买前必须全部卖出
     * <p>
     * 思路：
     * 1 无思路，直接看题解
     * 2 贪心算法：买进，高就卖出，重复以上
     * <p>
     * 反馈：
     * 1 贪心算法简洁版
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // return greedySolution(prices);
        return greedyCleanSolution(prices);
    }

    /**
     * 贪心算法简洁版
     * 1 ms	42.9 MB
     *
     * @param prices
     * @return
     */
    private int greedyCleanSolution(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * 贪心算法：买进，高就卖出，重复以上
     * 1 ms	42.4 MB
     *
     * @param prices
     * @return
     */
    private int greedySolution(int[] prices) {
        int profit = 0;
        for (int i = 1, buy = 0; i < prices.length; i++) {
            if (prices[buy] > prices[i]) {
                buy = i;
            }
            if (prices[i] > prices[buy]) {
                profit += prices[i] - prices[buy];
                buy = i;
            }
        }
        return profit;
    }

}

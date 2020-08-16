package com.plxcc.algorithm;

/**
 * @PackgeName: com.plxcc.algorithm
 * @ClassName: Test
 * @Author: plxc
 * Date: 2020/8/16 0:34
 * project name: 算法练习区
 * @Version:
 * @Description:
 */
public class Test {

    public static int maxProfit(int[] prices) {
        // write code here
        int profit=0;
        int priceMin=prices[0];
        for(int i:prices){
            if(priceMin>i){
                priceMin=i;
            }
            if(profit<i-priceMin){
                profit=i-priceMin;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int prices[]={2,4,1,1,2,4,1,5};
        System.out.println();
        System.out.println(maxProfit(prices));
    }
}

package G20200343030379;

import java.util.Arrays;

/**
 *  860. 柠檬水找零
 *
 *  在柠檬水摊上，每一杯柠檬水的售价为?5?美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回?true?，否则返回 false?。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 *
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 *
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * ?
 *
 * 提示：
 *
 * 0 <= bills.length <= 10000
 * bills[i]?不是?5?就是?10?或是?20?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：https://leetcode-cn.com/problems/lemonade-change/solution/lemonade-change-tan-xin-suan-fa-by-jyd/
 *
 *
 */



public class LeetCode_860_379 {

    public static void main(String[] args) {
        new LeetCode_860_379().lemonadeChange(new int[]{5,5,5,10,20});
    }

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 99.92% 的用户
     * 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了 5.15% 的用户
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for (int bill : bills) {
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five==0){
                    return false;
                }
                five--;
                ten++;
                //20块==（10+5）+5
                //或 （5+5+5）+5
            }else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if(five>2){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}

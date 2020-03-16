package G20200343030379;
/**
 * 91. ���뷽��
 *
 * һ��������ĸ?A-Z ����Ϣͨ�����·�ʽ�����˱��룺
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * ����һ��ֻ�������ֵķǿ��ַ������������뷽����������
 *
 * ʾ�� 1:
 *
 * ����: "12"
 * ���: 2
 * ����:?�����Խ���Ϊ "AB"��1 2������ "L"��12����
 * ʾ��?2:
 *
 * ����: "226"
 * ���: 3
 * ����:?�����Խ���Ϊ "BZ" (2 26), "VF" (22 6), ���� "BBF" (2 2 6) ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/decode-ways
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 */
public class LeetCode_91_379 {
    public static void main(String[] args) {
        new LeetCode_91_379().numDecodings2("100");
    }
    //��̬�滮 ���ҵ���
    /**
     * dp[i]=dp[i+1]+dp[i+2]
     *
     * ���룺1212
     * 2
     * 12
     * 212= 2 12  212
     * 1212=1 212�� 12 12
     *
     * 0:������
     * <=26  dp[i]=dp[i+1]+dp[i+2]
     * >26  dp[i]=dp[i+1]
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 38.1 MB , ������ Java �ύ�л����� 5.01% ���û�
     *
     * �ο���⣺https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
     * https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];

        //��������
        dp[s.length()]=1;
        //��ʼ�����ַ�


        if(s.charAt(s.length()-1)=='0'){
            dp[s.length()-1]=0;
        }else{
            dp[s.length()-1]=1;
        }


        for (int i = s.length()-2; i >= 0; i--) {
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }

            //С��26
            if((s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26){
                dp[i]=dp[i+1]+dp[i+2];
            }else{
                dp[i]=dp[i+1];
                //System.out.println("==");
            }
        }
        return dp[0];
    }


    //��̬�滮 ������,�������˼·�ǲ�ͬ��
    /**
     * dp[i]=dp[i+1]+dp[i+2]
     *
     * ���룺1212
     * 2
     * 12
     * 212= 2 12  212
     * 1212=1 212�� 12 12
     *
     * 0:������
     * <=26  dp[i]=dp[i+1]+dp[i+2]
     * >26  dp[i]=dp[i+1]
     *
     * �ο���⣺https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
     *
     * ִ����ʱ : 1 ms , ������ Java �ύ�л����� 100.00% ���û�
     * �ڴ����� : 38.4 MB , ������ Java �ύ�л����� 5.01% ���û�
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int[] dp=new int[s.length()+1];

        //��������
        dp[0]=1;
        //��ʼ�����ַ�


        //�����һ��0���Ƿ�
        if(s.charAt(0)=='0'){
            dp[1]=0;
        }else{
            dp[1]=1;
        }

        for (int i = 2; i <= s.length(); i++) {
           /* if(s.charAt(i-1)=='0'){
                dp[i]=dp[i-1];
                continue;
            }*/
            if(s.charAt(i-1)-'0'>=1 && (s.charAt(i-1)-'0')<=9){
                dp[i]=dp[i]+dp[i-1];
            }

            int send=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
            if(send>=10 && send<=26){
                dp[i]=dp[i]+dp[i-2];
            }

        }
        return dp[s.length()];
    }
}

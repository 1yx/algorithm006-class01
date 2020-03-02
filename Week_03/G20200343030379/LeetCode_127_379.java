package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *  127. ���ʽ���
 *
 *  �����������ʣ�beginWord?�� endWord����һ���ֵ䣬�ҵ���?beginWord ��?endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 *
 *  ÿ��ת��ֻ�ܸı�һ����ĸ��
 *  ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 *  ˵��:
 *
 *  ���������������ת�����У����� 0��
 *  ���е��ʾ�����ͬ�ĳ��ȡ�
 *  ���е���ֻ��Сд��ĸ��ɡ�
 *  �ֵ��в������ظ��ĵ��ʡ�
 *  ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 *  ʾ��?1:
 *
 *  ����:
 *  beginWord = "hit",
 *  endWord = "cog",
 *  wordList = ["hot","dot","dog","lot","log","cog"]
 *
 *  ���: 5
 *
 *  ����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *       �������ĳ��� 5��
 *  ʾ�� 2:
 *
 *  ����:
 *  beginWord = "hit"
 *  endWord = "cog"
 *  wordList = ["hot","dot","dog","lot","log"]
 *
 *  ���:?0
 *
 *  ����:?endWord "cog" �����ֵ��У������޷�����ת����
 *
 *  ��Դ�����ۣ�LeetCode��
 *  ���ӣ�https://leetcode-cn.com/problems/word-ladder
 *  ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *  ������⣺
 */



public class LeetCode_127_379 {

    public static void main(String[] args) {
        int i = new LeetCode_127_379().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }


    /**
     *  �ݹ鷨-�����������
     *  ִ����ʱ :
     *  �ڴ�����
     *
     *  �ο���⣺
     *
     */
    int minCount=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.equals(endWord)) return 1;
        Set<String> visited=new HashSet();
        dfs(beginWord,endWord,wordList,visited,0);
        return (minCount==Integer.MAX_VALUE)?0:minCount;

    }

    private void dfs(String begin, String end, List<String> wordList,Set<String> visited,int level) {
        if(begin.equals(end)){
            //if(minCount>level){
                minCount=level;
            //}
            return ;
        }


        for (String word : wordList) {
            if (visited.contains(word)) {
                continue;
            }
            int diff=0;
            for (int i = 0; i < begin.length(); i++) {
                if (begin.charAt(i)!=word.charAt(i)) {
                    if(++diff >1){
                        break;
                    }
                }

            }
            if(diff==1 && !visited.contains(word)){
                visited.add(word);
                dfs(word,end,wordList,visited,level+1);
                visited.remove(word);
            }
        }
    }

    /**
     * ������-�����������(ע�⣺����������־���ɺ�����ע�ⲻҪ��)
     *
     * ִ����ʱ :
     * �ڴ����� :
     *
     * �ο���⣺https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
     *
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)){
            return 0;
        }

        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            while (size-- >0){
                String poll = queue.poll();
                if(poll.equals(endWord)) return level;

                char[] chars = poll.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old=chars[i];

                    for (char c='a' ;c<='z';c++) {
                        chars[i] = c;

                        String next=new String(chars);

                        if(endWord.equals(next)){
                            return level+1;
                        }

                        if(!visited.contains(next) && wordList.contains(next)){
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    chars[i]=old;
                }
            }
            level++;
        }
        return 0;
    }



}

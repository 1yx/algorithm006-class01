"""
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
"""

class Solution:
    def numDecodings(self, s: str) -> int:
        n=len(s)
        if(not s or s[0]=="0"):
            return 0
        pre=1
        cur=1
        for i in range(1,n):
            if(s[i]=="0"):
                if(s[i-1]=="1" or s[i-1]=="2"):
                    cur=pre
                else:
                    return 0
            else:
                if(s[i-1]=="1" or (s[i-1]=="2" and "1"<=s[i]<="6")):
                    tmp=cur
                    cur+=pre
                    pre=tmp
                else:
                    pre=cur
                    cur=cur
        return cur

class Solution2:
    def numDecodings(self, s: str) -> int:
        n=len(s)
        if(not s or s[0]=="0"):
            return 0
        dp=[0]*(n+1)
        dp[0]=1
        dp[1]=1
        for i in range(1,n):
            if(s[i]=="0"):
                if(s[i-1]=="1" or s[i-1]=="2"):
                    dp[i+1]=dp[i-1]
                else:
                    return 0
            else:
                if(s[i-1]=="1" or (s[i-1]=="2" and "1"<=s[i]<="6")):
                    dp[i+1]=dp[i]+dp[i-1]
                else:
                    dp[i+1]=dp[i]
        return dp[-1]

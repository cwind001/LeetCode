package com.cwind.leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 7/4/15
 * Time: 5:08 PM
 * Email: billchen01@163.com
 * #10 - Hard
 */
public class RegularExpressionMatching {

    //Greedy algorithm, but may fail for "aaa", "ab*a*c*a" - DP will solve this.
    public boolean greedyIsMatch(String /* string to check */ s, String /* patterns */ p) {
        int sindex = 0, pindex=0;
        for(;pindex<p.length(); pindex++){
            if(sindex>=s.length()){
                break;
            }
            char cp = p.charAt(pindex);
            //match {x}*
            if((pindex<p.length()-1)&&p.charAt(pindex+1)=='*'){
                if(cp=='.'){ //case: .*
                    if(pindex+2>=p.length()){ // pattern ends with '.*'
                        return true;
                    }else { // find p[pindex+2] in s
                        char nextc = p.charAt(pindex+2);
                        boolean found = false;
                        while(sindex<s.length()){
                            if(s.charAt(sindex)==nextc){
                                sindex++;
                                pindex+=2;
                                found = true;
                                break;
                            } else {
                                sindex++;
                            }
                        }
                        if(!found){
                            return false;
                        }
                    }
                }else { // {x}*, x is not '.'
                    //Should check the characters after '*' to see how many 'x' should there be
                    int pcount = 0, scount = 0; //scount should be no less than pcount
                    while((pindex+2+pcount<p.length())&&p.charAt(pindex+2+pcount)==cp){ //Calculate pcount
                        pcount++;
                    }
                    while ((sindex+scount<s.length())&&s.charAt(sindex+scount)==cp) {
                        scount++;
                    }
                    if(scount<pcount){
                        return false;
                    }

                    pindex = pindex + pcount + 1;
                    sindex = sindex + scount;
                }
            } else { //Check single char
                  if(cp=='.'){
                      sindex++;
                  }else{
                      if(s.charAt(sindex)!=cp){
                          return false;
                      } else {
                          sindex++;
                      }
                  }
            }

        }
        //Patterns ends while still chars in input string
        if(sindex<s.length()||pindex<p.length()){
            return false;
        }
        return true;
    }

    // Dynamic Programming Solution
    public boolean isMatch(String /* string to check */ s, String /* patterns */ p) {
        boolean[] match = new boolean[s.length()+1];
        for(int i=0; i<match.length; i++){
            match[i] = false;
        }
        match[s.length()] = true;
        for(int i=p.length()-1; i>=0; i--){
            if(p.charAt(i)=='*'){
                for(int j=s.length()-1; j>=0; j--){
                    match[j] = match[j]||match[j+1]&&(p.charAt(i-1)=='.'||p.charAt(i-1)==s.charAt(j));
                }
                i--;
            }else {
                for(int j=0; j<s.length(); j++){
                    match[j] = match[j+1]&&(p.charAt(i)=='.'||p.charAt(i)==s.charAt(j));
                }
                match[s.length()] = false;
            }
        }

        return match[0];
    }

   /*
   '.' Matches any single character.
   '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true
    */
    public static void main(String[] args){
        RegularExpressionMatching tester = new RegularExpressionMatching();
        System.out.println(tester.isMatch("aa", "a"));      // false
        System.out.println(tester.isMatch("aa", "aa"));     // true
        System.out.println(tester.isMatch("aaa", "aa"));    // false
        System.out.println(tester.isMatch("aa", "a*"));     // true
        System.out.println(tester.isMatch("aa", ".*"));     // true
        System.out.println(tester.isMatch("ab", ".*"));     // true
        System.out.println(tester.isMatch("aab", "c*a*b")); // true
        System.out.println(tester.isMatch("acb", "a*.b"));  // true
        System.out.println(tester.isMatch("aaa", "aaaa"));  // false
        System.out.println(tester.isMatch("ab", ".*c"));    // false
        System.out.println(tester.isMatch("aaa", "a*a"));   // true
        System.out.println(tester.isMatch("aaa", "a*aa"));  // true
        System.out.println(tester.isMatch("aaa", "a*aaa")); // true
        System.out.println(tester.isMatch("aaa", "ab*a*c*a"));    // true
        System.out.println(tester.isMatch("aaaa", "ab*a*c*a"));    // true
        System.out.println(tester.isMatch("abaaaaaccca", "ab*a*c*a"));    // true
        System.out.println(tester.isMatch("abca", "ab*a*c*a"));    // true
        System.out.println(tester.isMatch("aa", "ab*a*c*a"));    // true
        System.out.println(tester.isMatch("abbbccca", "ab*a*c*a"));    // true
    }
}

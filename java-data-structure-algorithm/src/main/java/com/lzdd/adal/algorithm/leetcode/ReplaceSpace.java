package com.lzdd.adal.algorithm.leetcode;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/10 9:38 下午
 **/
public class ReplaceSpace {


    public static void main(String[] args) {
        ReplaceSpace rs = new ReplaceSpace();
        String testStr = " A BP  OO   ";
        System.out.println(testStr);
        System.out.println(rs.replace(new StringBuffer(testStr)));
    }

    public String replace(StringBuffer stringBuffer){
        int p1 = stringBuffer.length() -1;
        for (int i = 0; i <= p1;i++){
            if (' ' == stringBuffer.charAt(i)){
                stringBuffer.append("  ");
            }
        }
        int p2 = stringBuffer.length() -1;
        while (p1 >= 0 && p1 < p2){
            char c = stringBuffer.charAt(p1--);
            if (' ' == c){
                stringBuffer.setCharAt(p2--,'0');
                stringBuffer.setCharAt(p2--,'2');
                stringBuffer.setCharAt(p2--,'%');
            }else {
                stringBuffer.setCharAt(p2--,c);
            }
        }

        return stringBuffer.toString();
    }
}

package com.imdnd.common.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Adam DENG
 * @Date 2018/5/18 15:17
 */
public class Combination {

    public static void combine(Integer[] source, int begin, int number, List<Integer> result) {
        if (number == 0) {
            System.out.println(result.toString());
            return;
        }
        if (begin == source.length) {
            return;
        }
        result.add(source[begin]);
        combine(source, begin + 1, number - 1, result);
        result.remove(source[begin]);
        combine(source, begin + 1, number, result);
    }

    // 方法一
    public static List<Integer> combine(Integer[] chs) {

        if (chs == null || chs.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, result);
        }
        return result;
    }

    /**
     *
     * 方法二
     *
     * @param chs
     * @return
     */
    public static List<List<Integer>> comb(Integer[] chs) {
        List<List<Integer>> result = new ArrayList();
        int len = chs.length;
        int nbits = 1 << len;
        for (int i = 0; i < nbits; ++i) {
            int t;
            List<Integer> subResult = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                t = 1 << j;
                if ((t & i) != 0) {
                    subResult.add(chs[j]);
                }
            }
            result.add(subResult);
        }
        result.remove(0);
        return result;
    }


    public static void main(String[] args) {
        Integer[] chs = {1, 2, 4, 8, 16, 32, 64, 128};
        List<List<Integer>> result = comb(chs);
        List<Integer> amount = new ArrayList<>();
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for (List<Integer> target : result) {
            Integer sum = target.stream().mapToInt(value -> value).sum();
            amount.add(sum);
            listMap.put(sum, target);
        }
        System.out.println(amount.toString());
        System.out.println(listMap.toString());
    }


}

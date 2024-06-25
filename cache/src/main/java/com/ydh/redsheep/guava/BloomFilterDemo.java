package com.ydh.redsheep.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterDemo {

    //模拟布隆过滤器预计存储数据的大小，这里设置为100万
    private static int size = 1000000;
    //设置 期望的误判率
    private static double error = 0.000000000001;
    /**
     *  创建布隆过滤器
     *  Integer：表示过滤器存储的是整数类型的数据
     *  Funnels.integerFunnel()：表示过滤器只对整数类型进行判断
     */
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, error);
    //设置样本数据为100万
    private static int total = 1000000;

    public static void main(String[] args) {
        //1、在布隆过滤器中，插入样本数据
        for (int i = 0; i < total; i++) {
            //使用put()插入即可
            bloomFilter.put(i);
        }
        //2、定义一个误判数据量的计量值
        int count = 0;
        //3、误判测试前，打印下一句话，用于测试误判测试时间
        System.out.println("误判开始");
        /**
         * 4、添加10万个布隆过滤器中不存在的数据，用于测试误判率
         *
         *    这里直接在total的基础上，再加10万的数据
         */
        for (int i = total; i < total+100000; i++) {
            //mightContain()判断数据是否存在于布隆过滤器中
            if (bloomFilter.mightContain(i)) {
                count++;
                System.out.println("数据：" + i + "误判了");
            }
        }
        //打印误判数据及耗时
        System.out.println("总共误判数为：" + count);
    }

}

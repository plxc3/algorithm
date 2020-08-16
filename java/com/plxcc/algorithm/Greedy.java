package com.plxcc.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @PackgeName: com.plxcc.algorithm
 * @ClassName: Greedy
 * @Author: plxc
 * Date: 2020/8/15 23:02
 * project name: 算法练习区
 * @Version:
 * @Description:
 */
public class Greedy {
    public static void main(String[] args) {
        //创建广播电台
        HashMap<String, HashSet<String>> broadCasts = new HashMap<String, HashSet<String>>();
        //将各个电台放到broadCats中
        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("成都");
        hashSet1.add("杭州");
        hashSet3.add("上海");
        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5=new HashSet<>();
        hashSet5.add("大连");
        hashSet5.add("杭州");
//        加到mapzhong
      broadCasts.put("k1",hashSet1);
      broadCasts.put("k2",hashSet2);
      broadCasts.put("k3",hashSet3);
      broadCasts.put("k4",hashSet4);
      broadCasts.put("k5",hashSet5);
//      allAreas存放所有地区
        HashSet<String> allAreas=new HashSet<>();
        for(Map.Entry<String,HashSet<String>> m:broadCasts.entrySet()){
            for (String s:m.getValue()){
                allAreas.add(s);
            }
        }
        System.out.println(allAreas);
        //创建ArrayList存放选择的电台集合
        ArrayList<String> selects=new ArrayList<>();

        //定义临时的集合的，存放遍历的过程中的，存放遍历过程中电覆盖的的地区和还没有覆盖的地区的交集
        HashSet<String> tempSet=new HashSet<>();

        //定义maxKey，保存在一次遍历中，能覆盖的最大地区的对应电台的key
        //如果maxKey不为空，则加入到selects中去
        while (allAreas.size()!=0){
            tempSet.clear();
            for(String key:broadCasts.keySet()){
                String maxKey=null;
                HashSet<String> areas=broadCasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas的交集
                tempSet.retainAll(allAreas);
                if(tempSet.size()>0&&(maxKey==null||tempSet.size()>broadCasts.get(maxKey).size())){
                    maxKey=key;
                }
                if(maxKey!=null){
                    selects.add(maxKey);
                    allAreas.removeAll(broadCasts.get(maxKey));
                }
            }
        }
        System.out.println(selects);

    }



}

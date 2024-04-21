package com.word.luoji.tupian;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DuiBiTupian {
    public static List<String> list1=new ArrayList<>();
    public static List<String> list2=new ArrayList<>();
    public static List<String> list3=new ArrayList<>();
    public static List<String> list4=new ArrayList<>();
    Tupian tupian=Tupian.tupian();
    Pic pic=new Pic();
    public void tupian(String a,String aa,String b,String bb){
        int z=tupian.tiqu1(a,aa);
        int x=tupian.tiqu2(b,bb);
        for(int i=1;i<=z;i++){
            list1.add(""+i);
        }
        for(int i=1;i<=x;i++){
            list2.add(""+i);
        }
            for (int i = 1; i <=z; i++) {
                for (int j = 1; j <= x; j++) {
                    float cc=pic.bilv("D:\\architecture2023\\untitled5\\src\\main\\webapp\\static\\photo\\"+aa+"\\"+i+".jpeg","D:\\architecture2023\\untitled5\\src\\main\\webapp\\static\\photo\\"+bb+"\\"+j+".jpeg");
                    if(cc==100.0){
                        list3.add(""+i);
                        list4.add(""+j);
                    }
                }
            }
            for(int i=0;i<list3.size();i++){
                list1.remove(list3.get(i));
            }
        for(int i=0;i<list4.size();i++){
            list2.remove(list4.get(i));
        }
//        System.out.println("参数地址1中不同的图片的地址为：");
//        for(int i=0;i<list1.size();i++){
//            System.out.print(list1.get(i)+".jpeg"+" ");
//        }
//        System.out.println();
//        System.out.println("参数地址2中不同的图片的地址为：");
//        for(int i=0;i<list2.size();i++){
//            System.out.print(list2.get(i)+".jpeg"+" ");
//        }
//        System.out.println();
        }
    }

package com.word.luoji.yemeiyejiao;

import com.word.luoji.tiqu.GetHeaderFooter;
import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.List;

public class Duibi {
    public static List<String> duibiyemei(String aa,String bb){
        List<String> list=new ArrayList<>();
        GetHeaderFooter getHeaderFooter=new GetHeaderFooter();
        String a=getHeaderFooter.readHeader(aa);
        String b=getHeaderFooter.readHeader(bb);
        boolean bo=a.equals(b);
        if(bo){
            list.add("两文档页眉相等");
            list.add("两文档页眉相等");
        }else {
            list.add(a);
            list.add(b);
        }
        return list;
    }
    public static List<String> duibiyejiao(String aa,String bb){
        List<String> list=new ArrayList<>();
        GetHeaderFooter getHeaderFooter=new GetHeaderFooter();
        String a=getHeaderFooter.readFooter(aa);
        String b=getHeaderFooter.readFooter(bb);
        boolean bo=a.equals(b);
        if(bo){
            list.add("两文档页脚相等");
            list.add("两文档页脚相等");
        }else {
            list.add(a);
            list.add(b);
        }
        return list;
    }

    public List<String> duibiyejiaos(String aa, String bb) {
        String a=aa;
        String b=bb;
        List<String> list=duibiyejiao(a,b);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        return list;
    }

    public List<String> duibiyemeis(String aa,String bb) {
        String a=aa;
        String b=bb;
        List<String> list=duibiyemei(a,b);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        return list;
    }
}

package com.word.luoji.server;

import com.spire.doc.documents.Paragraph;
import com.word.luoji.pojo.Character;
import com.word.luoji.tiqu.WenZi;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        WenZi wenZi1 = new WenZi("C:\\Users\\23154\\Desktop\\精确测试对比文档111.docx");
        tiqujihe(wenZi1,0,list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    public static int
    tiqujihe(WenZi wenZi,int duan,List<Character> lista){
        int aa=0;
        Paragraph paragraph = wenZi.chushihuaduan(duan);
        int zi=paragraph.getChildObjects().getCount();
        for(int j=0;j<zi;j++) {
            Object object = wenZi.chushihuazi(paragraph, j);
            String ziduixiang = wenZi.huoquwenzi(object);
            if (ziduixiang != null) {
                if (ziduixiang.length() == 1) {
                    Character character = Character.builder()
                            .wenzi(ziduixiang)
                            .ziti(wenZi.huoquziti(object))
                            .daxiao(wenZi.huoqudaxiao(object))
                            .jaicu(wenZi.huoqujiacu(object))
                            .qingxie(wenZi.huoquqingxie(object))
                            .xiahuaxian(wenZi.xiahuaxian(object))
                            .shanchuxian(wenZi.shanchuxian(object))
                            .zitiyanse(wenZi.huoquziyanse(object))
                            .gaoliang(wenZi.huoqugaoliangyanse(object))
                            .beijingyanse(wenZi.huoqubeijingyanse(object))
                            .build();
                    lista.add(character);
                    aa++;
                } else if (ziduixiang.length() > 1) {
                    char[] chars = ziduixiang.toCharArray();
                    for (int i = 0; i < ziduixiang.length(); i++) {
                        Character character = Character.builder()
                                .wenzi("" + chars[i])
                                .ziti(wenZi.huoquziti(object))
                                .daxiao(wenZi.huoqudaxiao(object))
                                .jaicu(wenZi.huoqujiacu(object))
                                .qingxie(wenZi.huoquqingxie(object))
                                .xiahuaxian(wenZi.xiahuaxian(object))
                                .shanchuxian(wenZi.shanchuxian(object))
                                .zitiyanse(wenZi.huoquziyanse(object))
                                .gaoliang(wenZi.huoqugaoliangyanse(object))
                                .beijingyanse(wenZi.huoqubeijingyanse(object))
                                .build();
                        lista.add(character);
                        aa++;
                    }
                }
            }
        }
        return aa;
    }
}

package com.word.luoji.server;

import com.spire.doc.documents.Paragraph;
import com.word.luoji.pojo.Character;
import com.word.luoji.tiqu.Duibixiangsidu;
import com.word.luoji.tiqu.WenZi;

import java.awt.*;
import java.util.List;

import static com.word.luoji.server.Server.tiqujihe;

public class Server1 implements ServerAbstract{

    public static void fangruwu(List<Character> a) {
        Character character = Character.builder()
                .wenzi("无此文字")
                .ziti("无")
                .daxiao(0)
                .jaicu(" ")
                .qingxie(" ")
                .xiahuaxian(0)
                .shanchuxian(" ")
                .zitiyanse(String.valueOf(new Color(0,0,0)))
                .gaoliang(String.valueOf(new Color(0,0,0)))
                .beijingyanse(String.valueOf(new Color(0,0,0)))
                .build();
        a.add(character);
    }

    public double duibi(WenZi wenZi1, WenZi wenZi2, int duan1, int duan2) {
        Paragraph paragraph1 = wenZi1.chushihuaduan(duan1);
        String wen1 = wenZi1.duanluowenzi(paragraph1);
        Paragraph paragraph2 = wenZi2.chushihuaduan(duan2);
        String wen2 = wenZi1.duanluowenzi(paragraph2);
        return Duibixiangsidu.cosineSimilarity(wen1, wen2);
    }

    public int zhenduibi(WenZi wenZi1,WenZi wenZi2,List<Character> lista,List<Character> listb,List<Character> cuowua,List<Character> cuowub,int b, int a) {
        int duanluoshuliang1 = wenZi1.duanluoshuliang();
        int duanluoshuliang2 = wenZi2.duanluoshuliang();
        int c = 0;
        int d = 0;
        if (b == duanluoshuliang1 && a < duanluoshuliang2) {
            for (int i = a; i < duanluoshuliang2; i++) {
                int aa=tiqujihe(wenZi2, i, cuowub);
                for(int k=0;k<aa;k++) {
                    fangruwu(cuowua);
                }
            }
        } else if (b < duanluoshuliang1 && a == duanluoshuliang2) {
            for (int i = b; i < duanluoshuliang1; i++) {
                int aa=tiqujihe(wenZi1, i, cuowua);
                for(int k=0;k<aa;k++) {
                    fangruwu(cuowub);
                }
            }
        } else if (a >= duanluoshuliang2 && b >= duanluoshuliang1) {
            System.out.println("对比结束，或者超出范围");
            c=-1;
        } else if (duanluoshuliang1 < duanluoshuliang2) {
            c = 0;
            int e=a;
            d = 0;
            for (int i = 0; i < duanluoshuliang2-e; i++) {
                double duibudu = duibi(wenZi1, wenZi2, b, a);
                if (duibudu > 0.5) {
                    d = 1;
                    break;
                } else {
                    a++;//记录长的段的比对段数
                    c++;//记录往后移了几行
                }
            }
            if (c == duanluoshuliang2 - e && d == 0) {
                int aa=tiqujihe(wenZi1, b, cuowua);
                for(int k=0;k<aa;k++) {
                    fangruwu(cuowub);
                }
                c = -2;
            } else if (c == 0) {
                tiqujihe(wenZi1, b, lista);
                tiqujihe(wenZi2, a, listb);
            } else if (c > 0) {
                tiqujihe(wenZi1, b, lista);
                tiqujihe(wenZi2, a, listb);
                for (int i = 0; i < c; i++) {
                    int aa=tiqujihe(wenZi2, e + i, cuowub);
                    for(int k=0;k<aa;k++) {
                        fangruwu(cuowua);
                    }
                }
            }
        }
        else if (duanluoshuliang1 > duanluoshuliang2) {
            c = 0;
            int e=b;
            d = 0;
            for (int i = 0; i < duanluoshuliang1 - e; i++) {
                double duibudu = duibi(wenZi2, wenZi1, a, b);
                if (duibudu > 0.5) {
                    d = 1;
                    break;
                } else {
                    b++;//记录长的段的比对段数
                    c++;//记录往后移了几行
                }
            }
            if (c == duanluoshuliang1 - e && d == 0) {
                int aa=tiqujihe(wenZi2, a, cuowub);
                for(int k=0;k<aa;k++) {
                    fangruwu(cuowua);
                }
                c = -2;
            } else if (c == 0) {
                tiqujihe(wenZi1, b, lista);
                tiqujihe(wenZi2, a, listb);
            } else if (c > 0) {
                tiqujihe(wenZi1, b, lista);
                tiqujihe(wenZi2, a, listb);
                for (int i = 0; i < c; i++) {
                    int aa=tiqujihe(wenZi1, e + i, cuowua);
                    for(int k=0;k<aa;k++) {
                        fangruwu(cuowub);
                    }
                }
            }
        }

        else if (duanluoshuliang1 == duanluoshuliang2) {
            c = 0;
            int e=b;
            d = 0;
            for (int i = 0; i < duanluoshuliang1 - e; i++) {
                double duibudu = duibi(wenZi2, wenZi1, a, b);
                System.out.println(duibudu);
                if (duibudu > 0.5) {
                    d = 1;
                    break;
                } else {
                    b++;//记录长的段的比对段数
                    c++;//记录往后移了几行
                }
            }
            if (c == duanluoshuliang1 - e && d == 0) {
                int aa=tiqujihe(wenZi2, a, cuowub);
                for(int k=0;k<aa;k++) {
                    fangruwu(cuowua);
                }
                c = -2;
            } else if (c == 0) {
                tiqujihe(wenZi1, b, lista);
                tiqujihe(wenZi2, a, listb);
            } else if (c > 0) {
                tiqujihe(wenZi1, b, lista);
                tiqujihe(wenZi2, a, listb);
                for (int i = 0; i < c; i++) {

                    int aa=tiqujihe(wenZi1, e + i, cuowua);
                    for(int k=0;k<aa;k++) {
                        fangruwu(cuowub);
                    }
                }
            }
        }else{
            c=-1;
        }

        return c;
    }

    public void chuanru(String a, String b){

    }
    public void tiqu(int cc, int dd) {

    }
    public void quantiqu(){

    }






}

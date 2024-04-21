package com.word.luoji.server;

import com.word.luoji.pojo.Character;
import com.word.luoji.tiqu.WenZi;

import java.util.List;

public interface ServerAbstract {
    public double duibi(WenZi wenZi1, WenZi wenZi2, int duan1, int duan2);
    public int zhenduibi(WenZi wenZi1,WenZi wenZi2,List<Character> lista,List<Character> listb,List<Character> cuowua,List<Character> cuowub,int b, int a);
    public void chuanru(String a, String b);
    public void tiqu(int cc, int dd);
    public void quantiqu();

}

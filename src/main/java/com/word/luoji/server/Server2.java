package com.word.luoji.server;

import com.word.luoji.pojo.Character;
import com.word.luoji.tiqu.WenZi;

import java.util.ArrayList;
import java.util.List;

public class Server2 implements ServerAbstract{
    private String a;
    private String b;
    static List<Character> lista = new ArrayList<>();
    static List<Character> listb = new ArrayList<>();
    public static List<Character> cuowua = new ArrayList<>();
    public static List<Character> cuowub = new ArrayList<>();
    WenZi wenZi1;
    WenZi wenZi2;

    public void chuanru(String a, String b) {
        this.a = a;
        this.b = b;
        wenZi1 = new WenZi(a);
        wenZi2 = new WenZi(b);
    }


    public int zhenduibi(WenZi wenZi1, WenZi wenZi2, List<Character> lista, List<Character> listb, List<Character> cuowua, List<Character> cuowub, int b, int a) {
        Factory factory=new CreatServer1();
        ServerAbstract server1 = factory.creatServer();
        int f = server1.zhenduibi(wenZi1, wenZi2, lista, listb, cuowua, cuowub, b, a);
        if (lista != null && listb != null) {
            if (lista.size() < listb.size()) {
                int c = 0;
                for (int i = 0; i < lista.size(); i++) {
                    int jilu = 0;
                    int d = c;
                    for (int j = d; j < listb.size(); j++) {
                        if (!lista.get(i).getWenzi().equals(listb.get(j).getWenzi())) {
                            jilu++;
                            c++;
                            continue;
                        } else {
                            if (lista.get(i).getZiti().equals(listb.get(j).getZiti())) {
                                if (lista.get(i).getDaxiao() == listb.get(j).getDaxiao()) {
                                    if (lista.get(i).getJaicu() == listb.get(j).getJaicu()) {
                                        if (lista.get(i).getQingxie() == listb.get(j).getQingxie()) {
                                            if (lista.get(i).getXiahuaxian() == listb.get(j).getXiahuaxian()) {
                                                if (lista.get(i).getShanchuxian() == listb.get(j).getShanchuxian()) {
                                                    if (lista.get(i).getZitiyanse().equals(listb.get(j).getZitiyanse())) {
                                                        if (lista.get(i).getGaoliang().equals(listb.get(j).getGaoliang())) {
                                                            if (lista.get(i).getBeijingyanse().equals(listb.get(j).getBeijingyanse())) {
                                                                c++;
                                                                break;
                                                            } else {
                                                                cuowua.add(listb.get(j));
                                                                cuowub.add(lista.get(i));
                                                                c++;
                                                                break;
                                                            }
                                                        } else {
                                                            cuowua.add(listb.get(j));
                                                            cuowub.add(lista.get(i));
                                                            c++;
                                                            break;
                                                        }
                                                    } else {
                                                        cuowua.add(listb.get(j));
                                                        cuowub.add(lista.get(i));
                                                        c++;
                                                        break;
                                                    }
                                                } else {
                                                    cuowua.add(listb.get(j));
                                                    cuowub.add(lista.get(i));
                                                    c++;
                                                    break;
                                                }
                                            } else {
                                                cuowua.add(listb.get(j));
                                                cuowub.add(lista.get(i));
                                                c++;
                                                break;
                                            }
                                        } else {
                                            cuowua.add(listb.get(j));
                                            cuowub.add(lista.get(i));
                                            c++;
                                            break;
                                        }
                                    } else {
                                        cuowua.add(listb.get(j));
                                        cuowub.add(lista.get(i));
                                        c++;
                                        break;
                                    }

                                } else {
                                    cuowua.add(listb.get(j));
                                    cuowub.add(lista.get(i));
                                    c++;
                                    break;
                                }
                            } else {
                                cuowua.add(listb.get(j));
                                cuowub.add(lista.get(i));
                                c++;
                                break;
                            }
                        }
                    }
                    if (jilu == listb.size() - d) {
                        cuowua.add(lista.get(i));
                        Server1.fangruwu(cuowub);
                        c = c - jilu;
                    } else if (jilu < lista.size() - d) {
                        for (int j = 0; j < jilu; j++) {
                            cuowub.add(listb.get(d + j));
                            Server1.fangruwu(cuowua);
                        }
                    }
                }
                int aa = listb.size() - c;
                for (int k = 0; k < aa; k++) {
                    cuowub.add(listb.get(listb.size() - aa + k));
                    Server1.fangruwu(cuowua);
                }
            } else if (lista.size() >= listb.size()) {
                int c = 0;
                for (int i = 0; i < listb.size(); i++) {
                    int aaa = 0;
                    int jilu = 0;
                    int d = c;
                    for (int j = d; j < lista.size(); j++) {
                        if (!listb.get(i).getWenzi().equals(lista.get(j).getWenzi())) {
                            jilu++;
                            c++;
                            continue;
                        } else {
                            if (listb.get(i).getZiti().equals(lista.get(j).getZiti())) {
                                if (listb.get(i).getDaxiao() == lista.get(j).getDaxiao()) {
                                    if (listb.get(i).getJaicu() == lista.get(j).getJaicu()) {
                                        if (listb.get(i).getQingxie() == lista.get(j).getQingxie()) {
                                            if (listb.get(i).getXiahuaxian() == lista.get(j).getXiahuaxian()) {
                                                if (listb.get(i).getShanchuxian() == lista.get(j).getShanchuxian()) {
                                                    if (listb.get(i).getZitiyanse().equals(lista.get(j).getZitiyanse())) {
                                                        if (listb.get(i).getGaoliang().equals(lista.get(j).getGaoliang())) {
                                                            if (listb.get(i).getBeijingyanse().equals(lista.get(j).getBeijingyanse())) {
                                                                c++;
                                                                break;
                                                            } else {
                                                                cuowua.add(lista.get(j));
                                                                cuowub.add(listb.get(i));
                                                                c++;
                                                                break;
                                                            }
                                                        } else {
                                                            cuowua.add(lista.get(j));
                                                            cuowub.add(listb.get(i));
                                                            c++;
                                                            break;
                                                        }
                                                    } else {
                                                        cuowua.add(lista.get(j));
                                                        cuowub.add(listb.get(i));
                                                        c++;
                                                        break;
                                                    }
                                                } else {
                                                    cuowua.add(lista.get(j));
                                                    cuowub.add(listb.get(i));
                                                    c++;
                                                    break;
                                                }
                                            } else {
                                                cuowua.add(lista.get(j));
                                                cuowub.add(listb.get(i));
                                                c++;
                                                break;
                                            }
                                        } else {
                                            cuowua.add(lista.get(j));
                                            cuowub.add(listb.get(i));
                                            c++;
                                            break;
                                        }
                                    } else {
                                        cuowua.add(lista.get(j));
                                        cuowub.add(listb.get(i));
                                        c++;
                                        break;
                                    }

                                } else {
                                    cuowua.add(lista.get(j));
                                    cuowub.add(listb.get(i));
                                    c++;
                                    break;
                                }
                            } else {
                                cuowua.add(lista.get(j));
                                cuowub.add(listb.get(i));
                                c++;
                                break;
                            }
                        }
                    }
                    if (jilu == lista.size() - d) {
                        cuowub.add(listb.get(i));
                        Server1.fangruwu(cuowua);
                        c = c - jilu;
                    } else if (jilu < listb.size() - d) {
                        for (int j = 0; j < jilu; j++) {
                            cuowua.add(lista.get(d + j));
                            Server1.fangruwu(cuowub);
                        }
                    }
                }
                int aa = lista.size() - c;
                for (int k = 0; k < aa; k++) {
                    cuowua.add(lista.get(lista.size() - aa + k));
                    Server1.fangruwu(cuowub);
                }
            }
        }
        return f;
    }

    public void tiqu(int cc, int dd) {
        zhenduibi(wenZi1, wenZi2, lista, listb, cuowua, cuowub, cc, dd);
//        for (int i = 0; i < cuowua.size(); i++) {
//            System.out.println(cuowua.get(i).toString());
//        }
//        System.out.println("===================================================================================================");
//        for (int i = 0; i < cuowub.size(); i++) {
//            System.out.println(cuowub.get(i).toString());
//        }
        lista.clear();
        listb.clear();
    }


    public void quantiqu() {
        int a = wenZi1.duanluoshuliang();
        int b = wenZi2.duanluoshuliang();
        int j = 0;
        int iii = 1;
        int jj = 0;
        if (a < b) {
            for (int i = 0; i < a; i++) {
                int aa = zhenduibi(wenZi1, wenZi2, lista, listb, cuowua, cuowub, i, j);
                lista.clear();
                listb.clear();
                if (aa >= 0) {
                    j += (aa + 1);
                }
                if (aa == -2) {
                    j += 0;
                }
                if (j >= b) {
                    jj = 1;
                    break;
                }
                if (aa == -1) {
                    break;
                }
                iii++;
            }
            if (jj == 1) {
                int k = a - iii;
                for (int i = 0; i < k; i++) {
                    int kk = Server.tiqujihe(wenZi1, iii + i, cuowua);
                    for (int z = 0; z < kk; z++) {
                        Server1.fangruwu(cuowub);
                    }
                }
            } else {
                int k = b - j;
                for (int i = 0; i < k; i++) {
                    int kk = Server.tiqujihe(wenZi2, j + i, cuowub);
                    for (int z = 0; z < kk; z++) {
                        Server1.fangruwu(cuowua);
                    }
                }
            }
        }
        if (a >= b) {
            for (int i = 0; i < b; i++) {
                System.out.println(j+" "+i);
                int aa = zhenduibi(wenZi1, wenZi2, lista, listb, cuowua, cuowub, j, i);
                listb.clear();
                lista.clear();
                if (aa >= 0) {
                    j += (aa + 1);
                }
                if (aa == -2) {
                    j += 0;
                }
                if (j >= a) {
                    jj = 1;
                    break;
                }
                if (aa == -1) {
                    break;
                }
                iii++;
            }
            if (jj == 1) {
                int k = b - iii;
                for (int i = 0; i < k; i++) {
                    int kk = Server.tiqujihe(wenZi2, iii + i, cuowub);
                    for (int z = 0; z < kk; z++) {
                        Server1.fangruwu(cuowua);
                    }
                }
            } else {
                int k = a - j;
                for (int i = 0; i < k; i++) {
                    int kk = Server.tiqujihe(wenZi1, j + i, cuowua);
                    for (int z = 0; z < kk; z++) {
                        Server1.fangruwu(cuowub);
                    }
                }
            }
        }


        System.out.println(cuowua.size() + " " + cuowub.size());

//        for (int ii = 0; ii < cuowua.size(); ii++) {
////            System.out.println(cuowua.get(ii).toString());
//            abcd.add(cuowua.get(ii));
//        }
////        System.out.println("===================================================================================================");
//        for (int ii = 0; ii < cuowub.size(); ii++) {
////            System.out.println(cuowub.get(ii).toString());
//            defg.add(cuowub.get(ii));
//        }
        lista.clear();
        listb.clear();
//        cuowub.clear();
//        cuowua.clear();
    }
    public double duibi(WenZi wenZi1, WenZi wenZi2, int duan1, int duan2){
        return 0.0;
    }
}

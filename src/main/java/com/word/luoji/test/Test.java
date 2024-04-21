package com.word.luoji.test;

import org.apache.tika.exception.TikaException;
import com.word.luoji.server.Server2;
import com.word.luoji.tupian.DuiBiTupian;
import com.word.luoji.wendangleixing.DuiBiWenDang;
import com.word.luoji.yemeiyejiao.Duibi;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, TikaException {
        int queren = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入对比文件1地址：");
        String a = input.nextLine();
        System.out.print("请输入对比文件2地址：");
        String b = input.nextLine();
        String aa = DuiBiWenDang.duibi(a);
        if (aa.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            String bb = DuiBiWenDang.duibi(b);
            if (bb.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                while (true) {
                    System.out.println("请输入您需要的功能：\n1.按照段落对比文档内容\n2.对比全部文档内容\n3.对比页眉页脚\n4.对比文档中图片\n-1.退出");
                    int xuhao = input.nextInt();
                    switch (xuhao) {
                        case 1:
                            Server2 server2 = new Server2();
                            server2.chuanru(a, b);
                            System.out.println("请输入您要对比的段落！以空格分割！");
                            int aaa = input.nextInt();
                            int bbb = input.nextInt();
                            System.out.println("两个文档差异以上下形式展现，中间以等号（=）分割");
                            server2.tiqu(aaa, bbb);
                            System.out.println();
                            break;
                        case 2:
                            Server2 server22 = new Server2();
                            server22.chuanru(a, b);
                            server22.quantiqu();
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("请输入你想对比的是页眉还是页脚 1.为页眉 2.为页脚");
                            int aaaa=input.nextInt();
                            Duibi duibi = new Duibi();
                            if(aaaa==2) {
                                duibi.duibiyejiaos(a, b);
                                System.out.println();
                            }
                            else if(aaaa==1){
                                duibi.duibiyemeis(a,b);
                                System.out.println();
                            }
                            else{
                                System.out.println("输入错误！\n");
                            }
                            break;
                        case 4:
                            System.out.println("请输入输出图片的文件夹1名称：");
                            input.nextLine();
                            String q=input.nextLine();
                            System.out.println("请输入输出图片的文件夹2名称：");
                            String w=input.nextLine();
                            DuiBiTupian duiBiTupian=new DuiBiTupian();
//                            duiBiTupian.tupian(a,q,b,w);
                            break;
                        case -1:
                            queren = 1;
                            break;
                        default:
                            System.out.println("请输入1. 2. -1. 内容，您的输入无效，请重新输入！\n");
                            break;
                    }
                    if (queren == 1) {
                        break;
                    }

                }
            } else {
                System.out.println("警告：您上传的第二个文件格式异常，可能并非Word文档！！！");
            }
        } else {
            System.out.println("警告：您上传的第一个文件格式异常，可能并非Word文档！！！");
        }

    }
}

package com.word.luoji.tiqu;

import com.spire.doc.Document;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.UnderlineStyle;
import com.spire.doc.fields.TextRange;

import java.awt.*;

/**
 * 此类为文字对比提取对象
 */
public class WenZi {
    Document doc=new Document();
    /**
     * 通过构造方法初始化文件，构造方法需传入文件地址
     * @param dizhi
     */
    public WenZi(String dizhi){
        doc.loadFromFile(dizhi);
    }

    /**
     * 查找某一段的文字，需要传入段落的下标，从0开始
     * @param duan
     * @return
     */
    public String duanluowenzi(Paragraph paragraph){
        //获取每段内容
        return paragraph.getText();
    }
    public int duanzishu(Paragraph paragraph){
        return paragraph.getText().length();
    }


    public Paragraph chushihuaduan(int duan){
        Paragraph paragraph = doc.getSections().get(0).getParagraphs().get(duan);
        return paragraph;
    }

    public int ziduixiangshuliang(Paragraph paragraph){
        return paragraph.getChildObjects().getCount();
    }
    public Object chushihuazi(Paragraph paragraph,int zi){
        Object obj = paragraph.getChildObjects().get(zi);
        return obj;
    }
    /**
     * 获取文件的段落数量
     * @return
     */
    public int duanluoshuliang(){
        //获取段落数量
        int shuliang = doc.getSections().get(0).getParagraphs().getCount();
        return shuliang;
    }

    /**
     * 获取对象字
     * @param obj
     * @return
     */
    public String huoquwenzi(Object obj){
        String text=new String();
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            text=textRange.getText();
        }
        return text;
    }


    /**
     * 获取某个段的某个子对象的字体信息
     * @param duan
     * @param zi
     * @return
     */
    public String huoquziti(Object obj){
        String text=new String();
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
                text = textRange.getCharacterFormat().getFontName();
        }
        return text;
    }

    /**
     * 获取某个段，某个子对象的字体颜色
     * @param duan
     * @param zi
     * @return
     */
    public static String huoquziyanse(Object obj){
        Color color=new Color(0,0,0);
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
                color = textRange.getCharacterFormat().getTextColor();
        }
        return ""+color.toString();
    }

    /**
     * 获取某个段，某个子对象的字体背景（底纹）颜色
     * @param duan
     * @param zi
     * @return
     */
    public String huoqubeijingyanse(Object obj){
        Color color=new Color(0,0,0);
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
              color = textRange.getCharacterFormat().getTextBackgroundColor();
        }
        return ""+color.toString();
    }

    /**
     * 获取某个段的某个子对象的文本高亮颜色
     * @param duan
     * @param zi
     * @return
     */
    public String huoqugaoliangyanse(Object obj){
        Color color=new Color(0,0,0);
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
             color = textRange.getCharacterFormat().getHighlightColor();
        }
        return ""+color.toString();
    }

    /**
     * 获取某个段的某个子对象的加粗效果
     * @param duan
     * @param zi
     * @return
     */
    public String huoqujiacu(Object obj){
        String boldd=" ";
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();

            Boolean bold = textRange.getCharacterFormat().getBold();
            boldd=bold.toString();
        }
        return boldd;
    }

    /**
     * 获取某个段的某个子对象的倾斜效果
     * @param duan
     * @param zi
     * @return
     */
    public String huoquqingxie(Object obj){
        String boldd=" ";
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
              Boolean bold = textRange.getCharacterFormat().getItalic();
              boldd=bold.toString();
        }
        return boldd;
    }

    /**
     * 获取子对象字体的大小
     * @param duan
     * @param zi
     * @return
     */
    public float huoqudaxiao(Object obj){
        float daxiao=0;
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
                daxiao = textRange.getCharacterFormat().getFontSize();

        }
        return daxiao;
    }

    /**
     * 判断是否有下划线
     * @param duan
     * @param zi
     * @return
     */
    public int xiahuaxian(Object obj){
        int value=0;
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
            UnderlineStyle underlineStyle = textRange.getCharacterFormat().getUnderlineStyle();
            value=underlineStyle.getValue();
        }
        return value;
    }

    /**
     * 判断是否有删除线
     * @param duan
     * @param zi
     * @return
     */
    public String shanchuxian(Object obj){
        String aaa=" ";
        if(obj instanceof TextRange){
            TextRange textRange=(TextRange)obj;
            String a=textRange.getText();
            Boolean aa = textRange.getCharacterFormat().isStrikeout();
            aaa=aa.toString();
        }
        return aaa;
    }

    public static void main(String[] args) {
//        doc.loadFromFile("C:\\Users\\23154\\Desktop\\精确测试对比文档22.docx");
////        String huoquziti = huoqugaoliangyanse(12,4);
//        for(int i=0;i<30;i++){
//            boolean a= shanchuxian(0,i);
//            System.out.println(a);
//        }

    }
}

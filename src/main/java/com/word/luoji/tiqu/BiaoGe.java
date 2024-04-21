package com.word.luoji.tiqu;

import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.interfaces.ITable;

public class BiaoGe {
    /**
     * 此方法作用为提取表格文字
     * 此方法有两个参数
     * 第一个参数为文件地址，第二个参数为第几个表格
     * 返回值为表格内容
     * biaogewenzi
     * @param dizhi
     * @param index
     * @return
     */
    public static String biaogewenzi(String dizhi,int index){
        //加载Word测试文档
        Document doc = new Document();
        StringBuffer stringBuffer = new StringBuffer();
        doc.loadFromFile(dizhi);

        //获取第一节
        Section section = doc.getSections().get(0);

        //获取第i个表格
        ITable table = section.getTables().get(index);

        //遍历表格中的行
        for (int i = 0; i < table.getRows().getCount(); i++) {
            TableRow row = table.getRows().get(i);
            //遍历每行中的单元格
            for (int j = 0; j < row.getCells().getCount(); j++) {
                TableCell cell = row.getCells().get(j);
                //遍历单元格中的段落
                for (int k = 0; k < cell.getParagraphs().getCount(); k++) {
                    Paragraph paragraph = cell.getParagraphs().get(k);
                    stringBuffer.append(paragraph.getText() + "\t");//获取文本内容
                }
            }
            stringBuffer.append("\r\n");
        }
        return stringBuffer.toString();
    }

    /**
     * 此方法作用为获取word文档中表格的数量
     * 有一个参数
     * 第一个参数为文件地址
     * 返回值int为数量
     * biaogeshuliang
     * @param dizhi
     * @return
     */
    public static int biaogeshuliang(String dizhi){
        //加载Word测试文档
        Document doc = new Document();
        doc.loadFromFile(dizhi);
        //获取第一节
        Section section = doc.getSections().get(0);
        int shuliang = section.getTables().getCount();
        return shuliang;
    }

    public static void main(String[] args) {
        System.out.println(biaogewenzi("C:\\Users\\23154\\Desktop\\精确测试对比文档11.docx",0));
    }
}

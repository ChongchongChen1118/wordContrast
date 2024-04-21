package com.word.luoji.tupian;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class Tupian {
    private Tupian(){

    }
    /**
     * 提取word文档中的所有图片
     * @param docx_file_path
     * @param output_folder_path
     */
    public static int  extractImagesFromDocx(String docx_file_path, String output_folder_path)  {
        int a=0;
        try {
            XWPFDocument docx = new XWPFDocument(new FileInputStream(docx_file_path));
            List<XWPFPictureData> pictures = docx.getAllPictures();
            a=pictures.size();
            int i=0;
            for (XWPFPictureData picture : pictures) {
                i++;
                byte[] data = picture.getData();
                String name=picture.getFileName();
                name=name.substring(name.indexOf("."));
                String fileName = ""+i+name;
                FileOutputStream out = new FileOutputStream(new File(output_folder_path + "/" + fileName));
                out.write(data);
                out.close();
            }
            i=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    public int tiqu1(String a,String b) {
        String docx_file_path = a;
        String output_folder_path = "D:\\architecture2023\\untitled5\\src\\main\\webapp\\static\\photo\\"+b;
        //如果没有这个文件夹就新建一个
        if (!new File(output_folder_path).exists()) {
            new File(output_folder_path).mkdirs();
        }
        int aa=extractImagesFromDocx(docx_file_path, output_folder_path);
        return aa;
    }
    public int tiqu2(String a,String b) {
        String docx_file_path = a;
        String output_folder_path ="D:\\architecture2023\\untitled5\\src\\main\\webapp\\static\\photo\\"+b;
        //如果没有这个文件夹就新建一个
        if (!new File(output_folder_path).exists()) {
            new File(output_folder_path).mkdirs();
        }
        int aa=extractImagesFromDocx(docx_file_path, output_folder_path);
        return aa;
    }
    
    static Tupian tupian1=new Tupian();
    public static Tupian tupian(){
        return tupian1;
    }
}
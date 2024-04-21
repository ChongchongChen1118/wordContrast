package com.word.luoji.tiqu;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.IOException;

public class GetHeaderFooter{
    /**
     * 获取页眉
     * @param filePath
     * @return
     */
    public String readHeader(String filePath) {
        XWPFDocument doc = null;
        try {
            doc = new XWPFDocument(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();
        XWPFHeader header = policy.getDefaultHeader();
        String headerText = "";
        for (XWPFParagraph paragraph : header.getParagraphs()) {
            headerText += paragraph.getText();
        }
        return headerText;
    }

    /**
     * 获取页脚
     * @param filePath
     * @return
     */
    public String readFooter(String filePath) {
        XWPFDocument doc = null;
        try {
            doc = new XWPFDocument(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();
        XWPFFooter footer = policy.getDefaultFooter();
        String footerText = "";
        for (XWPFParagraph paragraph : footer.getParagraphs()) {
            footerText += paragraph.getText();
        }
        return footerText;
    }
}
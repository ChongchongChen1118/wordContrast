package com.word.luoji.wendangleixing;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;


import java.io.File;
import java.io.IOException;


public class DuiBiWenDang {
        public static String duibi(String a)throws IOException, TikaException {
            Tika tika = new Tika();
            String mimeType = tika.detect(new File(a));
            return mimeType;
        }

    }






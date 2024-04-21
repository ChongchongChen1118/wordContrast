package com.word.duibi;

import com.word.luoji.pojo.Cunru;
import com.word.luoji.server.*;
import com.word.luoji.tupian.DuiBiTupian;
import com.word.luoji.wendangleixing.DuiBiWenDang;
import com.word.luoji.yemeiyejiao.Duibi;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class Controller1 {
    @RequestMapping("/")
    public String zhuyemian() {
        return "zhuye";
    }

    @RequestMapping("/zhuye1")
    public String zhuye(MultipartFile file1, HttpSession session) throws IOException, TikaException {
        //获取上传的文件的文件名
        String fileName = file1.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中file目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("file");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        Cunru.setFile1(finalPath);
        //实现上传功能
        file1.transferTo(new File(finalPath));
        System.out.println(Cunru.getFile1());
        String aa = DuiBiWenDang.duibi(Cunru.getFile1());
        if (aa.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            return "zhuye1";
        } else {
            return "cuowu1";
        }
    }

    @RequestMapping("/zhuye2")
    public String zhuye1(MultipartFile file2, HttpSession session) throws IOException, TikaException {
        //获取上传的文件的文件名
        String fileName = file2.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中file目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("file1");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        Cunru.setFile2(finalPath);
        //实现上传功能
        file2.transferTo(new File(finalPath));
        System.out.println(Cunru.getFile2());
        String aa = DuiBiWenDang.duibi(Cunru.getFile2());
        if (aa.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
            return "xuanze";
        else
            return "cuowu1";
    }

    @RequestMapping("/yemei")
    public String yemei(Model model) {
        Duibi duibi = new Duibi();
        List<String> list = duibi.duibiyemeis(Cunru.getFile1(), Cunru.getFile2());
        model.addAttribute("yemei", list);
        return "yemei";
    }

    @RequestMapping("/yejiao")
    public String yejiao(Model model) {
        Duibi duibi = new Duibi();
        List<String> list = duibi.duibiyejiaos(Cunru.getFile1(), Cunru.getFile2());
        model.addAttribute("yejiao", list);
        return "yejiao";
    }

    @RequestMapping("/quanbu")
    public String quanbu(Model model) {
        Server2.cuowua.clear();
        Server2.cuowub.clear();
        Factory factory=new CreatServer2();
        ServerAbstract server2 = factory.creatServer();
        server2.chuanru(Cunru.getFile1(), Cunru.getFile2());
        server2.quantiqu();
        model.addAttribute("quanbu1", Server2.cuowua);
        model.addAttribute("quanbu2", Server2.cuowub);
        return "quanbu";
    }

    @RequestMapping("/duibi")
    public String duibi(String yi, String er,Model model) {
        Server2.cuowub.clear();
        Server2.cuowua.clear();
        int yii=Integer.parseInt(yi);
        int err=Integer.parseInt(er);
        Factory factory=new CreatServer2();
        ServerAbstract server2=factory.creatServer();
        server2.chuanru(Cunru.getFile1(), Cunru.getFile2());
        server2.tiqu(yii,err);
        model.addAttribute("quanbu1", Server2.cuowua);
        model.addAttribute("quanbu2", Server2.cuowub);
        return "duanluo";
    }
    @RequestMapping("/tupianxuanze")
    public String tupian(HttpSession session,Model model){
    ServletContext servletContext = session.getServletContext();
    String photoPath = servletContext.getRealPath("photo1");
    File file = new File(photoPath);
    if (!file.exists()) {
        file.mkdir();
    }
    String photoPath1 = servletContext.getRealPath("photo2");
    File file1 = new File(photoPath1);
    if (!file1.exists()) {
        file1.mkdir();
    }
    model.addAttribute("yi",file);
    model.addAttribute("er",file1);
    return "tupianxuanze";
    }


    @RequestMapping("/tupianduibi")
    public String tupianduibi(String yi, String er,Model model,HttpSession session){
        ServletContext servletContext = session.getServletContext();
        DuiBiTupian.list1.clear();
        DuiBiTupian.list2.clear();
        DuiBiTupian duiBiTupian=new DuiBiTupian();
        duiBiTupian.tupian(Cunru.getFile1(),yi,Cunru.getFile2(),er);
        model.addAttribute("yi",DuiBiTupian.list1);
        model.addAttribute("er",DuiBiTupian.list2);
        model.addAttribute("wenjian1",yi);
        model.addAttribute("wenjian2",er);
        return "tupian";
    }
}

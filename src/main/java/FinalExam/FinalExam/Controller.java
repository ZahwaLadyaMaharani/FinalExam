/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalExam.FinalExam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Zahwa Ladya Maharani_060
 */
@Controller
public class Controller {
  @RequestMapping("/FinalExam")
    //@ResponseBody
    public String getTable (@RequestParam("Id") String getText,
                          @RequestParam("Nk") String getText,
                          @RequestParam("Nama") String getText,
                          @RequestParam("tgllhr") @DateTimeFormat (pattern="yyyy-MM-dd") Date myDate,
                          @RequestParam("photo") MultipartFile image,
                          Model model) throws IOException{
        
        String blob = Base64.encodeBase64String(image.getBytes());
        String shImage = "data:image/jpeg;base64,".concat(blob);
        
        SimpleDateFormat tgl = new SimpleDateFormat("EEEE,dd MMMM yyyy");
        String tanggal = tgl.format(myDate);
        
        model.addAttribute("kId", getText);
        model.addAttribute("kNk", getText);
        model.addAttribute("kNama", getText);
        model.addAttribute("ktgl", tanggal);
        model.addAttribute("kimg", shImage);
        return "Klik";
    }
}

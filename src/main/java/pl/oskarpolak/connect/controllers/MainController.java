package pl.oskarpolak.connect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Lenovo on 10.07.2017.
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String indexPost(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
             UUID uuid = UUID.randomUUID();
             File fileLocal = new File("C:\\files\\"+uuid.toString());

             
            BufferedOutputStream stream = null;
            try {
                fileLocal.createNewFile();
                stream = new BufferedOutputStream(new FileOutputStream(fileLocal));
                stream.write(file.getBytes());
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "index";
    }

}

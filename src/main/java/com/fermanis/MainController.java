package com.fermanis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    private ResourceFileRepository resourceFileRepository;

    @GetMapping(path="/images")
    public String getImagesIndex(Model model) {
        Iterable<ResourceFile> resourceFiles = resourceFileRepository.findAll();
        model.addAttribute("resourceFiles", resourceFiles);
        return "images";
    }

    @RequestMapping(value="/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id, HttpServletResponse response) {
        ResourceFile resourceFile = resourceFileRepository.findOne(Long.parseLong(id));
        byte[] image = resourceFile.getImage();  //this just gets the data from a database
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        return ResponseEntity.ok(image);
    }

    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public String uploadForm() {
        return "fileUploadForm";
    }


    @RequestMapping(value="/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam(value="file", required = false) MultipartFile file, HttpServletRequest request) {
        ResourceFile resourceFile = null;
        try {
            resourceFile = new ResourceFile(file.getOriginalFilename(), file.getBytes());
            resourceFileRepository.save(resourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/images";
    }
}
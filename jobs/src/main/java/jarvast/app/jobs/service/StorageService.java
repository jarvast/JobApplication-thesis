package jarvast.app.jobs.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    private final Path rootLocation = Paths.get("upload-dir");
    @Autowired
    private UserService userService;

    public void store(MultipartFile file) {
        try {
            //if a usernamenek van már fájlja, akkor felülírja az eddigit
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("locati:" + this.rootLocation.resolve(file.getOriginalFilename()).toString());
            System.out.println("locati:" + this.rootLocation.resolve(file.getOriginalFilename()).toString());
            System.out.println("user" + userService.getLoggedInUser().getUsername());

            String extension = "";
            int i = file.getOriginalFilename().lastIndexOf('.');
            if (i > 0) {
                extension = file.getOriginalFilename().substring(i + 1);
            }
             userService.test();
            System.out.println("ex" + extension);
            String prefix = userService.getLoggedInUser().getUsername();
            String newFileName = prefix + "." + extension;
            System.out.println("newff" + newFileName);
            

            //String origi = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
            Files.deleteIfExists(this.rootLocation.resolve(prefix + ".png"));
            Files.deleteIfExists(this.rootLocation.resolve(prefix + ".jpg"));
            Files.deleteIfExists(this.rootLocation.resolve(prefix + ".jpeg"));
            //userService.updateImg(newFileName);
            Files.move(this.rootLocation.resolve(file.getOriginalFilename()), this.rootLocation.resolve(file.getOriginalFilename()).resolveSibling(newFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("FAsIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            String anyfn = filename + ".jpg";
            Path file = rootLocation.resolve(anyfn);
            System.out.println("ezt kesresi:" + anyfn);
            System.out.println("ez null? :" + file);

            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            Path filePng = rootLocation.resolve(filename + ".png");
            Resource resourcePng = new UrlResource(filePng.toUri());
            if (resourcePng.exists() || resourcePng.isReadable()) {
                return resourcePng;
            }
            Path fileJpeg = rootLocation.resolve(filename + ".jpeg");
            Resource resourceJpeg = new UrlResource(fileJpeg.toUri());
            if (resourceJpeg.exists() || resourceJpeg.isReadable()) {
                return resourceJpeg;
            }
            Path fileDefault = rootLocation.resolve("default.jpg");
            Resource resourceDefault = new UrlResource(fileDefault.toUri());
            if (resourceDefault.exists() || resourceDefault.isReadable()){
                return resourceDefault;
            }else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}

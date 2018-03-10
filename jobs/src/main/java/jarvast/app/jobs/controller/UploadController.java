package jarvast.app.jobs.controller;

import jarvast.app.jobs.service.StorageService;
import jarvast.app.jobs.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

/**
 *
 * @author TomiPC
 */
@Controller
@RequestMapping("/api/upload")
public class UploadController {
 
	@Autowired
	StorageService storageService;
        
        private UserService userService;
 
	List<String> files = new ArrayList<String>();
 
	@PostMapping("/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
                    System.out.println(file.getOriginalFilename()+ "oriigi");
			storageService.store(file);
                       //System.out.println(file.getName()+ "origi");
			files.add(file.getName());
			message = "You successfully usploaded " + file.getName() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to uplsoad " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
 
	@GetMapping("/getallfiles") //ez meg csak egy képeknke a nevét küldi amit meg kell jeleníteni
	public ResponseEntity<PictureUrl> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadController.class, "getFile", fileName).build().toString())//,fileName
				.collect(Collectors.toList());
                for (String o : fileNames){
                    System.out.println("sl" + o);
                }
                String fileName = "user";
                //System.out.println(ResponseEntity.ok(fileName));
                return ResponseEntity.ok().body(new PictureUrl(fileName));
		//return ResponseEntity.ok().body(fileNames);
	}
 
        //@GetMapping("/file") EZ CSAK EGY URLT KAP és onnan küldi a képet
	@GetMapping("/files/{filename:.+}")
        //@GetMapping("/getallfiles")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
            System.out.println("pathvari" + filename);
            //System.out.println("getimg" + userService.getImg());
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

    private static class PictureUrl {
        
        public String url;

        public PictureUrl() {
        }
        public PictureUrl(String url){
            this.url =url;
        }
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        
    }
}
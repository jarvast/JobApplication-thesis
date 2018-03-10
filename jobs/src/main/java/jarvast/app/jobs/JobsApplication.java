package jarvast.app.jobs;

import jarvast.app.jobs.service.StorageService;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobsApplication implements CommandLineRunner{

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        //storageService.deleteAll();
        //storageService.init();
    }
}

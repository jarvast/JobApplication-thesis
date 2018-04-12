package jarvast.app.jobs;

import jarvast.app.jobs.service.StorageService;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobsApplication {

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }
}

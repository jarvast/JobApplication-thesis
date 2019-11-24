package jarvast.app.jobs;

import jarvast.app.jobs.service.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class JobsApplication {

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(JobsApplication.class, args);
    }
}

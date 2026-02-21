package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class StorageServiceSystemApplication {
    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(StorageServiceSystemApplication.class, args);
        System.out.println("Container started");
        StorageService storage = context.getBean(StorageService.class);
        storage.storeFile("file1.txt");
        System.out.println();
        StorageService local1 =context.getBean("localStorage",StorageService.class);
        local1.storeFile("file2.txt");
        System.out.println();
        StorageService local2 =context.getBean("localStorage",StorageService.class);
        
        local2.storeFile("file3.txt");
    }
}
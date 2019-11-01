package main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
//@EntityScan(basePackages = {"br.com.tecdainfor.model"})
//@EnableJpaRepositories(basePackages = {"br.com.tecdainfor.dao"})
public class Application {

	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/setor").allowedOrigins("http://localhost:4200");
            }
        };
    }
    
}
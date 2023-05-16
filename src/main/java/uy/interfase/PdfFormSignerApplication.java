package uy.interfase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Milver Flores Acevedo
 * @since 1.0
 */
@EnableFeignClients
@SpringBootApplication
public class PdfFormSignerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfFormSignerApplication.class, args);
    }

}

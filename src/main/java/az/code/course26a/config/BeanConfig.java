package az.code.course26a.config;

import az.code.course26a.dto.StudentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }




    @Bean
    public ResourceLoader resourceLoader() {
        return new DefaultResourceLoader();
    }

}


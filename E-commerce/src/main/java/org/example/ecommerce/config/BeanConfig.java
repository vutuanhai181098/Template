package org.example.ecommerce.config;

import com.github.slugify.Slugify;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Slugify slugify() {
        return Slugify.builder().build();
    }
}

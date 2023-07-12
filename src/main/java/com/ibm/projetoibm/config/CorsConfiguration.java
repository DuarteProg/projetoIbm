package com.ibm.projetoibm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Permite a origem do cliente React
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos HTTP necessários
                .allowCredentials(true); // Permite enviar credenciais, se necessário
    }
}


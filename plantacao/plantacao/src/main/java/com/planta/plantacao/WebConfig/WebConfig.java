package com.planta.plantacao.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Esse método configura o CORS (Cross-Origin Resource Sharing)
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Isso vai aplicar a configuração para todas as rotas da API
                .allowedOriginPatterns("*") // Permite que qualquer origem (domínio) acesse nossa API
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite esses métodos HTTP
                .allowedHeaders("*") // Permite qualquer cabeçalho (header) na requisição
                .allowCredentials(true); // Permite enviar credenciais (como cookies ou cabeçalhos de autenticação)
    }
}

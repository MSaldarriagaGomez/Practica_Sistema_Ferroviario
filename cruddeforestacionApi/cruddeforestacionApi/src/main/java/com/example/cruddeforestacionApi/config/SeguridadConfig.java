package com.example.cruddeforestacionApi.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//le dice que activemos la parte de seguridad para que la configuremos
//son pojos con restricciones
@Configuration
    @EnableWebSecurity
public class SeguridadConfig {
    
//filtrar caracteristicas de la configuracion

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{

    httpSecurity
                .cors(cors-> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(authorize->authorize
                                               //.requestMatchers("./api/").authenticated() para rutas especificas que requieran autorizacion
                                               .anyRequest().permitAll() )      
    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    
    

return httpSecurity.build();

}

@Bean
public CorsConfigurationSource corsConfigurationSource(){

    CorsConfiguration configuration= new CorsConfiguration();

    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
    configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "DELETE", "POST"));
    configuration.setAllowedHeaders(Arrays.asList("Authorization","Conten Type"));
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
}

}

package com.busanit501.boot501.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CustomServletConfig implements WebMvcConfigurer {

    /**
     * application.properties(or .yml)에
     *   com.busanit501.upload.path=c:\\upload\\springTest
     * 과 같이 등록된 경로를 가져와서 사용
     */
    @Value("${com.busanit501.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 리소스(js, css, 이미지 등) 매핑
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        // 업로드된 파일 접근 설정
        // 예: http://localhost:8080/upload/sample.jpg => c:\\upload\springTest\sample.jpg
        registry.addResourceHandler("/upload/**")
                // 로컬 디스크 경로는 OS에 따라 "file:///경로/" 형태로 지정
                .addResourceLocations("file:///" + uploadPath + "/");

        /*
        // 필요 시 캐시 설정도 가능 (예: 3600초)
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + uploadPath + "/")
                .setCachePeriod(3600);
        */
    }
}

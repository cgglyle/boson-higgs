package io.github.cgglyle.boson.higgs.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jackson 配置
 *
 * @author lyle
 * @since 2022/09/04
 */
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        // 设置日期序列化规则
        objectMapper.registerModule(JavaTimeModuleHandler.getTimeModule(javaTimeModule));
        // 不序列化Null
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 禁止序列化未知值
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}

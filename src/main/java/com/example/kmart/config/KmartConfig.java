package com.example.kmart.config;

import com.example.kmart.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class KmartConfig {

    @Bean
    public SimpleDateFormat dateFormatter() {
        return new SimpleDateFormat(Constants.YYYY_MM_DD);
    }

    @Bean
    public SimpleDateFormat requestDateFormatter() {
        return new SimpleDateFormat(Constants.MMM_DD_YYYY);
    }

}


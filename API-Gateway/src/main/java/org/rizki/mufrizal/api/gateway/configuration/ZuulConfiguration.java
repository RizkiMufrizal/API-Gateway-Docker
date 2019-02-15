package org.rizki.mufrizal.api.gateway.configuration;

import org.rizki.mufrizal.api.gateway.filter.ErrorFilterZuul;
import org.rizki.mufrizal.api.gateway.filter.PostFilterZuul;
import org.rizki.mufrizal.api.gateway.filter.PreFilterZuul;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 17:23
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.configuration
 * @File ZuulConfiguration
 */
@Configuration
public class ZuulConfiguration {

    @Bean
    public PreFilterZuul preFilterZuul() {
        return new PreFilterZuul();
    }

    @Bean
    public PostFilterZuul postFilterZuul() {
        return new PostFilterZuul();
    }

    @Bean
    public ErrorFilterZuul errorFilterZuul() {
        return new ErrorFilterZuul();
    }

}

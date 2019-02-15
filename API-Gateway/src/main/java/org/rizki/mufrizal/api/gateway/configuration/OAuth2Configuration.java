package org.rizki.mufrizal.api.gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 16:36
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.configuration
 * @File OAuth2Configuration
 */

@Configuration
public class OAuth2Configuration {

    private static final String RESOURCE_ID = "RESOURCE_ID_API_GATEWAY";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Autowired
        private JedisConnectionFactory jedisConnectionFactory;

        @Bean
        public TokenStore tokenStore() {
            return new RedisTokenStore(jedisConnectionFactory);
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) throws Exception {
            resourceServerSecurityConfigurer
                    .tokenStore(tokenStore())
                    .resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .authorizeRequests()
                    .antMatchers("/api/*").fullyAuthenticated()
                    .and()
                    .addFilterBefore(new CorsConfiguration(), ChannelProcessingFilter.class);
        }

    }

}
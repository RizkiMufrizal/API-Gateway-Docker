package org.rizki.mufrizal.api.gateway.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 16:59
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.configuration
 * @File HealthCheckConfiguration
 */
@RestController
public class HealthCheckConfiguration {

    @GetMapping(value = "/health-check")
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
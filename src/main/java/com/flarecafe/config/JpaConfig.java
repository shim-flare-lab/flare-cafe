package com.flarecafe.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan(basePackages = "com.flarecafe")
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}

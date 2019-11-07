package com.example.demo;

import io.micrometer.core.instrument.Clock;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

//@Configuration
public class MyConfig {

  public static final Logger logger = LoggerFactory.getLogger("micrometer-metrics");

  @Bean
  public StatsdMeterRegistry statsdMeterRegistry(StatsdConfig config, Clock clock) {
    return StatsdMeterRegistry.builder(config)
      .clock(clock)
      .lineSink(logger::info)
      .build();
  }

}

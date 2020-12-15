package com.ramon.pereira.hermes.config;

import com.ramon.pereira.hermes.business.CommunicationBusiness;
import com.ramon.pereira.hermes.business.impl.CommunicationBusinessImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class SpringTestConfiguration {

    @Bean
    @Profile("communicationBusiness")
    public CommunicationBusiness communicationBusiness() {
        return new CommunicationBusinessImpl();
    }
}

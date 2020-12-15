package com.ramon.pereira.hermes.business;

import com.ramon.pereira.hermes.config.SpringTestConfiguration;
import com.ramon.pereira.hermes.repository.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
@ActiveProfiles(profiles = "communicationBusiness")
@ContextConfiguration(classes = SpringTestConfiguration.class)
@RunWith(SpringRunner.class)
public class CommunicationBusinessTest {

    @MockBean
    private ChannelRepository channelRepository;

    @MockBean
    private CommunicationRepository communicationRepository;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private RecipientRepository recipientRepository;

    @MockBean
    private CommunicationEventRepository communicationEventRepository;

    @Autowired
    private CommunicationBusiness communicationBusiness;

}

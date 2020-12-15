package com.ramon.pereira.hermes.business;

import com.ramon.pereira.hermes.config.SpringTestConfiguration;
import com.ramon.pereira.hermes.exception.CommunicationNotFoundException;
import com.ramon.pereira.hermes.repository.*;
import com.ramon.pereira.hermes.seed.CommunicationSeeder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

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

    @Test
    public void readByIdExist() {
        Mockito.when(this.communicationRepository.findById(1))
                .thenReturn(Optional.of(CommunicationSeeder.communicationSeed(1)));

        var communication = this.communicationBusiness.read(1);

        Assert.assertTrue(communication.isPresent());
        Assert.assertNotNull(communication.get().getId());
        Assert.assertEquals(Integer.valueOf(1), communication.get().getId());
    }

    @Test(expected = CommunicationNotFoundException.class)
    public void readByIdNotExist() {
        Mockito.when(this.communicationRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.empty());

        this.communicationBusiness.read(1);
    }

}

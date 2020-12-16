package com.ramon.pereira.hermes.business;

import com.ramon.pereira.hermes.config.SpringTestConfiguration;
import com.ramon.pereira.hermes.exception.ChannelNotFoundException;
import com.ramon.pereira.hermes.exception.CommunicationCanceledException;
import com.ramon.pereira.hermes.exception.CommunicationNotFoundException;
import com.ramon.pereira.hermes.exception.EventNotFoundException;
import com.ramon.pereira.hermes.model.Communication;
import com.ramon.pereira.hermes.model.CommunicationEvent;
import com.ramon.pereira.hermes.model.enChannel;
import com.ramon.pereira.hermes.model.enEvent;
import com.ramon.pereira.hermes.repository.*;
import com.ramon.pereira.hermes.seed.ChannelSeeder;
import com.ramon.pereira.hermes.seed.CommunicationSeeder;
import com.ramon.pereira.hermes.seed.EventSeeder;
import com.ramon.pereira.hermes.seed.RecipientSeeder;
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

    @Test(expected = CommunicationNotFoundException.class)
    public void removeCommunicationNotFound() {
        Mockito.when(this.communicationRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.empty());

        this.communicationBusiness.remove(1);
    }

    @Test(expected = CommunicationCanceledException.class)
    public void removeCommunicationAlreadyCanceled() {
        Mockito.when(this.communicationRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(CommunicationSeeder.communicationSeed(1, enEvent.CANCELED)));

        this.communicationBusiness.remove(1);
    }

    @Test(expected = EventNotFoundException.class)
    public void removeCommunicationEventNotFound() {
        Mockito.when(this.communicationRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(CommunicationSeeder.communicationSeed(1)));

        Mockito.when(this.eventRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.empty());

        this.communicationBusiness.remove(1);
    }

    @Test
    public void removeCommunication() {
        Mockito.when(this.communicationRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(CommunicationSeeder.communicationSeed(1, enEvent.SCHEDULED)));

        Mockito.when(this.eventRepository.findByName(enEvent.CANCELED))
                .thenReturn(Optional.of(EventSeeder.eventSeed(1, enEvent.CANCELED)));

        Mockito.when(this.communicationEventRepository.saveAndFlush(ArgumentMatchers.any(CommunicationEvent.class)))
                .thenReturn(ArgumentMatchers.any());

        Optional<Communication> communication = this.communicationBusiness.remove(1);

        Assert.assertTrue(communication.isPresent());
        Assert.assertNotNull(communication.get().getId());
        Assert.assertTrue(communication.get().getEvents()
                .stream()
                .anyMatch(event -> event.getEvent().getName() == enEvent.CANCELED));
    }

    @Test(expected = ChannelNotFoundException.class)
    public void createCommunicationChannelNotExist() {
        Mockito.when(this.channelRepository.findByName(ArgumentMatchers.any(enChannel.class)))
                .thenReturn(Optional.empty());

        this.communicationBusiness.create(CommunicationSeeder.communicationSeed(1));
    }

    @Test(expected = EventNotFoundException.class)
    public void createCommunicationEventNotExist() {
        Mockito.when(this.channelRepository.findByName(ArgumentMatchers.any(enChannel.class)))
                .thenReturn(Optional.of(ChannelSeeder.channelSeed(1, enChannel.WHATSAPP)));

        Mockito.when(this.eventRepository.findByName(enEvent.SCHEDULED))
                .thenReturn(Optional.empty());

        this.communicationBusiness.create(CommunicationSeeder.communicationSeed(1));
    }

    @Test
    public void createCommunicationRecipientExist() {
        Mockito.when(this.channelRepository.findByName(ArgumentMatchers.any(enChannel.class)))
                .thenReturn(Optional.of(ChannelSeeder.channelSeed(1, enChannel.WHATSAPP)));

        Mockito.when(this.eventRepository.findByName(enEvent.SCHEDULED))
                .thenReturn(Optional.of(EventSeeder.eventSeed(1, enEvent.SCHEDULED)));

        Mockito.when(this.recipientRepository.findOneByEmailOrPhone(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(RecipientSeeder.recipientSeed(1)));

        Communication communication = CommunicationSeeder.communicationSeed(1);

        Mockito.when(this.communicationRepository.saveAndFlush(ArgumentMatchers.any(Communication.class)))
                .thenReturn(communication);

        Optional<Communication> communicationCreated = this.communicationBusiness.create(communication);

        Assert.assertTrue(communicationCreated.isPresent());
        Assert.assertNotNull(communicationCreated.get().getId());
        Assert.assertFalse(communicationCreated.get().getEvents().isEmpty());
        Assert.assertFalse(communicationCreated.get().getChannels().isEmpty());
        Assert.assertFalse(communicationCreated.get().getRecipients().isEmpty());
    }

    @Test
    public void createCommunicationRecipientNotExit() {
        Mockito.when(this.channelRepository.findByName(ArgumentMatchers.any(enChannel.class)))
                .thenReturn(Optional.of(ChannelSeeder.channelSeed(1, enChannel.WHATSAPP)));

        Mockito.when(this.eventRepository.findByName(enEvent.SCHEDULED))
                .thenReturn(Optional.of(EventSeeder.eventSeed(1, enEvent.SCHEDULED)));

        Mockito.when(this.recipientRepository.findOneByEmailOrPhone(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

        Mockito.when(this.recipientRepository.saveAndFlush(ArgumentMatchers.any()))
                .thenReturn(RecipientSeeder.recipientSeed(1));

        Communication communication = CommunicationSeeder.communicationSeed(1);

        Mockito.when(this.communicationRepository.saveAndFlush(ArgumentMatchers.any(Communication.class)))
                .thenReturn(communication);

        Optional<Communication> communicationCreated = this.communicationBusiness.create(communication);

        Assert.assertTrue(communicationCreated.isPresent());
        Assert.assertNotNull(communicationCreated.get().getId());
        Assert.assertFalse(communicationCreated.get().getEvents().isEmpty());
        Assert.assertFalse(communicationCreated.get().getChannels().isEmpty());
        Assert.assertFalse(communicationCreated.get().getRecipients().isEmpty());
    }

}

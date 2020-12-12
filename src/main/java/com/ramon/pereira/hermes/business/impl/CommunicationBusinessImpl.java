package com.ramon.pereira.hermes.business.impl;

import com.ramon.pereira.hermes.business.CommunicationBusiness;
import com.ramon.pereira.hermes.exception.ChannelNotFoundException;
import com.ramon.pereira.hermes.model.*;
import com.ramon.pereira.hermes.repository.ChannelRepository;
import com.ramon.pereira.hermes.repository.CommunicationRepository;
import com.ramon.pereira.hermes.repository.EventRepository;
import com.ramon.pereira.hermes.repository.RecipientRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommunicationBusinessImpl implements CommunicationBusiness {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private CommunicationRepository communicationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Override
    public Optional<Communication> create(@NonNull Communication communication) {

        communication.getChannels().forEach(
                ch -> {
                    ch.setChannel(validChannel(ch));
                    ch.setCommunication(communication);
                }
        );

        Event event = eventRepository.findByName(enEvent.SCHEDULED).orElseThrow();

        communication.getEvents().forEach(
                ev -> {
                    ev.setEvent(event);
                    ev.setCommunication(communication);
                }
        );

        communication.getRecipients().forEach(
                rec -> {
                    rec.setRecipient(validRecipient(rec));
                    rec.setCommunication(communication);
                }
        );

        return Optional.of(communicationRepository.saveAndFlush(communication));
    }

    private Channel validChannel(@NonNull final CommunicationChannel communicationChannel) {
        return channelRepository.findByName(communicationChannel.getChannel().getName())
                .orElseThrow(ChannelNotFoundException::new);
    }

    private Recipient validRecipient(@NonNull final CommunicationRecipient communicationRecipient) {
        Recipient recipient = communicationRecipient.getRecipient();

        recipient = recipientRepository.findOneByEmailOrPhone(recipient.getEmail(), recipient.getPhone())
                .orElse(recipientRepository.saveAndFlush(Recipient.builder()
                        .name(recipient.getName())
                        .phone(recipient.getPhone())
                        .email(recipient.getEmail())
                        .build()));

        return recipient;
    }
}

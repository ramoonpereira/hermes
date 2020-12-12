package com.ramon.pereira.hermes.business.impl;

import com.ramon.pereira.hermes.business.CommunicationBusiness;
import com.ramon.pereira.hermes.repository.ChannelRepository;
import com.ramon.pereira.hermes.repository.CommunicationRepository;
import com.ramon.pereira.hermes.repository.EventRepository;
import com.ramon.pereira.hermes.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

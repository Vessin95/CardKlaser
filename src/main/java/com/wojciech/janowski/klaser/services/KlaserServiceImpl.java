package com.wojciech.janowski.klaser.services;

import com.wojciech.janowski.klaser.Card;
import com.wojciech.janowski.klaser.CardAlreadyExistsException;
import com.wojciech.janowski.klaser.NoSuchCardException;
import com.wojciech.janowski.klaser.Status;
import com.wojciech.janowski.klaser.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class KlaserServiceImpl implements KlaserService {

    @Autowired
    @Qualifier("lista")
    private CardsRepository cardsRepository;

    @Override
    public List<Card> findAll() {
        return cardsRepository.findAll();
    }

    @Override
    public List<Card> findAllToSell() {
        return cardsRepository.findAll().stream().filter(card -> card.getStatus() == Status.TO_SELL).collect(Collectors.toList());
    }

    @Override
    public List<Card> findDuplicates() {
        return cardsRepository.findAll().stream().filter(card -> card.getStatus() == Status.DUPLICATE).collect(Collectors.toList());
    }

    @Override
    public Optional<Card> findByID(Long id) {
        try {
            return Optional.of(cardsRepository.readByID(id));
        } catch (NoSuchCardException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Card> create(Card card) {
        try {
            return Optional.of(cardsRepository.create(card));
        } catch (CardAlreadyExistsException e) {
            try {
                return Optional.of(cardsRepository.readByID(card.getCatalogNumber()));
            } catch (NoSuchCardException e1) {
                return Optional.empty();
            }
        }
    }

    @Override
    public Optional<Card> edit(Card card) {
        try {
            return Optional.of(cardsRepository.update(card));
        } catch (NoSuchCardException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Boolean> deleteByID(Long id) {
        try {
            cardsRepository.deleteByID(id);
            return Optional.of(Boolean.TRUE);
        } catch (NoSuchCardException e) {
            return Optional.of(Boolean.FALSE);
        }
    }

    @Override
    public List<Card> findLatest3() {
        return cardsRepository.findAll().stream().filter(p -> Objects.equals(p.getStatus(), Status.TO_SELL))
                .collect(Collectors.toList());
    }
}

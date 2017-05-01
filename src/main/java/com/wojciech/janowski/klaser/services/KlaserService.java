package com.wojciech.janowski.klaser.services;

import com.wojciech.janowski.klaser.Card;

import java.util.List;
import java.util.Optional;

public interface KlaserService {
    List<Card> findAll();

    List<Card> findAllToSell();

    List<Card> findDuplicates();

    Optional<Card> findByID(Long id);

    Optional<Card> create(Card card);

    Optional<Card> edit(Card card);

    Optional<Boolean> deleteByID(Long id);

    List<Card> findLatest3();
}

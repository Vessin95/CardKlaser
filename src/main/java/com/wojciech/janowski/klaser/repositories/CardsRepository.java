package com.wojciech.janowski.klaser.repositories;

import com.wojciech.janowski.klaser.Card;
import com.wojciech.janowski.klaser.CardAlreadyExistsException;
import com.wojciech.janowski.klaser.NoSuchCardException;

import java.util.List;

public interface CardsRepository {
    Card create(Card card) throws CardAlreadyExistsException;
    Card readByID(Long id) throws NoSuchCardException;
    Card update(Card card) throws NoSuchCardException;
    void deleteByID(Long id) throws NoSuchCardException;
    List<Card> findAll();
}

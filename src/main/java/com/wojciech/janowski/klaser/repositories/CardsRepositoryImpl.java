package com.wojciech.janowski.klaser.repositories;

import com.wojciech.janowski.klaser.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Qualifier("lista")
public class CardsRepositoryImpl implements CardsRepository {

    private List<Card> cards = new ArrayList<Card>() {
        {
            add(Card.produceCard(1L, "Mystical Elf", "A delicate elf that lacks offense, but has a terrific defense backed by mystical power.", 4L, 800L, 2000L, Attribute.LIGHT, MonsterType.Spellcaster,
                    CardType.Normal, new BigDecimal("23.5"), new Date(), Status.NEW));
            add(Card.produceCard(2L, "Dark Magician", "The ultimate wizard in terms of attack and defense.", 7L, 2500L, 2100L, Attribute.DARK, MonsterType.Spellcaster,
                    CardType.Spirit, new BigDecimal("23.5"), new Date(), Status.NEW));
            add(Card.produceCard(3L, "Curse of Dragon", "A wicked dragon that taps into dark forces to execute a powerful attack.", 5L, 2000L, 1500L, Attribute.DARK, MonsterType.Dragon,
                    CardType.Spirit, new BigDecimal("23.5"), new Date(), Status.TO_SELL));
            add(Card.produceCard(4L, "Gaia The Fierce Knight", "A knight whose horse travels faster than the wind. His battle-charge is a force to be reckoned with.", 7L, 2300L, 2100L, Attribute.EARTH, MonsterType.Warrior,
                    CardType.Spirit, new BigDecimal("23.5"), new Date(), Status.DUPLICATE));
            add(Card.produceCard(5L, "Gaia The Fierce Knight", "A knight whose horse travels faster than the wind. His battle-charge is a force to be reckoned with.", 7L, 2300L, 2100L, Attribute.EARTH, MonsterType.Warrior,
                    CardType.Spirit, new BigDecimal("23.5"), new Date(), Status.DUPLICATE));
        }
    };

    @Override
    public Card create(Card card) throws CardAlreadyExistsException {
        if (!cards.isEmpty()) {
            card.setCatalogNumber(
                    this.cards.stream().mapToLong(p -> p.getCatalogNumber()).max().getAsLong() + 1);
        } else {
            card.setCatalogNumber(1L);
        }
        this.cards.add(card);
        return card;
    }

    @Override
    public Card readByID(Long id) throws NoSuchCardException {
        return this.cards.stream().filter(p -> Objects.equals(p.getCatalogNumber(), id)).findFirst()
                .orElseThrow(NoSuchCardException::new);
    }

    @Override
    public Card update(Card card) throws NoSuchCardException {
        for (int i = 0; i < this.cards.size(); i++) {
            if (Objects.equals(this.cards.get(i).getCatalogNumber(), card.getCatalogNumber())) {
                this.cards.set(i, card);
                return card;
            }
        }
        throw new NoSuchCardException("Nie ma takiej karty: " + card.getCatalogNumber());
    }

    @Override
    public void deleteByID(Long id) throws NoSuchCardException {
        for (int i = 0; i < this.cards.size(); i++) {
            if (Objects.equals(this.cards.get(i).getCatalogNumber(), id)) {
                this.cards.remove(i);
            }
        }
        throw new NoSuchCardException("Nie ma takiej Monety: " + id);
    }

    @Override
    public List<Card> findAll() {
        return this.cards;
    }
}

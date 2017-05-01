package com.wojciech.janowski.klaser;

import java.math.BigDecimal;
import java.util.Date;

public class Card {
    private Long catalogNumber;
    private String name;
    private String description;
    private Long level;
    private Long attack;
    private Long defense;
    private Attribute attribute;
    private MonsterType monsterType;
    private CardType cardType;
    private BigDecimal purchasePrice;
    private Date purchaseDate;
    private Status status;

    public static Card produceCard(Long catalogNumber, String name, String description, Long level, Long attack, Long defense,
                                   Attribute attribute, MonsterType monsterType, CardType cardType, BigDecimal purchasePrice,
                                   Date purchaseDate, Status status) {
        Card card = new Card();
        card.catalogNumber = catalogNumber;
        card.name = name;
        card.description = description;
        card.level = level;
        card.attack = attack;
        card.defense = defense;
        card.attribute = attribute;
        card.monsterType = monsterType;
        card.cardType = cardType;
        card.purchasePrice = purchasePrice;
        card.purchaseDate = purchaseDate;
        card.status = status;
        return card;
    }


    public Long getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(Long catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getAttack() {
        return attack;
    }

    public void setAttack(Long attack) {
        this.attack = attack;
    }

    public Long getDefense() {
        return defense;
    }

    public void setDefense(Long defense) {
        this.defense = defense;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (catalogNumber != card.catalogNumber) return false;
        if (level != card.level) return false;
        if (attack != card.attack) return false;
        if (defense != card.defense) return false;
        if (name != null ? !name.equals(card.name) : card.name != null) return false;
        if (description != null ? !description.equals(card.description) : card.description != null) return false;
        if (attribute != card.attribute) return false;
        if (monsterType != card.monsterType) return false;
        if (cardType != card.cardType) return false;
        if (purchasePrice != null ? !purchasePrice.equals(card.purchasePrice) : card.purchasePrice != null)
            return false;
        if (purchaseDate != null ? !purchaseDate.equals(card.purchaseDate) : card.purchaseDate != null) return false;
        return status == card.status;
    }

    @Override
    public int hashCode() {
        int result = (int) (catalogNumber ^ (catalogNumber >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (level ^ (level >>> 32));
        result = 31 * result + (int) (attack ^ (attack >>> 32));
        result = 31 * result + (int) (defense ^ (defense >>> 32));
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (monsterType != null ? monsterType.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "catalogNumber=" + catalogNumber +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", attack=" + attack +
                ", defense=" + defense +
                ", attribute=" + attribute +
                ", monsterType=" + monsterType +
                ", cardType=" + cardType +
                ", purchasePrice=" + purchasePrice +
                ", purchaseDate=" + purchaseDate +
                ", status=" + status +
                '}';
    }
}

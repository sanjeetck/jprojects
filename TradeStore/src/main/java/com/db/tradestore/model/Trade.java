package com.db.tradestore.model;

import java.time.LocalDate;
import java.util.Objects;

public class Trade {
    private String tradeId;
    private int version;
    private String counterPartyId;
    private String bookId;
    private LocalDate maturityDate;
    private LocalDate creationDate;
    private boolean expired;

    public Trade(String tradeId, int version, String counterPartyId, String bookId,
                 LocalDate maturityDate, LocalDate creationDate, boolean expired) {
        this.tradeId = tradeId;
        this.version = version;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.creationDate = creationDate;
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return Objects.equals(tradeId, trade.tradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId);
    }

    public String getTradeId() {
        return tradeId;
    }

    public int getVersion() {
        return version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isExpired() {
        return expired;
    }

}


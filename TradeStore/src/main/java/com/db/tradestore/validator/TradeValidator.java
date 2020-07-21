package com.db.tradestore.validator;

import com.db.tradestore.model.Trade;
import java.time.LocalDate;

/*
 * Assumes that the system will startup every day and fetch the current system date.
 * Does not consider timezone
 */
public class TradeValidator {
    //TODO :: What should be the currentDate to allow storing these 4 trades?
    private final LocalDate currenctDate = LocalDate.now();

    public boolean validateTrade(Trade t) {
        if (currenctDate.compareTo(t.getMaturityDate()) > 0) {
            System.out.println("Trade's maturity date  (" + t.getMaturityDate() + ") less than current date (" + currenctDate +
                    ") ::Rejected: tradeId: " + t.getTradeId() + " :Ver:: "+ t.getVersion());
            return false;
        }

        return true;
    }
}

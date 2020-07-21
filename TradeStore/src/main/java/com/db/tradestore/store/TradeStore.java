package com.db.tradestore.store;

import com.db.tradestore.model.Trade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Demo Trade Store using Map and ArrayList
 */
public class TradeStore {
    private Map<String, List<Trade>> tradeStore = new ConcurrentHashMap<>();

    public boolean addTradeToStore(Trade t) {
        return tradeStore.computeIfAbsent(t.getTradeId(), (key -> new ArrayList<>())).add(t);
    }

    public boolean updateTradeInStore(Trade t, Integer version) {
        List<Trade> tradeList = tradeStore.get(t.getTradeId());
        if ((tradeList.get(tradeList.size()-1)).getVersion() == version) {
            Trade tOld = tradeList.set(tradeList.size()-1, t);
            if (tOld != null) {
                return true;
            }
        }
        return false;
    }

    /*
     * Not sure when this needs to run, as part of adding/updating or as a separate thread
     */
    public void updateExpiryDates(LocalDate currentDate) {

    }

    public void showContents() {
        List<Trade> trades;
        for (String tradeKey: tradeStore.keySet()) {
            trades = tradeStore.get(tradeKey);
            for (Trade t : trades) {
                System.out.println("TradeId: " + t.getTradeId() +  " :: Trade Version: "
                        + t.getVersion() + " ::Trade Maturity Date: " + t.getMaturityDate());
            }
        }
    }
}

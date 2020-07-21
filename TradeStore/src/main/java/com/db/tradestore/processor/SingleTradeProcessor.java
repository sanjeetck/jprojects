package com.db.tradestore.processor;

import com.db.tradestore.model.Trade;
import com.db.tradestore.store.TradeStore;
import com.db.tradestore.validator.TradeValidator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * In a multi-threaded version,
 *      We could have one thread that receives the trades
 *      and use tradeId's hashcode for routing - Ensures if tradeId T1 goes to ThreadA,
 *      next versions of T1 will goto ThreadA
 *      Then  use say, 4 worker threads with their blocking queues (supplied by the receiver)
 *      Use Spring JMS for receiver
 */
public class SingleTradeProcessor {
    private Map<String, Integer> tradeLatestVersionMap = new ConcurrentHashMap<>();
    private TradeStore tradeStore;
    private TradeValidator validator;

    public SingleTradeProcessor(TradeStore tradeStore, TradeValidator validator) {
        this.validator = validator;
        this.tradeStore = tradeStore;
    }

    public Integer processTrades(List<Trade> tradesList) {
        int counter = 0;
        int oldTradeVersionId;

        for(Trade t : tradesList) {

            // Validate trade
            boolean validTrade = validator.validateTrade(t);
            if (!validTrade) {
                continue;
            }

            if (tradeLatestVersionMap.get(t.getTradeId()) != null) {
                oldTradeVersionId = tradeLatestVersionMap.get(t.getTradeId());
                if (t.getVersion() < oldTradeVersionId) {
                    //skip after logging an error
                    System.out.println("Older Version of trade in TradeStore greater than " +
                            "incoming version:" + t.getTradeId() + " :Ver:: "+ t.getVersion());
                    continue;
                }else {
                    if (t.getVersion() == oldTradeVersionId) {
                        // update trade
                        tradeStore.updateTradeInStore(t, t.getVersion());
                        counter++;
                        System.out.println("Updating Existing Version in TradeStore  " +
                                "incoming version:" + t.getTradeId() + " :Ver:: "+ t.getVersion());
                    }else {
                        // Add New Version
                        addNewTradeOrNewVersionInStore(t);
                        counter++;
                    }
                }
            }else {
                // New trade
                addNewTradeOrNewVersionInStore(t);
                counter++;
            }
        }
        return counter;
    }

    private void addNewTradeOrNewVersionInStore(Trade t) {
        tradeStore.addTradeToStore(t);
        tradeLatestVersionMap.put(t.getTradeId(), t.getVersion());
        System.out.println("Adding New trade or New Version in TradeStore  " +
                "incoming version:" + t.getTradeId() + " :Ver:: "+ t.getVersion());
    }
}

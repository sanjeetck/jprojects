package com.db.tradestore;

import com.db.tradestore.model.Trade;
import com.db.tradestore.processor.SingleTradeProcessor;
import com.db.tradestore.source.TradeGenerator;
import com.db.tradestore.store.TradeStore;
import com.db.tradestore.validator.TradeValidator;

/**
 * Trade Store Application
 * Overall Processing pattern
 * -> Receive TradeMessage
 * -> Create Trade
 * -> Validate Trade
 * -> Process Trade
 * -> Store Trade
 *  Missing (Expiry Date Updation) - I have query around this
 *
 *  P.S Dependency injection can be done with Spring but here I have kept things old way.
 */
public class TradeApp
{
    public static void main( String[] args ) {
        TradeStore tradeStore = new TradeStore();
        TradeValidator validator = new TradeValidator();
        SingleTradeProcessor tradeProcessor = new SingleTradeProcessor(tradeStore, validator);
        tradeProcessor.processTrades(TradeGenerator.generateBulkTrades());
    }
}

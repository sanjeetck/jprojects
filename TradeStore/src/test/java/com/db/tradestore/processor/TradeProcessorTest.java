package com.db.tradestore.processor;

import com.db.tradestore.model.Trade;
import com.db.tradestore.source.TradeGenerator;
import com.db.tradestore.store.TradeStore;
import com.db.tradestore.validator.TradeValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TradeProcessorTest {
    TradeValidator tradeValidator = new TradeValidator();
    TradeStore tradeStore = new TradeStore();

    SingleTradeProcessor processor = new SingleTradeProcessor(tradeStore, tradeValidator);

    @Test
    public void testAllValidTrades() {
        List<Trade> tradeList = TradeGenerator.generateSampleTrades();
        assertTrue("Valid", processor.processTrades(tradeList) == 2);
    }

    @Test
    public void testMultiVersionOfTrade() {
        List<Trade> tradeList = TradeGenerator.generateTradesWithVersionsTrades();
        assertTrue("Invalid", processor.processTrades(tradeList) == 4);
    }
}

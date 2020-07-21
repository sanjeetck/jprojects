package com.db.tradestore.store;

import com.db.tradestore.model.Trade;
import com.db.tradestore.processor.SingleTradeProcessor;
import com.db.tradestore.source.TradeGenerator;
import com.db.tradestore.validator.TradeValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TradeStoreTest {
    TradeStore tradeStore = new TradeStore();

    @Test
    public void testInsertionInStore() {
        List<Trade> tradeList = TradeGenerator.generateSampleTrades();
        assertTrue("Valid", tradeStore.addTradeToStore(tradeList.get(0)) == true);
    }

    @Test
    public void testUpdateInStore() {
        List<Trade> tradeList = TradeGenerator.generateTradesWithVersionsTrades();
        tradeStore.addTradeToStore(tradeList.get(3));
        assertTrue("Invalid",
                tradeStore.updateTradeInStore(tradeList.get(4), tradeList.get(4).getVersion()) == true);
    }
}

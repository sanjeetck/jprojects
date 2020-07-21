package com.db.tradestore.validator;

import com.db.tradestore.model.Trade;
import com.db.tradestore.source.TradeGenerator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TradeValidatorTest {
    TradeValidator validate = new TradeValidator();

    @Test
    public void testInvalidTrade() {
        List<Trade> tradeList = TradeGenerator.generateSampleTrades();
        assertTrue("Invalid", validate.validateTrade(tradeList.get(3)) == false);
    }

    @Test
    public void testValidTrade() {
        List<Trade> tradeList = TradeGenerator.generateSampleTrades();
        assertTrue("Invalid", validate.validateTrade(tradeList.get(1)) == true);
    }
}

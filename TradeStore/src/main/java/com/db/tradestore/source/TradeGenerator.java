package com.db.tradestore.source;

import com.db.tradestore.model.Trade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class TradeGenerator {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static List<Trade> generateSampleTrades() {
        List<Trade> sampleTrades = new ArrayList<>();

        sampleTrades.add(new Trade("T1", 1, "CP-1", "B1",
                LocalDate.parse("20/05/2020", formatter), LocalDate.now(), false));

        sampleTrades.add(new Trade("T2", 1, "CP-1", "B1",
                LocalDate.parse("20/05/2021", formatter), LocalDate.parse("14/03/2015", formatter), false));

        sampleTrades.add(new Trade("T2", 2, "CP-2", "B1",
                LocalDate.parse("20/05/2021", formatter), LocalDate.now(), false));

        sampleTrades.add(new Trade("T3", 3, "CP-3", "B2",
                LocalDate.parse("20/05/2014", formatter), LocalDate.now(), true));

        return sampleTrades;
    }

    public static List<Trade> generateTradesWithVersionsTrades() {
        List<Trade> sampleTrades = new ArrayList<>();

        sampleTrades.add(new Trade("T1", 1, "CP-1", "B1",
                LocalDate.parse("20/05/2021", formatter), LocalDate.now(), false));

        sampleTrades.add(new Trade("T1", 3, "CP-1", "B1",
                LocalDate.parse("20/05/2021", formatter), LocalDate.parse("14/03/2015", formatter), false));

        sampleTrades.add(new Trade("T1", 2, "CP-2", "B1",
                LocalDate.parse("20/05/2021", formatter), LocalDate.now(), false));

        sampleTrades.add(new Trade("T1", 4, "CP-3", "B2",
                LocalDate.parse("20/05/2021", formatter), LocalDate.now(), true));

        sampleTrades.add(new Trade("T1", 4, "CP-4", "B2",
                LocalDate.parse("20/05/2021", formatter), LocalDate.now(), true));

        return sampleTrades;
    }

    public static List<Trade> generateBulkTrades() {
        String str = new String("T");
        List<Trade> sampleTrades = new ArrayList<>();
        Random random = new Random();

        IntStream.rangeClosed(1, 1_00_000).forEach(counter ->
        {
            sampleTrades.add(new Trade(str + random.nextInt(1000),
                    random.nextInt(10), "CP-1", "B1",
                    LocalDate.parse("20/05/2021", formatter), LocalDate.now(), false ));
        });

        return sampleTrades;

    }
}

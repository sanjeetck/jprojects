package com.sk.algos.ds.newseries.algos.prefix;

import java.util.Arrays;

public class MapSumApplication {


    public static void main(String[] args) {
        String[][] inputTC = {
                {"init", ""},
                {"insert", "apple", "3"},
                {"sum", "ap"},
                {"insert", "app", "2"},
                {"sum", "ap"},
                {"insert", "apple", "5"},
                {"insert", "apple", "1"},
                {"sum", "apple"}
        };

        String[][] resultTC = {
                {"init", null},
                {"insert", null},
                {"sum", "3"},
                {"insert", null},
                {"sum", "5"},
                {"insert", null},
                {"insert", null},
                {"sum", "1"}
        };


        int totalCases = inputTC.length;
        int passedCases = 0;

        MapSum mapSum = new MapSum();
        String[][] actualResults  = new String[totalCases][2];

        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            String command = inputTC[cntr][0];
            String value = inputTC[cntr][1];

            if (command.equals("init")) {
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = null;
            }else if (command.equals("insert")) {
                String param = inputTC[cntr][2];
                mapSum.insert(value, Integer.parseInt(param));
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = null;
            }else if (command.equals("sum")) {
                int result = mapSum.sumPrefix(value);
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = String.valueOf(result);
            }
            System.out.println("Actual Results:" + actualResults[cntr][0] + " :: " +actualResults[cntr][1]);
            System.out.println("Expected Results:" + resultTC[cntr][0] + " :: " +resultTC[cntr][1]);
        }

        for (int cntr = 0; cntr < actualResults.length; cntr++) {
            System.out.println(actualResults[cntr][0] + " :: " +actualResults[cntr][1]);
            if (Arrays.equals(actualResults[cntr], resultTC[cntr])) {
                passedCases++;
            } else {
                System.out.println("Failed case no: " + cntr);
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }

    }
}
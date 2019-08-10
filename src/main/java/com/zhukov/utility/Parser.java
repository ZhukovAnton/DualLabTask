package com.zhukov.utility;

import com.zhukov.entity.Time;

public class Parser {
    private static volatile Parser instance;

    private Parser() {}

    public static Parser getInstance() {
        if (instance == null) {
            synchronized (Parser.class) {
                if (instance == null) {
                    instance = new Parser();
                }
            }
        }
        return instance;
    }

    public String getNameOfBusCompanyFromEntry(String entry) {
        return entry.split(" ")[0];
    }

    public Time getDepartureTimeFromEntry(String entry) {
        String departureTime = entry.split(" ")[1];
        String[] parsedDepartureTime = departureTime.split(":");
        Integer hours = Integer.parseInt(parsedDepartureTime[0]);
        Integer minutes = Integer.parseInt(parsedDepartureTime[1]);
        return new Time(hours, minutes);
    }

    public Time getArrivalTimeFromEntry(String entry) {
        String arrivalTime = entry.split(" ")[2];
        String[] parsedArrivalTime = arrivalTime.split(":");
        Integer hours = Integer.parseInt(parsedArrivalTime[0]);
        Integer minutes = Integer.parseInt(parsedArrivalTime[1]);
        return new Time(hours, minutes);
    }

}

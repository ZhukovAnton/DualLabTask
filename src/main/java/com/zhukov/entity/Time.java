package com.zhukov.entity;

public class Time implements Comparable{
    private Integer hours;
    private Integer minutes;

    public Time(Integer h, Integer m) {
        hours = h;
        minutes = m;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public static int getDifferenceInMinutes(Time first, Time second) {
        return first.hours * 60 + first.minutes - second.hours * 60 - second.minutes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (null == obj || getClass() != obj.getClass()) {
            return false;
        }

        Time time = (Time) obj;
        return hours.equals(time.hours) && minutes.equals(time.minutes);
    }

    @Override
    public String toString() {
        StringBuilder hhmm = new StringBuilder("");
        if (hours < 10) hhmm.append("0").append(hours);
        else hhmm.append(hours);
        if (minutes < 10) hhmm.append(":0").append(minutes);
        else hhmm.append(":").append(minutes);
        return hhmm.toString();
    }

    @Override
    public int compareTo(Object o) {
        Time time = (Time) o;
        return (hours * 60 + minutes) - time.hours * 60 - time.minutes;
    }
}

package com.zhukov.entity;

public class BusService implements Comparable {
    private String nameOfCompany;
    private Convenience convenience;
    private Time departureTime;
    private Time arrivalTime;
    private boolean valid = true;

    public BusService(String nameOfCompany, Convenience convenience, Time departureTime, Time arrivalTime) {
        this.nameOfCompany = nameOfCompany;
        this.convenience = convenience;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public Convenience getConvenience() {
        return convenience;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Object o) {
        BusService busService = (BusService) o;
        if (departureTime.equals(busService.departureTime)) {
            if (arrivalTime.equals((busService.arrivalTime))) {
                return -convenience.compareTo(busService.convenience);
            }
            else {
                return arrivalTime.compareTo(busService.arrivalTime);
            }
        }
        else {
            return departureTime.compareTo(busService.departureTime);
        }
    }
}

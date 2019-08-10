package com.zhukov.utility;

import com.zhukov.entity.BusService;
import com.zhukov.entity.Time;

import java.util.List;

public class Validator {
    private static volatile Validator instance;

    private Validator() {}

    public static Validator getInstance() {
        if (null == instance) {
            synchronized (Validator.class) {
                if (null == instance) {
                    instance = new Validator();
                }
            }
        }
        return instance;
    }

    private void invalidateAllServicesLongerThanAnHour(List<BusService> busServices) {
        for(BusService service : busServices) {
            if (Time.getDifferenceInMinutes(service.getArrivalTime(), service.getDepartureTime()) > 60) {
                service.setValid(false);
            }
        }
    }

    private void invalidateAllNotEfficientServices(List<BusService> busServices) {
        for (int i = 0; i < busServices.size(); ++i) {
            BusService currentService = busServices.get(i);
            if (!currentService.isValid()) continue;
            int j = i + 1;
            while(j < busServices.size() && currentService.getArrivalTime().compareTo(busServices.get(j).getDepartureTime()) > 0) {
                BusService tempService = busServices.get(j);
                if (!tempService.isValid()) {
                    j++;
                }
                else {
                    //if has the same departure and arrival time
                    if (currentService.getDepartureTime().compareTo(tempService.getDepartureTime()) == 0
                            && currentService.getArrivalTime().compareTo(tempService.getArrivalTime()) == 0) {
                        if (!currentService.getConvenience().isComfortable()) {
                            currentService.setValid(false);
                            break;
                        }
                        j++;
                        continue;
                    }

                    //if tempService starts at the same time and reaches earlier, or
                    //if tempService starts later and reaches at the same time, or
                    //if tempService starts later and reaches earlier.
                    if (currentService.getDepartureTime().compareTo(tempService.getDepartureTime()) <= 0
                            && currentService.getArrivalTime().compareTo(tempService.getArrivalTime()) >= 0) {
                        currentService.setValid(false);
                        break;
                    }
                    j++;
                }
            }
        }
    }

    public void validate(List<BusService> busServices) {
        invalidateAllServicesLongerThanAnHour(busServices);
        invalidateAllNotEfficientServices(busServices);
    }
}

package com.zhukov.main;

import com.zhukov.entity.BusService;
import com.zhukov.entity.Convenience;
import com.zhukov.entity.Time;
import com.zhukov.utility.DataProvider;
import com.zhukov.utility.Parser;
import com.zhukov.utility.Validator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class App 
{
    public static void main( String[] args ) throws IOException {
        String filePath = args[0];
        DataProvider dataProvider = new DataProvider(filePath);

        List<String> entries = dataProvider.getListOfEntriesFromFile();

        List<BusService> busServices = new ArrayList<>();

        Parser parser = Parser.getInstance();

        for(String entry : entries) {
            String companyName = parser.getNameOfBusCompanyFromEntry(entry);
            Time departureTime = parser.getDepartureTimeFromEntry(entry);
            Time arrivalTime = parser.getArrivalTimeFromEntry(entry);

            Convenience convenience = Convenience.Comfortable; //by default

            /*Hardcoded*/
            if (companyName.equals("Grotty")) {
                convenience = Convenience.Uncomfortable;
            }

            busServices.add(new BusService(companyName, convenience, departureTime, arrivalTime));
        }

        List<BusService> sortedBusServices = busServices.stream().sorted().collect(Collectors.toList());

        Validator validator = Validator.getInstance();

        validator.validate(sortedBusServices);

        FileWriter fw = new FileWriter("output.txt");

        printServicesOfSuchCompany("Posh", sortedBusServices, fw);

        fw.write("\n");

        printServicesOfSuchCompany("Grotty", sortedBusServices, fw);

        fw.close();
    }

    private static void printServicesOfSuchCompany(String nameOfCompany,
                                                   List<BusService> sortedBusServices,
                                                   FileWriter fw) throws IOException{
        for (BusService busService : sortedBusServices) {
            if (busService.isValid() && busService.getNameOfCompany().equals(nameOfCompany)) {
                fw.write(nameOfCompany + " "
                        + busService.getDepartureTime() + " "
                        + busService.getArrivalTime() + "\n");
            }
        }
    }
}

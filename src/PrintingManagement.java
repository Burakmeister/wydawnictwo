package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PrintingManagement implements Serializable {
    private ArrayList<PrintingHouse> listOfPrintingHouses;
    private ArrayList<PrintOrder> listOfPrintOrders;

    public PrintingManagement() {
        this.listOfPrintingHouses = new ArrayList<>();
        this.listOfPrintOrders = new ArrayList<>();
        PrintingHouse printingHouse0 = new PrintingHouse(false);
        listOfPrintingHouses.add(printingHouse0);
        PrintingHouse printingHouse1 = new PrintingHouse(false);
        listOfPrintingHouses.add(printingHouse1);
        PrintingHouse printingHouse2 = new PrintingHouse(true);
        listOfPrintingHouses.add(printingHouse2);
    }



//    public void addPrintingHouse() {
//        PrintingHouse printingHouse;
//        for (int i = 0; i<3; i++) {
//            if (i == 2) {
//                printingHouse = new PrintingHouse(true);
//            }else  printingHouse = new PrintingHouse(false);
//            listOfPrintingHouses.add(printingHouse);
//        }
//    }

    public void addPrintOrder(PrintOrder order) {
        listOfPrintOrders.add(order);
    }

    public ArrayList<PrintingHouse> getListOfPrintingHouses() {
        return listOfPrintingHouses;
    }

    public ArrayList<PrintOrder> getListOfPrintOrders() {
        return listOfPrintOrders;
    }
}

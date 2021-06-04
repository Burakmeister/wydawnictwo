package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class PrintingManagement implements Serializable{
    private ArrayList<PrintingHouse> listOfPrintingHouses;

    public PrintingManagement() {
        this.listOfPrintingHouses = new ArrayList<PrintingHouse>();
    }

    public void addPrintingHouse(PrintingHouse printingHouse) {
        listOfPrintingHouses.add(printingHouse);
    }

    public PrintOrder prepareReprint(ReprintOrder reprintOrder) {
        PrintOrder printOrder = new PrintOrder();
        printOrder.setCount(reprintOrder.getCount());
        Random generator = new Random();
        printOrder.setLiteraryItem(reprintOrder.getLiteraryItem());
        if (reprintOrder.getLiteraryItem() instanceof Book && ((Book) reprintOrder.getLiteraryItem()).isAlbum()) {
            printOrder.setPrintingHouseId(2);
        }else printOrder.setPrintingHouseId(generator.nextInt(1));
        return printOrder;
    }
}

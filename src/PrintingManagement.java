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
    }

    public void addPrintingHouse() {
        PrintingHouse printingHouse;
        for (int i = 0; i<3; i++) {
            if (i == 2) {
                printingHouse = new PrintingHouse(true, i);
            }else  printingHouse = new PrintingHouse(false, i);
            listOfPrintingHouses.add(printingHouse);
        }
    }

    public void addPrintOrder(PrintOrder order) {
        listOfPrintOrders.add(order);
    }

    public ArrayList<PrintingHouse> getListOfPrintingHouses() {
        return listOfPrintingHouses;
    }

    public ArrayList<PrintOrder> getListOfPrintOrders() {
        return listOfPrintOrders;
    }

    public PrintOrder prepareReprint(PrintOrder reprintOrder) {
//        PrintOrder printOrder = new PrintOrder();
//        reprintOrder.setCount(reprintOrder.getCount());
        Random generator = new Random();
        reprintOrder.setLiteraryItem(reprintOrder.getLiteraryItem());
        if (reprintOrder.getLiteraryItem() instanceof Book) {
            reprintOrder.setPrintingHouseId(2);
        }else reprintOrder.setPrintingHouseId(generator.nextInt(1));
        return reprintOrder;
    }
}

//reprintOrder.getLiteraryItem() instanceof Book && ((Book) reprintOrder.getLiteraryItem()).isAlbum()
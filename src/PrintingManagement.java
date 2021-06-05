package src;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
=======
package src;

import java.util.List;
>>>>>>> 13ac8906c945652e5c79aea95aaa02a02c31c635

public class PrintingManagement implements Serializable {
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
//        if (reprintOrder.getLiteraryItem() instanceof Book) {
//            printOrder.setPrintingHouseId(2);
//        }else printOrder.setPrintingHouseId(generator.nextInt(1));
        return printOrder;
    }
}

//reprintOrder.getLiteraryItem() instanceof Book && ((Book) reprintOrder.getLiteraryItem()).isAlbum()
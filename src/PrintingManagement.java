import java.util.List;
import java.util.Random;

public class PrintingManagement {
    private List<PrintingHouse> listOfPrintingHouses;

    public PrintingManagement(List<PrintingHouse> listOfPrintingHouses) {
        this.listOfPrintingHouses = listOfPrintingHouses;
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

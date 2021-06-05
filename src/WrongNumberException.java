package src;

public class WrongNumberException extends Exception{
    private int number;

    public WrongNumberException(int number) {
        this.number=number;
    }

    @Override
    public String getMessage() {
        return "Nieprawidlowa liczba '"+number+"', liczba powinna byc całkowita i większa od 0";
    }
}

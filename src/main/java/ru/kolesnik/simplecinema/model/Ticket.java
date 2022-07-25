package ru.kolesnik.simplecinema.model;

public class Ticket {

    private final int row;
    private final int column;
    private final int price;
    private boolean available;

    public Ticket(int row, int column) {
        this.row = row;
        this.column = column;
        if (row <= 4) {
            price = 10;
        } else {
            price = 8;
        }
        available = true;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}

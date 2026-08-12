package com.ara.BookManager.model;

public record Car(String make,String model,String year,double price) {
    public Car{
        if(year.length()>4){
            throw new IllegalArgumentException("year length exceeds 4!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", make, model, year, price);
    }
}

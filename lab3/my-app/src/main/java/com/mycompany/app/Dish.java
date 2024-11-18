package com.mycompany.app;

public abstract class Dish 
{
    private String name;
    private double price;
    private int calories;
    private boolean veganFriendly;

    public Dish(String name, double price, int calories, boolean veganFriendly) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.veganFriendly = veganFriendly;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getCalories() 
    {
        return calories;
    }

    public boolean isVeganFriendly() 
    {
        return veganFriendly;
    }

    @Override
    public String toString() 
    {
        return String.format("%s: %.2f руб., %d калорий, Веган: %s", 
                name, price, calories, veganFriendly ? "Да" : "Нет");
    }
}

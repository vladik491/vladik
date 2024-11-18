package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class Menu 
{
    private List<Dish> dishes;

    public Menu() 
    {
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) 
    {
        dishes.add(dish);
    }

    public List<Dish> getDishes() 
    {
        return dishes;
    }

    public void printMenu() 
    {
        System.out.println("Полное меню:");
        dishes.forEach(System.out::println);
    }

    public void printVeganDishes() 
    {
        System.out.println("Vegan friendly блюда:");
        dishes.stream()
                .filter(Dish::isVeganFriendly)
                .forEach(System.out::println);
    }

    public void printAveragePriceForHighCalories() 
    {
        double average = dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .mapToDouble(Dish::getPrice)
                .average()
                .orElse(0.0);
        System.out.printf("Средняя стоимость блюд с калорийностью > 300: %.2f руб.%n", average);
    }
}

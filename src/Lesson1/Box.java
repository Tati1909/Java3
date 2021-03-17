package Lesson1;

import Lesson1.Fruits.Fruit;
import Lesson1.Fruits.SpecificFruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit & SpecificFruit> {

    private final List<T> fruitList;
    private double totalWeight;
    private int capacity;

    public Box(int capacity, T... fruits) {
        this.fruitList = new ArrayList<>(Arrays.asList(fruits));
        this.capacity = capacity;
    }

    public void addFruit(T fruit) {
        if (capacity - 1 > 0) {
            fruitList.add(fruit);
        }

    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public float getWeight() {
        float commonWeight = 0.0f;

        for (T fruit : fruitList) {
            commonWeight += fruit.getWeight();
        }
        return commonWeight;
    }

    public boolean weightCompare(Box<?> anotherBox){
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.01;
    }

    //перемещение из 1 коробки в другую
    public void transferFruitsToAntherBox(Box<T> anotherBox){
        if(anotherBox == this) return; //проверяем что коробка не та же самая

        int countSize = Math.min(fruitList.size(), anotherBox.capacity);

        List<T> fruits = fruitList.subList(0, countSize);
        anotherBox.fruitList.addAll(fruits);
        fruitList.removeAll(fruits);

        anotherBox.capacity -=countSize;
        capacity += countSize;

    }
}

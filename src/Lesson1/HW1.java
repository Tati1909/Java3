package Lesson1;

/*      1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        2. Написать метод, который преобразует массив в ArrayList;
        3. Большая задача:
        Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Для хранения фруктов внутри коробки можно использовать ArrayList;
        Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
        Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        Не забываем про метод добавления фрукта в коробку.
        */

import Lesson1.Fruits.Apple;
import Lesson1.Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW1 {
    public static void main(String[] args) {
        //1 задание
        List<Integer> list = List.of(3,7);
        change(list);

        //2 задание
        String[] array = {"1", "2", "3", "4"};
        List<String> arrayList = transform(array);
        System.out.println(arrayList);

        //3
       /* BoxArray<Float> orange = new BoxArray<>();
        BoxArray<Float> apple = new BoxArray<>();

        List<Float> orangeList = new ArrayList<>();
        for(float i=1.0f; i<=10; i++)
        {
            orangeList.add(i);
        }
        System.out.println("Список апельсинов: " + orangeList);

        List<Float> appleList = new ArrayList<>();
        for(float i=1.0f; i<=10; i++)
        {
            appleList.add(i);
        }
        System.out.println("Список яблок: " + appleList);

*/

        Box<Apple> appleBox1 = new Box<>(5,
                new Apple(),new Apple(), new Apple());
        Box<Apple> appleBox2 = new Box<>(2);

        System.out.println("В коробке 1 лежат " + appleBox1.getWeight() + " апельсина.");
        appleBox1.transferFruitsToAntherBox(appleBox2);
        System.out.println("Мы пересыпали апельсины из первой коробки во вторую пустую.");
        System.out.println("В коробке 1 остался " + appleBox1.getWeight() + " апельсин, т к он не влез.");
        System.out.println("В коробке 2 лежат " + appleBox2.getWeight() + " апельсина.");
    }

    public static void change(List<Integer> list){
        for (int i = list.size()-1; i>=0;i--){
            int value = list.get(i);
            System.out.println(value);
        }
    }

    public static <T> List<T> transform(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }


}

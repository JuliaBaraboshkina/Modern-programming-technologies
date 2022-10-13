package abstraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Cats:");
        Cat cat=new Cat();
        cat.move();
        cat.eat();
        cat.talk();
        cat.feed();
        cat.live();
        System.out.println("Crocodiles:");
        Crocodile crocodile=new Crocodile();
        crocodile.move();
        crocodile.eat();
        crocodile.talk();
        crocodile.feed();
        crocodile.live();

        System.out.println("Полиморфизм");
        Animal animal1=new Crocodile();
        Animal animal2=new Cat();
        Crocodile animal3=new Crocodile();
        Mammal animal4=new Cat();
        Reptile animal5 = new Crocodile();

        ArrayList<Animal> list=new ArrayList<>();
        list.add(animal1);
        list.add(animal2);
        list.add(animal3);
        list.add(animal4);
        list.add(animal5);
        for (Animal animal:list){
            animal.move();
        }

    }
}

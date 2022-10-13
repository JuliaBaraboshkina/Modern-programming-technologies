package abstraction;

public class Cat extends Mammal{
    @Override
    public void eat(){System.out.println("Cats eat fish");}
    @Override
    public void move(){System.out.println("Cats sleep");}
    @Override
    public void talk(){System.out.println("Cats meow");}
    @Override
    public void feed(){System.out.println("Cats feed children milk");}
}

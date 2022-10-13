package abstraction;

public class Crocodile extends Reptile{
    @Override
    public void eat(){System.out.println("Crocodiles eat meet");}
    @Override
    public void move(){System.out.println("Crocodiles swim");}
    @Override
    public void talk(){System.out.println("Crocodiles cry");}
    public void feed(){System.out.println("Crocodiles don't feed children");}
}

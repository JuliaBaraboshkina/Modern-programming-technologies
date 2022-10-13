package inheritance;

public class FirstChildClass extends ParentClass{
    public FirstChildClass(){System.out.println("This is child 1");}
    public void methodChild1(){protectedMethod();defualtMethod();}
    @Override
    public void publicMethod(){
        super.publicMethod();
        System.out.println("This is public method override in child class");}
}

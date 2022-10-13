package inheritance;
public class Main {
    public static void main(String[] args){
        System.out.println("Parent");
        ParentClass parent=new ParentClass();
        parent.publicMethod();
        parent.protectedMethod();
        //parent.privateMethod();
        parent.defualtMethod();
        System.out.println("Child 1");
        FirstChildClass child=new FirstChildClass();
        child.publicMethod();
        child.methodChild1();
        System.out.println("Child 2");
        SecondChildClass child2=new SecondChildClass();
        child2.protectedMethod();
        child2.publicMethod();
    }
}


package InheritanceandPolymorphism;

public class Animal {
    int id = 1000 ;
    void shout() {
        System.out.println("shout");
    }
    void shout(int a) {
        System.out.println(a);
    }
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    int id = 5000 ;
    void bark() {
        System.out.println("barking...");
    }
}

class Cat extends Animal {
    int id = 123456 ;

    void meow() {
        System.out.println("meowing...");
    }
    void eat() {
        System.out.println("eating fish");
    }
    void shout()
    {
        System.out.println("shoutttttttt");
    }
}

class Main {
    public static void main(String args[]) {
        Animal a = new Animal() ;
        a.shout(3);
        Cat b = new Cat() ;

        // upcasting
        System.out.println("Upcasting");

        Animal c = new Cat() ;

        System.out.println(c.id);

        c.eat();
        c.shout();



        Cat d = new Cat() ;
        Animal e = d;

        System.out.println(e.id);

        e.eat();
        e.shout();

        // downcasting
        System.out.println("Downcasting");
        /* Animal animal = new Animal();
        Cat cat = (Cat) animal;
        cat.meow();*/

        Animal animal2 = new Cat();
        Cat cat2 = (Cat) animal2;

        System.out.println(cat2.id);

        cat2.meow();
        cat2.eat();






        

    }
}
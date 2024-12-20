package design.patterns.singleton;

public class Singleton {

    private static Singleton instance;

    private void Singleton(){}

    static Singleton getInstance(){
        if(instance == null){
             synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }

        }
        return  instance;
    }

    public void doSomething(){
        System.out.println("Singleton Instance");
    }
}

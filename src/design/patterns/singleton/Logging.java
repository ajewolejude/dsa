package design.patterns.singleton;

public class Logging {
    private static Logging instance;

    private void Logging(){};

    static Logging getInstance(){

        if(instance == null){
            synchronized (Logging.class){
                if (instance == null){
                    instance = new Logging();
                }
            }
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Logging Singleton");
    }
}

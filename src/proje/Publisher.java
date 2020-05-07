package proje;


import java.util.ArrayList;
public class Publisher implements ISubject {


    private ArrayList<IObserver> subscribers ;
    private static Publisher nesne;

    private Publisher()
    {
        subscribers = new ArrayList<>();
    }

    public static synchronized Publisher getInstance(){
        if(nesne==null)
            nesne=new Publisher();
        return nesne;
    }

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyObservers() {
        for (IObserver subscriber : subscribers) {
            subscriber.update();
        }
    }
}

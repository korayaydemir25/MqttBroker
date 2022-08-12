package Initiater;

import HelloListener.HelloListener;

import java.util.ArrayList;
import java.util.List;

public class Initiater {
    String _name;
    public Initiater(String name) {
        this._name = name;
    }
    List<HelloListener> listeners = new ArrayList<>();

   public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }
    public void sayHello() {
        System.out.println("Hello! " + "-" + _name);
        for (HelloListener hl : listeners)
            hl.someoneSaidHello();
    }
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }
}

package Initiater2;

import HelloListener.HelloListener;

import java.util.ArrayList;
import java.util.List;

public class Initiater2   {
    String _name;

    public Initiater2(String name) {
        _name = name;
    }

    List<HelloListener> listeners = new ArrayList<HelloListener>();

    public void addListener (HelloListener toAdd) {
        listeners.add(toAdd);
    }
    public void sayName(){
        System.out.println("Koray  -" + _name );
        for (HelloListener hl : listeners)
            hl.someoneSaidHello();
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}

package Responder;

import HelloListener.HelloListener;

public class Responder implements HelloListener {
    String _name;

    public Responder(String name) {
       this._name = name;
    }

    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there ... " + "-" + _name);
    }

    public String getName() {
        return _name;
    }
}


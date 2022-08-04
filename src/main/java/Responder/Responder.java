package Responder;

import HelloListener.HelloListener;

public class Responder implements HelloListener {
    String _name;
    public Responder(String name) {
        _name = name;
    }
    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there ... " + "-" + _name );
    }
    public String getName() {
        return _name;
    }
    public void setName(String _name) {
        this._name = _name;
    }
}


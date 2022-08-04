package Responder2;

import HelloListener.HelloListener;

public class Responder2 implements HelloListener {
    String _name;
    public Responder2(String name){
        _name = name;
    }
    @Override
    public void someoneSaidHello() {
        System.out.println("Nice to meet you  -" + _name );
    }
    public String getName() {
        return _name;
    }
    public void setName(String _name) {
        this._name = _name;
    }
}

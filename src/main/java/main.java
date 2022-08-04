import Initiater.Initiater;
import Initiater2.Initiater2;
import Responder.Responder;
import Responder2.Responder2;

class main {
    public static void main(String[] args) {
        Initiater initiater = new Initiater("init1");
        Responder responder = new Responder( "resp1");
        Initiater2 initiater2 = new Initiater2("init2");
        Responder2 responder2 = new Responder2 ("resp2");

        initiater2.addListener(responder2);
        initiater.addListener(responder);

        initiater.sayHello();
        initiater2.sayName();


    }
}

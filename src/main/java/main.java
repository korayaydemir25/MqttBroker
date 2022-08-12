import Mqtt.MqttManager;
import Mqtt.MqttService;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import params.Params;

import java.util.Scanner;

class main {
    public static void main(String[] args) throws MqttException {

        Scanner scanner = new Scanner(System.in);
        String broker = Params.broker;
        String clientId = Params.clientId;
        String pubTopic = Params.pubTopic;
        MemoryPersistence persistence = new MemoryPersistence();
        int qos = 1;

        MqttService mqttService = new MqttManager(new MqttClient(broker, clientId, persistence), new MqttConnectOptions());
        mqttService.connect();
        while (true) {
            System.out.println("P : publish  S : subscribe");
            System.out.print("Select : ");
            String selector = scanner.nextLine();
            switch (selector) {
                case "P":
                    while (true) {
                        System.out.print("Key: ");
                        String key = scanner.nextLine();
                        if (key.equals("***")) {
                            break;
                        }
                        System.out.print("Value: ");
                        String value = scanner.nextLine();
                        if (value.equals("***")) {
                            break;
                        }
                        mqttService.publish(key, value, pubTopic, qos);
                    }
                    break;
                case "S":
                    mqttService.subscribe();
                    String outSubscribe = scanner.nextLine();
                    if (outSubscribe.equals("***")) {
                        break;
                    }
            }
            if (selector.equals("exit")){
                break;
            }
        }
            mqttService.disconnect();



        //------------------------------------------------------------------------------------------------------------------------------------
//        Initiater initiater1 = new Initiater("init1");
//        Initiater initiater2 = new Initiater("init2");
//        while (true) {
//            System.out.println("Enter The Responder Name");
//            String _name = scanner.next();
//            Responder responder = new Responder(_name);
//            if (_name.equals("***"))
//                break;
//            if (_name.contains("+"))
//                initiater1.addListener(responder);
//            else
//                initiater2.addListener(responder);
//            System.out.println("Responder add list");
//        }
//        initiater1.sayHello();
//        initiater2.sayHello();
//    }
    }
}

package Mqtt;

import org.eclipse.paho.client.mqttv3.*;
import params.Params;

public class MqttManager implements MqttService, MqttCallback {

    private final MqttClient mqttClient;
    private final MqttConnectOptions mqttConnectOptions;

    public MqttManager(MqttClient mqttClient, MqttConnectOptions mqttConnectOptions) {
        this.mqttClient = mqttClient;
        this.mqttConnectOptions = mqttConnectOptions;
    }

    @Override
    public void connect() {
        try{
            this.mqttConnectOptions.setUserName(this.mqttClient.getClientId());
            this.mqttConnectOptions.setCleanSession(true);
            System.out.println("Connecting to broker: "+this.mqttClient.getServerURI());
            this.mqttClient.connect(this.mqttConnectOptions);
            System.out.println("Connected to broker");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public void publish(String key, String value, String pubTopic, int qos) {
        try {
            String content = "{'" +  key + "' : '"+ value + "'}";
            System.out.println("Publishing message:"+content);
            MqttMessage mqttMessage = new MqttMessage(content.getBytes());
            mqttMessage.setQos(qos);
            this.mqttClient.publish(pubTopic,mqttMessage);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
@Override
    public void subscribe() {
        this.mqttClient.setCallback(this);
        try {
            mqttClient.subscribe(Params.subTopic,1);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void disconnect() {
        try {
            this.mqttClient.disconnect();
            this.mqttClient.close();
            System.exit(0);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message){
        System.out.println("Message: " + message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}

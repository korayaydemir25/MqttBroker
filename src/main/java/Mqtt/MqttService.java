package Mqtt;

public interface MqttService {
    void connect();
    void publish(String key, String value, String pubTopic, int qos);
    void subscribe();
    void disconnect();

}

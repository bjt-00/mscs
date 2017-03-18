package com.bitguiders.hadoop.mqtt;

public class MQTTClient{
  	static final String BROKER_URL = "tcp://test.mosquitto.org:1883";//"tcp://iot.eclipse.org:1883";
	static final String TOPIC = "bitguiders";
	static final String DEVICE = "webserver";
	static final String CLIENT_ID = "temperature";
	static final String USER_NAME = "ak";
	static final String PASSWORD = "pwd";



	public static void main(String[] args) {
		MQTTHandler mqttHandler = new MQTTHandler(BROKER_URL);
		
		mqttHandler.connect();
		mqttHandler.subscribe(TOPIC+"/" + DEVICE + "/" + CLIENT_ID);
		   		String message = " 46 c";
		   		mqttHandler.publish(TOPIC+"/" + DEVICE + "/" + CLIENT_ID,message);
		//mqttHandler.disconnect();
	}
}
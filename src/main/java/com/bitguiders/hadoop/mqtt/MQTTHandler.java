package com.bitguiders.hadoop.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class MQTTHandler{

  MqttClient mqttClient;
	MqttConnectOptions connectOptions;
	  	private String brokerUrl = "tcp://iot.eclipse.org:1883";
		private String device = "webserver";
		private String clientId = "temperature";
		private String userName = "ak";
		private String password = "pwd";

	// the following two flags control whether this example is a publisher, a subscriber or both
	private Boolean isSubscriber = false;
	private Boolean isPublisher = false;

	public MQTTHandler(String brokerUrl){
	  	this.brokerUrl = brokerUrl;
	}
	public MQTTHandler(String brokerUrl,String clientId){
	  	this.brokerUrl = brokerUrl;
		this.clientId = clientId;
	}
	public MQTTHandler(String brokerUrl,String userName,String password){
	  	this.brokerUrl = brokerUrl;
	  	this.userName = userName;
		this.password = password;
	}
	public MQTTHandler(String brokerUrl,String userName,String password,String clientId){
	  	this.brokerUrl = brokerUrl;
	  	this.userName = userName;
		this.password = password;
		this.clientId = clientId;
	}
	public MQTTHandler(String brokerUrl,String userName,String password,String clientId,String device){
	  	this.brokerUrl = brokerUrl;
	  	this.userName = userName;
		this.password = password;
	  	this.device = device;
		this.clientId = clientId;
	}

	public void subscribe(String topic){
		isSubscriber=true;
		// setup topic
		try {
			int subQoS = 0;
			mqttClient.subscribe(topic, subQoS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void publish(String topic,String message){
		isPublisher=true;
		MqttTopic mqttTopic = mqttClient.getTopic(topic);

   		int pubQoS = 0;
		MqttMessage mqttMessage = new MqttMessage(message.getBytes());
		mqttMessage.setQos(pubQoS);
		mqttMessage.setRetained(false);

    	// Publish the message
    	System.out.println("Publishing to topic \"" + mqttTopic + "\" qos " + pubQoS);
    	MqttDeliveryToken token = null;
    	try {
    		// publish message to broker
			token = mqttTopic.publish(mqttMessage);
	    	// Wait until the message has been delivered to the broker
			token.waitForCompletion();
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connect(){
		// setup MQTT Client
		connectOptions = new MqttConnectOptions();
		
		connectOptions.setCleanSession(false);
		connectOptions.setKeepAliveInterval(30);
		//connOpt.setUserName(M2MIO_USERNAME);
		//connOpt.setPassword(M2MIO_PASSWORD_MD5.toCharArray());
		
		// Connect to Broker
		try {
			mqttClient = new MqttClient(brokerUrl, clientId);
			mqttClient.setCallback(new MQTTListener());
			mqttClient.connect(connectOptions);
		} catch (MqttException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Connected to " + brokerUrl);

	}
	public void disconnect(){
		try {
			// wait to ensure subscribed messages are delivered
			if (isSubscriber) {
				Thread.sleep(5000);
			}
			mqttClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
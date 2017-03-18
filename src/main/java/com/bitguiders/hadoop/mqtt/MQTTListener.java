package com.bitguiders.hadoop.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQTTListener implements MqttCallback {

	@Override
	public void connectionLost(Throwable arg0) {
		System.out.println("Connection lost!");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("-------------------------------------------------");
		System.out.println("| MQTTListener>> Topic:" + topic);
		System.out.println("| MQTTListener>> Message: " + new String(message.getPayload()));
		System.out.println("-------------------------------------------------");
	}

}

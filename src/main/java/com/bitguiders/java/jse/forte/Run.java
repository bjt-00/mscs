package com.bitguiders.java.jse.forte;

import java.io.Serializable;

/*Forte inc , Interview questions
 * Can we create new Instance of AbstractClass..? No
 * Can we set private to abstract method..? No
 * What are the methods that we will implement for Serializable interface..? No
 * Can we implement more than one interfaces..? Yes 
 * Can we extend String class..? No its final you can't extend it
 */
public class Run extends AbstractClass implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClass c = new Run();
		c.abstractMethod();
		
		new FinalClass();
	}

	@Override
	public void abstractMethod() {
		// TODO Auto-generated method stub
	}

}

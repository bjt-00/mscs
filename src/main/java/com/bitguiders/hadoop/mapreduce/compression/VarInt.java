package com.bitguiders.hadoop.mapreduce.compression;

import java.util.ArrayList;
import java.util.List;

public class VarInt {
	public static int byteRequiredForInt(int n){
		int size = 1;
		if ((n >>> 28) != 0) size = 5;
		else if ((n >>> 21) != 0) size = 4;
		else if ((n >>> 14) != 0) size = 3;
		else if ((n >>> 7) != 0) size = 2;
		
		return size;
	}
	
	public static byte[] encodeInt(int n){
		int size = byteRequiredForInt(n);
	
		byte[] code = new byte[size];
		
		for (int i = 0; i < size; i++){
			code[i] = (byte) (n & 0x0000007F);
			n = n >>> 7;
		}
		byte mask = (byte) 0x80;
		code[0] = (byte) (code[0] | mask);
		
		return code;
	}
	
	public static int decodeInt(byte[] code){
		byte mask = (byte) 0x7F;
		code[0] = (byte) (code[0] & mask);
	
		int n = 0;		
		for (int i = code.length -1; i >= 0;  i--){
			n = n << 7;
			n =  ( n | code[i]);
		}
		return n;
	}
	
	public static Byte[] encode(int[] a){
		
		List<Byte> bytes = new ArrayList<Byte>();
		for(int i=0;i<a.length;i++){
			byte[] intBytes = encodeInt(a[i]);
			for(byte b:intBytes){
				bytes.add(intBytes[0]);
			}
		}
		return bytes.toArray(new Byte[bytes.size()]);
	}
	
	public static int[] decode(Byte[] code){
		
		int[] ints = new int[code.length];
			for(int i=0;i<code.length;i++){
				byte[] byt = {code[i]};
				ints[i] = decodeInt(byt);
			}
		return ints;
	}
	 
	public static String toStringByte(byte b){
		String str ="";
		for (int i = 0; i < 8; i++){
			str += (b < 0) ? "1" : "0";
			b = (byte) (b << 1);
		}
		return str;
	}
	
	public static void main(String[] args) {
		//127,128
		//1 1111111, 0 0000001 1 0000000
		int[] ints = {100, 8, 150, 7, 300, 24, 500, 36};
		//int[] ints = {127,128};
		Byte[] encoded = encode(ints);
		
		System.out.println("--ENCODING--");
		for(int i=0;i<ints.length;i++){
			System.out.println("");
			byte[] byt ={encoded[i]};
		  System.out.print("Encoded From int= "+ints[i]+" to ,byte= "+encoded[i]+" ,bits= "+ toStringByte(encoded[i])+ " ,bytesRequired= "+byteRequiredForInt(decodeInt(byt)) );
		}
		
		System.out.print("\n\n--DECODING--");
		ints = decode(encoded);
		for(int i=0;i<encoded.length;i++){
			System.out.println("");
			byte[] byt ={encoded[i]};
		  System.out.print("Decoded From byte= "+encoded[i]+" to ,int= "+ints[i]+" ,bits= "+ toStringByte(encoded[i])+ " ,bytesRequired= "+byteRequiredForInt(decodeInt(byt)) );
		}
	}
}

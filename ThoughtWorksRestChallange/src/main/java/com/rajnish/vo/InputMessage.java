package com.rajnish.vo;

public class InputMessage {
	
	private String encryptedMessage;
	 private int key;


	 // Getter Methods 

	 public String getEncryptedMessage() {
	  return encryptedMessage;
	 }

	 public int getKey() {
	  return key;
	 }

	 // Setter Methods 

	 public void setEncryptedMessage(String encryptedMessage) {
	  this.encryptedMessage = encryptedMessage;
	 }

	 public void setKey(int key) {
	  this.key = key;
	 }
	 
	 @Override
		public String toString() {
			return "Input [encryptedMessage=" + encryptedMessage + ", key=" + key
					+ "]";
		}
	 
	}

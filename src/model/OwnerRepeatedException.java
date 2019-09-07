package model;

@SuppressWarnings("serial")
public class OwnerRepeatedException extends Exception {
	//methods
	public OwnerRepeatedException(String n) {
		//adding the message
		super(n);
		}
}

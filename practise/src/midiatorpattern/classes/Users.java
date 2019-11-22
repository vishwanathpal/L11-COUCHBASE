package midiatorpattern.classes;

public class Users {
	
	private String name;

	public Users(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sendMessage(String message) {
		MidiatorChatRoom.showMessage(this,message);
	}
}

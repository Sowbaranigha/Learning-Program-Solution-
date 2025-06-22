package homeautomation;

public class Main {
    public static void main(String[] args) {
    	
    	// receiver
        Light livingRoomLight = new Light();

        //commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        //invoker
        RemoteControl remote = new RemoteControl();

        
       // turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

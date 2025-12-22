package opgave4_command.exercise1;

public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn =
                new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff =
                new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn =
                new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff =
                new LightOffCommand(kitchenLight);


        GarageDoorUpCommand garageDoorUp =
                new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown =
                new GarageDoorDownCommand(garageDoor);

        StereoOnCommand stereoOn =
                new StereoOnCommand(stereo);
        StereoOffCommand  stereoOff =
                new StereoOffCommand(stereo);

        Hottub hottub = new Hottub();
        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);
        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);

        remoteControl.setCommand(livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(stereoOn, stereoOff);
        remoteControl.setCommand(hottubOnCommand, hottubOffCommand);
        remoteControl.setCommand(garageDoorUp, garageDoorDown);
        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);

    }
}
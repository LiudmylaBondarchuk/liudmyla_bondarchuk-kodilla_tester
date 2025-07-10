package com.kodilla.inheritance.homework;

public class SystemApplication {
   public static void main(String[] args) {
       OperatingSystem operatingSystem = new OperatingSystem(2000);
       operatingSystem.turnOn();
       operatingSystem.turnOff();

       MacOSVentura macOSVentura = new MacOSVentura(2024);
       macOSVentura.turnOn();
       macOSVentura.turnOff();

       Windows10 windows10 = new Windows10(2019 );
       windows10.turnOn();
       windows10.turnOff();

    }
}

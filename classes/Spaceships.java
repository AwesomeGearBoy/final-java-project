package classes;

public class Spaceships {
    String shipName;
    int fuelCapacity; // In pounds
    int currentFuel;
    Astronauts[] astronauts;


public Spaceships(String shipName, int fuelCapcity, int currentFuel, Astronauts[] astronauts)   {
    this.shipName = shipName;
    this.fuelCapacity = fuelCapcity;
    this.currentFuel = currentFuel;
    this.astronauts = astronauts;
}
}

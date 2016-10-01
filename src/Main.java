import parkingClass.Parking;
import parkingClass.Voiture;
import sun.plugin2.util.SystemUtil;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        // instanciate a Car park
        Parking parking = new Parking(50,100);
        // instanciate a registration number
        long matricule = new Long(45555);
        // instanciate a car
        Voiture car = new Voiture(matricule);
        // give actual time
        long time = new Date().getTime();
        // push the fisrt car at the car park
        parking.pushCar(car, new Date(time));
        // fill our car park with a different cars
        for(int i=1; i<=120 ; i++) {
            matricule += 15;
            time+=1000000000;
            boolean result_push = parking.pushCar(car, new Date(time));
            if( !result_push ) {
                System.out.println("Le Parking est plein !!");
                break;
            }
        }

        // get a random car in this case car's with index 50
        car = parking.getCars().get(50);
        // pull the car from the car park
        parking.pullCar(car, new Date(time));
        // print the exit Ticket's
        System.out.println(parking.ExitTicket(car));
    }
}

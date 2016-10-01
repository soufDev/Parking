package parkingClass;


import java.util.Date;
import java.util.LinkedList;


public class Parking {
    // car park capacity
    private int capacity;

    //date ouverture et fermeture si on veux les prendre en compte
    private Date openDate;
    private Date closeDate;

    //liste pour les voitures
    private LinkedList<Voiture> cars;

    // prix par heure
    private int HourPrice;

    public Parking (int hourPrice, int capacity) {
        this.capacity = capacity;
        this.HourPrice = hourPrice;
        cars = new LinkedList<Voiture>();
    }

    // getters and setters
    public Date getCloseDate() {
        return closeDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHourPrice() {
        return HourPrice;
    }

    public LinkedList<Voiture> getCars() {
        return cars;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setHourPrice(int hourPrice) {
        HourPrice = hourPrice;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public void setCars(LinkedList<Voiture> cars) {
        this.cars = cars;
    }

    public boolean pushCar(Voiture car, Date DateEnter) {
        if (this.cars.size() == capacity) {
            return false;
        }else {
            car.setDateEnter(DateEnter);
            car.Enter();
            this.cars.add(car);
            return true;
        }
    }

    public boolean pullCar(Voiture car , Date DateExit) {
        int indexCar = this.carExist(this.cars, car);
        if( this.cars.isEmpty() ) {
            return false;
        }else if ( indexCar == -1) {
            return false;
        } else {
            car.setDateExit(DateExit);
            car.Exit();
            this.cars.remove(indexCar);
            return true;
        }
    }

    // car exsit in list of cars
    public int carExist(LinkedList<Voiture> cars, Voiture car) {
        for(int i=0 ; i<cars.size() ; i++) {
            if(cars.get(i).getRegistration_number() == car.getRegistration_number() ){
                return i;
            }
        }
        return -1;
    }

    public String EnterTicket(Voiture car) {
        return "*******************************\nBienvenue\nDate Entrée : "
                +car.getDateEnter()+"\nPrix Heure : "
                +this.HourPrice+"\nMerci !!\n"+
                "*******************************";
    }

    public String ExitTicket(Voiture car) {
        long millis = car.CountMillis();
        Double hours = car.CountHours(millis);
        return "*******************************\nMerci de Votre Visite\nDate Entrée : "
                +car.getDateEnter()+"\nDate Sortie : "+car.getDateExit()+
                "\nPrix Heure : "+this.HourPrice+
                "\nPrix à Payé : "+hours*this.HourPrice
                +"\nMerci !!\n"
                +"*********************************";
    }

}

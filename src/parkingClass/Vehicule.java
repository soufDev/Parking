package parkingClass;

import java.util.Date;

public class Vehicule {
    // Registration number
    protected long registration_number;
    // date d'entree et de sortie
    protected Date dateEnter;
    protected Date dateExit;

    // etat de la voiture
    protected byte state;

    // constructor
    public Vehicule (long registration_number) {
        this.registration_number = registration_number;
    }

    //getters and setters
    public void setDateEnter(Date dateEnter) {
        this.dateEnter = dateEnter;
    }

    public Date getDateEnter() {
        return dateEnter;
    }

    public void setDateExit(Date dateExit) {
        this.dateExit = dateExit;
    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public byte getState() {
        return state;
    }

    public void setRegistration_number(long registration_number) {
        this.registration_number = registration_number;
    }

    public long getRegistration_number() {
        return registration_number;
    }

    // set the state when the car enter=1 or exit=0
    public void Enter() {
        this.state = 1;
    }

    public void Exit() {
        this.state = 0;
    }

    // count how much miliseconds the car spend a the car park
    public long CountMillis () {
        if(dateEnter == null) {
            return -1;
        }else if(dateExit == null){
            return -1;
        }else {
            return dateExit.getTime() - dateEnter.getTime();
        }
    }

    public Double CountHours(long milliseonds) {
        return new Double( new Double(dateExit.getTime() - dateEnter.getTime()).doubleValue()  / (new Double(1000).doubleValue()*new Double(3600).doubleValue() ) );
    }
}

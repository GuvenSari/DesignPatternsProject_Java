// person who will be assigned by department for reservation quires
public class ReservationPerson {
    // since only one person can handle reservations that why singleton design pattern is used
    private static ReservationPerson obj;
    Reservations reservations;

    // method to get instance of reserved person
    public static ReservationPerson getReservedPerson(){
        if (obj == null){
            synchronized(ReservationPerson.class){
                if (obj == null){
                    obj = new ReservationPerson();//instance will be created at request time
                }
            }
        }
        return obj;
    }


    public ReservationPerson() {
        this.reservations = new Reservations();
    }

    // reserved person calling security person to unlock the room
    public void callUponSecurity(String name){
        Thread t1 = new Thread(new SecurityPersonal(), name);
        t1.start();
    }
}

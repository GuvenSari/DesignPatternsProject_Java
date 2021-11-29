import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// security class to unlock the room
// security person implementing runnable because in security class thread was used
class SecurityPersonal implements Runnable{
    @Override
    public void run() {
        System.out.println("Reservation person called security person '" + Thread.currentThread().getName() + "' to unlock the room");
        Security.releaseLock();
    }
}

public class Security {
    private static Security instance = null;
    private static final Lock lock = new ReentrantLock();

    private Security() { }

    public static Security releaseLock() {
        // security person releasing lock
        if (instance == null) {
            lock.lock();
            System.out.println("\n" + Thread.currentThread().getName() + " acquired lock of room");
            try {
                if (instance == null)
                    instance = new Security();
            } finally {
                lock.unlock();
                System.out.println("\n" + Thread.currentThread().getName() + " released lock of room");
                System.out.println("Now You can use the room");
            }
        }
        return instance;
    }
}

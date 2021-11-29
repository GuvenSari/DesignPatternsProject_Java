interface Visitor {
    public void Accept(ReservationFor student);
}

public class ReservationVisitor implements Visitor {
    @Override
    public void Accept(ReservationFor student) { }
}
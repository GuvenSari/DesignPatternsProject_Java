import java.util.ArrayList;

interface AbstractIterator {
    void First();
    void Next();
    Boolean IsDone () ;
    Equipment CurrentEquipment();
}

interface AbstractAggregate {
    public AbstractIterator CreateIterator();
    public void add(Equipment equipment); 		// No needed for iteration.
    public int getCount (); // Needed for iteration.
    public Equipment get(int index); // Needed for iteration.
    public ArrayList<Equipment> getEquipments(); // Needed for iteration.

}

class CollectionIterator implements AbstractIterator {
    protected EquipmentsCollection equipmentsCollection;
    private int current;

    public CollectionIterator(EquipmentsCollection equipmentsCollection) {
        this.equipmentsCollection = equipmentsCollection;
        current = 0;
    }

    @Override
    public void First() {
        current = 0;
    }

    @Override
    public void Next() {
        current++;
    }

    @Override
    public Boolean IsDone() {
        return current >= equipmentsCollection.getCount();
    }

    @Override
    public Equipment CurrentEquipment() {
        return (IsDone() ? null : equipmentsCollection.get(current));
    }
}



public class EquipmentsCollection implements AbstractAggregate {

    private ArrayList<Equipment> equipmentArrayList = new ArrayList<Equipment>();
    public CollectionIterator CreateIterator() {
        return new CollectionIterator(this);
    }

    @Override
    public int getCount() {
        return equipmentArrayList.size();
    }

    @Override
    public void add(Equipment equipment) {
        equipmentArrayList.add(equipment);
    }

    @Override
    public Equipment get(int index) {
        return equipmentArrayList.get(index);
    }

    @Override
    public ArrayList<Equipment> getEquipments() {
        return equipmentArrayList;
    }
}

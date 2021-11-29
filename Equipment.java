
public interface Equipment {
    void Add(Equipment e);
    void Remove(Equipment e);
    void Display();
    public String getName();
    public boolean isAvailable();
    public void setStatus(boolean status);
    public boolean getAvailable();
}
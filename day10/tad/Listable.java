
public interface Listable {

    boolean isEmpty();
    boolean isFull();

    int getValueAt(int index);

    void setValueAt(int index, int value);

    void addValue(int value);
    void addValueAt(int index, int value);

    void removeAt(int index);
    void removeValue(int value);

}

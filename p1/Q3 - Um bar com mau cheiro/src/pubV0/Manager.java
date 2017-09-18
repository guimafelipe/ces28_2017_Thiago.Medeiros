package pubV0;

public interface Manager {
    void setItems();
    void remItem(String name);
    Object getItem(String name);
    int getPrice(String name);
}

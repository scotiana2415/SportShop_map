public class Produkt {
    private String name;
    private float price;
    private Jahreszeit jahreszeit;

    public Produkt(String name, float price, Jahreszeit jahreszeit) {
        this.name = name;
        this.price = price;
        this.jahreszeit = jahreszeit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jahreszeit getJahreszeit() {
        return jahreszeit;
    }

    public void setJahreszeit(Jahreszeit jahreszeit) {
        this.jahreszeit = jahreszeit;
    }

}

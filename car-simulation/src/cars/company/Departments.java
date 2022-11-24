package cars.company;

public abstract class Departments implements Company{
    private int price;
    public Departments(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

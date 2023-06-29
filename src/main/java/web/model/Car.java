package web.model;

public class Car {
    String model;
    int series;
    String kind;
    public Car(){}

    public Car(String model, int series, String kind) {
        this.model = model;
        this.series = series;
        this.kind = kind;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", kind='" + kind + '\'' +
                '}';
    }
}

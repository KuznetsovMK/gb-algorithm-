package lesson5;

public class Subject {
    private int weight;
    private int cost;
    private String title;

    public Subject(int weight, int cost, String title) {
        this.weight = weight;
        this.cost = cost;
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "weight=" + weight +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                '}';
    }
}

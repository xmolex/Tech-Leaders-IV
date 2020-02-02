import java.util.Objects;

public class Manage {

    protected boolean isStart;
    protected String model;

    public Manage(String model) {
        this.isStart = false;
        this.model = model;
    }

    public boolean go() {
        isStart = !isStart;
        return isStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manage manage = (Manage) o;
        return Objects.equals(model, manage.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "Manage{" +
                "isStart=" + isStart +
                ", model='" + model + '\'' +
                '}';
    }
}

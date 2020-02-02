public class CarManage extends Manage {

    public CarManage(String model) {
        super(model);
    }

    @Override
    public String toString() {
        return "Я управляю машиной " + this.model + ", мы движемся: " + isStart;
    }
}

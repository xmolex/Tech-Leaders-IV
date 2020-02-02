public class BikeManage extends Manage {

    public BikeManage(String model) {
        super(model);
    }

    @Override
    public String toString() {
        return "Я управляю велосипедом " + this.model + ", мы движемся: " + isStart;
    }
}

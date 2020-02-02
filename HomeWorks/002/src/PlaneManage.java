public class PlaneManage extends Manage {

    private boolean isPilotOnBoad = false;

    public PlaneManage(String model) {
        super(model);
    }

    private boolean checkPilotOnBoad() {
        return isPilotOnBoad;
    }

    public boolean setPilotOnBoad(boolean booleanPilotOnBoad) {
        isPilotOnBoad = booleanPilotOnBoad;
        return true;
    }

    @Override
    public boolean go() {
        if ((!isStart && checkPilotOnBoad()) // можем начать движение, если стоим и пилот на борту
                || isStart // можем остановиться, если в движении, даже без пилота
        ) {
            isStart = !isStart;
            return isStart;
        }

        return isStart;
    }


    @Override
    public String toString() {
        return "Я управляю самолетом " + this.model + ", мы движемся: " + isStart + ", наличие пилота на борту: " + isPilotOnBoad;
    }
}

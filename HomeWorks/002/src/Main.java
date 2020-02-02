public class Main {

    public static void main(String[] args) {

        //demoEqualsAndHashCode();

        //demoIncapsulation();

        demoPrivateMethod();

    }

    private static void demoPrivateMethod() {
        PlaneManage managePlane1 = new PlaneManage("Boing 747");

        System.out.println("Исходное состояние самолета:");
        System.out.println(managePlane1.toString());

        System.out.println("Пытаемся начать движение:");
        managePlane1.go();
        System.out.println(managePlane1.toString());

        System.out.println("Помещаем пилота внутрь самолета и снова пытаемся начать движение:");
        managePlane1.setPilotOnBoad(true);
        managePlane1.go();
        System.out.println(managePlane1.toString());
    }

    private static void demoIncapsulation() {

        Manage manageCar1 = new CarManage("Acura RSX");
        Manage manageBike1 = new BikeManage("Merida X5");
        Manage managePlane1 = new PlaneManage("Boing 747");
        Manage[] ListManages = new Manage[3];

        ListManages[0] = manageCar1;
        ListManages[1] = manageBike1;
        ListManages[2] = managePlane1;

        System.out.println("Демонстрация полиморфизма:");

        for (int manageCounter = 0; manageCounter < ListManages.length; manageCounter++) {
            System.out.println(ListManages[manageCounter].toString());
        }

    }

    private static void demoEqualsAndHashCode() {
        Manage manageCar1 = new Manage("Acura RSX");
        Manage manageCar2 = new Manage("Acura RSX");
        Manage manageCar3 = new Manage("BMW 750i");

        System.out.println("Сравниваем по ==");
        System.out.println(manageCar1 == manageCar2);
        System.out.println("Сравниваем с помощью equals");
        System.out.println(manageCar1.equals(manageCar2));
        System.out.println("Хэш коды:");
        System.out.println(manageCar1.hashCode() + " " + manageCar2.hashCode() +
                " " + manageCar3.hashCode());
    }
}

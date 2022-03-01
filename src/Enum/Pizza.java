package Enum;

public class Pizza {
    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }
    public enum TestColor {
        GREEN;
    }

    public boolean isDeliverable() {
        if (this.status == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }
    public static void main(String[] args) {

        Pizza a = new Pizza() ;
        //a.setStatus(PizzaStatus.ORDERED);

        if (a.isDeliverable()) {
            System.out.println("da duoc giao ");
        } else {
            System.out.println("chua duoc giao");
        }

        Pizza testPz= new Pizza() ;
        testPz.setStatus(PizzaStatus.DELIVERED);

        if(testPz.getStatus().equals(Pizza.PizzaStatus.DELIVERED));

        if(testPz.getStatus() == Pizza.PizzaStatus.DELIVERED) {
            System.out.println("hop ly");
        }

        if(testPz.getStatus().equals(TestColor.GREEN)) {
            System.out.println(" vo ly ");
        }
        //if(testPz.getStatus() == TestColor.GREEN);
    }
}


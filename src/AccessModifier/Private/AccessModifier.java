package AccessModifier.Private;

public class AccessModifier {

    private int id = 1 ;

    private AccessModifier() {

    }

    private void shot() {
        System.out.println("bum bum");
    }

    public static void main(String[] args) {

        AccessModifier a = new AccessModifier() ;
        System.out.println(a.id);
        a.shot();
    }

}

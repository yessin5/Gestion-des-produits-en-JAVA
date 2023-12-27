import java.sql.SQLException;

public class Test {
    public static void main(String []args){
        Produit p1 = new Produit(123, "Sandwich", 5000);
        Produit p2 = new Produit("Pizza", 4500);
        Produit p3 = new Produit("Burger", 2300);
        String str1 = p1.toString();
        String str2 = p2.toString();
        String str3 = p3.toString();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        Traitement tr = new Traitement();
        try {
            tr.save(p1);
            tr.save(p2);
            tr.save(p3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

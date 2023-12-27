import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Traitement {
    Connection c = Connect.getConnection();
    public void save(Produit P) throws SQLException {
        PreparedStatement ps = c.prepareStatement("insert into Produits(nom_produit, prix) values(?,?)");
        ps.setString(1, P.getLibelle());
        ps.setDouble(2, P.getPrix());
        ps.executeUpdate();
    }

    ArrayList<Produit> search(String mc) throws SQLException {
        PreparedStatement ps = c.prepareStatement("select* from Produits where NOM_PRODUIT like ?");
        ps.setString(1, "%"+mc+"%");
        ResultSet res = ps.executeQuery();
        ArrayList<Produit> list = new ArrayList<>();
        while (res.next()){
            Produit P = new Produit();
            P.setId(res.getInt(1));
            P.setLibelle(res.getString(2));
            P.setPrix(res.getDouble(3));
            list.add(P);
        }
        return list;
    }

    public Produit getProduit(int id) throws SQLException {
        PreparedStatement ps = c.prepareStatement("select* from Produits where ID_PRODUIT = ? ");
        ps.setInt(1, id);
        ResultSet res = ps.executeQuery();
        Produit P = new Produit();
        P.setId(id);
        P.setPrix(res.getDouble(3));
        P.setLibelle(res.getString(2));
        return P;
    }

    public void UpdateProduit(Produit P) throws SQLException{
        PreparedStatement ps = c.prepareStatement("update Produits where ID_PRODUIT = ? set(?,?)");
        ps.setInt(1, P.getId());
        ps.setString(2, P.getLibelle());
        ps.setDouble(3, P.getPrix());
        ps.executeUpdate();
    }

    public void deleteProduit(int id) throws SQLException {
        PreparedStatement ps = c.prepareStatement("delete from Produits where ID_PRODUIT = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}


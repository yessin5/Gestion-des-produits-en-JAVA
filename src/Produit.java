public class Produit {
    private int id;
    private String libelle;
    private double prix;

    public Produit() {}
    public Produit(int id, String libelle, double prix){
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
    }

    public Produit(String libelle, double prix){
        this.libelle = libelle;
        this.prix = prix;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrix() {
        return prix;
    }
    public String toString(){
        return "ID="+id+" Liblle="+libelle+ " Prix=" +prix;
    }
}


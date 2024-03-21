package eval.mikolo.mikolo.model.laptop.stat;

import eval.mikolo.mikolo.model.Constante;

public class StatVenteTotalMois {
    int quantiteLaptop;
    int num_mois;
    String mois;
    int annee;

    public StatVenteTotalMois(int quantiteLaptop, int num_mois, int annee)
    throws Exception {
        this.setQuantiteLaptop(quantiteLaptop);
        this.setNum_mois(num_mois);
        this.setAnnee(annee);
    }
    public int getQuantiteLaptop() {
        return quantiteLaptop;
    }
    public void setQuantiteLaptop(int quantiteLaptop)
    throws Exception {
        if(quantiteLaptop<0) {
            throw new Exception("Veuillez entrer une quantite de laptop plus grande");
        }
        this.quantiteLaptop = quantiteLaptop;
    }
    public int getNum_mois() {
        return num_mois;
    }
    public void setNum_mois(int num_mois)
    throws Exception {
        if(num_mois<=0||num_mois>12) {
            throw new Exception("Veuillez entrer un numero de mois valide");
        }
        this.setMois(Constante.getListeMois()[num_mois-1]);
        this.num_mois = num_mois;
    }
    public String getMois() {
        return mois;
    }
    public void setMois(String mois)
    throws Exception {
        this.mois = mois;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
}

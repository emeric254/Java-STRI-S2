public class Traitre extends Samourai
{
    private String Seigneur;
    private float Traitrise;

    public Traitre(String pNom, int pArgent, String pBoisson, String pSeigneur)
    {
        super(pNom, pArgent, pBoisson, pSeigneur);
        Traitrise = 0;
    }

    public void direBonjour()
    {
        super.direBonjour();
        parler("En plus je suis à " + Traitrise + " d'escroquerie !");
    }

    public void faireLeGentil(Humain h, int don)
    {
        perdreArgent(don);
        parler("hé mec, voila " + don + " sous ! ami ?");
        h.gagnerArgent(don);
        Traitrise -= Traitrise/10;
    }
}

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
        Traitrise -= ( don/10 > Traitrise) ? 0 : don/10 ;
    }

    public void extorquer(Commercant c)
    {
        if(Traitrise<3)
        {
            gagnerArgent(c.seFaireExtorquer());
            parler("trahis ? xP");
            Traitrise +=1;
        }
        else
        {
            parler(" Je suis deja niveau " + Traitrise + ", impossible que je vole plus malheureusement ...");
        }
    }
}

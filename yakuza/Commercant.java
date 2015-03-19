public class Commercant extends Humain
{

    public Commercant(String pNom, int pArgent, String pBoisson)
    {
        super(pNom, pArgent, pBoisson);
        Boisson = "thé";
    }

    public int seFaireExtorquer()
    {
        int montant = getArgent();
        perdreArgent(montant);
        parler("Le monde est trop cruel !!!");
        return montant;
    }

    public void recevoir(int a)
    {
        gagnerArgent(a);
        parler("Je vous remercie !");
    }
}

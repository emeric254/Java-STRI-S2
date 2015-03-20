public class Commercant extends Humain
{

    public Commercant(String pNom, int pArgent)
    {
        super(pNom, pArgent, "thé");
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

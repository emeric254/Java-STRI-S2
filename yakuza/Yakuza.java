public class Yakuza extends Humain
{
    private String Clan;
    private int Reputation;

    public Yakuza()
    {
        this("");
    }

    public Yakuza(String nomClan)
    {
        super();
        Clan = nomClan;
        Reputation = 0;
    }

    public String getClan()
    {
        return new String(Clan);
    }

    public int getReputation()
    {
        return new Integer(Reputation);
    }

    public void extorquer(Commercant c)
    {
        gagnerArgent(c.seFaireExtorquer());
        Reputation += 1 ;
        parler("Bien ou bien le pauvre maintenant ?");
    }

    public void gagnerDuel()
    {
        Reputation += 1 ;
        parler("Victoire ! EZ win !");
    }

    public int perdreDuel()
    {
        int montant = getArgent();
        perdreArgent(montant);
        parler("J'ai perdu ...");
        return montant;
    }

}

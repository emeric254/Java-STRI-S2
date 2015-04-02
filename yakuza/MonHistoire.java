public class MonHistoire
{
    public static void main(String[] args)
    {
        Humain h = new Humain("Prof", 10, "Porto");
        h.direBonjour();
        h.boire();

        Commercant c = new Commercant("Marchant", 35);
        c.direBonjour();

        Yakuza y = new Yakuza("Yaku le noir", 4200, " biere ", "WarSong");
        y.extorquer(c);

        Ronin r = new Ronin("Roro", 61, "sake");
        r.donner(10,c);
        r.provoquer(y);
        r.direBonjour();


// merci robin pour cette histoire qui suit xP
        Traitre t= new Traitre ("Traitre",  300, "biere","seigneur blabla");
        t.direBonjour();
        t.extorquer(c);

        GrandMere g = new GrandMere("GranMa");
        g.faireConnaissanceAvec(t);
        g.faireConnaissanceAvec(r);
        g.faireConnaissanceAvec(y);
        g.faireConnaissanceAvec(c);

        g.ragoter();
        g.reunion();
        g.trier();
        System.out.println("tri...");
        g.reunion();
        g.sauvegarde();

        System.out.println("\n\nReset de «GrandMa»...\n");

        g = new GrandMere("GranMa");
        g.lecture();
        g.ragoter();
    }
}

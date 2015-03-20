public class MonHistoire
{
    public static void main(String[] args)
    {
        Humain h = new Humain("Prof", 10, "Porto");
        h.direBonjour();
        h.boire();
        Commercant c = new Commercant("Marchant", 35);
        c.direBonjour();
        Yakuza y = new Yakuza("Yaku le noir", 42, " biere ", "WarSong");
        y.extorquer(c);
        Ronin r = new Ronin("Roro", 61, "sake");
        r.donner(10,c);
        r.provoquer(y);
        r.direBonjour();
    }

}

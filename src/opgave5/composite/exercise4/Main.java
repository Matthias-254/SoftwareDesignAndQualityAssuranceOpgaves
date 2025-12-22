package opgave5.composite.exercise4;

public class Main {

    public static void main(String[] args) {
        Location root = new Location("root");

        Location belgie = new Location("België");
        root.add(belgie);

        Location brussel = new Location("Brussel");
        belgie.add(brussel);
        Location antwerpen = new Location("Antwerpen");
        belgie.add(antwerpen);

        Location anderlecht = new Location("DT, Anderlecht");
        brussel.add(anderlecht);
        anderlecht.add(new Picture("img10.jpg"));
        anderlecht.add(new Picture("img11.jpg"));

        Location zebra = new Location("Zebra, Sint-Goriks");
        brussel.add(zebra);
        zebra.add(new Picture("img12.jpg"));


        antwerpen.add(new Picture("img9.jpg"));
        antwerpen.add(new Picture("img8.jpg"));

        Location frankrijk = new Location("Frankrijk");
        root.add(frankrijk);
        Location paris = new Location("Parijs");
        frankrijk.add(paris);
        paris.add(new Picture("img7.jpg"));
        paris.add(new Picture("img2.jpg"));

        Location spanje = new Location("Spanje");
        root.add(spanje);
        spanje.add(new Picture("img2.jpg"));
        spanje.add(new Picture("img1.jpg"));

        System.out.println(root.getName());
        System.out.println("├── " + belgie.getName());
        System.out.println("│   ├── " + brussel.getName());
        System.out.println("│   │   ├── " + anderlecht.getName());
        System.out.println("│   │   │   ├── " + anderlecht.getChild(0).getName());
        System.out.println("│   │   │   └── " + anderlecht.getChild(1).getName());
        System.out.println("│   │   └── " + zebra.getName());
        System.out.println("│   │       └── " + zebra.getChild(0).getName());
        System.out.println("│   └── " + antwerpen.getName());
        System.out.println("│       ├── " + antwerpen.getChild(0).getName());
        System.out.println("│       └── " + antwerpen.getChild(1).getName());
        System.out.println("├── " + frankrijk.getName());
        System.out.println("│   └── " + paris.getName());
        System.out.println("│       ├── " + paris.getChild(0).getName());
        System.out.println("│       └── " + paris.getChild(1).getName());
        System.out.println("└── " + spanje.getName());
        System.out.println("    ├── " + spanje.getChild(0).getName());
        System.out.println("    └── " + spanje.getChild(1).getName());

    }

}
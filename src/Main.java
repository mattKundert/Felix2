import java.util.Scanner;

class Parachutiste {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        final double G=9.81; //cste de gravité
        double v0 = 0;
        double t0=0;
        double t=0;
        double s= 2.0/masse;
        double q= Math.exp((-s*(t-t0)));
        double vitesse = (G/s)*(1-q)+ v0*q;
        double hauteur=h0;
        double accel=G-s*vitesse;

        boolean vS=false;
        boolean vM=false;
        boolean hP=false;
        boolean tP=false;



        while (hauteur>=0){
            System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);
            t++;
            q= Math.exp((-s*(t-t0)));
            vitesse = (G/s)*(1-q)+ v0*q;
            if (vitesse>343&&vS==false){
                System.out.println("## Felix depasse la vitesse du son");
                vS=true;
            }

            hauteur=h0-(G/s)*(t-t0)-((v0-(G/s))/s)*(1-q);
            if (hauteur<2500&&hP==false){
                System.out.println("## Felix ouvre son parachute");
                hP=true;
            }
            if (hauteur<2500&&tP==false){
                t0=t;
                v0=vitesse;
                h0=hauteur;
                s=25.0/masse;
                tP=true;
            }

            accel=G-s*vitesse;
            if (accel<0.5&&vM==false){
                System.out.println(" ## Felix a atteint sa vitesse maximale");
                vM=true;
            }

        }




        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
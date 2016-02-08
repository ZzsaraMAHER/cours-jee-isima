package fr.isima.exemple;

public class DisplayArguments {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Argument num 1 : " + args[0]);
        } else {
            System.err.println("Aucun argument fourni");
        }
    }

}

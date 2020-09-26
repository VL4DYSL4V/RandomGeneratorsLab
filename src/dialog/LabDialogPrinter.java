package dialog;

public final class LabDialogPrinter {

    public void printGreetings(){
        System.out.println("Hi! This is Vladislav's (From K-23) laboratory work.");
    }

    public void printManual(){
        System.out.println("Please, enter number from 1 to 10 (incl) to see diagrams for different pseudorandom generators." +
                algorithmTable() +
                "\n\tTo see all statistics, enter 'all'." +
                "\n\tTo reset all algorithms to default state, enter 'reset'" +
                "\n\tTo exit, enter stop");
    }

    public void askAboutCustomization(){
        System.out.println("Would you like to customize the algorithm? If so, enter '+', if not - enter '-'");
    }

    private String algorithmTable(){
        return "\n\tAlgorithms:" +
                "\n 1 - Linear congruent;" +
                "\n 2 - Quadratic congruent;" +
                "\n 3 - Fibonacci;" +
                "\n 4 - Inverse congruent;" +
                "\n 5 - Differ;" +
                "\n 6 - 3 sigma;" +
                "\n 7 - Polar;" +
                "\n 8 - Ratio;" +
                "\n 9 - Arens;" +
                "\n 10 - Logarithm;";
    }
}

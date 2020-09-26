package app;

import algorithm.LabRandom;
import customization.ConsoleDialogCustomizer;
import customization.Customizer;
import dialog.LabDialogPrinter;
import statistics.StatisticsGenerator;
import util.AlgorithmPacks;

import java.util.*;

public class Application {
    private final Map<Integer, LabRandom> labRandoms;
    private final LabDialogPrinter labDialogPrinter = new LabDialogPrinter();
    private final Customizer algorithmCustomizer;
    private final StatisticsGenerator statisticsGenerator;

    public Application(StatisticsGenerator statisticsGenerator) {
        this.statisticsGenerator = statisticsGenerator;
        this.labRandoms = AlgorithmPacks.standardAllRandomPack();
        this.algorithmCustomizer = new ConsoleDialogCustomizer(Collections.unmodifiableMap(labRandoms));
    }

    public void run() {
        labDialogPrinter.printGreetings();
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            labDialogPrinter.printManual();
            input = sc.next().toLowerCase().trim();
            if (input.matches("[1-9]|10")) {
                LabRandom labRandom = getRandom(input);
                labDialogPrinter.askAboutCustomization();
                input = sc.next().toLowerCase().trim();
                if ("+".equals(input)) {
                    algorithmCustomizer.customize(labRandom);
                }
                System.out.println(labRandom + "\n" + labRandom.getStatistics(statisticsGenerator));
            } else if ("all".equals(input)) {
                printAllStatistics();
            } else if ("reset".equals(input)) {
                reset();
            }
        } while (!"stop".equals(input));
    }

    private LabRandom getRandom(String input) {
        int key = Integer.parseInt(input) - 1;
        return labRandoms.get(key);
    }

    private void printAllStatistics() {
        labRandoms.forEach((number, random) -> {
            System.out.println(random);
            System.out.println(random.getStatistics(statisticsGenerator));
        });
    }

    private void reset() {
        labRandoms.values().forEach(LabRandom::setDefaultConfig);
    }
}

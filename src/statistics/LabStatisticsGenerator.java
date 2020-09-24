package statistics;

import algorithm.LabRandom;
import algorithm.anotherDistribution.AnotherLabRandom;
import algorithm.evenDistribution.EvenLabRandom;
import algorithm.normalDistribution.NormalLabRandom;
import data.Pair;

import java.math.BigDecimal;
import java.util.*;

public class LabStatisticsGenerator implements StatisticsGenerator {

    private final String header = "\tInterval\t\tFrequency\t\n";

    @Override
    public String getForEvenDistribution(EvenLabRandom random) {
        List<Pair<Double>> intervals = splitInterval(0, 1, 0.1);
        Map<Pair<Double>, Double> rows = rows(intervals, random);
        return getTable(rows);
    }

    @Override
    public String getForNormalDistribution(NormalLabRandom random) {
        List<Pair<Double>> intervals = splitInterval(-3, 3, 0.25);
        Map<Pair<Double>, Double> rows = rows(intervals, random);
        return getTable(rows);
    }

    @Override
    public String getForAnotherDistribution(AnotherLabRandom random) {
        List<Pair<Double>> intervals = splitInterval(0, 100, 4);
        Map<Pair<Double>, Double> rows = rows(intervals, random);
        return getTable(rows);
    }

    @Override
    public String getForAnyRandom(LabRandom labRandom, double leftIntervalBorder, double rightIntervalBorder, double step) {
        List<Pair<Double>> intervals = splitInterval(leftIntervalBorder, rightIntervalBorder, step);
        Map<Pair<Double>, Double> rows = rows(intervals, labRandom);
        return getTable(rows);
    }

    private String getTable(Map<Pair<Double>, Double> rows){
        StringBuilder sb = new StringBuilder(100);
        sb.append(header);
        rows.forEach((key, value) -> {
            sb.append("\t");
            sb.append("[").append(key.getFirst()).append(" - ").append(key.getSecond()).append("]");
            sb.append("\t\t");
            sb.append(value);
            sb.append("\n");
        });
        return sb.toString();
    }

    private Map<Pair<Double>, Double> rows(List<Pair<Double>> intervals, LabRandom labRandom) {
        Map<Pair<Double>, Double> rows = new LinkedHashMap<>();
        intervals.forEach((pair) -> rows.put(pair, 0.0));
        int generatingAmount = 10_000;
        for (int i = 0; i < generatingAmount; i++) {
            double rand = labRandom.getRandom();
            for (Pair<Double> key : rows.keySet()) {
                if ((Double.compare(key.getFirst(), rand) == -1 || Double.compare(key.getFirst(), rand) == 0)
                        && (Double.compare(rand, key.getSecond()) == -1 || Double.compare(rand, key.getSecond()) == 0)) {
                    rows.put(key, rows.get(key) + 1);
                    break;
                }
            }
        }
        rows.replaceAll((k, v) -> rows.get(k) / generatingAmount);
        return rows;
    }

    private List<Pair<Double>> splitInterval(double leftIntervalBorder, double rightIntervalBorder, double step) {
        if (leftIntervalBorder >= rightIntervalBorder) {
            throw new IllegalArgumentException();
        }
        List<Pair<Double>> out = new ArrayList<>();
        BigDecimal bdStep = new BigDecimal(step).setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal currRight = new BigDecimal(leftIntervalBorder).add(bdStep).setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal currleft = new BigDecimal(leftIntervalBorder).setScale(2, BigDecimal.ROUND_DOWN);
        while (currRight.doubleValue() < rightIntervalBorder) {
            out.add(new Pair<>(currleft.doubleValue(), currRight.doubleValue()));
            currleft = currRight;
            currRight = currRight.add(bdStep).setScale(2, BigDecimal.ROUND_DOWN);
        }
        out.add(new Pair<>(currleft.doubleValue(), currRight.doubleValue()));
        return out;
    }
}

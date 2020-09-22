package enums;

public enum AlgorithmConstants {
    A(16769023), C(1073676287), D(1354828), MOD(2147483647);
    private final int value;

    AlgorithmConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

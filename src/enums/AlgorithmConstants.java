package enums;

public enum AlgorithmConstants {
    A(16769023), C(1073676287), D(1354828), MAX_MOD(2147483647),
    MOD_FOR_INVERSE(1_048_576),MOD_2(9369319),MOD_3(126247697);
    private final int value;

    AlgorithmConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

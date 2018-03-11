package ua.kpi.cad.linguisticvar.domain.operator;

import ua.kpi.cad.linguisticvar.domain.FuzzySet;

import java.util.Arrays;

public class SlightlyOperator extends Operator {
    {
        this.PRIORITY = 3;
    }

    @Override
    public FuzzySet applyTo(FuzzySet... operands) {
        validate(operands);

        FuzzySet fuzzySet = operands[0];

        double[] values = Arrays.stream(fuzzySet.getMembershipFunctionValues())
                .map(val -> Math.pow(val, 0.5))
                .toArray();

        return new FuzzySet(values);
    }

    @Override
    protected void validate(FuzzySet... operands) throws IllegalArgumentException {
        if (operands.length != 1) {
            throw new IllegalArgumentException("Not operator could be applied only for single fuzzy set.");
        }
    }
}

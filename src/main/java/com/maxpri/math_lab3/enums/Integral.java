package com.maxpri.math_lab3.enums;

/**
 * @author max_pri
 */
public enum Integral {
    FIRST (new double[]{0, 0, 1, 0}) {
        @Override
        public String toString() {
            return "first";
        }
    },
    SECOND (new double[]{-16, 3, -5, 1}) {
        @Override
        public String toString() {
            return "second";
        }
    },
    THIRD (new double[]{-7, 6, -5, 4}) {
        @Override
        public String toString() {
            return "third";
        }
    },
    FOURTH (new double[]{-1, -1, 1, 1}) {
        @Override
        public String toString() {
            return "fourth";
        }
    };


    public final double[] coeffs;

    private Integral(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    @Override
    public String toString() {
        return this.toString();
    }
}

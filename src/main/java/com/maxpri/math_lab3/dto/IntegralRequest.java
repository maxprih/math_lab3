package com.maxpri.math_lab3.dto;

import com.maxpri.math_lab3.enums.Integral;
import com.maxpri.math_lab3.enums.SolveMethod;

/**
 * @author max_pri
 */
public class IntegralRequest {

    private Integral integral;

    private double a;

    private double b;

    private double epsilon;

    private SolveMethod method;

    public IntegralRequest() {
    }

    public Integral getIntegral() {
        return integral;
    }

    public void setIntegral(Integral integral) {
        this.integral = integral;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public SolveMethod getMethod() {
        return method;
    }

    public void setMethod(SolveMethod method) {
        this.method = method;
    }
}

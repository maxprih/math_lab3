package com.maxpri.math_lab3.service;

import com.maxpri.math_lab3.dto.IntegralRequest;
import com.maxpri.math_lab3.dto.IntegralResponse;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class SolveService {

    public IntegralResponse solve(IntegralRequest integralRequest) {
        IntegralResponse respone = new IntegralResponse();
        switch (integralRequest.getMethod().toString()) {
            case "simpsons" -> respone = simpsonMethod(integralRequest.getIntegral().getCoeffs(), integralRequest.getA(), integralRequest.getB(), integralRequest.getEpsilon());
            case "left_rectangles" -> respone = leftRectangleMethod(integralRequest.getIntegral().getCoeffs(), integralRequest.getA(), integralRequest.getB(), integralRequest.getEpsilon());
            case "right_rectangles" -> respone = rightRectangleMethod(integralRequest.getIntegral().getCoeffs(), integralRequest.getA(), integralRequest.getB(), integralRequest.getEpsilon());
            case "mid_rectangles" -> respone = midRectangleMethod(integralRequest.getIntegral().getCoeffs(), integralRequest.getA(), integralRequest.getB(), integralRequest.getEpsilon());
            case "trapezoidal" -> respone = trapezoidMethod(integralRequest.getIntegral().getCoeffs(), integralRequest.getA(), integralRequest.getB(), integralRequest.getEpsilon());
        }

        return respone;
    }

    public IntegralResponse simpsonMethod(double[] coeffs, double a, double b, double epsilon) {

        IntegralResponse response = new IntegralResponse();

        long sectors = 4L;

        double res, prevRes = 0;

        while (true) {
            StringBuilder logs = new StringBuilder();
            double odd = 0, even = 0;
            double step = (b - a) / sectors;
            double x = a + step;
            for (int i = 1; i < sectors; i++) {
                double y = calc(x, coeffs);
                if (i % 2 == 0) {
                    even += y;
                } else {
                    odd += y;
                }
                logs.append("X_").append(i).append(" = ").append(x);
                logs.append("\tY_").append(i).append(" = ").append(y).append("\n");
                x += step;
            }
            logs.append("n = ").append(sectors).append("\n");

            res = (calc(a, coeffs) + calc(b, coeffs) + 4 * odd + 2 * even) * step / 3;
            double error = Math.abs(res - prevRes);

            response.setAnswer(res);
            response.setError(error);
            response.setSectors(sectors);
            response.setLogs(logs.toString());

            if (prevRes != 0 && error <= epsilon) {
                break;
            }
            prevRes = res;
            sectors *= 2;
        }

        return response;
    }

    public IntegralResponse leftRectangleMethod(double[] coeffs, double a, double b, double epsilon) {

        IntegralResponse response = new IntegralResponse();

        long sectors = 4L;

        double prevRes = 0;

        while (true) {
            StringBuilder logs = new StringBuilder();
            double x = a;
            double step = (b - a) / sectors;
            double ans = 0;
            for (int i = 0; i < sectors; i++) {
                double y = calc(x, coeffs);
                ans += y;
                logs.append("X_").append(i).append(" = ").append(x);
                logs.append("\tY_").append(i).append(" = ").append(y).append("\n");
                x += step;
            }
            ans *= step;
            logs.append("n = ").append(sectors).append("\n");
            double error = Math.abs(ans - prevRes);

            response.setAnswer(ans);
            response.setError(error);
            response.setSectors(sectors);
            response.setLogs(logs.toString());

            if (prevRes != 0 && error <= epsilon) {
                break;
            }
            prevRes = ans;
            sectors *= 2;
        }

        return response;
    }

    public IntegralResponse rightRectangleMethod(double[] coeffs, double a, double b, double epsilon) {

        IntegralResponse response = new IntegralResponse();

        long sectors = 4L;

        double prevRes = 0;

        while (true) {
            StringBuilder logs = new StringBuilder();
            double x = a;
            double step = (b - a) / sectors;
            double ans = 0;
            for (int i = 0; i < sectors; i++) {
                double y = calc(x+step, coeffs);
                ans += y;
                logs.append("X_").append(i).append(" = ").append(x);
                logs.append("\tY_").append(i).append(" = ").append(y).append("\n");
                x += step;
            }
            ans *= step;
            logs.append("n = ").append(sectors).append("\n");
            double error = Math.abs(ans - prevRes);

            response.setAnswer(ans);
            response.setError(error);
            response.setSectors(sectors);
            response.setLogs(logs.toString());

            if (prevRes != 0 && error <= epsilon) {
                break;
            }
            prevRes = ans;
            sectors *= 2;
        }

        return response;
    }

    public IntegralResponse midRectangleMethod(double[] coeffs, double a, double b, double epsilon) {

        IntegralResponse response = new IntegralResponse();

        long sectors = 4L;

        double prevRes = 0;

        while (true) {
            StringBuilder logs = new StringBuilder();
            double x = a;
            double step = (b - a) / sectors;
            double ans = 0;
            for (int i = 0; i < sectors; i++) {
                double y = calc(x + (step / 2), coeffs);
                ans += y;
                logs.append("X_").append(i).append(" = ").append(x);
                logs.append("\tY_").append(i).append(" = ").append(y).append("\n");
                x += step;
            }
            ans *= step;
            logs.append("n = ").append(sectors).append("\n");
            double error = Math.abs(ans - prevRes);

            response.setAnswer(ans);
            response.setError(error);
            response.setSectors(sectors);
            response.setLogs(logs.toString());

            if (prevRes != 0 && error <= epsilon) {
                break;
            }
            prevRes = ans;
            sectors *= 2;
        }

        return response;
    }

    public IntegralResponse trapezoidMethod(double[] coeffs, double a, double b, double epsilon) {

        IntegralResponse response = new IntegralResponse();

        long sectors = 4L;

        double prevRes = 0;

        while (true) {
            StringBuilder logs = new StringBuilder();
            double x = a;
            double step = (b - a) / sectors;
            double ans = 0;
            for (int i = 0; i < sectors; i++) {
                double y = calc(x, coeffs);
                ans += y;
                logs.append("X_").append(i).append(" = ").append(x);
                logs.append("\tY_").append(i).append(" = ").append(y).append("\n");
                x += step;
            }
            ans += (calc(a, coeffs) + calc(b, coeffs)) / 2;
            ans *= step;
            logs.append("n = ").append(sectors).append("\n");
            double error = Math.abs(ans - prevRes);

            response.setAnswer(ans);
            response.setError(error);
            response.setSectors(sectors);
            response.setLogs(logs.toString());

            if (prevRes != 0 && error <= epsilon) {
                break;
            }
            prevRes = ans;
            sectors *= 2;
        }

        return response;
    }

    private static double calc(double x, double[] eq) {
        double ans = 0;
        for (int i = 0; i < eq.length; i++) {
            ans += eq[i] * Math.pow(x, i);
        }
        return ans;
    }
}

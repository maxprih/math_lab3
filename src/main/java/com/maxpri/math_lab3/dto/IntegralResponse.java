package com.maxpri.math_lab3.dto;

import java.util.List;

/**
 * @author max_pri
 */
public class IntegralResponse {

    private double answer;

    private double error;

    private double sectors;

    private String logs;

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getSectors() {
        return sectors;
    }

    public void setSectors(double sectors) {
        this.sectors = sectors;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
}

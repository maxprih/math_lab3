package com.maxpri.math_lab3.enums;

/**
 * @author max_pri
 */
public enum SolveMethod {
    LEFT_RECTANGLES_METHOD {
        @Override
        public String toString() {
            return "left_rectangles";
        }
    },
    MID_RECTANGLES_METHOD {
        @Override
        public String toString() {
            return "mid_rectangles";
        }
    },
    RIGHT_RECTANGLES_METHOD {
        @Override
        public String toString() {
            return "right_rectangles";
        }
    },
    SIMPSONS_METHOD {
        @Override
        public String toString() {
            return "simpsons";
        }
    },
    TRAPEZOIDAL_METHOD {
        @Override
        public String toString() {
            return "trapezoidal";
        }
    };


}

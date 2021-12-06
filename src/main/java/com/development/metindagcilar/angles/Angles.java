package com.development.metindagcilar.angles;

public class Angles {

    public String angles(String angles) {
        char[] chars = angles.toCharArray();

        int leftAngle = 0;
        int rightAngle = 0;
        for (char c : chars) {
            if (c == '>' && rightAngle > 0) {
                rightAngle--;
            } else if (c == '>') {
                leftAngle++;
            } else if (c == '<' && rightAngle >= 0) {
                rightAngle++;
            } else if (c == '<') {
                rightAngle++;
                leftAngle--;
            }
        }
        StringBuilder leftAngles = new StringBuilder();
        for (int i = 0; i < leftAngle; i++) {
            leftAngles.append("<");
        }
        leftAngles.append(angles);
        for (int i = 0; i < rightAngle; i++) {
            leftAngles.append(">");
        }
        return leftAngles.toString();

    }
}

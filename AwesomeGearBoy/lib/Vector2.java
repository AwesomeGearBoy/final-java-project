package AwesomeGearBoy.lib;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private static Vector2 _zero = new Vector2(0f, 0f);
    private static Vector2 _one = new Vector2(1f, 1f);
    private static Vector2 _inf = new Vector2(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static Vector2 _up = new Vector2(0.0f, -1.0f);
    private static Vector2 _down = new Vector2(0.0f, 1.0f);
    private static Vector2 _right = new Vector2(1.0f, 0.0f);
    private static Vector2 _left = new Vector2(-1.0f, 0.0f);

    public float get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new IndexOutOfBoundsException("Index must be 0 or 1.");
        };
    }

    public void set(int index, float value) {
        switch (index) {
            case 0 -> x = value;
            case 1 -> y = value;
            default -> throw new IndexOutOfBoundsException("Index must be 0 or 1.");
        }
    }

    public static Vector2 zero = _zero;
    public static Vector2 one = _one;
    public static Vector2 inf = _inf;
    public static Vector2 up = _up;
    public static Vector2 down = _down;
    public static Vector2 right = _right;
    public static Vector2 left = _left;

    public void deconstruct(float X, float Y) {
        X = x;
        Y = y;
    }

    public void normalize() {
        float num = lengthSquared();
        if (num == 0.0f) {
            x = (y = 0f);
            return;
        }

        double doubNum = (double)num;
        double doubNum2 = Math.sqrt(doubNum);
        float num2 = (float)doubNum2;

        x /= num2;
        y /= num2;
    }

    public Vector2 abs() {
        return new Vector2(Math.abs(x), Math.abs(y));
    }

    public float angle(Vector2 to) {
        double X = (double)to.x;
        double Y = (double)to.y;
        double result = Math.atan2(X, Y);
        float result2 = (float)result;
        return result2;
    }

    public float angleTo(Vector2 to) {
        double result = Math.atan2(cross(to), dot(to));
        float result2 = (float)result;
        return result2;
    }

    public float angleToPoint(Vector2 to) {
        double result = Math.atan2(to.y - y, to.x - x);
        float result2 = (float)result;
        return result2;
    }

    public float aspect() {
        return x / y;
    }

    public Vector2 ceil() {
        double ceiledX = Math.ceil(x);
        double ceiledY = Math.ceil(y);
        float X = (float)ceiledX;
        float Y = (float)ceiledY;
        return new Vector2(X, Y);
    }

    public Vector2 clamp(Vector2 min, Vector2 max) {
        double clampedX = Math.clamp(x, min.x, max.x);
        double clampedY = Math.clamp(y, min.y, max.y);
        float X = (float)clampedX;
        float Y = (float)clampedY;
        return new Vector2(X, Y);
    }

    public Vector2 clamp(float min, float max) {
        double clampedX = Math.clamp(x, min, max);
        double clampedY = Math.clamp(y, min, max);
        float X = (float)clampedX;
        float Y = (float)clampedY;
        return new Vector2(X, Y);
    }

    public float cross(Vector2 with) {
        return x * with.y - y * with.x;
    }

    public Vector2 directionTo(Vector2 to) {
        return new Vector2(to.x - x, to.y - y).normalized();
    }

    public float distanceSquaredTo(Vector2 to) {
        return (x - to.x) * (x - to.x) + (y - to.y) * (y - to.y);
    }

    public float distanceTo(Vector2 to) {
        double result = Math.sqrt((x - to.x) * (x - to.x) + (y - to.y) * (y - to.y));
        float result2 = (float)result;
        return result2;
    }

    public float dot(Vector2 with) {
        return x * with.x + y * with.y;
    }

    public Vector2 floor() {
        double resultX = Math.floor(x);
        double resultY = Math.floor(y);
        Vector2 result = new Vector2((float)resultY, (float)resultX);
        return result;
    }

    public Vector2 inverse() {
        return new Vector2(1.0f / x, 1.0f / y);
    }

    public boolean isNormalized() {
        return Math.abs(lengthSquared() - 1f) < 1E-06f;
    }

    public float length() {
        double result = Math.sqrt(x * x + y * y);
        float result2 = (float)result;
        return result2;
    }

    public float lengthSquared() {
        return x * x + y * y;
    }

    public Vector2 normalized() {
        Vector2 result = this;
        result.normalize();
        return result;
    }

    public String toString() {
        return x + ", " + y;
    }
}

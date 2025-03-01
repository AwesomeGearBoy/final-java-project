package AwesomeGearBoy.lib;

// TODO: Add descriptions and documentation to all methods, along with the class.
// Can literally be copied and pasted.

/**
 * <p>2-element structure that can be used to represent positions in 2D space or any other pair of numeric values.
 * <p> 
 * <p> 
 * <p>The code for this class in particular is not entirely my own, this classes code is taken and translated from 
 * Godot's C# class, Vector2.cs. Literally all processes in this class were ripped straight from there, but this class 
 * provides a very good way to represent a xy plane, as well as hold two values, x and y.
 */
public final class Vector2 {
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

    public static Vector2 ZERO = _zero;
    public static Vector2 ONE = _one;
    public static Vector2 INF = _inf;
    public static Vector2 UP = _up;
    public static Vector2 DOWN = _down;
    public static Vector2 RIGHT = _right;
    public static Vector2 LEFT = _left;

    /**
     * <p>Helper method for deconstruction into a tuple.
     * @return Deconstructed Vector2 as a float[]
     */
    public float[] deconstruct() {
        return new float[]{x, y};
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

    /**
     * Returns a new vector with all components in absolute values (i.e. positive).
     * @return A vector with Math.abs() called on each component.
     */
    public Vector2 abs() {
        return new Vector2(Math.abs(x), Math.abs(y));
    }

    /**
     * Returns this vector's angle with respect to the X axis, or (1, 0) vector, in radians. 
     * Equivalent to the result of Godot.Mathf.Atan2(System.Single,System.Single) when called 
     * with the vector's Godot.Vector2.Y and Godot.Vector2.X as parameters: Mathf.Atan2(v.Y, v.X).
     * @return The angle of this vector, in radians.
     */
    public float angle() {
        double result = Math.atan2(y, x);
        float result2 = (float)result;
        return result2;
    }

    /**
     * Returns the angle to the given vector, in radians.
     * @param to The other vector to compare this vector to.
     * @return The angle between the two vectors, in radians.
     */
    public float angleTo(Vector2 to) {
        double result = Math.atan2(dot(to), cross(to));
        float result2 = (float)result;
        return result2;
    }

    /**
     * Returns the angle between the line connecting the two points and the X axis, 
     * in radians.
     * @param to The other vector to compare this vector to.
     * @return The angle between the two vectors, in radians.
     */
    public float angleToPoint(Vector2 to) {
        double result = Math.atan2(to.y - y, to.x - x);
        float result2 = (float)result;
        return result2;
    }

    /**
     * Returns the aspect ratio of this vector, the ratio of AwesomeGearBoy.lib.Vector2.x to AwesomeGearBoy.lib.Vector2.y.
     * @return The AwesomeGearBoy.lib.Vector2.x component divided by the AwesomeGearBoy.lib.Vector2.y component.
     */
    public float aspect() {
        return x / y;
    }

    /**
     * Returns the vector "bounced off" from a plane defined by the given normal.
     * @param normal The normal vector defining the plane to bounce off. Must be normalized.
     * @return The bounced vector.
     */
    public Vector2 bounce(Vector2 normal) {
        Vector2 result = reflect(normal);
        float resultX = -result.x;
        float resultY = -result.y;
        return new Vector2(resultX, resultY);
    }

    /**
     * Returns a new vector with all components rounded up (towards positive infinity).
     * @return A vector with Math.ceil() called on each component.
     */
    public Vector2 ceil() {
        double ceiledX = Math.ceil(x);
        double ceiledY = Math.ceil(y);
        float X = (float)ceiledX;
        float Y = (float)ceiledY;
        return new Vector2(X, Y);
    }

    /**
     * Returns a new vector with all components clamped between the components of min 
     * and max using AwesomeGearBoy.lib.Vector2.clamp().
     * @param min The vector with minimum allowed values.
     * @param max The vector with maximum allowed values.
     * @return The vector with all components clamped.
     */
    public Vector2 clamp(Vector2 min, Vector2 max) {
        double clampedX = clamp(x, min.x, max.x);
        double clampedY = clamp(y, min.y, max.y);
        float X = (float)clampedX;
        float Y = (float)clampedY;
        return new Vector2(X, Y);
    }

    /**
     * Returns a new vector with all components clamped between the components of min 
     * and max using AwesomeGearBoy.lib.Vector2.clamp().
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The vector with all components clamped.
     */
    public Vector2 clamp(float min, float max) {
        double clampedX = clamp(x, min, max);
        double clampedY = clamp(y, min, max);
        float X = (float)clampedX;
        float Y = (float)clampedY;
        return new Vector2(X, Y);
    }

    private static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Returns the cross product of this vector and with.
     * @param with The other vector.
     * @return The cross product value.
     */
    public float cross(Vector2 with) {
        return x * with.y - y * with.x;
    }

    /**
     * Performs a cubic interpolation between vectors preA, this vector, b, and postB, 
     * by the given amount weight.
     * @param b The destination vector.
     * @param preA A vector before this vector.
     * @param postB A vector after b.
     * @param weight A value on the range of 0.0 to 1.0, representing the amount of interpolation.
     * @return The interpolated vector.
     */
    public Vector2 cubicInterpolate(Vector2 b, Vector2 preA, Vector2 postB, float weight) {
        return new Vector2(
            cubicInterpolate(this.x, b.x, preA.x, postB.x, weight),
            cubicInterpolate(this.y, b.y, preA.y, postB.y, weight)
        );
    }
    
    private static float cubicInterpolate(float a, float b, float preA, float postB, float weight) {
        float p = (postB - b) - (preA - a);
        float q = (preA - a) - p;
        float r = b - preA;
        float s = a;
        
        return p * weight * weight * weight + q * weight * weight + r * weight + s;
    }

    /**
     * Performs a cubic interpolation between vectors preA, this vector, b, and postB, 
     * by the given amount weight. It can perform smoother interpolation than AwesomeGearBoy.lib.Vector2.cubicInterpolate() 
     * by the time values.
     * @param b The destination vector.
     * @param preA A vector before this vector.
     * @param postB A vector after b.
     * @param weight A value on the range of 0.0 to 1.0, representing the amount of interpolation.
     * @param t
     * @param preAT
     * @param postBT
     * @return The interpolated vector.
     */
    public Vector2 cubicInterpolateInTime(Vector2 b, Vector2 preA, Vector2 postB, float weight, float t, float preAT, float postBT) {
        return new Vector2(cubicInterpolateInTime(this.x, b.x, preA.x, postB.x, weight, t, preAT, postBT), cubicInterpolateInTime(this.y, b.y, preA.y, postB.y, weight, t, preAT, postBT));
    }
    
    private static float cubicInterpolateInTime(float a, float b, float preA, float postB, float weight, float t, float preAT, float postBT) {
        float t2 = t * t;
        float t3 = t2 * t;
    
        float p0 = preA;
        float p1 = a;
        float p2 = b;
        float p3 = postB;
    
        float t0 = preAT;
        float t1 = 0;
        float t2Val = t;
        float t3Val = postBT;
    
        float a1 = (t2Val - t) / (t2Val - t0);
        float a2 = (t - t0) / (t2Val - t0);
        float a3 = (t3Val - t) / (t3Val - t1);
        float a4 = (t - t1) / (t3Val - t1);
    
        float m1 = a1 * (p1 - p0) + a2 * (p2 - p1);
        float m2 = a3 * (p2 - p1) + a4 * (p3 - p2);
    
        float h1 = 2 * t3 - 3 * t2 + 1;
        float h2 = -2 * t3 + 3 * t2;
        float h3 = t3 - 2 * t2 + t;
        float h4 = t3 - t2;
    
        return h1 * p1 + h2 * p2 + h3 * m1 + h4 * m2;
    }

    /**
     * Returns the point at the given t on a one-dimensional Bezier curve defined by 
     * this vector and the given control1, control2, and end points.
     * @param control1 Control point that defines the bezier curve.
     * @param control2 Control point that defines the bezier curve.
     * @param end The destination vector.
     * @param t A value on the range of 0.0 to 1.0, representing the amount of interpolation.
     * @return The interpolated vector.
     */
    public Vector2 bezierInterpolate(Vector2 control1, Vector2 control2, Vector2 end, float t) {
        return new Vector2(bezierInterpolate(this.x, control1.x, control2.x, end.x, t), bezierInterpolate(this.y, control1.y, control2.y, end.y, t));
    }
    
    private static float bezierInterpolate(float start, float control1, float control2, float end, float t) {
        float u = 1 - t;
        float tt = t * t;
        float uu = u * u;
        float uuu = uu * u;
        float ttt = tt * t;
    
        return (uuu * start) + (3 * uu * t * control1) + (3 * u * tt * control2) + (ttt * end);
    }

    /**
     * Returns the derivative at the given t on the Bezier curve defined by this vector 
     * and the given control1, control2, and end points.
     * @param control1 Control point that defines the bezier curve.
     * @param control2 Control point that defines the bezier curve.
     * @param end The destination value for the interpolation.
     * @param t A value on the range of 0.0 to 1.0, representing the amount of interpolation.
     * @return The resulting value of the interpolation.
     */
    public Vector2 bezierDerivative(Vector2 control1, Vector2 control2, Vector2 end, float t) {
        return new Vector2(bezierDerivative(this.x, control1.x, control2.x, end.x, t), bezierDerivative(this.y, control1.y, control2.y, end.y, t));
    }
    
    private static float bezierDerivative(float start, float control1, float control2, float end, float t) {
        float u = 1 - t;
        return (3 * u * u * (control1 - start)) + (6 * u * t * (control2 - control1)) + (3 * t * t * (end - control2));
    }

    /**
     * Returns the normalized vector pointing from this vector to to.
     * @param to The other vector to point towards.
     * @return The direction from this vector to to.
     */
    public Vector2 directionTo(Vector2 to) {
        return new Vector2(to.x - x, to.y - y).normalized();
    }

    /**
     * Returns the squared distance between this vector and to. This method runs faster 
     * than AwesomeGearBoy.lib.Vector2.distanceTo(), so prefer it if you need to compare 
     * vectors or need the squared distance for some formula.
     * @param to The other vector to use.
     * @return The squared distance between the two vectors.
     */
    public float distanceSquaredTo(Vector2 to) {
        return (x - to.x) * (x - to.x) + (y - to.y) * (y - to.y);
    }

    /**
     * Returns the distance between this vector and to.
     * @param to The other vector to use.
     * @return The distance between the two vectors.
     */
    public float distanceTo(Vector2 to) {
        double result = Math.sqrt((x - to.x) * (x - to.x) + (y - to.y) * (y - to.y));
        float result2 = (float)result;
        return result2;
    }

    /**
     * Returns the dot product of this vector and with.
     * @param with The other vector to use.
     * @return The dot product of the two vectors.
     */
    public float dot(Vector2 with) {
        return x * with.x + y * with.y;
    }

    /**
     * Returns a new vector with all components rounded down (towards negative infinity).
     * @return A vector with Math.floor() called on each component.
     */
    public Vector2 floor() {
        double resultX = Math.floor(x);
        double resultY = Math.floor(y);
        Vector2 result = new Vector2((float)resultY, (float)resultX);
        return result;
    }

    /**
     * Returns the inverse of this vector. This is the same as new Vector2(1 / v.x, 1 / v.y).
     * @return The inverse of this vector.
     */
    public Vector2 inverse() {
        return new Vector2(1.0f / x, 1.0f / y);
    }

    /**
     * Returns true if this vector is finite, by calling AwesomeGearBoy.lib.Vector2.isFinite() 
     * on each component.
     * @return Whether this vector is finite or not.
     */
    public boolean isFinite() {
        return isFinite(x) && isFinite(y);
    }
    
    private static boolean isFinite(float value) {
        return !Float.isNaN(value) && !Float.isInfinite(value);
    }

    /**
     * Returns true if the vector is normalized, and false otherwise.
     * @return A boolean indicating whether or not the vector is normalized.
     */
    public boolean isNormalized() {
        return Math.abs(lengthSquared() - 1f) < 1E-06f;
    }

    /**
     * Returns the length (magnitude) of this vector.
     * @return The length of this vector.
     */
    public float length() {
        double result = Math.sqrt(x * x + y * y);
        float result2 = (float)result;
        return result2;
    }

    /**
     * Returns the squared length (squared magnitude) of this vector. This method runs 
     * faster than AwesomeGearBoy.lib.Vector2.length(), so prefer it if you need to compare vectors 
     * or need the squared length for some formula.
     * @return The squared length of this vector.
     */
    public float lengthSquared() {
        return x * x + y * y;
    }

    /**
     * Returns the result of the linear interpolation between this vector and to by 
     * amount weight.
     * @param to The destination vector for interpolation.
     * @param weight A value on the range of 0.0 to 1.0, representing the amount of interpolation.
     * @return The resulting vector of the interpolation.
     */
    public Vector2 lerp(Vector2 to, float weight) {
        return new Vector2(lerp(this.x, to.x, weight), lerp(this.y, to.y, weight));
    }

    private static float lerp(float a, float b, float weight) {
        return a + weight * (b - a);
    }

    /**
     * Returns the vector with a maximum length by limiting its length to length.
     * @return The vector with its length limited.
     */
    public Vector2 limitLength() {
        float length = 1.0f;
        Vector2 result = this;
        float num = length();
        if (num > 0.0f && length < num) {
            result.x /= num;
            result.y /= num;
            result.x *= length;
            result.y *= length;
        }

        return result;
    }

    /**
     * Returns the vector with a maximum length by limiting its length to length.
     * @param length The length to limit to.
     * @return The vector with its length limited.
     */
    public Vector2 limitLength(float length) {
        Vector2 result = this;
        float num = length();
        if (num > 0.0f && length < num) {
            result.x /= num;
            result.y /= num;
            result.x *= length;
            result.y *= length;
        }

        return result;
    }

    /**
     * <p>Returns the result of the component-wise maximum between this vector and with.
     * <p>Equivalent to new Vector2(Math.max(x, with.x), Math.max(y, with.y)).
     * @param with The other vector to use.
     * @return The resulting maximum vector.
     */
    public Vector2 max(Vector2 with) {
        double resultX = Math.max(x, with.x);
        double resultY = Math.max(y, with.y);
        return new Vector2((float)resultX, (float)resultY);
    }

     /**
     * <p>Returns the result of the component-wise maximum between this vector and with.
     * <p>Equivalent to new Vector2(Math.max(x, with.x), Math.max(y, with.y)).
     * @param with The other value to use.
     * @return The resulting maximum vector.
     */
    public Vector2 max(float with) {
        double resultX = Math.max(x, with);
        double resultY = Math.max(y, with);
        return new Vector2((float)resultX, (float)resultY);
    }

    /**
     * <p>Returns the result of the component-wise minimum between this vector and with.
     * <p>Equivalent to new Vector2(Math.min(x, with.x), Math.min(y, with.y)).
     * @param with The other vector to use.
     * @return The resulting minimum vector.
     */
    public Vector2 min(Vector2 with) {
        double resultX = Math.min(x, with.x);
        double resultY = Math.min(y, with.y);
        return new Vector2((float)resultX, (float)resultY);
    }

    /**
     * <p>Returns the result of the component-wise minimum between this vector and with.
     * <p>Equivalent to new Vector2(Math.min(x, with.x), Math.min(y, with.y)).
     * @param with The other value to use.
     * @return The resulting minimum vector.
     */
    public Vector2 min(float with) {
        double resultX = Math.min(x, with);
        double resultY = Math.min(y, with);
        return new Vector2((float)resultX, (float)resultY);
    }

    /**
     * Moves this vector toward to by the fixed delta amount.
     * @param to The vector to move towards.
     * @param delta The amount to move towards by.
     * @return The resulting vector.
     */
    public Vector2 moveToward(Vector2 to, float delta) {
        Vector2 vector = this;
        float X = to.x - vector.x;
        float Y = to.y - vector.y;
        Vector2 vector2 = new Vector2(X, Y);
        float num = vector2.length();
        if (num <= delta || num < 1E-06f) {
            return to;
        }

        float resultX = vector.x + vector2.x / num * delta;
        float resultY = vector.y + vector2.y / num * delta;
        return new Vector2(resultX, resultY);
    }

    /**
     * Returns the vector scaled to unit length. Equivalent to v / v.length().
     * @return A normalized version of the vector.
     */
    public Vector2 normalized() {
        Vector2 result = this;
        result.normalize();
        return result;
    }

    /**
     * Returns a vector composed of the AwesomeGearBoy.lib.Vector2.posMod() 
     * of this vector's components and mod.
     * @param mod A value representing the divisor of the operation.
     * @return A vector with each component AwesomeGearBoy.lib.Vector2.posMod() 
     * by mod.
     */
    public Vector2 posMod(float mod) {
        return new Vector2(posMod(x, mod), posMod(y, mod));
    }

    /**
     * Returns a vector composed of the AwesomeGearBoy.lib.Vector2.posMod() 
     * of this vector's components and modv's components.
     * @param modv A vector representing the divisors of the operation.
     * @return A vector with each component AwesomeGearBoy.lib.Vector2.posMod() 
     * by modv's components.
     */
    public Vector2 posMod(Vector2 modv) {
        return new Vector2(posMod(x, modv.x), posMod(y, modv.y));
    }

    private static float posMod(float value, float mod) {
        float result = value % mod;
        return (result < 0) ? result + mod : result;
    }

    /**
     * Returns a new vector resulting from projecting this vector onto the given vector 
     * onNormal. The resulting new vector is parallel to onNormal. See also Godot.Vector2.Slide(Godot.Vector2).
     * <p>Note: If the vector onNormal is a zero vector, the components of the resulting 
     * new vector will be null.
     * @param onNormal The vector to project onto.
     * @return The projected vector.
     */
    public Vector2 project(Vector2 onNormal) {
        float resultX = onNormal.x * (dot(onNormal) / onNormal.lengthSquared());
        float resultY = onNormal.y * (dot(onNormal) / onNormal.lengthSquared());
        return new Vector2(resultX, resultY);
    }

    /**
     * Returns this vector reflected from a plane defined by the given normal.
     * @param normal The normal vector defining the plane to reflect from. Must be normalized.
     * @return The reflected vector.
     */
    public Vector2 reflect(Vector2 normal) {
        float resultX = 2.0f * dot(normal) * normal.x - this.x;
        float resultY = 2.0f * dot(normal) * normal.y - this.y;
        return new Vector2(resultX, resultY);
    }

    /**
     * Rotates this vector by angle radians.
     * @param angle The angle to rotate by, in radians.
     * @return The rotated vector.
     */
    public Vector2 rotated(float angle) {
        float sin = (float) Math.sin(angle);
        float cos = (float) Math.cos(angle);
        return new Vector2(x * cos - y * sin, x * sin + y * cos);
    }

    /**
     * Returns this vector with all components rounded to the nearest integer, with 
     * halfway cases rounded towards the nearest multiple of two.
     * @return The rounded vector.
     */
    public Vector2 round() {
        float resultX = Math.round(x);
        float resultY = Math.round(y);
        return new Vector2(resultX, resultY);
    }

    /**
     * Returns a vector with each component set to one or negative one, depending on 
     * the signs of this vector's components, or zero if the component is zero, by calling 
     * Math.signum() on each component.
     * @return A vector with all components as either 1, -1, or 0.
     */
    public Vector2 sign() {
        return new Vector2(Math.signum(x), Math.signum(y));
    }
    
    /**
     * Returns the result of the spherical linear interpolation between this vector 
     * and to by amount weight. This method also handles interpolating the lengths if 
     * the input vectors have different lengths. For the special case of one or both 
     * input vectors having zero length, this method behaves like AwesomeGearBoy.lib.Vector2.lerp().
     * @param to The destination vector for interpolation.
     * @param weight A value on the range of 0.0 to 1.0, representing the amount of interpolation.
     * @return The resulting vector of the interpolation.
     */
    public Vector2 slerp(Vector2 to, float weight) {
        float num = lengthSquared();
        float num2 = to.lengthSquared();
        if (num == 0.0f || num2 == 0.0f) {
            return lerp(to, weight);
        }

        double doubNum = (double)num;
        float num3 = (float)Math.sqrt(doubNum);
        float num4 = lerp(num3, (float)Math.sqrt(num2), weight);
        float num5 = angleTo(to);
        return rotated((num5 * weight) * (num4 / num3));
    }

    /**
     * Returns a new vector resulting from sliding this vector along a line with normal 
     * normal. The resulting new vector is perpendicular to normal, and is equivalent 
     * to this vector minus its projection on normal.
     * <p>Note: The vector normal must be normalized.
     * @param normal The normal vector of the plane to slide on.
     * @return The slid vector.
     * @see AwesomeGearBoy.lib.Vector2.project()
     * @see AwesomeGearBoy.lib.Vector2.normalized()
     */
    public Vector2 slide(Vector2 normal) {
        float resultX = this.x - normal.x * dot(normal);
        float resultY = this.y - normal.y * dot(normal);
        return new Vector2(resultX, resultY);
    }

    /**
     * Returns a new vector with each component snapped to the nearest multiple of the 
     * corresponding component in step. 
     * <p>This can also be used to round to an arbitrary number of decimals.
     * @param step A vector value representing the step size to snap to.
     * @return The snapped vector.
     */
    public Vector2 snapped(Vector2 step) {
        float resultX = snap(x, step.x);
        float resultY = snap(x, step.x);
        return new Vector2(resultX, resultY);
    }

    /**
     * Returns a new vector with each component snapped to the nearest multiple of step.
     * <p>This can also be used to round to an arbitrary number of decimals.
     * @param step A vector value representing the step size to snap to.
     * @return The snapped vector.
     */
    public Vector2 snapped(float step) {
        return new Vector2(snap(x, step), snap(y, step));
    }
    
    private static float snap(float value, float step) {
        return Math.round(value / step) * step;
    }

    /**
     * Returns a perpendicular vector rotated 90 degrees counter-clockwise compared 
     * to the original, with the same length.
     * @return The perpendicular vector.
     */
    public Vector2 orthogonal() {
        return new Vector2(y, 0.0f - x);
    }

    /**
     * Creates a unit Vector2 rotated to the given angle. This is equivalent to doing 
     * Vector2(Mathf.Cos(angle), Mathf.Sin(angle)).
     * @param angle Angle of the vector, in radians.
     * @return The resulting vector.
     */
    public static Vector2 fromAngle(float angle) {
        float sin = (float) Math.sin(angle);
        float cos = (float) Math.cos(angle);
        return new Vector2(cos, sin);
    }

    /**
     * Returns true if the vector is exactly equal to the given object (obj).
     * <p>Note: Due to floating-point precision errors, consider using AwesomeGearBoy.lib.Vector2.isEqualApprox() 
     * instead, which is more reliable.
     * @param obj The object to compare with.
     * @return Whether or not the vector and the object are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2 vector2 = (Vector2) obj;
        return Float.compare(vector2.x, x) == 0 && Float.compare(vector2.y, y) == 0;
    }

    /**
     * Returns true if the vectors are exactly equal.
     * <p>Note: Due to floating-point precision errors, consider using AwesomeGearBoy.lib.Vector2.isEqualApprox() 
     * instead, which is more reliable.
     * @param other The other vector.
     * @return Whether or not the vectors are exactly equal.
     */
    public boolean equals(Vector2 other) {
        if (this.x == other.x) {
            return this.y == other.y;
        }

        return false;
    }

    /**
     * Returns true if this vector and other are approximately equal, by running AwesomeGearBoy.lib.Vector2.isEqualApprox() 
     * on each component.
     * @param other The other vector to compare.
     * @return Whether or not the vectors are approximately equal.
     */
    public boolean isEqualApprox(Vector2 other) {
        return isEqualApprox(this.x, other.x) && isEqualApprox(this.y, other.y);
    }
    
    private static boolean isEqualApprox(float a, float b) {
        return Math.abs(a - b) < 1e-6f;
    }

    /**
     * Returns true if this vector's values are approximately zero, by running AwesomeGearBoy.lib.Vector2.isZeroApprox() 
     * on each component. This method is faster than using AwesomeGearBoy.lib.Vector2.isEqualApprox() 
     * with one value as a zero vector.
     * @return Whether or not the vector is approximately zero.
     */
    public boolean isZeroApprox() {
        return isZeroApprox(this.x) && isZeroApprox(this.y);
    }
    
    private static boolean isZeroApprox(float value) {
        return Math.abs(value) < 1e-6f;
    }
    
    /**
     * Serves as the hash function for AwesomeGearBoy.lib.Vector2.
     * @return A hash code for this vector.
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }

    /**
     * Converts this AwesomeGearBoy.lib.Vector2 to a string.
     * @return A string representation of this vector.
     */
    @Override
    public String toString() {
        return toString(null);
    }

    /**
     * Converts this Godot.Vector2 to a string with the given format.
     * @param format
     * @return A string representation of this vector.
     */
    public String toString(String format) {
        if (format == null) {
            return String.format("(%f, %f)", x, y);
        }
        return String.format("(%s, %s)", String.format(format, x), String.format(format, y));
    }
}

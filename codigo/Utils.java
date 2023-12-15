package codigo;

public class Utils {
    public static boolean isFloatInRange(float number, float start, float end, float epsilon) {
        return (number >= start - epsilon) && (number <= end + epsilon);
    }
    
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isBlank();
    }
}
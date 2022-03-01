package Generic;

public class MaximumTest
{
    // xac dinh gioi han max cua cac doi tuong Comparable
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // gia su ban dau x la lon nhat
        if ( y.compareTo( max ) > 0 ){
            max = y; // y la lon nhat
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // bay gio z la lon nhat
        }
        return max; // tra ve doi tuong lon nhat
    }
    public static void main( String args[] )
    {
        System.out.printf( "Max cua %d, %d va %d la %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "Max cua %.1f,%.1f va %.1f la %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "Max cua %s, %s va %s la %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }
}

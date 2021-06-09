package FunctionalInterface;

/**
 *
 */
public class TestMain
{
    public static void main (String[] args)
    {
        Converter<String,Integer> converter = (from -> Integer.valueOf(from));
//        Converter<String,Integer> converter = Integer::valueOf;
        Integer integer =  converter.convert("123");
        System.out.print(integer.getClass());
    }
}

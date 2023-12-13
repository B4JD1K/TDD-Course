package m3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tdd.m3.StringUtil;

import java.util.stream.Stream;

public class StringUtilTest {

    @ParameterizedTest
    @MethodSource("validLimitProvider")
    public void limitReached_StringTruncates(int limit, String output) {

        String input = "The economy is about to";   // length 23
        Assertions.assertEquals(output, StringUtil.truncateWithEllipsis(input, limit));
    }

    public static Stream<Arguments> validLimitProvider() {
        return Stream.of(
                Arguments.of(1, "T..."),     // min possible limit
                Arguments.of(11, "The economy...")
        );
    }

    //    @Test
//    public void limitNotReached_StringNotChanged (){
//
//        String input = "The economy is about to";   // length 23
//        int limit = 40;
//
//        Assertions.assertEquals( "The economy is about to",StringUtil.truncate(input,limit));
//    }
//    @Test
//    public void limitNotReachedAtBorder_StringNotChanged (){
//
//        String input = "The economy is about to";   // length 23
//        int limit = 23;
//
//        Assertions.assertEquals( "The economy is about to",StringUtil.truncate(input,limit));
//    }
    /* Dwa powyższe testy można sparametryzować przy pomocy @ParameterizedTest */
    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    public void limitNotReachedAtBorder_StringNotChanged(String input, int limit) {
        Assertions.assertEquals("The economy is about to", StringUtil.truncateWithEllipsis(input, limit));
    }

    public static Stream<Arguments> inputOutputLimitProvider() {
        String input = "The economy is about to";
        return Stream.of(
                Arguments.of(input, 40),
                Arguments.of(input, input.length())  // at border, input length == limit
        );
    }

    //    @Test
//    public void invalidInput_isRejected(){
//        Assertions.assertThrows(IllegalArgumentException.class,
//                ()->StringUtil.truncate(null,5));
//    }
//    @Test
//    public void invalidLimitInput_isRejected(){
//        Assertions.assertThrows(IllegalArgumentException.class,
//                ()->StringUtil.truncate("Some input",0));
//    }
    /* Dwa powyższe testy też zostały sparametryzowane */
    @ParameterizedTest
    @MethodSource("invalidArgumentProvider")
    public void invalidInput_isRejected(String input, int limit) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StringUtil.truncateWithEllipsis(input, limit));
    }

    public static Stream<Arguments> invalidArgumentProvider() {
        return Stream.of(
                Arguments.of(null, 5),
                Arguments.of("Some input", 0)
        );
    }

    //    @Test
//    public void inputShorterThanLimit_StringNotChanged(){
//        String input = "The";
//        int limit = 2;
//
//        Assertions.assertEquals(input,StringUtil.truncate(input,limit));
//    }

    @ParameterizedTest
    @MethodSource("shortInputLessOrEqualToEllipsis")
    public void inputShorterThanLimit_StringNotChanged(String input, int limit) {
        Assertions.assertEquals(input, StringUtil.truncateWithEllipsis(input, limit));
    }

    public static Stream<Arguments> shortInputLessOrEqualToEllipsis() {
        return Stream.of(
                Arguments.of("The", 2),
                Arguments.of("The", 3)
        );
    }
}

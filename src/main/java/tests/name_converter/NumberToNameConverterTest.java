package tests.name_converter;

import cheatsheet.result_analysis.number_to_name_converter.NumberToWords;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ERICK on 18.04.2017.
 */
public class NumberToNameConverterTest {

    private NumberToWords processor = null;
    private String result;

    @Before
    public void setResult() {
        result = new String();
    }

    @Test
    public void getNameFromIntDefaultProc() throws Exception {
        processor = new NumberToWords("10999999999999");
        result = processor.getName();
        assertTrue(result.equals("ten trillion nine hundred ninety-nine billion " +
                "nine hundred ninety-nine million nine hundred ninety-nine thousand " +
                "nine hundred ninety-nine"));
    }

    @Test
    public void getNameFromDoubleDefaultProc() throws Exception {
        processor = new NumberToWords("10.278");
        result = processor.getName();
        assertTrue(result.equals("ten and two hundred seventy-eight thousandth"));
    }

    @Test
    public void getNameIntFromExpProc() throws Exception {
        processor = new NumberToWords("10E6");
        result = processor.getName();
        assertTrue(result.equals("ten by ten to the six"));
    }

    @Test
    public void getNameFromDoubleExpProc() throws Exception {
        processor = new NumberToWords("10.1E6.5");
        result = processor.getName();
        assertTrue(result.equals("ten and one tenth by ten to the six and five tenth"));
    }
}
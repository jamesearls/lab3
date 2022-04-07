package org.jfree.data;

import java.security.InvalidParameterException;
import org.jfree.data.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Any TC's commented out would not compile due to invalid input.
 * @author James
 *
 */

public class DataUtilitiesTest extends DataUtilities {

	private static Values2D values2D;
	private static double[] validArray = {1.8,2.3,3.7,4.2,5.8};
	private static int[] intArray = {1,2,3,4};




	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();

		values2D = testValues;

		testValues.addValue(1, 0, 0);
		testValues.addValue(2, 0, 1);
		testValues.addValue(5, 0, 2);
		testValues.addValue(99, 0, 3);

		testValues.addValue(6, 1, 0);
		testValues.addValue(-2, 1, 1);
		testValues.addValue(17, 1, 2);
		testValues.addValue(-834, 1, 3);
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		values2D = null;
	}


	//CalculateColumnTotal method
	// TC 6.1
	@Test
	public void testCalculateColumnTotal_ValidDataValidColumn() {

		assertEquals("Wrong sum returned. It should be -735",
				-735, DataUtilities.calculateColumnTotal(values2D, 3), 0.00000001d);
	}

	// TC 6.2
	@Test
	public void testCalculateColumnTotal_ValidDataNegColumn(){
		try {

			assertEquals("Wrong value returned should be 0",
					0, DataUtilities.calculateColumnTotal(values2D, -47), 0.00000001d);
		} catch (Exception e) {
			fail("0 Should have been Returned");
		}
	}
	// TC 6.3
	@Test
	public void testCalculateColumn_ValidDataColumnGreaterThanColumnUpperBound() {

		try {
			assertEquals("Wrong value returned should be 0",
					0, DataUtilities.calculateColumnTotal(values2D, 56), 0.00000001d);
		} catch (Exception e) {
			fail("0 Should have been Returned");
		}
	}
	// TC 6.4
//	@Test
//	public void testCalculateColumnTotal_StringDataValidColumn(){
//		try
//		{
//			DataUtilities.calculateColumnTotal("james", 0);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}

	// TC 6.5
// @Test
//	public void testCalculateColumnTotal_CharDataNegNumColumn(){
//		try
//		{
//			DataUtilities.calculateColumnTotal('j', -23);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}

		// TC 6.4
//		@Test
//	public void testCalculateColumnTotal_BoolDataColumnGreaterThanColumnUpperBound(){
//		try
//		{
//			DataUtilities.calculateColumnTotal(true, 55);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}


	//calculatRowTotal method
	// TC 7.1
	@Test
	public void testCalculateRowTotal_ValidDataValidColumn() {

		assertEquals("Wrong sum returned. It should be 107",
				107, DataUtilities.calculateRowTotal(values2D, 0), 0.00000001d);
	}

	// TC 7.2
	@Test
	public void testCalculateRowTotal_ValidDataNegRow(){
		try {

			assertEquals("Wrong value returned should be 0",
					0.0,DataUtilities.calculateRowTotal(values2D, -32), 0.00000001d);

		} catch (Exception e) {
					fail("0 Should have been Returned");
		}
	}
	// TC 7.3
	@Test
	public void testCalculateRowTotal_ValidDataColumnGreaterThanColumnUpperBound() {
		try {
			assertEquals("Wrong value returned should be 0",
					0, DataUtilities.calculateRowTotal(values2D, 21), 0.00000001d);
		} catch (Exception e) {
			fail("0 Should have been Returned");
		}
	}
	// TC 7.4
	// @Test
//	public void testCalculateRowTotal_StringDataValidRow(){
//		try
//		{
//			DataUtilities.calculateRowTotal("james", 0);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}

	// TC 7.5
//	@Test
//	public void testCalculateRowTotal_CharDataNegRow(){
//		try
//		{
//			DataUtilities.calculateRowTotal('j', -23);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}

	// TC 7.6
//	@Test
//	public void testCalculateRowTotal_BooleanDataColumnGreaterThanColumnUpperBound(){
//		try
//		{
//			DataUtilities.calculateRowTotal(true, 55);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}

	//createNumberArray method
	// TC 8.1
	@Test
	public void testCreateNumberArray_ValidData() {
		try {
			Number[] numArray = DataUtilities.createNumberArray(validArray);
			assertEquals("Length of arrays must be equal.",
					validArray.length, numArray.length);

			assertEquals("Array contents must be equal.", validArray[0],
					numArray[0].doubleValue(), 0.0000001);
			assertEquals("Array contents must be equal.", validArray[1],
					numArray[1].doubleValue(), 0.0000001);
			assertEquals("Array contents must be equal.", validArray[2],
					numArray[2].doubleValue(), 0.0000001);
			assertEquals("Array contents must be equal.", validArray[3],
					numArray[3].doubleValue(), 0.0000001);
			assertEquals("Array contents must be equal.", validArray[4],
					numArray[4].doubleValue(), 0.0000001);
		} catch (Exception e) {
			fail("No exception should be thrown");
		}
	}
	// TC 8.2
	@Test
	public void testCreateNumberArray_EmptyArrayData() {
		double[] emptyArray = {};
		Number[] numArray = DataUtilities.createNumberArray(emptyArray);
		assertEquals("Length of arrays must be equal.",
			emptyArray.length, numArray.length);
	}
	// TC 8.3
	@Test
	public void testCreateNumberArray_NullData() {
		double[] nullArray = null;
		try
		{
			Number[] numArray = DataUtilities.createNumberArray(nullArray);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}

	}
	// TC 8.4
//	@Test
//	public void testCreateNumberArray_IntArrayData() {
//		try
//		{
//			Number[] numArray = DataUtilities.createNumberArray(intArray);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e)
//		{
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}


	//CreateNumberArray2D method
	// TC 9.1
    @Test
    public void testCreateNumberArray2D_ValidData() {
        double[][] valid2DArray = new double[2][];
        valid2DArray[0] = new double[] {1.7, 3.2, 5.8, 3.1};
        valid2DArray[1] = new double[] {191.2, 3.2, 6.3, 9.4};

        Number[][] n = DataUtilities.createNumberArray2D(valid2DArray);
        assertEquals(4, n[0].length);
        assertEquals(4, n[1].length);
    }
	// TC 9.2
	@Test
	public void testCreateNumberArray2D_EmptyArrayData() {
		double[][] empty2DArray = new double[2][];
		empty2DArray[0] = new double[] {};
		empty2DArray[1] = new double[] {};

		Number[][] n = DataUtilities.createNumberArray2D(empty2DArray);
		assertEquals(0, n[0].length);
		assertEquals(0, n[1].length);
	}
	// TC 9.3
	@Test
	public void testCreateNumberArray2D_NullAData() {
		double[][] null2DArray = null;
		try
		{
			Number[][] n = DataUtilities.createNumberArray2D(null2DArray);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

    // TC 9.4
//    @Test
//    public void testCreateNumberArray2D_IntArrayData() {
//        int[][] invalid2DArray = new int[2][];
//
//        invalid2DArray[0] = new int[] {1, 3, 5, 3};
//        invalid2DArray[1] = new int[] {191, 3, 6, 8};
//
//        Number[][] n = DataUtilities.createNumberArray2D(invalid2DArray);
//        assertEquals(2, n.length);
//        assertEquals(4, n[0].length);
//        assertEquals(5, n[1].length);
//    }

	//getCumulativePercentages method

	// TC 10.1
	@Test
	public void testGetCumulativePercentages_ValidData() {
		DefaultKeyedValues kv = new DefaultKeyedValues();
		kv.addValue("0", 5);
		kv.addValue("1", 9);
		kv.addValue("2", 2);

		KeyedValues percentages = DataUtilities.getCumulativePercentages(kv);

		assertEquals(0.3125, percentages.getIndex("0"), 0.0000001);
		assertEquals(0.875, percentages.getIndex("1"), 0.0000001);
		assertEquals(0.1, percentages.getIndex("2"), 0.0000001);

	}

	// TC 10.2
	@Test
	public void testGetCumulativePercentages_ZeroValues() {
		DefaultKeyedValues kv = new DefaultKeyedValues();
		kv.addValue("0", 0);
		kv.addValue("1", 0);
		kv.addValue("2", 0);

		KeyedValues percentages = DataUtilities.getCumulativePercentages(kv);

		assertEquals(0, percentages.getIndex("0"), 0.0000001);
		assertEquals(0, percentages.getIndex("1"), 0.0000001);
		assertEquals(0, percentages.getIndex("2"), 0.0000001);

	}

	// TC 10.3
	@Test
	public void testGetCumulativePercentages_NegNumValue() {
		DefaultKeyedValues kv = new DefaultKeyedValues();
		kv.addValue("0", -5);
			KeyedValues percentages = DataUtilities.getCumulativePercentages(kv);
			assertEquals(-0.3125, percentages.getIndex("0"), 0.0000001);
		}

	// TC 10.4
	@Test
	public void testGetCumulativePercentages_EmptyValues() {
		DefaultKeyedValues kv = new DefaultKeyedValues();

		KeyedValues percentages = DataUtilities.getCumulativePercentages(kv);

		assertEquals(0, percentages.getIndex("0"), 0.0000001);
	}
	// TC 10.5
	@Test
	public void testGetCumulativePercentages_NullData() {
		try {
			KeyedValues percentages = DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	// TC 10.6
//	@Test public void testGetCumulativePercentages_DoubleArrayData() {
//		double[] values = new double[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		try {
//			KeyedValues percentages = DataUtilities.getCumulativePercentages(values);
//			fail("No exception thrown - Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e) {
//			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
//		}
//	}
	

}
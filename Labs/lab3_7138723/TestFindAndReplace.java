/* ITI 1121. Introduction to Computing II; Laboratory 3
 * ITI 1521. Introduction a l'informatique II; Laboratoire 3
 */

/** A series of tests for the method findAndReplace.
 *
 * @author Marcel Turcotte (turcotte@site.uottawa.ca)
 */

import org.junit.Test;

import org.junit.*;


public class TestFindAndReplace {
  
	@Test
    public void testInIsNull() {
	String[] query = { "I" };
	String[] replacement = { "You" };
	Assert.assertNull( Utils.findAndReplace( null, query, replacement ) );
    }

	@Test
    public void testQueryIsNull() {
	String[] text = { "I", "understand" };
	String[] replacement = { "You" };
	Assert.assertNull( Utils.findAndReplace( text, null, replacement ) );
    }

	@Test
    public void testReplacementIsNull() {
	String[] text = { "I", "understand" };
	String[] query = { "I" };
	Assert.assertNull( Utils.findAndReplace( text, query, null ) );
    }

	@Test
    public void testInAndQueryAreNull() {
	String[] replacement = { "You" };
	Assert.assertNull( Utils.findAndReplace( null, null, replacement ) );
    }

	@Test
    public void testInAndReplacementreNull() {
	String[] query = { "I" };
	Assert.assertNull( Utils.findAndReplace( null, query, null ) );
    }

	@Test
    public void testQueryAndReplacementreNull() {
	String[] text = { "I", "understand" };
	Assert.assertNull( Utils.findAndReplace( text, null, null ) );
    }

	@Test
    public void testAllNull() {
	Assert.assertNull( Utils.findAndReplace( null, null, null ) );
    }

	@Test
    public void testNotSameLength() {
	String[] text = { "I", "understand" };
	String[] query = { "I" };
	String[] replacement = { "You", "They" };
	Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

	@Test
    public void testNullInIn() {
	String[] text = { "I", null };
	String[] query = { "I" };
	String[] replacement = { "You" };
	Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

	@Test
    public void testNullInQuery() {
	String[] text = { "I", "understand" };
	String[] query = { "I", null };
	String[] replacement = { "You", "They" };
	Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

	@Test
    public void testNullInReplacement() {
	String[] text = { "I", "understand" };
	String[] query = { "I", "We" };
	String[] replacement = { null, "They" };
	Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

	@Test
    public void testNoChange1() {
	String[] text = { "I", "understand" };
	String[] query = { };
	String[] replacement = { };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( text[ i ], result[ i ] );
	}
    }

	@Test
	public void testNoChange2() {
	String[] text = { "I", "understand" };
	String[] query = { "You" };
	String[] replacement = { "I" };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( text[ i ], result[ i ] );
	}
    }

	@Test
    public void testChangeFirst1() {
	String[] text = { "I", "understand" };
	String[] query = { text[ 0 ] };
	String[] replacement = { "You" };
	String[] expected = { replacement[ 0 ], text[ 1 ] };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], result[ i ] );
	}
    }

	@Test
    public void testChangeFirst2() {
	String[] text = { "I", "understand" };
	String[] query = { new String( "I" ) };
	String[] replacement = { "You" };
	String[] expected = { "You", "understand" };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], result[ i ] );
	}
    }

	@Test
    public void testChangeLast() {
	String[] text = { "I", "understand" };
	String[] query = { new String( "understand" ) };
	String[] replacement = { "see" };
	String[] expected = { "I", "see" };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], result[ i ] );
	}
    }

	@Test
    public void testChangeLeft() {
	String[] text = { "I", "understand" };
	String[] query = { new String( "understand" ), new String( "understand" ) };
	String[] replacement = { "see", "grasp" };
	String[] expected = { "I", "see" };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], result[ i ] );
	}
    }

	@Test
    public void testMultipleChanges1() {
	String[] text = { "I", "like", "Java" };
	String[] query = { new String( "I" ), new String( "like" ), new String( "Java" ) };
	String[] replacement = { "You", "enjoy", "object-oriented programming" };
	String[] expected = { "You", "enjoy", "object-oriented programming" };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], result[ i ] );
	}
    }

	@Test
    public void testMultipleChanges2() {
	String[] text = { "I", "like", "Java" };
	String[] query = { new String( "I" ), new String( "Java" ), new String( "like" ) };
	String[] replacement = { "You", "object-oriented programming", "enjoy" };
	String[] expected = { "You", "enjoy", "object-oriented programming" };
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], result[ i ] );
	}
    }

	@Test
    public void testInIsUnchanged() {
	String[] text = { "I", "like", "Java" };
	String[] query = { new String( "I" ), new String( "Java" ), new String( "like" ) };
	String[] replacement = { "You", "object-oriented programming", "enjoy" };
	String[] expected = new String[ text.length ];
	System.arraycopy( text, 0, expected, 0, text.length );
	String[] result = Utils.findAndReplace( text, query, replacement );
	Assert.assertNotNull( result );
	Assert.assertFalse( text == result );
	Assert.assertTrue( text.length == result.length );
	for ( int i=0; i<text.length; i++ ) {
	    Assert.assertEquals( expected[ i ], text[ i ] );
	}
    }

  
}

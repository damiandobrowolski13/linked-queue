/*
  Test cases for LinkedQueue class.

  Compile: javac -d target -cp .:target:junit-platform-console-standalone-1.9.1.jar TestCases.java

  Run: java -jar junit-platform-console-standalone-1.9.1.jar --class-path target --select-class TestCases

*/

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class TestCases {
	String msg;
	String tst;


	public void setup() {
	}

	public void tearDown() {
	}

    /*
      Test the constructor.
      This test makes a queue and verifies that it is empty, 
      thereby testing the constructor AND the size() method.
    */
  @Test // This pragma is required before each test method.
  public void testConstructor0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
    msg = "Testing a new queue reports empty.";
    try {
    	LinkedQueue<Double> q = new LinkedQueue<Double>();
    	assertEquals(q.isEmpty(),true);
    	System.out.println("PASS: " + msg);
    } catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	  }
	  catch (IllegalArgumentException ex) {
	  	fail("Expected an empty queue." + ex);
	  }
	}

	@Test 
	public void testConstructor1() {

		msg = "Testing a new queue has size 0.";

		try {
			LinkedQueue<Double> q = new LinkedQueue<Double>();
			assertEquals(q.size(),0);
			System.out.println("PASS: " + msg);
		} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	  }
	  catch (IllegalArgumentException ex) {
	  	fail("Expected an empty queue." + ex);
	  }
	}


    // TODO: More tests.
    // Tests for enqueue

	@Test
	public void testEnqueue(){

		msg = "Testing ability to enqueue items at the tail.";

		try {
			LinkedQueue<Double> q = new LinkedQueue<Double>();
			assertEquals(q.size(),0);
			q.enqueue(0.0);
			assertEquals(q.size(),1);
			assertEquals(q.peek(), new Double(0.0));
			System.out.println("PASS: " + msg);
		} catch (AssertionError aex){
    		fail("assertion error" + aex); //assertion failed
    } catch (IllegalArgumentException ex){
    		fail("Expected an empty queue." + ex);
    }
	}

    // Tests for dequeue

	@Test
	public void testDequeue(){

		msg = "Testing ability to dequeue items at the head.";

		try{
			LinkedQueue<Double> q = new LinkedQueue<Double>();
			q.enqueue(0.0);
			q.enqueue(1.0);
			q.dequeue();
			assertEquals(q.size(),1);
			assertEquals(q.peek(), new Double(1.0));
			System.out.println("PASS: " + msg);
		} catch (AssertionError aex){
    		fail("assertion error" + aex); //assertion failed
    } catch (IllegalArgumentException ex){
    		fail("Expected an empty queue." + ex);
  	}
	}


    // Tests for peek

	@Test
	public void testPeek(){

		msg = "Testing ability to peek items at the head.";
		
		try {
			LinkedQueue<Double> q = new LinkedQueue<Double>();
			q.enqueue(0.0);
			assertEquals(q.peek(), new Double(0.0));
			System.out.println("PASS: " + msg);
		} catch (AssertionError aex){
    		fail("assertion error" + aex); //assertion failed
    } catch (IllegalArgumentException ex){
    		fail("Expected an empty queue." + ex);
    }
  }


  	// Tests for toString

  @Test
  public void testToString(){

  	msg = "Testing ability to print queue as strings.";

  	try{
  		LinkedQueue<Double> q = new LinkedQueue<Double>();
  		q.enqueue(0.0);
  		q.enqueue(1.0);
  		assertEquals(q.size(),2);
  		assertEquals(q.toString(),"0.0 1.0 ");
  		System.out.println("PASS: " + msg);
  	} catch (AssertionError aex){
    		fail("assertion error" + aex); //assertion failed
    } catch (IllegalArgumentException ex){
    		fail("Expected an empty queue." + ex);
    }
  }


  	// Tests for methods of iterator

  @Test
  public void testHasNext(){

  	msg = "Testing ability for iterator to check hasNext.";

  	try{
	  	LinkedQueue<Double> q = new LinkedQueue<Double>();
	  	q.enqueue(0.0);
	  	q.enqueue(1.0);
	  	assertEquals(q.iterator().hasNext(),true);
	  } catch (AssertionError aex){
    		fail("assertion error" + aex); //assertion failed
    } catch (IllegalArgumentException ex){
    		fail("Expected an empty queue." + ex);
    }
  }

  @Test
  public void testNext(){

  	msg = "Testing ability for iterator to return next.";

  	try{
	  	LinkedQueue<Double> q = new LinkedQueue<Double>();
	  	q.enqueue(0.0);
	  	q.enqueue(1.0);
	  	assertEquals(q.iterator().next(), new Double(1.0));
	  } catch (AssertionError aex){
    		fail("assertion error" + aex); //assertion failed
    } catch (IllegalArgumentException ex){
    		fail("Expected an empty queue." + ex);
    }
  }
} // end of TestCases


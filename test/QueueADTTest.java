import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueADTTest
{
  private QueueADT<String> q;

  @BeforeEach void setUp()
  {
    q = new SimpleBoundedArrayQueueCorrect<>(5);
  }

  // Test enqueue method
  @Test void enqueueMany()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertEquals(5, q.size());
  }

  @Test void enqueueTooMany()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertThrows(IllegalStateException.class, () -> q.enqueue("F"));
  }

  @Test void enqueueNull()
  {
    assertThrows(IllegalArgumentException.class, () -> q.enqueue(null));
  }

  @Test void dequeueEmptyQueue()
  {
    assertThrows(IllegalStateException.class, () -> q.dequeue());
  }

  @Test void dequeueReturnsFirstElementInQueue()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertEquals("A", q.dequeue());
  }

  @Test void dequeueDecreasesSize()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    q.dequeue();
    assertEquals(4, q.size());
  }

  @Test void firstEmptyQueue()
  {
    assertThrows(IllegalStateException.class, () -> q.first());
  }

  @Test void firstReturnFirstInQueueElement()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertEquals("A", q.first());
  }

  @Test void sizeFullQueue()
  {
    // Already tested in enqueueMany()
  }

  @Test void sizeSomeElements()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    assertEquals(3, q.size());
  }

  @Test void sizeZero()
  {
    assertEquals(0, q.size());
  }

  @Test void isEmptyTrue()
  {
    assertTrue(q.isEmpty());
  }

  @Test void isEmptyFalse()
  {
    q.enqueue("A");
    assertFalse(q.isEmpty());
  }

  @Test void indexOfElementInFullQueue()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertEquals(2, q.indexOf("C"));
  }

  @Test void indexOfWithDuplicates()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("D");
    assertEquals(3, q.indexOf("D"));
  }

  @Test void indexOfElementNotFound()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    assertEquals(-1, q.indexOf("D"));
  }

  @Test void indexOfEmptyQueue()
  {
    assertEquals(-1, q.indexOf("D"));
  }

  @Test void containsTrue()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    assertTrue(q.contains("C"));
  }

  @Test void containsFalse()
  {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    assertFalse(q.contains("D"));
  }

  @Test void containsEmpty()
  {
    assertThrows(NullPointerException.class, () -> q.contains("A"));
  }

}
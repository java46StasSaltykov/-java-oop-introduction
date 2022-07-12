package telran.shapes.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.shapes.Rectangle;
import telran.shapes.Square;

class RectangleTests {

	@Test
	void rectangleTest() {
		int width = 10;
		int height = 5;
		Rectangle rectangle = new Rectangle(width, height);
		assertEquals(width, rectangle.getWidth());
		assertEquals(height, rectangle.getHeight());
		rectangle.draw();
		System.out.println("\n");
		width = 9;
		height = 7;
		rectangle.setHeight(height);
		rectangle.setWidth(width);
		assertEquals(width, rectangle.getWidth());
		assertEquals(height, rectangle.getHeight());
		rectangle.draw();
		System.out.println("\n");
	}
	
	@Test
	void squareTest() {
		int width = 5;
		Square square = new Square(width);
		assertTrue(square.getHeight() == square.getWidth());
		assertEquals(width, square.getWidth());
		square.draw();
		System.out.println("\n");
		width = 10;
		square.setWidth(width);
		assertTrue(square.getHeight() == square.getWidth());
		assertEquals(width, square.getWidth());
		square.draw();
		
	}

}

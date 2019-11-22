package decoratorpattern.implementedclasses;

import decoratorpattern.interfaces.Shape;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}

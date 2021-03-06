package aopTest.vo;

import org.springframework.stereotype.Component;

@Component
public class Triangle {

	private String name;
	private int width;
	private int height;
	
	public Triangle() {
		
	}

	public Triangle(String name, int width, int height) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		return width*height/2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [name=" + name + ", width=" + width + ", height=" + height + "]";
	}
}

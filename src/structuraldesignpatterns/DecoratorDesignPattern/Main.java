package structuraldesignpatterns.DecoratorDesignPattern;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Pizza pizza = new JalepenoDecorator(new CheeseDecorator(new BasePizza()));
		System.out.println(pizza.bake());
		
		//Exapmle for Decorator design pattern

		InputStream stream = new FileInputStream("C:\\Users\\vnsee\\OneDrive\\Documents\\demofile.txt");
		System.out.println("stream is -> " + stream);
		InputStream inputStream = new BufferedInputStream(stream);
		System.out.println("BufferedInputStream is -> " + inputStream);
		InputStream dataStream = new DataInputStream(inputStream);
		System.out.println("DataInputStream is -> " + dataStream);

	}
}

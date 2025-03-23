package designpatterns.AbstractFactoryMethod;


/**
 * Families of objects creation is called abstract factory method
  	ApplicationContext is the Abstract Factory.
	AnnotationConfigApplicationContext is the Concrete Factory.
	Vehicle is the Abstract Product.
	Car and Bike are Concrete Products.
	The client (Main) just requests a Vehicle from the factory using getBean(), without worrying about how it's created.
 */
interface CarFactory {
	
	Car createCar();
	
	CarSpecification createSpecification();

}

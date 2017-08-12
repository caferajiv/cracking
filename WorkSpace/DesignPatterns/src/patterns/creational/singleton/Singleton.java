package patterns.creational.singleton;

public class Singleton {
	private static Singleton singleton;

	private Singleton() {
	}

	// return only one spooler instance
	public static synchronized Singleton getInstance() 
	{
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) // if none created
					singleton = new Singleton(); // create one
			}
		}
		return singleton; // return it
	}

	public void print(String s) {
		System.out.println(s);
	}
}

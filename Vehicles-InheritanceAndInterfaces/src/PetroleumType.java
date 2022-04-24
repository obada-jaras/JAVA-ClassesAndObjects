
public class PetroleumType {
	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;
	private static double gasolinePrice;
	private static double dieselPrice;


	
	//constructors 
	public PetroleumType() {
	}

	public PetroleumType(double gasolinePrice, double dieselPrice) {
		super();
		PetroleumType.gasolinePrice = gasolinePrice;
		PetroleumType.dieselPrice = dieselPrice;
	}
	//**end constructors
	
	
	
	
	//setters and getters
	public static int getDIESEL() {
		return DIESEL;
	}

	public static int getGASOLINE() {
		return GASOLINE;
	}

	public static double getGasolinePrice() {
		return gasolinePrice;
	}

	public static void setGasolinePrice(double gasolinePrice) {
		PetroleumType.gasolinePrice = gasolinePrice;
	}

	public static double getDieselPrice() {
		return dieselPrice;
	}

	public static void setDieselPrice(double dieselPrice) {
		PetroleumType.dieselPrice = dieselPrice;
	}
	//end setters and getters
	
}

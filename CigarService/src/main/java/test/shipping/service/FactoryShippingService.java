package test.shipping.service;

public class FactoryShippingService {
	
	public static final String FREIGHT_MOVERS_CODE = "FM"; 
	
	public static final String INTERNAT_SHIPPING = "IS";
	
	private static final FactoryShippingService INSTANCE = new FactoryShippingService();
	
	private FactoryShippingService(){
		super();
	}
	
	public static FactoryShippingService getInstance(){
		return INSTANCE;
	}
	
	public IShippingService createShippingService(final String shippingCode){
		IShippingService shippingService = null;
		if (FREIGHT_MOVERS_CODE.equals(shippingCode)){
			shippingService = new FreightMoversServiceImpl();
		}else if (INTERNAT_SHIPPING.equals(shippingCode)){
			shippingService = new InternatShippingServiceImpl();
		}
		return shippingService;
		
	}
	
	

}

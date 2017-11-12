package test.shipping.service;

import test.certif.entity.Address;

//Adapter
public class InternatShippingServiceImpl implements IShippingService{

	@Override
	public boolean sendShippingRequest(Address from, Address to, String reference) {
		System.out.println("International shipping send your package "+reference);
		System.out.println("Adresse :"+to.getAdress());
		return true;
	}

}

package com.mtit.serviceSewmi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
	ServiceRegistration billingServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Billing Service (Producer) Starting....");
		BillingService billingService = new BillingServiceImpl();
		
		billingServiceRegistration = context.registerService(BillingService.class.getName(), billingService, null);
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Billing Service Stopping.....");
		billingServiceRegistration.unregister();
	}

}

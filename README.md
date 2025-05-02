Billing Service - Restaurant Order Management System


Overview

The Billing Service is a Producer module in the Restaurant Order Management System, built using the Open Service Gateway Initiative (OSGi) architecture. This service is responsible for generating bills once an order is marked as "Ready for Delivery." It plays a critical role in ensuring accurate billing by calculating the order total, applying taxes, and confirming payment details.
This module operates within a modular OSGi ecosystem, publishing its services for Consumers (like the Cashier Consumer) to subscribe to, ensuring loose coupling and scalability in the system.


Functionality

Bill Generation: Automatically generates a bill when an order is marked as "Ready for Delivery."
Billing Details: Calculates and provides details such as:
Order total
Applicable taxes
Payment confirmation


Project Structure

Sewmi_BillingService/src: Contains the source code for the Billing Service.
com.mtit.serviceSewmi/BillingService.java: Interface defining the billing service.
com.mtit.serviceSewmi/BillingServiceImpl.java: Implementation of the billing logic.
ServiceActivator.java: OSGi activator for registering the service.


Setup and Usage

Ensure you have an OSGi framework installed (e.g., Apache Felix or Equinox).
Clone the repository and navigate to the Sewmi_BillingService directory.
Build the module using the provided build.properties file.
Deploy the bundle in your OSGi framework.
The service will automatically register and be available for Consumers to subscribe to.


Dependencies

Java SE 1.8
OSGi Framework (e.g., Apache Felix)


Future Enhancements

Support for multiple tax rates based on location.
Integration with online payment gateways.

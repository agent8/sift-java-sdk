package com.easilydo.sift.model;

import java.util.HashMap;
import java.util.Map;

import com.easilydo.sift.model.gen.*;

public enum Domain {
	UNKNOWN(0, "unknown", null),
	PURCHASE(1, "purchase", Order.class),
	SHIPMENT(2, "shipment", ParcelDelivery.class),
	BILL(3, "bill", Invoice.class),
	EVENT(4, "event", EventReservation.class),
	RESTAURANT(5, "restaurant", FoodEstablishmentReservation.class),
	HOTEL(6, "hotel", LodgingReservation.class),
	TRAIN(7, "train", TrainReservation.class),
	DEAL(8, "deal", Deal.class),
	CONTACT(9, "contact", Contact.class),
	CAR_RENTAL(10, "rentalcar", RentalCarReservation.class),
	FLIGHT(11, "flight", FlightReservation.class),
	BOARDING_PASS(12, "boardingpass", FlightReservation.class),
	REMINDER(13, "reminder", Reminder.class),
	CRUISE(14, "cruise", LodgingReservation.class);

	public final int id;
	public final String name;
	public final Class clazz;
	private static Map<String, Domain> constants = new HashMap<String, Domain>();

	static {
		for (Domain d: values()) {
			constants.put(d.name, d);
		}
	}

	Domain(int id, String name, Class clazz) {
		this.id = id;
		this.name = name;
		this.clazz = clazz;
	}

	public static Domain getDomain(String type) {
		return constants.get(type);
	}
}

package com.easilydo.sift.model;

import java.util.HashMap;
import java.util.Map;

public enum ShipmentStatus {
	DELIVERED("http://schema.org/OrderDelivered"),
	IN_TRANSIT("http://schema.org/OrderInTransit"),
	PICKUP_AVAILABLE("http://schema.org/OrderPickupAvailable");

	private final String name;
	private static Map<String, ShipmentStatus> constants = new HashMap<String, ShipmentStatus>();

	static {
		for (ShipmentStatus s: values()) {
			constants.put(s.name, s);
		}
	}

	ShipmentStatus(String name) {
		this.name = name;
	}

	public static ShipmentStatus getShipmentStatus(String type) {
		return constants.get(type);
	}
}

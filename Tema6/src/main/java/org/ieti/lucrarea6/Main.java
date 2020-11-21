package org.ieti.lucrarea6;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		SubscriptionPlan plan = new SubscriptionPlan(27, "Plan D");
		FileUtility.writeToFile(plan);

		SubscriptionPlan subscriptionPlan = FileUtility.readFromFile();
		assert subscriptionPlan != null;
		System.out.println(subscriptionPlan.toString());

	}
}

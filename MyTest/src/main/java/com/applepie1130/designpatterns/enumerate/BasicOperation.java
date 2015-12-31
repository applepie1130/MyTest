package com.applepie1130.designpatterns.enumerate;

public enum BasicOperation implements Operation {
	
	PLUS("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		public double apply(double x, double y) {
			return x - y;
		}
	},
	DIVIDE("/") {
		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	},
	MULTI("*") {
		@Override
		public double apply(double x, double y) {
			return x * y;
		}
	};
	
	private final String symbol;

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}

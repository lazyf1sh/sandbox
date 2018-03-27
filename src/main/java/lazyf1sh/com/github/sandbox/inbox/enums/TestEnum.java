package com.github.lazyf1sh.sandbox.enums;

public enum TestEnum {
	TEST("strTestCustomValue");

	private String test;

	private TestEnum(String test) {
		this.test = test;
	}

	public String getValue() {
		return this.test;
	}
}

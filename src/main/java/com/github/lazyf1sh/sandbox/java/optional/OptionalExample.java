//package com.github.lazyf1sh.sandbox.java.optional;
//
//import static org.junit.Assert.*;
//
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import org.junit.Test;
//
///*
// * https://www.baeldung.com/java-optional
// * Optional as a single-value container that either contains a value or doesn't (it is then said to be "empty").
// * Optional is a class that encapsulates an optional value.
// * Optional should help us to avoid such unforeseen exceptions
// *
// */
//public class OptionalExample
//{
//	@Test
//	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
//	    String name = "baeldung";
//	    Optional.of(name);
//	}
//
//	@Test
//	public void givenNonNull_whenCreatesOptional_thenCorrect() {
//	    String name = "baeldung";
//	    Optional<String> opt = Optional.of(name);
//	    assertEquals("Optional[baeldung]", opt.toString());
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
//	    String name = null;
//	    Optional<String> opt = Optional.of(name);
//	}
//
//	@Test
//	public void givenNonNull_whenCreatesNullable_thenCorrect() {
//	    String name = "baeldung";
//	    Optional<String> opt = Optional.ofNullable(name);
//	    assertEquals("Optional[baeldung]", opt.toString());
//	}
//
//	@Test
//	public void givenNull_whenCreatesNullable_thenCorrect() {
//	    String name = null;
//	    Optional<String> opt = Optional.ofNullable(name);
//	    assertEquals("Optional.empty", opt.toString());
//	}
//
//	@Test
//	public void givenOptional_whenIsPresentWorks_thenCorrect() {
//	    Optional<String> opt = Optional.of("Baeldung");
//	    assertTrue(opt.isPresent());
//
//	    opt = Optional.ofNullable(null);
//	    assertFalse(opt.isPresent());
//	}
//
//	@Test
//	public void whenOrElseWorks_thenCorrect() {
//	    String nullName = null;
//	    String name = Optional.ofNullable(nullName).orElse("john");
//	    assertEquals("john", name);
//	}
//
//	@Test
//	public void givenOptional_whenIfPresentWorks_thenCorrect() {
//	    Optional<String> opt = Optional.of("baeldung");
//
//	    opt.ifPresent(name -> System.out.println(name.length()));
//	}
//
//	@Test
//	public void whenOrElseGetWorks_thenCorrect() {
//	    String nullName = null;
//	    String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
//	    assertEquals("john", name);
//	}
//
//	public String getMyDefault() {
//	    System.out.println("Getting Default Value");
//	    return "Default Value";
//	}
//
//	//@Test
//	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
//	    String text = null;
//
//	    System.out.println("Using orElseGet:");
//	    String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
//	    assertEquals("Default Value", defaultText);
//
//	    System.out.println("Using orElse:");
//	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
//	    assertEquals("Default Value", defaultText);
//	}
//
//	@Test
//	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
//	    String text = "Text present";
//
//	    System.out.println("Using orElseGet:");
//	    String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
//	    assertEquals("Text present", defaultText);
//
//	    System.out.println("Using orElse:");
//	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
//	    assertEquals("Text present", defaultText);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void whenOrElseThrowWorks_thenCorrect() {
//	    String nullName = null;
//	    String name = Optional.ofNullable(nullName).orElseThrow(
//	      IllegalArgumentException::new);
//	}
//
//	@Test
//	public void givenOptional_whenGetsValue_thenCorrect() {
//	    Optional<String> opt = Optional.of("baeldung");
//	    String name = opt.get();
//
//	    assertEquals("baeldung", name);
//	}
//
//	@Test(expected = NoSuchElementException.class)
//	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
//	    Optional<String> opt = Optional.ofNullable(null);
//	    String name = opt.get();
//	}
//
//}

package com.kodilla.collections.adv.maps.schools;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Principal test suite")
class PrincipalTestSuite {

    @Test
    @DisplayName("should create principal with valid names")
    void testCreatePrincipal() {
        //given & when
        Principal principal = new Principal("Anna", "Kowalska");

        //then
        assertEquals("Anna", principal.getFirstname());
        assertEquals("Kowalska", principal.getLastname());
    }

    @Test
    @DisplayName("should throw NullPointerException when firstname is null")
    void testNullFirstname() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Principal(null, "Kowalska"));
    }

    @Test
    @DisplayName("should throw NullPointerException when lastname is null")
    void testNullLastname() {
        //given & when & then
        assertThrows(NullPointerException.class, () -> new Principal("Anna", null));
    }

    @Test
    @DisplayName("should be equal when names match")
    void testEqualPrincipals() {
        //given
        Principal principal1 = new Principal("Anna", "Kowalska");
        Principal principal2 = new Principal("Anna", "Kowalska");

        //when & then
        assertEquals(principal1, principal2);
        assertEquals(principal1.hashCode(), principal2.hashCode());
    }

    @Test
    @DisplayName("should not be equal when firstname differs")
    void testNotEqualDifferentFirstname() {
        //given
        Principal principal1 = new Principal("Anna", "Kowalska");
        Principal principal2 = new Principal("Maria", "Kowalska");

        //when & then
        assertNotEquals(principal1, principal2);
    }

    @Test
    @DisplayName("should not be equal when lastname differs")
    void testNotEqualDifferentLastname() {
        //given
        Principal principal1 = new Principal("Anna", "Kowalska");
        Principal principal2 = new Principal("Anna", "Nowak");

        //when & then
        assertNotEquals(principal1, principal2);
    }

    @Test
    @DisplayName("should return readable toString")
    void testToString() {
        //given
        Principal principal = new Principal("Anna", "Kowalska");

        //when
        String result = principal.toString();

        //then
        assertTrue(result.contains("Anna"));
        assertTrue(result.contains("Kowalska"));
    }
}

/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZonaTests {

    @Test
    @DisplayName("Verifica o método checaSensores - Caso 1")
    // Caso 1 - para o caso Estado.FOGO, 2 Sensores de Incendio indicando fogo, Zona
    // não Crítica, 1
    // Sprinkler
    // Resultado esperado -> True

    public void checaSensorFogoCaso1() {

        System.out.println("Instanciando os sensores de Incendio");
        Incendio sensorIncendio1 = new Incendio(true);
        Incendio sensorIncendio2 = new Incendio(true);
        List<Sensor> sensores = Arrays.asList(sensorIncendio1, sensorIncendio2);

        System.out.println("Instanciando atuadores (sprinklers)");
        Sprinkler atuadorSprinkler = new Sprinkler(1, false);
        List<Atuador> atuadores = Arrays.asList(atuadorSprinkler);

        System.out.println("Instanciando Zona");
        Zona zonaTest = new Zona(1, false, sensores, atuadores);

        System.out.println("Testando o método");
        assertEquals(true, zonaTest.checaSensores(), "Deve retornar True.");
        System.out.println("Finalizado.");
    }

    @Test
    @DisplayName("Verifica o método checaSensores - Caso 2")
    // Caso 2 - para o caso Estado.SEM_FOGO, 2 Sensores de Incendio indicando sem
    // fogo, Zona não
    // Crítica, 1
    // Sprinkler
    // Resultado esperado -> False

    public void checaSensorFogoCaso2() {

        System.out.println("Instanciando os sensores de Incendio");
        Incendio sensorIncendio1 = new Incendio(false);
        Incendio sensorIncendio2 = new Incendio(false);
        List<Sensor> sensores = Arrays.asList(sensorIncendio1, sensorIncendio2);

        System.out.println("Instanciando atuadores (sprinklers)");
        Sprinkler atuadorSprinkler = new Sprinkler(1, false);
        List<Atuador> atuadores = Arrays.asList(atuadorSprinkler);

        System.out.println("Instanciando Zona");
        Zona zonaTest = new Zona(1, false, sensores, atuadores);

        System.out.println("Testando o método");
        assertEquals(false, zonaTest.checaSensores(), "Deve retornar False.");
        System.out.println("Finalizado.");
    }
}

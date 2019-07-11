package com.pandero.demo;

import com.pandero.demo.entities.Turno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void testFullLeaderboard() {
		List<Turno> lista = new ArrayList<>();

		Turno turno1 = new Turno();
		turno1.setId(1L);
		turno1.setFechaIngreso(LocalDateTime.of(2019, Month.JULY, 7, 18, 40, 20));

		Turno turno2 = new Turno();
		turno2.setId(2L);
		turno2.setFechaIngreso(LocalDateTime.of(2019, Month.JULY, 7, 18, 40, 22));

		Turno turno3 = new Turno();
		turno3.setId(3L);
		turno3.setFechaIngreso(LocalDateTime.of(2019, Month.JULY, 7, 18, 40, 21));

		lista.add(turno3);
		lista.add(turno2);
		lista.add(turno1);

		lista.sort((Turno h1, Turno h2) -> h1.getFechaIngreso().compareTo(h2.getFechaIngreso()));

		lista.forEach(System.out::println);
		//System.out.println(Arrays.toString(lista.toArray()));

	}



}

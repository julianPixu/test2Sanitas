package com.mycorp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycorp.models.CorreoElectronico;
import com.mycorp.models.FicheroAdjunto;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
public class RealizarSimulacionTest extends TestCase {
	
	CorreoElectronico correoElectronico = new CorreoElectronico(1L, "Julian");
	FicheroAdjunto ficheroAdjuntoMock; 
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testSetAdjuntos() {
    	ficheroAdjuntoMock = mock(FicheroAdjunto.class);
		when(ficheroAdjuntoMock.getNombre())
			.thenReturn("Pepito");
		when(ficheroAdjuntoMock.getContenido())
			.thenReturn(("Contenido del fichero prueba").getBytes());
		
		correoElectronico.addAdjunto(ficheroAdjuntoMock);
		
		assertEquals(correoElectronico.getAdjuntos().size(),1);
		assertEquals(correoElectronico.getAdjuntos().get(0), ficheroAdjuntoMock);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.devsu.test.microservicioclientes.clientes.MsClientesApp;
import com.devsu.test.microservicioclientes.clientes.entity.Cliente;
import com.devsu.test.microservicioclientes.clientes.entity.Persona;
import com.devsu.test.microservicioclientes.clientes.service.ClienteService;
import com.devsu.test.microservicioclientes.clientes.service.PersonaService;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Ana Luisa Ruano Espina <a href="mailto:annaruanoespina@gmail.com">Ana
 * Ruano</a>
 */
@SpringBootTest(classes = MsClientesApp.class)
public class PersonaServiceTest {

    /**
     * Servicio de persona
     */
    @Autowired
    PersonaService service;

    /**
     * Servicio de persona
     */
    @Autowired
    ClienteService serviceCliente;

    @Test
    void CrearPersonaCliente() {
        System.out.println("CrearPersonaCliente ");
        Persona persona = new Persona();
        Integer correlativo = 0;
        System.out.println("correlativo " + correlativo);
        persona.setNombre("Ana Ruano");
        persona.setDireccion("Direccion de prueba");
        persona.setEdad(Short.valueOf("34"));
        persona.setGenero("F");
        persona.setIdentificacion("ABCD123" + correlativo);
        persona.setTelefono("12345678");
        persona.setIdPersona(Long.valueOf(correlativo));
        Persona creado = service.crear(persona);
        if (creado != null) {
            System.out.println("se creo la persona " + creado.getIdPersona());
            Integer correlativoCliente = 0;
            System.out.println("correlativoCliente " + correlativoCliente);
            Cliente cliente = new Cliente();
            cliente.setContrasena("password");
            cliente.setIdPersona(creado);
            cliente.setIdCliente("AB002" + correlativoCliente);
            cliente.setIdentificador(Long.valueOf(correlativoCliente));
            cliente.setEstado('1');

            Cliente cCreado = serviceCliente.crear(cliente);
            if (cCreado == null) {
                System.out.println("no se creo el cliente");
            } else {
                System.out.println("se creo el cliente");
            }
        } else {
            System.out.println("no se creo la persona");
        }

        assertNotNull(creado);

    }

}

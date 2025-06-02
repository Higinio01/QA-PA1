import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioNominaTest {

    /**
     * Test para verificar que el método calcularSalario calcula correctamente el salario
     * de un empleado FULL_TIME sin horas extra.
     */
    @Test
    public void calcularSalario_SinHorasExtra_DeberiaRetornarPagoBase() {
        Empleado empleado = new Empleado("Ana", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 38);

        assertEquals(7600.0, salario);
    }


    /**
     * Test para verificar que el método calcularSalario calcula correctamente el salario
     * de un empleado FULL_TIME con horas extra.
     */
    @Test
    public void calcularSalario_ConHorasExtra_DeberiaPagarHorasExtraSoloFullTime() {
        Empleado empleado = new Empleado("Luis", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 45);

        assertEquals(9500.0, salario);
    }

    /**
     * Test para verificar que el método calcularSalario calcula correctamente el salario
     * de un empleado PART_TIME sin horas extra.
     */
    @Test
    public void calcularSalario_PART_TIME_NoDebePagarHorasExtra() {
        Empleado empleado = new Empleado("Mario", TipoEmpleado.PART_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 45);

        assertEquals(9000.0, salario);
    }
}

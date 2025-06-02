import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioNominaTest {

    @Test
    public void calcularSalario_SinHorasExtra_DeberiaRetornarPagoBase() {
        Empleado empleado = new Empleado("Ana", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalarioSemanal(empleado, 38);

        assertEquals(7600.0, salario);  // 38 * 200
    }

    @Test
    public void calcularSalario_ConHorasExtra_DeberiaPagarHorasExtraSoloFullTime() {
        Empleado empleado = new Empleado("Luis", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        // 40h normales + 5h extra con 1.5x: (40 * 200) + (5 * 200 * 1.5) = 8000 + 1500 = 9500
        double salario = servicio.calcularSalarioSemanal(empleado, 45);

        assertEquals(9500.0, salario);
    }

    @Test
    public void calcularSalario_PART_TIME_NoDebePagarHorasExtra() {
        Empleado empleado = new Empleado("Mario", TipoEmpleado.PART_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        // No se pagan horas extra: 45 * 200 = 9000
        double salario = servicio.calcularSalarioSemanal(empleado, 45);

        assertEquals(9000.0, salario);
    }
}

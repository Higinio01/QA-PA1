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
        double salario = servicio.calcularSalario(empleado, 38);

        assertEquals(7600.0, salario);
    }
}

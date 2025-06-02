
import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioNominaTest {

    @Test
    public void calcularSalario_SinHorasExtra_DeberiaRetornarPagoBase() {
        Empleado empleado = new Empleado("Ana", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 38);
        assertEquals(7600.0, salario);
    }

    @Test
    public void calcularSalario_ConHorasExtra_DeberiaPagarHorasExtraSoloFullTime() {
        Empleado empleado = new Empleado("Luis", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 45);
        assertEquals(10000.0, salario);
    }

    @Test
    public void calcularSalario_PART_TIME_NoDebePagarHorasExtra() {
        Empleado empleado = new Empleado("Mario", TipoEmpleado.PART_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 45);
        assertEquals(9500.0, salario); // 45 * 200
    }

    @Test
    public void calcularSalario_DeberiaLanzarExcepcionPorHorasNegativas() {
        Empleado empleado = new Empleado("Julia", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        assertThrows(IllegalArgumentException.class, () ->
                servicio.calcularSalario(empleado, -5));
    }

    @Test
    public void calcularSalario_DeberiaLanzarExcepcionSiEmpleadoEsNulo() {
        ServicioNomina servicio = new ServicioNomina();
        assertThrows(IllegalArgumentException.class, () ->
                servicio.calcularSalario(null, 40));
    }

    @Test
    public void calcularSalario_DeberiaIncluirBonoPorPuntualidadSiTrabajaMasDe38Horas() {
        Empleado empleado = new Empleado("Pedro", TipoEmpleado.FULL_TIME, 200.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 39); // 39*200 + 500
        assertEquals(8300.0, salario);
    }

    @Test
    public void calcularSalario_DeberiaLanzarExcepcionSiExcedeLimiteYNoEstaAutorizado() {
        Empleado empleado = new Empleado("Carlos", TipoEmpleado.FULL_TIME, 600.0, false);
        ServicioNomina servicio = new ServicioNomina();
        assertThrows(IllegalArgumentException.class, () ->
                servicio.calcularSalario(empleado, 40)); // 600*40 = 24,000
    }

    @Test
    public void calcularSalario_DeberiaPermitirExcesoSiEstaAutorizado() {
        Empleado empleado = new Empleado("Autorizado", TipoEmpleado.FULL_TIME, 600.0, true);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularSalario(empleado, 40);
        assertEquals(24500.0, salario);
    }
}

import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioNominaTest {

    private ServicioNomina servicio;

    @BeforeEach
    void setUp() {
        servicio = new ServicioNomina();
    }

    // Empleado full time sin horas extra ni bono
    @Test
    void calcularSalario_Juan_fullTime_30horas() {
        Empleado e = new Empleado("Juan", TipoEmpleado.FULL_TIME, 400, true);
        double salario = servicio.calcularSalarioSemanal(e, 30);
        assertEquals(12000, salario);
    }

    // Empleado full time justo por debajo del umbral de bono
    @Test
    void calcularSalario_Luis_fullTime_38horas_sinBono() {
        Empleado e = new Empleado("Luis", TipoEmpleado.FULL_TIME, 400, true);
        double salario = servicio.calcularSalarioSemanal(e, 38);
        assertEquals(15200, salario);
    }

    // Empleado part time sin bono ni horas extra
    @Test
    void calcularSalario_Ana_partTime_35horas() {
        Empleado e = new Empleado("Ana", TipoEmpleado.PART_TIME, 350, true);
        double salario = servicio.calcularSalarioSemanal(e, 35);
        assertEquals(12250, salario);
    }

    // Empleado part time con bono
    @Test
    void calcularSalario_Sofia_partTime_39horas_conBono() {
        Empleado e = new Empleado("Sofia", TipoEmpleado.PART_TIME, 450, true);
        double salario = servicio.calcularSalarioSemanal(e, 39);
        assertEquals(18050, salario);
    }

    // Empleado full time con 2 horas extra y bono
    @Test
    void calcularSalario_Carlos_fullTime_42horas_conExtrasYBono() {
        Empleado e = new Empleado("Carlos", TipoEmpleado.FULL_TIME, 400, true);
        double salario = servicio.calcularSalarioSemanal(e, 42);
        assertEquals(17700, salario);
    }

    // Empleado full time con 1 hora extra y bono
    @Test
    void calcularSalario_Mario_fullTime_41horas_conExtrasYBono() {
        Empleado e = new Empleado("Mario", TipoEmpleado.FULL_TIME, 450, true);
        double salario = servicio.calcularSalarioSemanal(e, 41);
        assertEquals(19175, salario);
    }

    // Empleado full time con 3 horas extra y bono
    @Test
    void calcularSalario_Luisa_fullTime_43horas_conExtrasYBono() {
        Empleado e = new Empleado("Luisa", TipoEmpleado.FULL_TIME, 390, true);
        double salario = servicio.calcularSalarioSemanal(e, 43);
        assertEquals(17855, salario);
    }

    // Salario total excede el límite sin autorización
    @Test
    void calcularSalario_excedeTopeSinAutorizacion_lanzaExcepcion() {
        Empleado e = new Empleado("Pedro", TipoEmpleado.FULL_TIME, 600, false);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            servicio.calcularSalarioSemanal(e, 40);
        });
        assertEquals("El salario excede el limite sin autorización.", ex.getMessage());
    }

    // Horas trabajadas negativas
    @Test
    void calcularSalario_horasNegativas_lanzaExcepcion() {
        Empleado e = new Empleado("Laura", TipoEmpleado.PART_TIME, 300, true);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            servicio.calcularSalarioSemanal(e, -5);
        });
        assertEquals("Horas no pueden ser negativas.", ex.getMessage());
    }

}

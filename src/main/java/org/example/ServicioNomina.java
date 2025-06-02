package org.example;

public class ServicioNomina {

    /**
     * Calcula el salario de un empleado basado en su tipo y horas trabajadas.
     * @param empleado
     * @param horasTrabajadas
     * @return
     */
    public double calcularSalario(Empleado empleado, int horasTrabajadas) {
        double tarifa = empleado.getTarifaPorHora();

        if (empleado.getTipo() == TipoEmpleado.FULL_TIME) {
            int horasNormales = Math.min(horasTrabajadas, 40);
            int horasExtra = Math.max(horasTrabajadas - 40, 0);
            return (horasNormales * tarifa) + (horasExtra * tarifa * 1.5);
        } else {
            return horasTrabajadas * tarifa;
        }
    }
}


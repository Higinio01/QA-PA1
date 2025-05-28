package org.example;

public class ServicioNomina {

    private static final double MAX_SALARIO_SIN_AUTORIZACION = 20000;
    private static final double BONO_PUNTUALIDAD = 500;
    private static final int HORAS_EXTRA_LIMITE = 40;
    private static final int BONO_HORAS_LIMITE = 38;

    public double calcularSalarioSemanal(Empleado empleado, int horasTrabajadas) {
        if (empleado == null) throw new IllegalArgumentException("Empleado no puede ser nulo.");
        if (horasTrabajadas < 0) throw new IllegalArgumentException("Horas no pueden ser negativas.");

        double salario = 0;
        double tarifa = empleado.getTarifaPorHora();

        if (empleado.getTipo() == TipoEmpleado.FULL_TIME) {
            int horasNormales = Math.min(horasTrabajadas, HORAS_EXTRA_LIMITE);
            int horasExtra = Math.max(horasTrabajadas - HORAS_EXTRA_LIMITE, 0);
            salario = horasNormales * tarifa + horasExtra * tarifa * 1.5;
        } else {
            salario = horasTrabajadas * tarifa;
        }

        if (horasTrabajadas > BONO_HORAS_LIMITE) {
            salario += BONO_PUNTUALIDAD;
        }

        if (salario > MAX_SALARIO_SIN_AUTORIZACION && !empleado.isAutorizado()) {
            throw new IllegalArgumentException("El salario excede el limite sin autorización.");
        }

        return salario;
    }
}

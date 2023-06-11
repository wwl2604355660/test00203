package com.springmvc.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wwl
 * @create 2023-05-04 16:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complex {
    private double real;
    private double imag;

    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new Complex(newReal, newImag);
    }

    public Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImag = this.imag - other.imag;
        return new Complex(newReal, newImag);
    }

    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imag * other.imag;
        double newImag = this.real * other.imag + this.imag * other.real;
        return new Complex(newReal, newImag);
    }

    public Complex divide(Complex other) {
        double denominator = Math.pow(other.real, 2) + Math.pow(other.imag, 2);
        double newReal = (this.real * other.real + this.imag * other.imag) / denominator;
        double newImag = (this.imag * other.real - this.real * other.imag) / denominator;
        return new Complex(newReal, newImag);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }
}

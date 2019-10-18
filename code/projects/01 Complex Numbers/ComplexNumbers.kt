import kotlin.math.abs
import kotlin.math.sqrt

class ComplexNumber(var real: Int = 0, var imaginary: Int = 0) {


    fun getRealPart(): Int {
        return this.real
    }

    fun getImaginaryPart(): Int {
        return this.imaginary
    }

    override fun toString(): String {
        val imaginaryFinal = if (this.imaginary < 0) "${this.imaginary}" else "+${this.imaginary}"
        return "${this.real}${imaginaryFinal}i"
    }

    fun plus(complex: ComplexNumber): ComplexNumber {
        val finalReal = this.real + complex.real
        val finalImaginary = this.imaginary + complex.imaginary
        return ComplexNumber(finalReal, finalImaginary)
    }

    fun times(complex: ComplexNumber): ComplexNumber {
        val first = this.real * complex.real
        val outer = this.real * complex.imaginary
        val inner = this.imaginary * complex.real
        val last = this.imaginary * complex.imaginary
        return ComplexNumber((first - last), (outer + inner))
    }

    fun times(n: Int) = ComplexNumber(this.real*n, this.imaginary*n)

    fun pow(x: Int): ComplexNumber {
        if (x <= 0) {
            throw Exception("The value of x cannot be less than or equal to 0")
        }

        if (x == 1) {
            return this
        }

        var finalComplexNumber = ComplexNumber()

        for (i in 0 until x-1) {
            if (i == 0) {
                finalComplexNumber = this.times(this)
            } else {
                finalComplexNumber = finalComplexNumber.times(this)
            }
        }

        return finalComplexNumber
    }

    fun getModulus() = sqrt(((this.real*this.real) + (this.imaginary*this.imaginary)).toDouble())

    fun getConjugate(): ComplexNumber {
        var finalComplex = ComplexNumber()
        if (this.imaginary > 0) {
            finalComplex = ComplexNumber(this.real, -this.imaginary)
        } else {
            finalComplex = ComplexNumber(this.real, abs(this.imaginary))
        }
        return finalComplex
    }

    override fun equals(x: Any?): Boolean {
        if (x is ComplexNumber) {
            if (this.real == x.real && this.imaginary == x.imaginary) {
                return true
            }
            return false
        }
        return false
    }

    override fun hashCode(): Int {
        var result = this.real
        result = 31 * result + this.imaginary
        return result
    }

}
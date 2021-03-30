class Matriz(
    val ROW: Int,
    val COL: Int,
    val MATRIZ: Array<IntArray> = Array(ROW) { IntArray(COL) }
) {

    companion object {

        fun requestData(matriz: Matriz): Array<Int> {
            val size = matriz.ROW * matriz.COL
            val data = IntArray(size)
            var cont = 0
            var input = 0

            println("RELLENAR MATRIZ")

            for (n in 0 until matriz.MATRIZ.size) {
                for (g in 0 until matriz.MATRIZ.size) {
                    print("MATRIZ [$n] [$g] -> ")
                    input = readLine().toString().toInt()
                    data[cont] = input
                    cont++
                }
            }
            return data.toTypedArray()
        }
    }


    private fun toIntArray(): IntArray {

        val aux = IntArray(ROW * COL)
        var c = 0

        for (n in 0 until MATRIZ.size) {
            for (g in 0 until MATRIZ.size) {
                aux.set(c, MATRIZ[n][g])
                c++
            }
        }
        return aux
    }

    private fun simetricos(matriz: Matriz) = (ROW == matriz.ROW && COL == matriz.COL)

    fun llenarMatriz(data: Array<Int>) {

        var cont = 0

        for (i in 0 until ROW) {
            for (j in 0 until ROW) {
                MATRIZ[i][j] = data.get(cont)
                cont++
            }
        }
    }

    fun sumar(matriz: Matriz): Matriz {

        if (this.simetricos(matriz)) {

            val dataMatriz1 = this.toIntArray()
            val dataMatriz2 = matriz.toIntArray()
            val dataSuma = IntArray(ROW * COL)
            var c = 0

            for (s in 0 until ROW * COL) {
                dataSuma.set(c, (dataMatriz1[s] + dataMatriz2[s]))
                c++
            }

            val resultMatriz = Matriz(ROW, COL)
            resultMatriz.llenarMatriz(dataSuma.toTypedArray())

            return resultMatriz

        } else throw ArithmeticException("No Coinciden en tamaño")
    }

    fun restar(matriz: Matriz): Matriz {

        if (this.simetricos(matriz)) {

            val dataMatriz1 = this.toIntArray()
            val dataMatriz2 = matriz.toIntArray()
            val dataResta = IntArray(ROW * COL)
            var c = 0

            for (s in 0 until ROW * COL) {
                dataResta.set(c, (dataMatriz1[s] - dataMatriz2[s]))
                c++
            }

            val resultMatriz = Matriz(ROW, COL)
            resultMatriz.llenarMatriz(dataResta.toTypedArray())

            return resultMatriz

        } else throw ArithmeticException("No Coinciden en tamaño")
    }

    fun multiplicarMatriz(matriz: Matriz) : Matriz{

        if(COL <= matriz.ROW){

            val matrizResultante = Matriz(ROW,matriz.COL)
            val producto = IntArray(ROW*matriz.COL)
            var aux = 0
            var cont = 0

            for (i in 0 until ROW) {
                for (j in 0 until matriz.ROW) {
                    aux = 0
                    for (k in 0 until ROW) {
                        aux += MATRIZ[i][k] * matriz.MATRIZ[k][j]
                    }
                    producto.set(cont, aux)
                    cont++
                }
            }

            matrizResultante.llenarMatriz(producto.toTypedArray())

            return matrizResultante

        } else throw ArithmeticException("Numero de Columnas mayor al numero de filas que la matriz a multiplicar")
    }

    fun multiplicarEscalar(number: Int): Matriz {

        val dataMatrizResultante = IntArray(ROW * COL)
        val matrizResultante = Matriz(ROW, COL)

        var c = 0
        for (n in 0 until ROW) {
            for (g in 0 until ROW) {
                dataMatrizResultante.set(c, number * (MATRIZ[n][g]))
                c++
            }
        }
        matrizResultante.llenarMatriz(dataMatrizResultante.toTypedArray())
        return matrizResultante
    }

    override fun toString(): String {

        var data = "\n"
        for (i in 0 until MATRIZ.size) {
            for (j in 0 until MATRIZ.size) {
                data += "   |${MATRIZ[i][j]}|  "
           }
            data += "\n"
        }
        return data
    }

} 

## Examen de Test Unitarios

---

### Enunciado

Con el código de este repositorio realiza:

- (*4 puntos*) Los test unitarios de los **dos** métodos, utiliza test **parametrizados**. Suponiendo que la `string` DNI, siempre es un DNI válido.
- (*2 puntos*) En el código, hay un error, ¿lo pudiste comprabar en los test? ¿Plantea la solución?
- (*3 puntos*) Si no hubiera una comprobación previamente encuanto a la longitud de la `string` del DNI, ¿Qué hay que cambiar en los tests para que comprueben estos casos?

Entrega tu repositorio con el código y los test. Además un `Readme` explicando y justificando cada apartado

Formato del `Readme` *1 punto*

---

##  <span style="color: pink;">SAÚL RESPUESTA EXAMEN:</span> 

### SOLUCIÓN A LOS APARTADOS MEDIANTE LOS TEST: 

### 1. Los test unitarios de los **dos** métodos, utiliza test **parametrizados**. Suponiendo que la `string` DNI, siempre es un DNI válido.

### 2. En el código, hay un error, ¿lo pudiste comprabar en los test? ¿Plantea la solución?

### 3. Si no hubiera una comprobación previamente encuanto a la longitud de la `string` del DNI, ¿Qué hay que cambiar en los tests para que comprueben estos casos?

<BR> 

##  <span style="color: lightgreen;">APARTADO 1:</span>

```bash
# REALIZAMOS UN TEST PARA EL METODO comprobarDNI Y ASEGURARNOS DE QUE FUNCIONA CORRECTAMENTE

@ParameterizedTest (name = "Comprobar DNI: {0} {1} => {2}")
    @CsvSource({
      
      // CASOS CORRECTOS 
      
            "00000000, T, true",
            "12345678, Z, true",
            "98765432, K, true",
            "11111111, H, true",
            "53974423, R, true",
            
    // CASOS INCORRECTOS 
    
             "00000000, R, false",
             "12345678, A, false",
            
    //APARTADO 3: CASOS CON LONGITUD DIFERENTE
    
              "0, T, true",
              "123, P, true",
              "123456789, E, true"
    })
    void testComprobarDNI(String dni, char letra, boolean expected) {
        boolean result = Main.comprobarDNI(dni, letra);
        assertEquals(expected, result);
    }
    
    
    
# AHORA VAMOS A REALIZAR UN TEST PARAMETRIZADO PARA EL SEGUUNDO MÉTODO CALCULARLETRA
    
@ParameterizedTest(name = "LETRA DNI: {0} => {1}")
@CsvSource({
  
// EN ESTE TEST PARAMETRIZADO PRIMAREMENTE INTRODUJE CASOS ESTANDAR VÁLIDOS PARA COMPROBAR EN SÍ EL MÉTODO

            "00000000, T",
            "00000001, R",
            "00000002, W",
            "00000003, A",
            "00000004, G",
            "00000005, M",
            "00000006, Y",
            "00000007, F",
            "00000008, P",
            "00000009, D",
            "00000010, X",
            "00000011, B",
            "00000012, N",
            "00000013, J",
            "00000014, Z",
            "00000015, S", // APARTADO 2.
            "00000016, Q", // APARTADO 2.
            
// UN CASO REAL DE UN DNI RANDOM

            "12345678, Z",
            
// APARTADO 3 : CASOS CON DIFERENTES LONGITUDES PARA TESTEAR

            "0, T",
            "123, P",
            
})
    public void testCalcularLetraDNI(String dni, char expected) {
        assertEquals(expected, Main.calcularLetraDNI(dni));
}

```

##  <span style="color: lightgreen;">APARTADO 2:</span>
#### En el código se puede observar un error, se comprueba con los test, al hacer pruebas en donde validaba los casos más estandar con el método calcularLetraDNI, se puede observar que en el caso 15 y en el caso 16 hay un error de posiciones, la letra Q debería de estar en la posición 16 y la S en la 15
```bash
// ARRAY INCORRECTO
char[] letrasDNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','Q','S','V','H','L','C','K','E'};

// ARRAY CORRECTO
char[] letrasDNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
```


##  <span style="color: lightgreen;">APARTADO 3:</span>
#### El código no valida la longitud lo que significa que aceptaría DNIS que en la realidad no sería validos, como el 0T, 123P o el  ( AMBOS CASOS ESTÁN TESTEADOS EN MI TEST.JAVA PARA COMPROBARLO...) pero no afecta al resultado ya que el cálculo de la letra solo depende del valor numerico no de la longitud

```bash
# PARA CORREGIR ESTE ERROR DEBERÍA DE CAMBIARSE EL MÉTODO COMPROBARDNI
 
( Eso sería tan simple como agregar una condición en la que la longitud del dni no puede ser distinto de 8 )
if (dni.length() != 8)
```

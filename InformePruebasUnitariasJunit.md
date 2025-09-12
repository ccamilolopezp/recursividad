# Informe de implementación: Recursividad, pruebas con JUnit y CI/CD con GitHub Actions

## 1. Introducción
En este proyecto se desarrolló un programa en **Java** orientado a demostrar el uso de recursividad en tres niveles: `factorial`, `multiplicación` y `suma`.  
Posteriormente, se construyó un conjunto de pruebas unitarias con **JUnit 5**, incluyendo casos parametrizados y validaciones de tipo y de resultado.  
Finalmente, se integró el repositorio con **GitHub Actions**, definiendo un flujo de integración continua (CI) que separa claramente las etapas de compilación, pruebas, empaquetado y ejecución de la clase principal.  
Adicionalmente, se exploraron herramientas de generación de reportes de pruebas en formato HTML, aunque no se incluyeron en la versión final del pipeline.

---

## 2. Implementación de la función recursiva
El programa implementa la función **factorial** utilizando un esquema de **recursión anidada en tres niveles**:
1. `factorial(n)` se define en términos de una **multiplicación** recursiva.
2. La **multiplicación** se resuelve a través de **sumas recursivas**.
3. La **suma** se convierte en el nivel más básico de la recursión.  

De este modo, se ilustra cómo un problema matemático aparentemente simple puede descomponerse en subproblemas recursivos más elementales.

---

## 3. Pruebas unitarias con JUnit 5
Se diseñaron pruebas unitarias para validar el correcto funcionamiento del algoritmo recursivo. Entre las técnicas utilizadas destacan:
- **Pruebas parametrizadas** con `@ParameterizedTest` y `@CsvSource`, lo que permitió ejecutar automáticamente múltiples casos de prueba con diferentes entradas y resultados esperados.
- **Validaciones de tipo** (`assertInstanceOf`) para garantizar que las funciones retornan los tipos de datos correctos.
- **Validaciones de resultado** (`assertEquals`, `assertThrows`) para verificar la exactitud matemática y el manejo de excepciones en casos inválidos (por ejemplo, factorial de un número negativo).
- Se combinaron enfoques de **pruebas clásicas unitarias** con pruebas más dinámicas mediante **datasets CSV**, incrementando la cobertura y robustez.

---

## 4. Integración continua con GitHub Actions
Se configuró un flujo de CI en GitHub Actions con los siguientes pasos diferenciados:
1. **Compile only**: compila el proyecto sin ejecutar tests.  
2. **Run tests**: ejecuta todas las pruebas unitarias con JUnit y muestra los resultados en consola.  
3. **Package (skip tests)**: empaqueta el proyecto en un archivo `.jar` sin reejecutar las pruebas.  
4. **Run main class**: ejecuta la clase principal (`com.ejemplo.App`) dentro del workflow.  

Esta separación facilita identificar errores en fases específicas y proporciona mayor trazabilidad en los logs.  

---

## 5. Exploración de herramientas de reporte
Durante el desarrollo se exploraron opciones para **generar reportes HTML de pruebas**, lo que hubiera permitido obtener resultados más visuales y detallados.  
Se consideraron librerías y configuraciones adicionales como:
- **Surefire Reports** con salida en HTML.  
- **JUnit Console Launcher** para generar reportes avanzados.  

Sin embargo, en la versión final del pipeline se optó por mantener la salida en **consola estándar**, priorizando la simplicidad y compatibilidad con la integración continua en GitHub Actions.

---

## 6. Conclusiones
- El proyecto permitió aplicar **recursividad en cascada** (factorial → multiplicación → suma) como ejemplo didáctico de descomposición funcional.  
- Las pruebas unitarias con **JUnit 5** demostraron ser flexibles y expresivas, combinando validaciones tradicionales con pruebas parametrizadas basadas en CSV.  
- La configuración de **GitHub Actions** reforzó la importancia de separar las fases del ciclo de construcción (compilación, test, empaquetado, ejecución).  
- Aunque se exploraron herramientas de reporte HTML, se priorizó la simplicidad en la versión final, limitando la salida a logs en consola.  

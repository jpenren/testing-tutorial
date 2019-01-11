# Ejercicio 1

Desarrollar la implementación del servicio de banca siguiendo TDD con las definiciones:

Caso 1:
- Dado que existe una cuenta con número de cuenta N
- Cuando se consulta la cuenta con número N
- Entonces se devuelve la cuenta y los datos asociados

Caso 2:
- Dadas las cuentas A y B, ambas con un balance de 100
- Cuando se transfiere 50 de la cuenta A a B 
- Entonces el importe se resta en A y se añade a B

Caso 3:
- Dadas las cuentas A y B, ambas con un balance de 100
- Cuando se transfiere una cantidad superior al balence de la cuanta A
- Entonces se lanza excepción inicando saldo insuficiente

Caso 4:
- Dadao que la cuenta A no existe
- Cuando se transfiere de la cuenta A a B
- Entonces se lanza ex.

Caso 5:
- Dadao que la cuenta B no existe
- Cuando se transfiere de la cuenta A a B
- Entonces se lanza ex.
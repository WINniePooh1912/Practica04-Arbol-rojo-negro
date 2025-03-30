# Practica 04 - Árbol Rojo-Negro - Estructuras de Datos y Algoritmia

Este proyecto implementa un árbol rojo-negro (RBTree) en Java, una estructura de datos balanceada que garantiza operaciones eficientes de inserción, búsqueda y eliminación en tiempo logarítmico. A continuación, se presenta una guía general sobre su funcionamiento y estructura.

## Árbol Rojo-Negro

Los árboles rojo-negro son árboles binarios de búsqueda autoequilibrados, donde cada nodo tiene un color adicional (rojo o negro). El árbol asegura que las operaciones de inserción, eliminación y búsqueda se realicen en tiempo logarítmico, manteniendo el equilibrio del árbol mediante una serie de reglas y rotaciones.

## Estructura del Proyecto

El proyecto contiene las siguientes clases principales:

- **Main.java**: Contiene el código de ejemplo para probar las funcionalidades del árbol rojo-negro.
- **RBNode.java**: Implementa los nodos del árbol, incluyendo propiedades para almacenar valores y referencias a nodos padres, hijos izquierdo y derecho, así como el color del nodo.
- **RBTree.java**: Implementa el árbol rojo-negro en sí, con métodos para insertar nodos, mantener el equilibrio mediante rotaciones y realizar traversales en diferentes órdenes (preorden, postorden, inorden).

## Características

- **Inserción balanceada**: Los nodos se insertan de manera que el árbol se mantenga equilibrado utilizando las propiedades del árbol rojo-negro.
- **Rotaciones**: Implementa rotaciones a la izquierda y derecha para mantener el equilibrio después de las inserciones.
- **Traversales**: El árbol soporta traversales preorden, postorden e inorden en ambas direcciones (izquierda y derecha).
- **Visualización**: Se puede imprimir el árbol en una forma horizontal o nivel por nivel para facilitar su visualización.

## Explicación del Código
`Main.java`: En esta clase se crean instancias de un árbol rojo-negro (RBTree) y se realizan inserciones de nodos utilizando el método `addRBNode`. Luego, se imprimen las traversales del árbol en diferentes órdenes y se muestran tanto el árbol balanceado como el no balanceado.

`RBNode.java`: Define la estructura de los nodos del árbol rojo-negro. Cada nodo tiene un valor y referencias a su padre, hijo izquierdo, y derecho, además de un color que puede ser negro o rojo.

`RBTree.java`: Implementa las operaciones principales sobre el árbol rojo-negro. Incluye la inserción de nodos, balanceo del árbol mediante rotaciones y la actualización de alturas. Además, incluye métodos para las traversales (preorden, postorden, inorden) y la visualización del árbol.

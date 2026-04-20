package nodos;

public class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    // 1. Eliminar por código (remove)
    public boolean remove(int codigo) {
        if (cabeza == null){
            return false;
        }

        if (cabeza.dato == codigo) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == codigo) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // 2. Obtener cantidad de nodos (size)
    public int size() {
        int contador = 0;
        Nodo tmp = cabeza;
        while (tmp != null) {
            contador++;
            tmp = tmp.siguiente;
        }
        return contador;
    }

    // 3. Insertar en posición específica (add)
    public void add(int index, Nodo obj) {
        int tamanoActual = size();

        if (index < 0 || index > tamanoActual) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        if (index == 0) {
            obj.siguiente = cabeza;
            cabeza = obj;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.siguiente;
            }
            obj.siguiente = actual.siguiente;
            actual.siguiente = obj;
        }
    }

    // Método auxiliar para mostrar
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
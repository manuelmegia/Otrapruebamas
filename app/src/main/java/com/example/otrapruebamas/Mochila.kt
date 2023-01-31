package com.example.otrapruebamas

class Mochila(private var pesoMochila: Int){
    private var contenido = ArrayList<Articulo>()

    fun getPesoMochila(): Int {
        return pesoMochila
    }

    fun addArticulo(articulo: Articulo): String {
        if (articulo.getPeso() <= pesoMochila) {
            contenido.add(articulo)
            this.pesoMochila -= articulo.getPeso()
        } else {
            return "El articulo '" + articulo.getId() + "' no puede entrar porque la mochila está llena, debes vender artículos"
        }
        return "Articulo '" + articulo.getId() + "' introducido, peso restante de la Mochila: " + pesoMochila
    }

    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }

    override fun toString(): String {
        return "Mochila(pesoMochila=$pesoMochila, contenido=$contenido)"
    }

    fun findObjeto(id: String): Int {
        for ((indice, item) in contenido.withIndex()) {
            if (item.getId() == id) {
                return indice
            }
        }
        return -1
    }

}